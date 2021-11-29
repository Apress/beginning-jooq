package com.apress.jooq;

import static com.apress.jooq.executable.JooqAdvancedQuery.*;

public class JooqAdvancedSyntaxDemoApplication {

    public static void main(String[] args) throws Exception {
        group();
        windowFunction();
        //merge(); MySQL does not support the MERGE syntax
        upsert();
    }
}
