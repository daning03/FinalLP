package com.fina.services;

import com.cibertec.models.Habitacion;
import com.cibertec.repository.IHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionServiceImpl implements IHabitacionService {

    @Autowired
    private IHabitacionRepository habitacionRepository;

    @Override
    public List<Habitacion> findAll() {
        return habitacionRepository.findAll();
    }

    @Override
    public Habitacion findById(Long id) {
        return habitacionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Habitacion habitacion) {
        habitacionRepository.save(habitacion);
    }

    @Override
    public void deleteById(Long id) {
        habitacionRepository.deleteById(id);
    }
}