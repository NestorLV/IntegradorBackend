package persistence.repository;

import persistence.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long>{
    @Query("FROM Odontologo u WHERE u.nombre = ?1")
    List<Dentist> searchDentistByName(String name);

}
