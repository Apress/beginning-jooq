package com.apress.jooq;

import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.conf.MappedCatalog;
import org.jooq.conf.MappedSchema;
import org.jooq.conf.RenderMapping;
import org.jooq.conf.Settings;
import org.jooq.impl.DefaultConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Map;

import static com.apress.jooq.executable.JooqInsert.insertVehicle;
import static com.apress.jooq.executable.JooqInsert.insertVehicleAsSelect;
import static com.apress.jooq.executable.JooqLocking.selectWithLockingForShare;
import static com.apress.jooq.executable.JooqLocking.selectWithLockingForUpdate;
import static com.apress.jooq.executable.JooqOrderBy.selectWithOrderByCase;
import static com.apress.jooq.executable.JooqSelect.*;
import static com.apress.jooq.executable.JooqUpdate.updateRowVehicle;
import static com.apress.jooq.executable.JooqUpdate.updateVehicle;
import static com.apress.jooq.executable.JooqWithTransaction.changeVehiclePrice;

public class JooqDMLDemoApplication {

    static Logger logger = LoggerFactory.getLogger(JooqDMLDemoApplication.class);

    public static void main(String[] args) throws Exception {
        insertVehicle();
        insertVehicleAsSelect();
        updateVehicle();
        updateRowVehicle();
        changeVehiclePrice(2, BigDecimal.valueOf(23000.00));
        selectWithLockingForUpdate(2, BigDecimal.valueOf(23000.00));
        selectWithLockingForShare(2, BigDecimal.valueOf(23000.00));
    }


    public static Configuration configureSchemaOrCatalog(String schemaInEffect) {
        Settings settings = new Settings()
                .withRenderMapping(new RenderMapping().withDefaultCatalog("")
                        .withSchemata(new MappedSchema().withInput("master").withOutput(schemaInEffect))
                        .withCatalogs(new MappedCatalog().withInput("master").withOutput(schemaInEffect)));
        DefaultConfiguration configuration = new DefaultConfiguration();
        settings.setRenderFormatted(true);
        configuration.setSQLDialect(SQLDialect.MYSQL);
        configuration.setSettings(settings);
        return configuration;
    }

}
