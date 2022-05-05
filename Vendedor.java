import java.io.*;
import java.util.ArrayList;

public class Vendedor implements Serializable {
    private String usuario;
    private Inmobiliaria inmobiliaria;
    private PrintWriter salidaPagos;

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

    public void imprimirMensualidades(ArrayList<Float> pagos, String pagosFichero){
        try {
            salidaPagos = new PrintWriter(new BufferedWriter(new FileWriter(pagosFichero)));

            salidaPagos.println("Adquisicion de inmueble por pagos mensuales");
            salidaPagos.println("Mensualidad: Cuota");

            int contador = 1;
            for (Float p: pagos){
                salidaPagos.println(contador + ": $"+p);
                contador++;
            }
        } catch (IOException err){
            System.out.println("Error al crear el archivo.");
        } finally {
            salidaPagos.close(); // cerrando stream
        }
    }

    public void vender(int identificador){ // que significa status?
        this.inmobiliaria.getInmuebles().get(identificador).setStatus("Vendido");
    }

    public void apartar(int identificador){ // que significa status?
        this.inmobiliaria.getInmuebles().get(identificador).setStatus("Apartado");
    }

    public void cuotas(int identificador){
        this.inmobiliaria.getInmuebles().get(identificador).setStatus("Cuotas");
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
