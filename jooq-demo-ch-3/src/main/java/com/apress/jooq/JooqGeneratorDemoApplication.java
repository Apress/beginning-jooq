package com.apress.jooq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.apress.jooq.executable.generate.JooqGenerator.generateCodeWithCode;
import static com.apress.jooq.executable.generate.JooqGenerator.generateCodeWithConfigFile;

public class JooqGeneratorDemoApplication {

    static Logger logger = LoggerFactory.getLogger(JooqGeneratorDemoApplication.class);

    public static void main(String[] args) throws Exception {
        generateCodeWithCode();
        generateCodeWithConfigFile();
    }

}
