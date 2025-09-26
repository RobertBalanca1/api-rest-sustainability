package com.sustainbility.repository;

import com.sustainbility.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByCompanyId(Long companyId);  // Método para encontrar metas por id de empresa
}
