package com.nttdata.pe.personalcustomerservice.repository;

import com.nttdata.pe.personalcustomerservice.model.PersonalCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalCustomerRepository extends JpaRepository<PersonalCustomer, Long> {
}
