package com.sustainbility.service;

import com.sustainbility.model.Report;
import com.sustainbility.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    // Generar un reporte para una compañía (puedes personalizar más dependiendo de los detalles)
    public Report generateReport(Long companyId) {
        // Aquí debes definir cómo generas los reportes. En este ejemplo, solo retornamos el primer reporte encontrado.
        List<Report> reports = reportRepository.findByCompanyId(companyId);
        if (!reports.isEmpty()) {
            return reports.get(0);  // Retorna el primer reporte disponible, si existe
        }
        return null;  // Si no hay reportes, retornar null
    }

    // Crear un nuevo reporte
    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    // Obtener todos los reportes de una compañía
    public List<Report> getReportsByCompany(Long companyId) {
        return reportRepository.findByCompanyId(companyId);
    }
}
