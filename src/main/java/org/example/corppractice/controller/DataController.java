package org.example.corppractice.controller;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.corppractice.dto.ApiResponse;
import org.example.corppractice.dto.DataDateRequest;
import org.example.corppractice.dto.DataRequest;
import org.example.corppractice.dto.DataDateResponse;
import org.example.corppractice.dto.StationDataDateRes;
import org.example.corppractice.dto.StationDateDataReq;
import org.example.corppractice.service.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;

    @PostMapping("/data")
    public ResponseEntity<String> createData(@RequestBody DataRequest dataRequest) {
        dataService.createData(dataRequest);
        return ResponseEntity.ok().body("success");
    }

    @GetMapping("/data")
    public ResponseEntity<ApiResponse<DataDateResponse>> getDataByDate(
        @RequestBody DataDateRequest dataDateRequest
    ) {
        DataDateResponse dataDateResponse = dataService.getDataByDate(
            dataDateRequest);
        return ResponseEntity.ok(new ApiResponse<>("success", dataDateResponse));
    }

    @GetMapping("/sgData")
    public ResponseEntity<ApiResponse<List<DataDateResponse>>> getSgDataByDate(
        @RequestBody StationDateDataReq req
    ) {
        List<DataDateResponse> dataList = dataService.getSgDateByData(req);
        return ResponseEntity.ok(new ApiResponse<>("success", dataList));
    }
}
