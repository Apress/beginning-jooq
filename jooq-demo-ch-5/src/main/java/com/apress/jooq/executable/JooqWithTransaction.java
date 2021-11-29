package com.apress.jooq.executable;

import com.apress.jooq.connectionprovider.CustomConnectionProvider;
import com.apress.jooq.listener.QueryIntrospectionListener;
import org.jooq.*;
import org.jooq.conf.RenderQuotedNames;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.jooq.impl.DSL.*;

public class JooqWithTransaction {
    static Logger logger = LoggerFactory.getLogger(JooqWithTransaction.class.getName());

    public static void changeVehiclePrice(int vehicleId, BigDecimal newPrice) throws SQLException {
        DSLContext context = DSL.using(new CustomConnectionProvider(), SQLDialect.MYSQL, new Settings()
                .withRenderQuotedNames(RenderQuotedNames.ALWAYS)
                .withRenderFormatted(true));
        context.transaction(configuration -> {
            configuration.set(new QueryIntrospectionListener());
            BigDecimal oldPrice = selectVehicleForUpdate(vehicleId, configuration);
            updateVehiclePrice(vehicleId, newPrice, configuration);
            configuration.dsl().transaction(innerConfig -> {
                insertPriceChange(vehicleId, newPrice, oldPrice, configuration);
            });
        });
    }

    public static BigDecimal selectVehicleForUpdate(int vehicleId, Configuration configuration) {
        Table vehicleTable = table("vehicle");
        Field<BigDecimal> vehicleCurrentPrice = field("vehicle_curr_price", BigDecimal.class);
        Condition vehicleCondition = condition("vehicle_id = ?", vehicleId);
        DSLContext context = DSL.using(configuration);
        List<BigDecimal> price = context.select(vehicleCurrentPrice)
                .from(vehicleTable)
                .where(vehicleCondition)
                .forUpdate()
                .wait(3000)
                .fetchInto(BigDecimal.class);
        return price.get(0);
    }

    public static void updateVehiclePrice(int vehicleId, BigDecimal price, Configuration configuration) {
        DSLContext context = DSL.using(configuration);
        int rowsAffected = context.update(table("vehicle"))
                .set(field("vehicle_curr_price"), price)
                .where(field("vehicle_id").eq(vehicleId))
                .execute();
        logger.info("Updated vehicle price. Row count: {}", rowsAffected);
    }

    public static void insertPriceChange(int vehicleId, BigDecimal currentPrice, BigDecimal oldPrice, Configuration configuration) {
        DSLContext context = DSL.using(configuration);
        int execute = context.insertInto(table("vehicle_price_change"), field("vehicle_id"), field("current_price"), field("revised_price"))
                .values(vehicleId, oldPrice, currentPrice)
                .execute();
    }
}
