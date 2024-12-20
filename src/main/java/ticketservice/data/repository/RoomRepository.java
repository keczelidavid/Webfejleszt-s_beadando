package ticketservice.data.repository;

import ticketservice.data.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity,String> {
    RoomEntity findByName(String name);
}