package com.apress.jooq;




import static com.apress.jooq.executable.generate.JooqGenerator.generateCodeWithCode;
import static com.apress.jooq.executable.generate.JooqGenerator.generateCodeWithConfigFile;

public class JooqGeneratorDemoApplication {


    public static void main(String[] args) throws Exception {
        generateCodeWithCode();
        //generateCodeWithConfigFile();
    }

}
