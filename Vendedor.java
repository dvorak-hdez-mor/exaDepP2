import java.util.ArrayList;

public class Vendedor {
    private String usuario;
    private Inmobiliaria inmobiliaria;

    Vendedor(String usuario, Inmobiliaria inmobiliaria){
        this.usuario = usuario;
        this.inmobiliaria = inmobiliaria;
    }

    public Inmueble visualizar(int identificador){
        return this.inmobiliaria.getInmuebles().get(identificador); // excepcion cuando no exista
    }

    // recursiva
    public ArrayList<Float> cotizarPagos(float costo, float sueldo, ArrayList<Float> pagos){
        if (costo < sueldo) {
            pagos.add(costo);
        } else {
            cotizarPagos(costo*0.5f, sueldo, pagos);
            cotizarPagos(costo*0.4f, sueldo, pagos);
            cotizarPagos(costo*0.3f, sueldo, pagos);
            cotizarPagos(costo*0.2f, sueldo, pagos);
            cotizarPagos(costo*0.1f, sueldo, pagos);
        }
        return pagos;
    }

    public void vender(int identificador){ // que significa status?
        this.inmobiliaria.getInmuebles().get(identificador).setStatus(false);
    }

    public void apartar(int identificador){ // que significa status?
        this.inmobiliaria.getInmuebles().get(identificador).setStatus(false);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
