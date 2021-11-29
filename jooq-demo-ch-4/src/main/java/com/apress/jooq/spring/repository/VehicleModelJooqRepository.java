package com.apress.jooq.spring.repository;

import com.apress.jooq.generated.tables.pojos.VehicleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleModelJooqRepository extends CrudRepository<VehicleModel, Long> {

    @Query(name = "CustomVehicleModelQuery")
    List<VehicleModel> getVehicleModelByVehicleManId(long id);
}
