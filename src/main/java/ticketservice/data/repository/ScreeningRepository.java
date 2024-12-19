package ticketservice.data.repository;

import ticketservice.data.entity.MovieEntity;
import ticketservice.data.entity.RoomEntity;
import ticketservice.data.entity.ScreeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends JpaRepository<ScreeningEntity, Long> {
    ScreeningEntity findByMovieAndRoom(MovieEntity movie, RoomEntity room);
}
