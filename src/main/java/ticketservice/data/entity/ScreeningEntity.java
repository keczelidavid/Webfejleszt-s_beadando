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
public class ScreeningEntity {

    @EmbeddedId
    private ScreeningId id;

    @ManyToOne
    @MapsId("movieTitle")
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    @ManyToOne
    @MapsId("roomName")
    @JoinColumn(name = "room_id")
    private RoomEntity room;
    @Column(name = "vetités kezdete", nullable = false)
    private LocalDateTime screeningTime;

    public ScreeningEntity(MovieEntity movie, RoomEntity room, LocalDateTime screeningTime, int duration) {
        if (movie == null || room == null) {
            throw new IllegalArgumentException("Movie and Room must not be null");
        }
        this.movie = movie;
        this.room = room;
        this.id = new ScreeningId(movie.getTitle(), room.getName());
        this.screeningTime = screeningTime;
    }
}