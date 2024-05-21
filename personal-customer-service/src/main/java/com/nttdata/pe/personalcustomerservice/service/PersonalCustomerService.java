package com.nttdata.pe.personalcustomerservice.service;

import com.nttdata.pe.personalcustomerservice.model.PersonalCustomer;
import com.nttdata.pe.personalcustomerservice.repository.PersonalCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalCustomerService {

    @Autowired
    private PersonalCustomerRepository repository;

    public PersonalCustomer registerCustomer(PersonalCustomer customer) {
        return repository.save(customer);
    }

    public PersonalCustomer updateCustomer(Long id, PersonalCustomer updatedCustomer) {
        Optional<PersonalCustomer> optionalCustomer = repository.findById(id);
        if (optionalCustomer.isPresent()) {
            PersonalCustomer existingCustomer = optionalCustomer.get();
            existingCustomer.setFirstName(updatedCustomer.getFirstName());
            existingCustomer.setLastName(updatedCustomer.getLastName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            return repository.save(existingCustomer);
        }
        return null;
    }

    public List<PersonalCustomer> getAllCustomers() {
        return repository.findAll();
    }

    public PersonalCustomer getCustomerById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
