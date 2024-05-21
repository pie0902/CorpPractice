package org.example.corppractice.entity;


import jakarta.persistence.Column;
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
public class StationGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String serialNumber;
    private LocalDateTime createdAt;
    public StationGroup(String serialNumber){
        this.serialNumber = serialNumber;
        this.createdAt = LocalDateTime.now();
    }
}
