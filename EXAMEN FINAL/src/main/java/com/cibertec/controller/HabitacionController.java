package com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cibertec.models.Habitacion;
import com.cibertec.services.IHabitacionService;

import java.util.List;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionController {

    @Autowired
    private IHabitacionService habitacionService;

    @GetMapping("/listar")
    public String listarHabitaciones(Model model) {
        List<Habitacion> habitaciones = habitacionService.listarHabitaciones();
        model.addAttribute("habitaciones", habitaciones);
        return "habitaciones/listaHabitaciones";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        return "habitaciones/formularioAgregar";
    }

    @PostMapping("/agregar")
    public String agregarHabitacion(@ModelAttribute Habitacion habitacion) {
        habitacionService.agregarHabitacion(habitacion);
        return "redirect:/habitaciones/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Habitacion habitacion = habitacionService.obtenerHabitacionPorId(id);
        model.addAttribute("habitacion", habitacion);
        return "habitaciones/formularioEditar";
    }

    @PostMapping("/editar/{id}")
    public String editarHabitacion(@PathVariable Long id, @ModelAttribute Habitacion habitacion) {
        habitacion.setId(id);
        habitacionService.actualizarHabitacion(habitacion);
        return "redirect:/habitaciones/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarHabitacion(@PathVariable Long id) {
        habitacionService.eliminarHabitacion(id);
        return "redirect:/habitaciones/listar";
    }
}

