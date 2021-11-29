package com.apress.jooq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.apress.jooq.executable.JooqBatch.*;


public class JooqBatchDemoApplication {

    public static void main(String[] args) throws Exception {
        batchInsertVehicle();
        batchChangedVehicleRecord();
        bulkImport();
    }
}
