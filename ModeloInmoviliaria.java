import java.io.*;
import java.util.ArrayList;

public class ModeloInmoviliaria {

    private Inmobiliaria inmobiliaria;
    private String fichero;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;

    ModeloInmoviliaria(Inmobiliaria inmobiliaria, String fichero){
        this.inmobiliaria = inmobiliaria;
        entrada = null;
        salida = null;
        this.fichero = fichero;
        this.leerArchivo();
    }

    public void leerArchivo(){
        try {
            this.entrada = new ObjectInputStream(new FileInputStream(this.fichero));
            Object objeto;

            objeto = this.entrada.readObject(); // Primera lectura

            while (objeto != null){
                if (objeto instanceof Vendedor)
                    this.inmobiliaria.setVendedor((Vendedor) objeto);
                else if (objeto instanceof Personal)
                    this.inmobiliaria.setPersonal((Personal) objeto);
                else if (objeto instanceof Inmueble)
                    this.inmobiliaria.getInmuebles().add((Inmueble) objeto);
                objeto = this.entrada.readObject();
            }

        } catch (FileNotFoundException err){
            System.out.println("Archivo no encontrado");
        } catch (IOException err){
            System.out.println(err.getCause());
        } catch (ClassNotFoundException err){
            System.out.println(err.getCause());
        } finally {
            try {
                this.entrada.close(); // Cerrando Stream
            } catch (IOException err){
                System.out.println(err.getCause());
            }
        }
    }

    public void escribirArchivo(){
        try {
            this.salida = null;
            this.salida = new ObjectOutputStream(new FileOutputStream(this.fichero));

            salida.writeObject(inmobiliaria.getPersonal());

            salida.writeObject(inmobiliaria.getVendedor());

            for (Inmueble inm: inmobiliaria.getInmuebles()){
                salida.writeObject(inm);
            }

        } catch (FileNotFoundException err){
            System.out.println("Archivo no encontrado");
        } catch (IOException err){
            System.out.println(err.getCause());
        } finally {
            try {
                this.salida.close(); // Cerrando Stream
            } catch (IOException err){
                System.out.println(err.getCause());
            }
        }
    }

    public Inmobiliaria getInmobiliaria(){
        return inmobiliaria;
    }

}
