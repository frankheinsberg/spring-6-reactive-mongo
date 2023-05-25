package guru.springframework.reactivemongo.repositories;

import guru.springframework.reactivemongo.domain.Customer;
import guru.springframework.reactivemongo.model.CustomerDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface CustomerRepsoitory extends ReactiveMongoRepository<Customer, String> {

    Mono<CustomerDTO> findFirstByCustomerName(String customerName);
}
