package ticketservice.data.repository;

import ticketservice.data.entity.MovieEntity;
import ticketservice.data.entity.RoomEntity;
import ticketservice.data.entity.ScreeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ticketservice.data.entity.ScreeningId;

import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<ScreeningEntity, ScreeningId> {
    ScreeningEntity findByMovieAndRoom(MovieEntity movie, RoomEntity room);
    List<ScreeningEntity> findByMovie_Title(String movieTitle);
    List<ScreeningEntity> findByRoom_Name(String roomName);
}
