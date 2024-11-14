package ma.emsi.bankaccountserver.repositories;

import ma.emsi.bankaccountserver.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
