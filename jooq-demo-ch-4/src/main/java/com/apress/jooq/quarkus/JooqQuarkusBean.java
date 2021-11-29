package com.apress.jooq.quarkus;

import com.apress.jooq.custom.CompleteVehicleRecord;
import io.quarkus.runtime.Startup;
import org.jooq.DSLContext;
import org.jooq.ResultQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.SQLException;
import java.util.List;

@Named("JooqBean")
@Startup
@ApplicationScoped
public class JooqQuarkusBean {

    static Logger logger = LoggerFactory.getLogger(JooqQuarkusBean.class);

    @Inject
    DSLContext context;

    @PostConstruct
    public void validateJooq() throws SQLException {
            ResultQuery resultQuery = context.resultQuery("SELECT * FROM edens_car.complete_car_listing");
            List<CompleteVehicleRecord> allVehicles = resultQuery.fetchInto(CompleteVehicleRecord.class);
            logger.info(allVehicles.toString());
    }

}
