package ticketservice.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ticketservice.data.entity.MovieEntity;
import ticketservice.data.entity.RoomEntity;
import ticketservice.data.entity.ScreeningEntity;
import ticketservice.data.entity.ScreeningId;
import ticketservice.data.repository.MovieRepository;
import ticketservice.data.repository.RoomRepository;
import ticketservice.data.repository.ScreeningRepository;
import ticketservice.service.ScreeningManagementService;
import ticketservice.service.dto.ScreeningDto;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScreeningManagementServiceImpl implements ScreeningManagementService {

    @Autowired
    MovieRepository movieRepo;

    @Autowired
    RoomRepository roomRepo;

    @Autowired
    ScreeningRepository screeningRepo;

    @Autowired
    ModelMapper mapper;


    @Override
    public ScreeningDto save(ScreeningDto dto) {
        System.out.println("The Given object is: " + dto.toString());

        RoomEntity roomEntity = roomRepo.findByName(dto.getRoom().getName());
        MovieEntity movieEntity = movieRepo.findByTitle(dto.getMovie().getTitle());

        if (roomEntity != null && movieEntity != null &&
                dto.getMovie().getTitle().equals(movieEntity.getTitle()) &&
                dto.getRoom().getName().equals(roomEntity.getName())) {
            System.out.println("Room and Movie found");

            ScreeningEntity entity = mapper.map(dto, ScreeningEntity.class);
            entity = screeningRepo.save(entity);

            return mapper.map(entity, ScreeningDto.class);
        } else {
            System.out.println("Room and Movie not found");
            return null;
        }
    }

    @Override
    public List<ScreeningDto> findAll() {
        List<ScreeningEntity> entities = screeningRepo.findAll();
        return mapper.map(entities, new TypeToken<List<ScreeningDto>>(){}.getType());
    }

    @Override
    public ScreeningDto findById(ScreeningId id) {
        ScreeningDto dto = new ScreeningDto();
        ScreeningEntity entity = screeningRepo.getReferenceById(id);

        dto.setId(entity.getId());
        dto.setRoom(entity.getRoom());
        dto.setMovie(entity.getMovie());
        dto.setScreeningTime(entity.getScreeningTime());

        return dto;
    }

    @Override
    public ScreeningDto update(ScreeningDto dto) {
        return null;
    }

    @Override
    public void delete(ScreeningId id) {
        screeningRepo.deleteById(id);
    }


    @Override
    public List<ScreeningDto> findByAny(String movieTitle, String roomName, LocalDateTime screeningTime) {
        List<ScreeningEntity> szurt = screeningRepo.findAll();
        szurt = szurt.stream()
                .filter(x -> movieTitle == null || x.getMovie().getTitle().equals(movieTitle))
                .filter(x -> roomName == null || x.getRoom().getName().equals(roomName))
                .filter(x -> screeningTime == null || x.getScreeningTime().isBefore(screeningTime))
                .toList();


        return mapper.map(szurt, new TypeToken<List<ScreeningDto>>(){}.getType());
    }

    @Override
    public String toString() {
        return "ScreeningManagementServiceImpl{" +
                "movieRepo=" + movieRepo +
                ", roomRepo=" + roomRepo +
                ", screeningRepo=" + screeningRepo +
                ", mapper=" + mapper +
                '}';
    }
}
