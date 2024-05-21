package org.example.corppractice.controller;


import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.example.corppractice.dto.ApiResponse;
import org.example.corppractice.dto.StationGroupRequest;
import org.example.corppractice.dto.StationGroupResponse;
import org.example.corppractice.entity.StationGroup;
import org.example.corppractice.service.StationGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StationGroupController {

    private final StationGroupService stationGroupService;

    @PostMapping("/stationGroup")
    public ResponseEntity<ApiResponse<StationGroupResponse>> createStationGroup(@RequestBody StationGroupRequest request){
        StationGroupResponse stationGroupResponse = stationGroupService.createStationGroup(request);
        return ResponseEntity.ok(new ApiResponse<>("success",stationGroupResponse));
    }
}
