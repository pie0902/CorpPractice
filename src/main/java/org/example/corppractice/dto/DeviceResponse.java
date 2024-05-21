package org.example.corppractice.dto;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.corppractice.entity.StationGroup;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceResponse {
    private Long deviceId;
    private String serialNumber;
    private StationGroup stationGroup;
    private LocalDateTime createdAt;

}
