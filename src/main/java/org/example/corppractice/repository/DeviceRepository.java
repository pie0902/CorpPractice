package org.example.corppractice.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.example.corppractice.entity.DataRecord;
import org.example.corppractice.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Long> {
    List<Device> findByStationGroup_Id(Long id);
    Optional<Device> findBySerialNumber(String serialNumber);
}
