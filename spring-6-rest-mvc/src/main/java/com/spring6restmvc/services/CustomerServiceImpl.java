package com.spring6restmvc.services;

import com.spring6restmvc.model.Beer;
import com.spring6restmvc.model.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        Customer bob = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Bob Daniel")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer carl = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Carl Logan")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer dan = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Dan Amarson")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(bob.getId(), bob);
        customerMap.put(carl.getId(), carl);
        customerMap.put(dan.getId(), dan);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return customerMap.get(id);
    }
}