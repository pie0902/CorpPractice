package org.example.corppractice.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.example.corppractice.entity.DataRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<DataRecord,Long> {
    List<DataRecord> findBySerialNumberAndRecordedAtBetween(String serialNumber, LocalDateTime startDate, LocalDateTime endDate);
}
