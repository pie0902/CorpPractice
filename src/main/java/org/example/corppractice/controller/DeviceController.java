package org.example.corppractice.controller;


import lombok.RequiredArgsConstructor;
import org.example.corppractice.dto.ApiResponse;
import org.example.corppractice.dto.DeviceRequest;
import org.example.corppractice.dto.DeviceResponse;
import org.example.corppractice.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @PostMapping("/device")
    public ResponseEntity<ApiResponse<DeviceResponse>> getData(@RequestBody DeviceRequest deviceRequest){
        DeviceResponse deviceResponse = deviceService.getData(deviceRequest);
        return ResponseEntity.ok(new ApiResponse<>("success", deviceResponse));
    }
}
