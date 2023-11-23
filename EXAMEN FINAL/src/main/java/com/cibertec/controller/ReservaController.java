package com.cibertec.controller;

import com.cibertec.models.Habitacion;
import com.cibertec.models.Reserva;
import com.fina.services.IHabitacionService;
import com.fina.services.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private IReservaService reservaService;

    @Autowired
    private IHabitacionService habitacionService;

    @GetMapping("/carrito")
    public String verCarrito(Model model) {
        List<Reserva> reservasEnCarrito = reservaService.obtenerReservasEnCarrito();
        model.addAttribute("reservasEnCarrito", reservasEnCarrito);
        return "carritoReservas";
    }

    @PostMapping("/agregarCarrito/{habitacionId}")
    public String agregarReservaAlCarrito(@PathVariable Long habitacionId, Model model) {
        Habitacion habitacion = habitacionService.obtenerHabitacionPorId(habitacionId);
        reservaService.agregarReservaAlCarrito(habitacion);

        List<Habitacion> habitaciones = habitacionService.obtenerTodasLasHabitaciones();
        model.addAttribute("habitaciones", habitaciones);

        return "redirect:/habitaciones/catalogo";
    }

    @GetMapping("/confirmarReserva")
    public String confirmarReserva(Model model) {
        List<Reserva> reservasEnCarrito = reservaService.obtenerReservasEnCarrito();
        model.addAttribute("reservasEnCarrito", reservasEnCarrito);

        if (!reservasEnCarrito.isEmpty()) {
            boolean pagoExitoso = procesarPago();

            if (pagoExitoso) {
                reservaService.confirmarReservas(reservasEnCarrito);
                enviarCorreosConfirmacion(reservasEnCarrito);
                reservaService.limpiarCarrito();
            } else {
                return "pagoFallido";
            }
        

        return "confirmacionReserva";


    private boolean procesarPago() {
        try {
            // Simulación de procesamiento de pago exitoso
            System.out.println("Procesando pago...");
            Thread.sleep(2000); // Simular el tiempo de procesamiento
            System.out.println("Pago exitoso");
            return true;
        } catch (InterruptedException e) {
            System.out.println("Error en el procesamiento de pago: " + e.getMessage());
            return false;
        }
    }

    private void enviarCorreosConfirmacion(List<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            // Simulación de envío de correo de confirmación
            System.out.println("Enviando correo de confirmación a: " + reserva.getCliente().getEmail());
        }
    }
}