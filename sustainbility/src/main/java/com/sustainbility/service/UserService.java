package com.sustainbility.service;

import com.sustainbility.model.User;
import com.sustainbility.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Obtener un usuario por nombre de usuario
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);  // Busca al usuario por nombre de usuario
    }

    // Crear un nuevo usuario
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Actualizar un usuario existente
    public User updateUser(String username, User user) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            user.setId(existingUser.getId());  // No sobrescribir el ID
            return userRepository.save(user);
        }
        return null;  // Si no se encuentra el usuario, retornar null
    }

    // Eliminar un usuario por su nombre de usuario
    public boolean deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;  // Si no existe el usuario, retornar false
    }
}
