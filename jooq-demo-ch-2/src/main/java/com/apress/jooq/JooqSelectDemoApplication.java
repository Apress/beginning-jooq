package com.apress.jooq;

import org.jooq.*;
import org.jooq.Configuration;
import org.jooq.conf.*;
import org.jooq.impl.DefaultConfiguration;

import java.util.Map;

import static com.apress.jooq.executable.JooqOrderBy.selectWithOrderByCase;
import static com.apress.jooq.executable.JooqSelect.*;

public class JooqSelectDemoApplication {

    public static void main(String[] args) throws Exception {
        selectWithSubquery();
        selectWithFetchMany();
        selectWithCase();
        selectWithCte();
        selectWithOrderByCase();
        selectWithGroupByAndHaving();
        selectWithOptionalCondition(true, Map.of("color","BLUE","year","2021"));
        selectWithCursor();
        selectFrom();
        selectField();
        selectWhere();
        selectCondition();
        basicSelect();
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
