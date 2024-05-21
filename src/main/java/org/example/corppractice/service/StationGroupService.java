package org.example.corppractice.service;

import lombok.RequiredArgsConstructor;
import org.example.corppractice.dto.StationGroupRequest;
import org.example.corppractice.dto.StationGroupResponse;
import org.example.corppractice.entity.StationGroup;
import org.example.corppractice.repository.StationGroupRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StationGroupService {
    private final StationGroupRepository stationGroupRepository;
    public StationGroupResponse createStationGroup(StationGroupRequest request){
        StationGroup stationGroup = new StationGroup(request.getStationGroupSerial());
        stationGroupRepository.save(stationGroup);
        StationGroupResponse stationGroupResponse = new StationGroupResponse(
            stationGroup.getId(),
            stationGroup.getSerialNumber(),
            stationGroup.getCreatedAt());
        return stationGroupResponse;

    }
}
