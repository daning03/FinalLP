package com.fina.services;

import com.cibertec.models.Habitacion;
import com.cibertec.models.Reserva;

import java.util.List;

public interface IReservaService {
    List<Reserva> obtenerTodas();
    Reserva obtenerReservaPorId(Long id);
    void registrarReserva(Reserva reserva);
    void actualizarReserva(Reserva reserva);
    void eliminarReserva(Long id);
	List<Reserva> obtenerReservasEnCarrito();
	void agregarReservaAlCarrito(Habitacion habitacion);
	void limpiarCarrito();
}