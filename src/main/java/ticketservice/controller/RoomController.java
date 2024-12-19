package ticketservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ticketservice.service.RoomManagementService;
import ticketservice.service.dto.RoomDto;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    RoomManagementService service;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/saveroom")
    public RoomDto save(@RequestBody RoomDto dto){
        return service.save(dto);
    }

    @PutMapping("/updateroom")
    public RoomDto update(@RequestBody RoomDto dto){
        RoomDto existingRoom = service.findByName(dto.getName());

        if (existingRoom != null) {
            existingRoom.setSeatRows(dto.getSeatRows());
            existingRoom.setSeatColumns(dto.getSeatColumns());

            return service.save(existingRoom);
        }
        return null;
    }

    @DeleteMapping("/room")
    public void deleteByTitle(@RequestParam String name) {
        service.delete(name);
    }

    @GetMapping("/room")
    public List<RoomDto> findAll(){
        return  service.findAll();
    }

    @GetMapping("filterRoom")
    public List<RoomDto> filterRoom(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) Integer seatRows,
                                      @RequestParam(required = false) Integer seatColumns){
        return service.findByAny(name, seatRows, seatColumns);
    }


}
