package com.sustainbility.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    // Puedes agregar más campos si es necesario (por ejemplo, email, nombre completo, etc.)
}