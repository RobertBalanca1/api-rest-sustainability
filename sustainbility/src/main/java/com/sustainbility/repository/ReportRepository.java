package com.sustainbility.repository;

import com.sustainbility.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByCompanyId(Long companyId);  // Método para encontrar reportes por id de empresa
}
