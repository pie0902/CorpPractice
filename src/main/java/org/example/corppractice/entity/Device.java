package org.example.corppractice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Device{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deviceId;
    @Column(unique = true)
    private String serialNumber;
    @ManyToOne
    @JoinColumn(name = "stationGroupId")
    private StationGroup stationGroup;
    private LocalDateTime createdAt;
    public Device(String serialNumber,StationGroup stationGroup){
        this.serialNumber = serialNumber;
        this.stationGroup = stationGroup;
        this.createdAt = LocalDateTime.now();
    }

}
