import java.awt.*;
import java.io.Serializable;

public class Personal implements Serializable {
    private String contrasenia;
    private Inmobiliaria inmobiliaria;

    Personal(String contrasenia){
        this.contrasenia = contrasenia;
    }

    public void altaInmueble(String tipo, String ubicacion, float tamanioArea, float precio, int numCuartos, int numBanios, String descripcion, float precioLista, String status){
        Inmueble inm = new Inmueble(tipo, ubicacion, tamanioArea, precio, numCuartos, numBanios, descripcion, precioLista, status);
        inmobiliaria.addInmueble(inm);
    }

    public void bajaInmueble(int indice){
        inmobiliaria.getInmuebles().remove(indice);
    }

    public Inmobiliaria getInmobiliaria() {
        return inmobiliaria;
    }

    public void setInmobiliaria(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String toString(){
        return "Contrasenia: "+this.contrasenia;
    }
}
