package com.apress.jooq.executable;

import com.apress.jooq.connectionprovider.CustomConnectionProvider;
import com.apress.jooq.custom.CompleteVehicleRecord;
import org.jooq.DSLContext;
import org.jooq.ResultQuery;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class JooqWithDataSource {
    static Logger logger = LoggerFactory.getLogger(JooqWithDataSource.class.getName());

    public static void basicSelect() throws SQLException {
        DSLContext context = DSL.using(new CustomConnectionProvider(), SQLDialect.MYSQL);
        ResultQuery resultQuery = context.resultQuery("SELECT * FROM edens_car.complete_car_listing");
        List<CompleteVehicleRecord> allVehicles = resultQuery.fetchInto(CompleteVehicleRecord.class);
        logger.info(allVehicles.toString());
    }
}
