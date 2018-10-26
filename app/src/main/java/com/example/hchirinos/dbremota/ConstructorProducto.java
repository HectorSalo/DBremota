package com.example.hchirinos.dbremota;

public class ConstructorProducto {

    private String nombre_producto;
    private String marca_producto;
    private String unidad_producto;
    private double precio_producto;
    private int imagen_producto;

    public ConstructorProducto () {


    }

    public ConstructorProducto(String nombre_producto, String marca_producto, String unidad_producto, double precio_producto, int imagen_producto) {
        this.nombre_producto = nombre_producto;
        this.marca_producto = marca_producto;
        this.unidad_producto = unidad_producto;
        this.precio_producto = precio_producto;
        this.imagen_producto = imagen_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public String getMarca_producto() {
        return marca_producto;
    }

    public String getUnidad_producto() {
        return unidad_producto;
    }

    public double getPrecio_producto() {
        return precio_producto;
    }

    public int getImagen_producto() {
        return imagen_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setMarca_producto(String marca_producto) {
        this.marca_producto = marca_producto;
    }

    public void setUnidad_producto(String unidad_producto) {
        this.unidad_producto = unidad_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }

    public void setImagen_producto(int imagen_producto) {
        this.imagen_producto = imagen_producto;
    }
}
