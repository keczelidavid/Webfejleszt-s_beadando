package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "Mozi film")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class MovieEntity {
    @Id
    private String title;
    @Column(name = "műfaj", nullable = false)
    private String genre;
    @Column(name = "időtartam", nullable = false)
    private int duration;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity movie = (MovieEntity) o;
        return duration == movie.duration && Objects.equals(title, movie.title) && Objects.equals(genre, movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, duration);
    }
}