package org.example.corppractice.repository;

import java.util.List;
import org.example.corppractice.entity.StationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StationGroupRepository extends JpaRepository<StationGroup, Long> {
    StationGroup findBySerialNumber(String serialNumber);

    @Query("SELECT sg.Id FROM StationGroup sg WHERE sg.serialNumber = :serialNumber")
    Long findIdBySerialNumber(@Param("serialNumber") String serialNumber);
}
