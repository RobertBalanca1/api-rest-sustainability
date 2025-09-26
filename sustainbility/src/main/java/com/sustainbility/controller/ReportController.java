package com.sustainbility.controller;

import com.sustainbility.model.Report;
import com.sustainbility.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/company/{companyId}")
    public Report generateReport(@PathVariable Long companyId) {
        return reportService.generateReport(companyId);
    }

    @PostMapping
    public Report createReport(@RequestBody Report report) {
        return reportService.createReport(report);
    }
}
