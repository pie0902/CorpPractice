package org.example.corppractice.service;


import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.example.corppractice.dto.DeviceRequest;
import org.example.corppractice.dto.DeviceResponse;
import org.example.corppractice.entity.Device;
import org.example.corppractice.entity.StationGroup;
import org.example.corppractice.repository.DeviceRepository;
import org.example.corppractice.repository.StationGroupRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final StationGroupRepository stationGroupRepository;

    public DeviceResponse getData(DeviceRequest deviceRequest) {
        StationGroup stationGroup = stationGroupRepository.findBySerialNumber(deviceRequest.getStationGroupSerial());
        Device device = new Device(deviceRequest.getSerialNumber(), stationGroup);
        deviceRepository.save(device);
        DeviceResponse deviceResponse = new DeviceResponse(device.getDeviceId(), device.getSerialNumber(),stationGroup,
            LocalDateTime.now());
        return deviceResponse;
    }
}
