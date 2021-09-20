package persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.entities.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
