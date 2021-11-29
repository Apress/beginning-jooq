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

import static com.apress.jooq.executable.JooqJoin.*;
import static com.apress.jooq.executable.JooqSelect.*;
import static com.apress.jooq.executable.generate.JooqGenerator.generateCodeWithCode;
import static com.apress.jooq.executable.generate.JooqGenerator.insertGeneratedVehicle;

public class JooqGeneratedCodeDemoApplication {

    static Logger logger = LoggerFactory.getLogger(JooqGeneratedCodeDemoApplication.class);

    public static void main(String[] args) throws Exception {
        selectWithGeneratedCode();
        selectIntoRecord();
        selectWithGeneratedCode();
        navigateRecord();
        insertGeneratedVehicle();
        join();
        mapJoin();
        mapStreamJoin();
    }


}
