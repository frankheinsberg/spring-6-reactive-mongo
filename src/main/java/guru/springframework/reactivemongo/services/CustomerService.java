package guru.springframework.reactivemongo.services;

import guru.springframework.reactivemongo.domain.Customer;
import guru.springframework.reactivemongo.model.CustomerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<CustomerDTO> listCustomers();

    Mono<CustomerDTO> save (Mono<CustomerDTO> customerDTO);

    Mono<CustomerDTO> getById (String customerName);

    Mono<CustomerDTO> updateCustomer (String customerName, CustomerDTO customerDTO);

    Mono<CustomerDTO> patchCustomer (String customerName, CustomerDTO customerDTO);

    Mono<Void> deleteCustomerById (String customerId);
}
