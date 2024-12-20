package ticketservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ticketservice.data.entity.ScreeningId;
import ticketservice.service.ScreeningManagementService;
import ticketservice.service.dto.ScreeningDto;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {

    @Autowired
    ScreeningManagementService service;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/savescreening")
    public ScreeningDto save(@RequestBody ScreeningDto dto){
        return service.save(dto);
    }

    @PutMapping("/updatescreening")
    public ScreeningDto update(@RequestBody ScreeningDto dto){
        ScreeningDto existingScreening = service.findById(dto.getId());

        if (existingScreening != null) {
            existingScreening.setId(dto.getId());
            existingScreening.setRoom(dto.getRoom());
            existingScreening.setMovie(dto.getMovie());
            existingScreening.setScreeningTime(dto.getScreeningTime());

            return service.save(existingScreening);
        }
        return null;
    }

    @DeleteMapping("/screening")
    public void deleteById(@RequestParam String movieTitle, @RequestParam String roomName) {
        ScreeningId id = new ScreeningId(movieTitle, roomName);
        service.delete(id);
    }

    @GetMapping("/screening")
    public List<ScreeningDto> findAll(){
        return  service.findAll();
    }

    @GetMapping("filterScreening")
    public List<ScreeningDto> filterScreening(@RequestParam(required = false) String movieTitle,
                                              @RequestParam(required = false) String roomName,
                                              @RequestParam(required = false)LocalDateTime screeningTime){
        return service.findByAny(movieTitle, roomName, screeningTime);
    }

}
