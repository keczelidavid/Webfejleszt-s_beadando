package ticketservice.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ticketservice.data.entity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,String> {
    MovieEntity findByTitle(String title);
}