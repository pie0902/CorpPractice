package org.example.corppractice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class DataRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private int dataValue;
    private LocalDateTime recordedAt;

    public DataRecord(String serialNumber, int dataValue, LocalDateTime recordedAt) {
        this.serialNumber = serialNumber;
        this.dataValue = dataValue;
        this.recordedAt = recordedAt;
    }
}
