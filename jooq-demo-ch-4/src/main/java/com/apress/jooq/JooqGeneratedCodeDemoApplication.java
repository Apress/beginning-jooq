package com.apress.jooq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.apress.jooq.executable.JooqJoin.*;
import static com.apress.jooq.executable.JooqSelect.*;
import static com.apress.jooq.executable.generate.JooqGenerator.insertGeneratedVehicle;

public class JooqGeneratedCodeDemoApplication {

    static Logger logger = LoggerFactory.getLogger(JooqGeneratedCodeDemoApplication.class);

    public static void main(String[] args) throws Exception {
        selectWithGeneratedCode();
        selectIntoRecord();
        selectWithGeneratedCode();
        navigateRecord();
        join();
        mapJoin();
        mapStreamJoin();
        insertGeneratedVehicle();
    }


}
