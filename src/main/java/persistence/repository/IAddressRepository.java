package persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.entities.Address;

public interface IAddressRepository extends JpaRepository<Address,Long> {
}
