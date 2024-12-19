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
public class RoomDto {
    private String name;
    private int seatRows;
    private int seatColumns;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomDto roomDto = (RoomDto) o;
        return seatRows == roomDto.seatRows && seatColumns == roomDto.seatColumns && Objects.equals(name, roomDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, seatRows, seatColumns);
    }
}
