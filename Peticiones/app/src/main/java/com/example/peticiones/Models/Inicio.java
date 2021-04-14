package com.example.peticiones.Models;

import java.io.Serializable;

public class Inicio implements Serializable {
    public boolean estado;
    public String[] detalle;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String[] getDetalle() {
        return detalle;
    }

    public void setDetalle(String[] detalle) {
        this.detalle = detalle;
    }
}
