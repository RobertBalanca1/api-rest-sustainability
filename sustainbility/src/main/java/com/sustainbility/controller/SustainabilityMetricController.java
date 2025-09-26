package com.sustainbility.controller;

import com.sustainbility.model.SustainabilityMetric;
import com.sustainbility.service.SustainabilityMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metrics")
public class SustainabilityMetricController {

    @Autowired
    private SustainabilityMetricService sustainabilityMetricService;

    // Obtener todas las métricas de sostenibilidad para una compañía
    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<SustainabilityMetric>> getMetricsByCompany(@PathVariable Long companyId) {
        List<SustainabilityMetric> metrics = sustainabilityMetricService.getMetricsByCompany(companyId);
        return !metrics.isEmpty() ? ResponseEntity.ok(metrics) : ResponseEntity.notFound().build();
    }

    // Crear una nueva métrica de sostenibilidad
    @PostMapping
    public SustainabilityMetric createMetric(@RequestBody SustainabilityMetric sustainabilityMetric) {
        return sustainabilityMetricService.createMetric(sustainabilityMetric);
    }
}
