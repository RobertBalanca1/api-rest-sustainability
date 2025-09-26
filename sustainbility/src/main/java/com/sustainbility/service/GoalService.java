package com.sustainbility.service;

import com.sustainbility.model.Goal;
import com.sustainbility.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    // Obtener todas las metas de una compañía
    public List<Goal> getGoalsByCompany(Long companyId) {
        return goalRepository.findByCompanyId(companyId);  // Utiliza el método personalizado en el repositorio
    }

    // Obtener una meta por su ID
    public Goal getGoalById(Long id) {
        Optional<Goal> goal = goalRepository.findById(id);
        return goal.orElse(null);  // Si no existe, retorna null
    }

    // Crear una nueva meta
    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    // Actualizar una meta existente
    public Goal updateGoal(Long id, Goal goal) {
        if (goalRepository.existsById(id)) {
            goal.setId(id);  // Aseguramos que el ID no se sobrescriba
            return goalRepository.save(goal);
        }
        return null;  // Si no existe la meta con ese ID, retornar null
    }

    // Eliminar una meta por su ID
    public boolean deleteGoal(Long id) {
        if (goalRepository.existsById(id)) {
            goalRepository.deleteById(id);
            return true;
        }
        return false;  // Si no existe la meta con ese ID, retornar false
    }
}
