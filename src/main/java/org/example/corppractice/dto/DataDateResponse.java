package org.example.corppractice.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataDateResponse {
    private Long id;
    private String serialNumber;
    private double averageData;
}
