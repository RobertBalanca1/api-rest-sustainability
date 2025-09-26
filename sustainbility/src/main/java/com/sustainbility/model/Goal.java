package com.sustainbility.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goalName;
    private String description;
    private String targetDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    // Otros campos relacionados con las metas pueden agregarse aquí.
}