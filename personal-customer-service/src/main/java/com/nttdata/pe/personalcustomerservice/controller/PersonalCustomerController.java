package com.nttdata.pe.personalcustomerservice.controller;

import com.nttdata.pe.personalcustomerservice.model.PersonalCustomer;
import com.nttdata.pe.personalcustomerservice.service.PersonalCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal-customers")
public class PersonalCustomerController {

    @Autowired
    private PersonalCustomerService service;

    @PostMapping("/register")
    public ResponseEntity<PersonalCustomer> registerCustomer(@RequestBody PersonalCustomer customer) {
        return ResponseEntity.ok(service.registerCustomer(customer));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonalCustomer> updateCustomer(@PathVariable Long id, @RequestBody PersonalCustomer customer) {
        PersonalCustomer updatedCustomer = service.updateCustomer(id, customer);
        if (updatedCustomer != null) {
            return ResponseEntity.ok(updatedCustomer);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonalCustomer>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalCustomer> getCustomerById(@PathVariable Long id) {
        PersonalCustomer customer = service.getCustomerById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        }
        return ResponseEntity.notFound().build();
    }
}
