import java.io.Serializable;
import java.util.ArrayList;

public class Inmobiliaria implements Serializable {
    private Personal personal;
    private Vendedor vendedor;
    private ArrayList<Inmueble> inmuebles;

    Inmobiliaria(Personal personal, Vendedor vendedor){
        this.personal = personal;
        this.vendedor = vendedor;
        this.inmuebles = new ArrayList<Inmueble>();
    }

    Inmobiliaria(){
        this.inmuebles = new ArrayList<Inmueble>();
    }

    public boolean logearse(String contrasenia){
        if (personal.getContrasenia().equals(contrasenia))
            return true;
        return false;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void addInmueble(Inmueble inm){
        inmuebles.add(inm);
    }

    public void eliminarInmueble(int identificador){
        inmuebles.remove(identificador);
    }

    public ArrayList<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(ArrayList<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }
}
