package com.apress.jooq;

import com.apress.jooq.quarkus.JooqQuarkusBean;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.jooq.DSLContext;

import javax.inject.Inject;

@QuarkusMain
public class JooqQuarkusDemoApplication {

    @Inject
    DSLContext dslContext;

    @Inject
    JooqQuarkusBean jooqQuarkusBean;

    public static void main(String[] params){
        Quarkus.run(params);
    }
}
