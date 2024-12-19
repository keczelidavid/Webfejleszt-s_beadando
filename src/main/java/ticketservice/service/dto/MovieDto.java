package ticketservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieDto {
    private String title;
    private String genre;
    private int duration;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDto movieDto = (MovieDto) o;
        return duration == movieDto.duration && Objects.equals(title, movieDto.title) && Objects.equals(genre, movieDto.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, duration);
    }
}
