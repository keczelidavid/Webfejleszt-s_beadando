package ticketservice.service;

import ticketservice.data.entity.ScreeningId;
import ticketservice.service.dto.ScreeningDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningManagementService {
    ScreeningDto save(ScreeningDto dto);
    List<ScreeningDto> findAll();
    ScreeningDto findById(ScreeningId id);
    ScreeningDto update(ScreeningDto dto);
    void delete(ScreeningId id);
    List<ScreeningDto> findByAny(String movieTitle, String roomName, LocalDateTime screeningTime);
}
