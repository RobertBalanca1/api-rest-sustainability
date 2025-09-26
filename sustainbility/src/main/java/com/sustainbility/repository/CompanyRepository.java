package com.sustainbility.repository;

import com.sustainbility.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByName(String name);  // Método para encontrar compañía por nombre
}

