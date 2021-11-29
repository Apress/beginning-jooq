package com.apress.jooq;

import com.apress.jooq.spring.JooqBean;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class, FlywayAutoConfiguration.class})
@ComponentScan(basePackages = {"com.apress.jooq.spring","com.apress.jooq.generated.tables.pojos"})
public class JooqSpringDemoApplication {

    @Autowired
    DSLContext context;

    @Autowired
    JooqBean jooqBean;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(JooqSpringDemoApplication.class, args);
    }
}
