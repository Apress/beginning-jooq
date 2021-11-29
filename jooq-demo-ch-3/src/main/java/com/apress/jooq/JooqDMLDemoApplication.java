package com.apress.jooq;



import java.math.BigDecimal;

import static com.apress.jooq.executable.JooqInsert.insertVehicle;
import static com.apress.jooq.executable.JooqInsert.insertVehicleAsSelect;
import static com.apress.jooq.executable.JooqLocking.selectWithLockingForShare;
import static com.apress.jooq.executable.JooqLocking.selectWithLockingForUpdate;
import static com.apress.jooq.executable.JooqUpdate.updateRowVehicle;
import static com.apress.jooq.executable.JooqUpdate.updateVehicle;
import static com.apress.jooq.executable.JooqWithTransaction.changeVehiclePrice;

public class JooqDMLDemoApplication {

    public static void main(String[] args) throws Exception {
        insertVehicle();
        insertVehicleAsSelect();
        updateVehicle();
        updateRowVehicle();
        changeVehiclePrice(2, BigDecimal.valueOf(23000.00));
        selectWithLockingForUpdate(2, BigDecimal.valueOf(23000.00));
        selectWithLockingForShare(2, BigDecimal.valueOf(23000.00));
    }
}
