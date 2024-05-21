package org.example.corppractice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StationDataDateRes {
    private Long deviceId;
    private String serialNumber;
    private double averageData;
}
