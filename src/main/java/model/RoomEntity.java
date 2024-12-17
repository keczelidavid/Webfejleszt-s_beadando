package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "Terem")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class RoomEntity {
    @Id
    private String name;
    private int seatRows;
    private int seatColumns;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntity that = (RoomEntity) o;
        return seatRows == that.seatRows && seatColumns == that.seatColumns && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, seatRows, seatColumns);
    }
}
