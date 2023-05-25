package guru.springframework.reactivemongo.services;

import guru.springframework.reactivemongo.domain.Customer;
import guru.springframework.reactivemongo.mappers.CustomerMapper;
import guru.springframework.reactivemongo.model.CustomerDTO;
import guru.springframework.reactivemongo.repositories.CustomerRepsoitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepsoitory customerRepsoitory;

    private final CustomerMapper customerMapper;

    @Override
    public Flux<CustomerDTO> listCustomers() {

        return customerRepsoitory.findAll()
                .map(customerMapper::customerToCustomerDto);
    }

    @Override
    public Mono<CustomerDTO> save(Mono<CustomerDTO> customerDTO) {

        return customerDTO.map(customerMapper::customerDtoToCustomer)
                .flatMap(customerRepsoitory::save)
                .map(customerMapper::customerToCustomerDto);
    }

    @Override
    public Mono<CustomerDTO> getById(String customerId) {

        return customerRepsoitory.findById(customerId)
                .map(customerMapper::customerToCustomerDto);
    }

    @Override
    public Mono<CustomerDTO> updateCustomer(String customerId, CustomerDTO customerDTO) {

        return customerRepsoitory.findById(customerId)
                .map(foundCustomer -> {
                    foundCustomer.setCustomerName(customerDTO.getCustomerName());
                    return foundCustomer;
                }).flatMap(customerRepsoitory::save)
                .map(customerMapper::customerToCustomerDto);
    }

    @Override
    public Mono<CustomerDTO> patchCustomer(String customerName, CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public Mono<Void> deleteCustomerById(String customerId) {

        return customerRepsoitory.deleteById(customerId);
    }
}
