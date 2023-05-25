package guru.springframework.reactivemongo.services;

import guru.springframework.reactivemongo.domain.Customer;

public class CustomerServiceImplTest {

    public static Customer getTestCustomer() {
        return Customer.builder()
                .customerName("New Customer")
                .build();
    }
}
