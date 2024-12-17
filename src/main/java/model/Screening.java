package model;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Vetítés")
@Getter
@Setter
@NoArgsConstructor
public class Screening {

    @EmbeddedId
    private ScreeningId id;

    @ManyToOne
    @MapsId("movieTitle")
    private MovieEntity movie;

    @ManyToOne
    @MapsId("roomName")
    private RoomEntity room;
    private LocalDateTime screeningTime;
    private int duration;

    public Screening(MovieEntity movie, RoomEntity room, LocalDateTime screeningTime, int duration) {
        if (movie == null || room == null) {
            throw new IllegalArgumentException("Movie and Room must not be null");
        }
        this.movie = movie;
        this.room = room;
        this.id = new ScreeningId(movie.getTitle(), room.getName());
        this.screeningTime = screeningTime;
        this.duration = duration;
    }
}