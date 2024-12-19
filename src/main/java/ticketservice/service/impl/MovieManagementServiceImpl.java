package ticketservice.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ticketservice.data.entity.MovieEntity;
import ticketservice.data.repository.MovieRepository;
import ticketservice.service.MovieManagementService;
import ticketservice.service.dto.MovieDto;

import java.util.List;

@Service
public class MovieManagementServiceImpl implements MovieManagementService {

    @Autowired
    MovieRepository repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public MovieDto save (MovieDto dto){
        MovieEntity entity = mapper.map(dto, MovieEntity.class);
        entity = repo.save(entity);

        MovieDto rdto = mapper.map(entity, MovieDto.class);

        return rdto;
    }

    @Override
    public List<MovieDto> findAll() {
        List<MovieEntity> entities = repo.findAll();
        return mapper.map(entities, new TypeToken<List<MovieDto>>(){}.getType());
    }

    @Override
    public MovieDto findByTitle(String title) {
        MovieDto dto = new MovieDto();
        MovieEntity entity = repo.getReferenceById(title);

        dto.setTitle(entity.getTitle());
        dto.setDuration(entity.getDuration());
        dto.setGenre(entity.getGenre());

        return dto;
    }

    @Override
    public MovieDto update(MovieDto dto) {
        return null;
    }

    @Override
    public void delete(String title) {
        repo.deleteById(title);
    }

    @Override
    public List<MovieDto> findByAny(String title, String genre, Integer duration) {
        List<MovieEntity> szurt = repo.findAll();
        szurt = szurt.stream()
                .filter(x -> title == null || x.getTitle().equals(title))
                .filter(x -> genre == null || x.getGenre().equals(genre))
                .filter(x -> duration == null || x.getDuration() <= duration)
                .toList();

        return mapper.map(szurt, new TypeToken<List<MovieDto>>(){}.getType());
    }
}
