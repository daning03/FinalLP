package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.models.Habitacion;

public interface IHabitacionRepository extends JpaRepository<Habitacion, Integer> {
}
