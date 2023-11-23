package com.fina.services;

import com.cibertec.models.Habitacion;

import java.util.List;

public interface IHabitacionService {
    List<Habitacion> findAll();
    Habitacion findById(Long id);
    void save(Habitacion habitacion);
    void deleteById(Long id);
	Habitacion obtenerHabitacionPorId(Long habitacionId);
	List<Habitacion> obtenerTodasLasHabitaciones();
}