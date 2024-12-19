package ticketservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ticketservice.data.entity.MovieEntity;
import ticketservice.data.entity.RoomEntity;
import ticketservice.data.entity.ScreeningId;

import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScreeningDto {


    private ScreeningId id;
    private MovieEntity movie;
    private RoomEntity room;
    private LocalDateTime screeningTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScreeningDto that = (ScreeningDto) o;
        return Objects.equals(id, that.id) && Objects.equals(movie, that.movie) && Objects.equals(room, that.room) && Objects.equals(screeningTime, that.screeningTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie, room, screeningTime);
    }
}
