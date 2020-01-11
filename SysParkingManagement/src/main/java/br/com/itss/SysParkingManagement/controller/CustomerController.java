package br.com.itss.SysParkingManagement.controller;

import br.com.itss.SysParkingManagement.exception.ResourceNotFoundException;
import br.com.itss.SysParkingManagement.model.Customer;
import br.com.itss.SysParkingManagement.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public Page<Customer> getCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Customer with id " + id + "not found")
                );
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable Long id,
                                   @Valid @RequestBody Customer customerRequest) throws ResourceNotFoundException {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(customerRequest.getName());
                    customer.setCpf(customerRequest.getCpf());
                    customer.setPhoneNumber(customerRequest.getPhoneNumber());
                    return customerRepository.save(customer);
                }).orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + "not found"));
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) throws ResourceNotFoundException {
        return customerRepository.findById(id)
                .map(question -> {
                    customerRepository.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + "not found"));
    }
    
}
