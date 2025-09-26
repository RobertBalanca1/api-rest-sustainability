package com.sustainbility.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sustainability_metrics")
public class SustainabilityMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String metricName;
    private String description;
    private Double value;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}