package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.models.Reserva;

public interface IReservaRepository extends JpaRepository<Reserva, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}
