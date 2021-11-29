package com.apress.jooq.spring;

import com.apress.jooq.generated.tables.pojos.Vehicle;
import com.apress.jooq.generated.tables.pojos.VehicleModel;
import com.apress.jooq.spring.repository.VehicleModelJooqRepository;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

import static com.apress.jooq.generated.Tables.*;
import static org.jooq.impl.DSL.*;

@Repository
public class JooqBean {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    VehicleModelJooqRepository vehicleModelRepository;

    @Autowired
    DSLContext dslContext;

    final Logger logger = LoggerFactory.getLogger(JooqBean.class);

    @PostConstruct
    public void initialize(){
        List<VehicleModel> vehicleModels = runJpaJooqSql();
        vehicleModels.forEach(vehicle -> logger.info("Retrieved vehicle: {}",vehicle));
    }

    public String generateSql(){
        Query jooqQuery = DSL.using(SQLDialect.MYSQL,new Settings()
                //.withRenderQuotedNames(RenderQuotedNames.NEVER)
        )
                .select(VEHICLE.VEHICLE_ID, VEHICLE.VEHICLE_COLOR, VEHICLE.VEHICLE_CURR_PRICE)
                .from(VEHICLE)
                .where(VEHICLE.VEHICLE_MANUFACTURER.eq(param("vehicle_manufacturer", Long.class))).getQuery();
        return  jooqQuery.getSQL();
    }

    public List<VehicleModel> runJpaJooqSql(){
        //Generate jOOQ SQL
        Query jooqQuery = DSL.using(SQLDialect.MYSQL)
                .select(VEHICLE_MODEL.VEHICLE_MODEL_ID, VEHICLE_MODEL.VEHICLE_MODEL_NAME,VEHICLE_MODEL.VEHICLE_MAN_ID,VEHICLE_MODEL.VEHICLE_STYLE_ID,VEHICLE_MODEL.VERSION)
                .from(VEHICLE_MODEL)
                .where(VEHICLE_MODEL.VEHICLE_MAN_ID.eq(param("vehicle_man_id", Long.class))
                        .and(VEHICLE_MODEL.VEHICLE_MODEL_NAME.notIn(inline("MDX"))))
                .getQuery();
        logger.info("The jOOQ-generated SQL: {}", jooqQuery.getSQL());
        //Load jOOQ-generated SQL into JPA context as a NamedQuery
        javax.persistence.Query nativeQuery = entityManager.createNativeQuery(jooqQuery.getSQL(),VehicleModel.class);
        entityManager.getEntityManagerFactory().addNamedQuery("CustomVehicleModelQuery",nativeQuery);
        //Set param
        int parameterCount = 1;
        long vehicleManufacturer = 4;
        for(Parameter parameter: nativeQuery.getParameters()){
            nativeQuery.setParameter(parameterCount++,vehicleManufacturer);
        }
        //Run the jOOQ-generated SQL within Spring Data JPA
        List<VehicleModel> modelByVehicleManId = vehicleModelRepository.getVehicleModelByVehicleManId(vehicleManufacturer);
        logger.info("Vehicle Models: {}",modelByVehicleManId);
        //Run the jOOQ-generated SQL within vanilla JPA/Hibernate
        List<VehicleModel> resultList = nativeQuery.getResultList();
        return resultList;
    }

}
