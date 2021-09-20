package persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.entities.Turn;

public interface ITurnRepository extends JpaRepository<Turn,Long> {
}
