package ticketservice.service;

import ticketservice.data.entity.MovieEntity;
import ticketservice.service.dto.MovieDto;

import java.util.List;

public interface MovieManagementService {
        MovieDto save(MovieDto dto);
        List<MovieDto> findAll();
        MovieDto findByTitle(String title);
        MovieDto update(MovieDto dto);
        void delete(String title);
        List<MovieDto> findByAny(String title,
                                 String genre,
                                 Integer duration);
}
