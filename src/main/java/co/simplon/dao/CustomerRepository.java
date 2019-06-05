package co.simplon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import co.simplon.entities.Customer;
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
