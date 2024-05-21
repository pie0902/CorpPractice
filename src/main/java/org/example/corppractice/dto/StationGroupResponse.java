package org.example.corppractice.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.corppractice.service.StationGroupService;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StationGroupResponse {
    private Long StationGroupId;
    private String serialNumber;
    private LocalDateTime createdAt;
}
