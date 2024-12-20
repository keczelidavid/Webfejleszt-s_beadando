package ticketservice.data.entity;




import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Vetítés")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ScreeningEntity {

    @EmbeddedId
    private ScreeningId id;

    @ManyToOne
    @MapsId("movieTitle")
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieEntity movie;

    @ManyToOne
    @MapsId("roomName")
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;

    @Column(name = "vetités kezdete")
    private LocalDateTime screeningTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScreeningEntity that = (ScreeningEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(movie, that.movie) && Objects.equals(room, that.room) && Objects.equals(screeningTime, that.screeningTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movie, room, screeningTime);
    }
}