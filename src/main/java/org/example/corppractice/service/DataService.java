package org.example.corppractice.service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.corppractice.dto.DataDateRequest;
import org.example.corppractice.dto.DataDateResponse;
import org.example.corppractice.dto.DataRequest;
import org.example.corppractice.dto.StationDataDateRes;
import org.example.corppractice.dto.StationDateDataReq;
import org.example.corppractice.entity.DataRecord;
import org.example.corppractice.entity.Device;
import org.example.corppractice.repository.DataRepository;
import org.example.corppractice.repository.DeviceRepository;
import org.example.corppractice.repository.StationGroupRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataService{
    private final DataRepository dataRepository;
    private final DeviceRepository deviceRepository;
    private final StationGroupRepository stationGroupRepository;
    public void createData(DataRequest dataRequest) {
        String serialNumber = dataRequest.getSerialNumber();
        int interval = dataRequest.getInterval();
        String dataSet = dataRequest.getDataSet();
        LocalDateTime recordedAt = LocalDateTime.parse(dataRequest.getRecorded_at(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        List<DataRecord> records = new ArrayList<>();
        for (int i = 0; i < dataSet.length(); i += 4) {
            String hexValue = dataSet.substring(i, i + 4);
            int dataValue = Integer.parseInt(hexValue, 16);
            if (dataValue > 32767) { // 16진수 4자리의 음수 값 처리 (2's complement)
                dataValue -= 65536;
            }
            LocalDateTime timestamp = recordedAt.plusMinutes(i / 4 * interval);
            records.add(new DataRecord(serialNumber, dataValue, timestamp));
        }
        dataRepository.saveAll(records);
    }

    public DataDateResponse getDataByDate(DataDateRequest dataDateRequest) {
        List<DataRecord> dataRecords = dataRepository.findBySerialNumberAndRecordedAtBetween(
            dataDateRequest.getSerialNumber(), dataDateRequest.getStartDate(), dataDateRequest.getEndDate());
        double avgData = dataRecords.stream()
            .mapToInt(DataRecord::getDataValue)
            .average()
            .orElse(0.0);

        BigDecimal roundedAvgData = new BigDecimal(avgData).setScale(1, RoundingMode.HALF_UP);
//        Long deviceId = dataRecords.isEmpty() ? null : dataRecords.get(0).getId();
        Device device = deviceRepository.findBySerialNumber(dataDateRequest.getSerialNumber()).orElseThrow(()->new RuntimeException("오류"));
         Long deviceId = device.getDeviceId();
        String deviceSerialNumber = dataRecords.isEmpty() ? null : dataRecords.get(0).getSerialNumber();
        DataDateResponse dataDateResponse = new DataDateResponse(deviceId,
            deviceSerialNumber,roundedAvgData.doubleValue());
        return dataDateResponse;
    }

    public List<DataDateResponse> getSgDateByData(StationDateDataReq req) {
        Long sgId = stationGroupRepository.findIdBySerialNumber(req.getStationGroupSerial());
        List<Device> devices = deviceRepository.findByStationGroup_Id(sgId);
        List<DataDateResponse> dataList = new ArrayList<>();
        for(Device device : devices) {
            DataDateRequest dataDateRequest = new DataDateRequest(device.getSerialNumber(),req.getStartDate(),req.getEndDate());
            dataList.add(getDataByDate(dataDateRequest));
        }
        return dataList;
    }
}
