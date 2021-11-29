package com.apress.jooq.executable.generate;

import org.jooq.codegen.JavaGenerator;
import org.jooq.codegen.JavaWriter;
import org.jooq.meta.TableDefinition;

public class CopyrightGenerator extends JavaGenerator {

    protected void printClassJavadoc(JavaWriter out, String comment) {
        out.println("/** This is proprietary code of Initech co */");
    }

    protected void generateRecordClassFooter(TableDefinition table, JavaWriter out){
        out.println();
        out.tab(1).println("public static String getInitechWarning(){");
        out.tab(2).println("return \"This is proprietary code of Initech co\";");
        out.tab(1).println("}");
        out.println();
    }
}
