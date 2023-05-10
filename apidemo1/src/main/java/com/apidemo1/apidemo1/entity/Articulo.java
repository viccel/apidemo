package com.apidemo1.apidemo1.entity;


import javax.persistence.*;

@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private Long id; //clave única del producto. Dato alfanumérico de 10 caracteres. No se permite actualizar.

    @Column(updatable = false)
    private String nombre; //nombre con el que se identifica al producto. Dato alfanumérico de hasta 20 caracteres. No se permite actualizar.
    private String descripcion; //campo que contiene una descripción general del producto. Dato alfanumérico de hasta 200 caracteres. Se permite actualizar.
    @Column(updatable = false)
    private double precio; //Dato numérico con dos decimales. No se permite actualizar.
    private String modelo; //alfanumérico de 10 caracteres. Se permite actualizar

    public Articulo() {
    }

    public Articulo(Long id, String nombre, String descripcion, double precio, String modelo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
