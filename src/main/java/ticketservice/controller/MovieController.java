package ticketservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ticketservice.service.MovieManagementService;
import ticketservice.service.dto.MovieDto;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    MovieManagementService service;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/savemovie")
    public MovieDto save(@RequestBody MovieDto dto){
        return service.save(dto);
    }

    @PutMapping("/updatemovie")
    public MovieDto update(@RequestBody MovieDto dto){
        MovieDto existingMovie = service.findByTitle(dto.getTitle());

        if (existingMovie != null) {
            existingMovie.setDuration(dto.getDuration());
            existingMovie.setGenre(dto.getGenre());

            return service.save(existingMovie);
        }
        return null;
    }

    @DeleteMapping("/movie")
    public void deleteByTitle(@RequestParam String title) {
        service.delete(title);
    }

    @GetMapping("/movie")
    public List<MovieDto> findAll(){
        return  service.findAll();
    }

    @GetMapping("filterMovie")
    public List<MovieDto> filterMovie(@RequestParam(required = false) String title,
                                      @RequestParam(required = false) String genre,
                                      @RequestParam(required = false) Integer duration){
        return service.findByAny(title, genre, duration);
    }



}
