import java.awt.*;
import java.io.Serializable;

public class Personal implements Serializable {
    private String usuario; // para distinguir entre usuarios con la misma contrasenia
    private String contrasenia;
    private Inmobiliaria inmobiliaria;

    Personal(String usuario, String contrasenia, Inmobiliaria inmobiliaria){
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.inmobiliaria = inmobiliaria;
    }

    public void altaInmueble(String tipo, String ubicacion, float tamanioArea, float precio, int numCuartos, int numBanios, String descripcion, float precioLista, String status){
        inmobiliaria.getInmuebles().add(new Inmueble(tipo, ubicacion, tamanioArea, precio, numCuartos, numBanios, descripcion, precioLista, status));
    }

    public void bajaInmueble(int indice){
        inmobiliaria.getInmuebles().remove(indice);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
}
