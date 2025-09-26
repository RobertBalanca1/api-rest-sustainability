package com.sustainbility.repository;

import com.sustainbility.model.SustainabilityMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SustainabilityMetricRepository extends JpaRepository<SustainabilityMetric, Long> {
    List<SustainabilityMetric> findByCompanyId(Long companyId);  // Método para encontrar métricas por id de empresa
    SustainabilityMetric findByCompanyIdAndMetricName(Long companyId, String metricName);  // Método para encontrar métrica específica
}
