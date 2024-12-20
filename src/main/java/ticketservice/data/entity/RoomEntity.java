package ticketservice.data.entity;

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
    @Column(name = "ülés sorok száma", nullable = false)
    private Integer seatRows;
    @Column(name = "ülés oszlopok száma", nullable = false)
    private Integer seatColumns;

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

    @Override
    public String toString() {
        return "RoomEntity{" +
                "name='" + name + '\'' +
                ", seatRows=" + seatRows +
                ", seatColumns=" + seatColumns +
                '}';
    }
}
