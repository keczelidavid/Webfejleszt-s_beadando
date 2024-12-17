package data.repository;

import data.entity.MovieEntity;
import data.entity.RoomEntity;
import data.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    Screening findByMovieAndRoom(MovieEntity movie, RoomEntity room);
}
