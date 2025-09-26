package com.sustainbility.service;

import com.sustainbility.model.SustainabilityMetric;
import com.sustainbility.repository.SustainabilityMetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SustainabilityMetricService {

    @Autowired
    private SustainabilityMetricRepository sustainabilityMetricRepository;

    // Obtener todas las métricas de sostenibilidad de una compañía
    public List<SustainabilityMetric> getMetricsByCompany(Long companyId) {
        return sustainabilityMetricRepository.findByCompanyId(companyId);
    }

    // Obtener una métrica de sostenibilidad específica por el nombre de la métrica
    public SustainabilityMetric getMetricsByCompanyAndName(Long companyId, String metricName) {
        return sustainabilityMetricRepository.findByCompanyIdAndMetricName(companyId, metricName);
    }

    // Crear una nueva métrica de sostenibilidad
    public SustainabilityMetric createMetric(SustainabilityMetric sustainabilityMetric) {
        return sustainabilityMetricRepository.save(sustainabilityMetric);
    }

    // Actualizar una métrica de sostenibilidad existente
    public SustainabilityMetric updateMetric(Long id, SustainabilityMetric sustainabilityMetric) {
        if (sustainabilityMetricRepository.existsById(id)) {
            sustainabilityMetric.setId(id);  // Aseguramos que el ID no se sobrescriba
            return sustainabilityMetricRepository.save(sustainabilityMetric);
        }
        return null;  // Si no existe la métrica con ese ID, retornar null
    }

    // Eliminar una métrica de sostenibilidad
    public boolean deleteMetric(Long id) {
        if (sustainabilityMetricRepository.existsById(id)) {
            sustainabilityMetricRepository.deleteById(id);
            return true;
        }
        return false;  // Si no existe la métrica con ese ID, retornar false
    }
}
