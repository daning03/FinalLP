package com.cibertec.models;

import java.util.ArrayList;
import java.util.List;

import com.cibertec.models.Reserva;

public class Carrito {
    private List<Reserva> reservaencarrito = new ArrayList<>();

    public List<Reserva> getReservaEnCarrito() {
        return reservaencarrito;
    }

    public void agregarReserva(Reserva reserva) {
        reservaencarrito.add(reserva);
    }

    public void vaciarCarrito() {
        reservaencarrito.clear();
    }
}

