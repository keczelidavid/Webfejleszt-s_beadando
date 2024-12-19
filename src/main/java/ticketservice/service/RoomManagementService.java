package ticketservice.service;


import ticketservice.service.dto.RoomDto;

import java.util.List;

public interface RoomManagementService {
    RoomDto save(RoomDto dto);
    List<RoomDto> findAll();
    RoomDto findByName(String name);
    RoomDto update(RoomDto dto);
    void delete(String name);
    List<RoomDto> findByAny(String name,
                            Integer seatRows,
                            Integer seatColumns );
}
