package com.jose.api_buses.models.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroDeBus;
    private String placa;
    private String caracteristicas;
    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marcaDeBus;
    private boolean activo; //Activo o Inactivo

    public int getNumeroDeBus() {
        return numeroDeBus;
    }

    public void setNumeroDeBus(int numeroDeBus) {
        this.numeroDeBus = numeroDeBus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Marca getMarcaDeBus() {
        return marcaDeBus;
    }

    public void setMarcaDeBus(Marca marcaDeBus) {
        this.marcaDeBus = marcaDeBus;
    }
}
