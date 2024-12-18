package ticketservice.data.entity;




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
    @Column(name = "mozi film", nullable = false)
    private MovieEntity movie;

    @ManyToOne
    @MapsId("roomName")
    @Column(name = "szoba", nullable = false)
    private RoomEntity room;
    @Column(name = "vetités kezdete", nullable = false)
    private LocalDateTime screeningTime;

    public Screening(MovieEntity movie, RoomEntity room, LocalDateTime screeningTime, int duration) {
        if (movie == null || room == null) {
            throw new IllegalArgumentException("Movie and Room must not be null");
        }
        this.movie = movie;
        this.room = room;
        this.id = new ScreeningId(movie.getTitle(), room.getName());
        this.screeningTime = screeningTime;
    }
}