package com.fina.services;

import com.cibertec.models.Reserva;
import com.cibertec.repository.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements IReservaService {

    @Autowired
    private IReservaRepository reservaRepository;

    @Override
    public List<Reserva> obtenerTodas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    public void registrarReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    @Override
    public void actualizarReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    @Override
    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}