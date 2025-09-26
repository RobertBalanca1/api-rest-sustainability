package com.sustainbility.service;

import com.sustainbility.model.Company;
import com.sustainbility.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    // Obtener todas las compañías
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Obtener una compañía por su ID
    public Company getCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.orElse(null);  // Si no existe, retorna null
    }

    // Crear una nueva compañía
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    // Actualizar una compañía existente
    public Company updateCompany(Long id, Company company) {
        if (companyRepository.existsById(id)) {
            company.setId(id);  // Aseguramos que el ID no se sobrescriba
            return companyRepository.save(company);
        }
        return null;  // Si no existe la compañía con ese ID, retornar null
    }

    // Eliminar una compañía por su ID
    public boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;  // Si no existe la compañía con ese ID, retornar false
    }
}
