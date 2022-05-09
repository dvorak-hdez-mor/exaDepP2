import java.io.Serializable;
import java.util.ArrayList;

public class Inmobiliaria implements Serializable {
    private ArrayList<Personal> personal;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Inmueble> inmuebles;

    Inmobiliaria(){
        this.personal = new ArrayList<Personal>();
        this.vendedores = new ArrayList<Vendedor>();
        this.inmuebles = new ArrayList<Inmueble>();
    }

    public void altaPersonal(Personal personal){ // Se usa al momento de leer archivo
        this.personal.add(personal);
    }

    public void bajaPersonal(Personal personal){
        this.personal.remove(personal);
    }

    public void altaVendedor(Vendedor vendedor){
        this.vendedores.add(vendedor);
    }

    public void bajaVendedor(Vendedor vendedor){
        this.vendedores.remove(vendedor);
    }

    public boolean logearse(String usuario, String contrasenia){

        for (Personal p: personal){
            if (p.getUsuario().equals(usuario) && p.getContrasenia().equals(contrasenia))
                return true;
        }
        return false;
    }

    public boolean logearse(String usuario){
        for (Vendedor v: vendedores){
            if (v.getUsuario() == usuario)
                return true;
        }
        return false;
    }

    public ArrayList<Personal> getPersonal() {
        return personal;
    }

    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }

    public ArrayList<Inmueble> getInmuebles() {
        return inmuebles;
    }
}
