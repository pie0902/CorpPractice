package org.example.corppractice.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

@Getter
@NoArgsConstructor
public class DataRequest {
    private String serialNumber;
    private int interval;
    private String dataSet;
    private String recorded_at;
}
