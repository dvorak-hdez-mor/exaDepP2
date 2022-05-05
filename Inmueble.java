import jdk.jshell.Snippet;

import java.io.Serializable;

public class Inmueble implements Serializable {
    private String tipo;
    private String ubicacion;
    private float tamanioArea;
    private float precio;
    private int numCuartos;
    private int numBanios;
    private String descripcion;
    private float precioLista;
    private String status; // Apartado, vendido, cuotas, disponible

    public Inmueble(String tipo, String ubicacion, float tamanioArea, float precio, int numCuartos, int numBanios, String descripcion, float precioLista, String status) {
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.tamanioArea = tamanioArea;
        this.precio = precio;
        this.numCuartos = numCuartos;
        this.numBanios = numBanios;
        this.descripcion = descripcion;
        this.precioLista = precioLista;
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getTamanioArea() {
        return tamanioArea;
    }

    public void setTamanioArea(float tamanioArea) {
        this.tamanioArea = tamanioArea;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getNumCuartos() {
        return numCuartos;
    }

    public void setNumCuartos(int numCuartos) {
        this.numCuartos = numCuartos;
    }

    public int getNumBanios() {
        return numBanios;
    }

    public void setNumBanios(int numBanios) {
        this.numBanios = numBanios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(float precioLista) {
        this.precioLista = precioLista;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString(){
        return "Tipo: "+tipo+"\n"+
                "Ubicacion: "+ubicacion+"\n"+
                "Tamaño del area: "+tamanioArea+" mts² \n"+
                "Precio: $"+precio+"\n"+
                "Numero de cuartos: "+numCuartos+"\n"+
                "Numero de baños: "+numBanios+"\n"+
                "Descripcion: "+descripcion+"\n"+
                "Precio de lista: "+precioLista+"\n"+
                "Status: "+status;
    }
}
