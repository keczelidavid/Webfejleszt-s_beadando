package ticketservice.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ticketservice.data.entity.RoomEntity;
import ticketservice.data.repository.RoomRepository;
import ticketservice.service.RoomManagementService;
import ticketservice.service.dto.RoomDto;

import java.util.List;

@Service
public class RoomManagementServiceImp implements RoomManagementService {

    @Autowired
    RoomRepository repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public RoomDto save(RoomDto dto) {
        RoomEntity entity = mapper.map(dto, RoomEntity.class);
        entity = repo.save(entity);

        RoomDto rdto = mapper.map(entity, RoomDto.class);

        return rdto;
    }

    @Override
    public List<RoomDto> findAll() {
        List<RoomEntity> entities = repo.findAll();
        return mapper.map(entities, new TypeToken<List<RoomDto>>(){}.getType());
    }

    @Override
    public RoomDto findByName(String name) {
        RoomDto dto = new RoomDto();
        RoomEntity entity = repo.getReferenceById(name);

        dto.setName(entity.getName());
        dto.setSeatRows(entity.getSeatRows());
        dto.setSeatColumns(entity.getSeatColumns());

        return dto;
    }

    @Override
    public RoomDto update(RoomDto dto) {
        return null;
    }

    @Override
    public void delete(String name) {
        repo.deleteById(name);
    }

    @Override
    public List<RoomDto> findByAny(String name, Integer seatRows, Integer seatColumns) {
        List<RoomEntity> szurt = repo.findAll();
        szurt = szurt.stream()
                .filter(x -> name == null || x.getName().equals(name))
                .filter(x -> seatRows == null || x.getSeatRows() <= (seatRows))
                .filter(x -> seatColumns == null || x.getSeatColumns() <= seatColumns)
                .toList();

        return mapper.map(szurt, new TypeToken<List<RoomDto>>(){}.getType());
    }
}
