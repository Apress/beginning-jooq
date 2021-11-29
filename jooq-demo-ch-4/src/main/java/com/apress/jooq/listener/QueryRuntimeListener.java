package com.apress.jooq.listener;

import com.apress.jooq.JooqSpringDemoApplication;
import org.jooq.ExecuteContext;
import org.jooq.impl.DefaultExecuteListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class QueryRuntimeListener extends DefaultExecuteListener {

    static Logger logger = LoggerFactory.getLogger(JooqSpringDemoApplication.class);

    @Override
    public void fetchStart(ExecuteContext ctx) {
        logger.info("Executing: {}",ctx.sql());
        logger.info("Query type: {}",ctx.type());
    }

    @Override
    public void exception(ExecuteContext ctx) {
        if(Objects.nonNull(ctx.sqlException())){
            //handle exception
        }
    }

}
