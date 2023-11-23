package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.models.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}
