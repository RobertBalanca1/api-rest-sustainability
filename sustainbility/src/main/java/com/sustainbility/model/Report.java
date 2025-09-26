package com.sustainbility.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reportName;
    private String description;
    private String reportDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    // Otros campos relacionados con los reportes pueden agregarse aquí.
}