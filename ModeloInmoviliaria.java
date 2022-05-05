import java.io.*;
import java.util.ArrayList;

public class ModeloInmoviliaria {

    Inmobiliaria inmobiliaria;
    String fichero;
    ObjectInputStream entrada;
    ObjectOutputStream salida;

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
                    this.inmobiliaria.altaVendedor((Vendedor) objeto);
                else if (objeto instanceof Personal)
                    this.inmobiliaria.altaPersonal((Personal) objeto);
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
            this.salida = new ObjectOutputStream(new FileOutputStream(this.fichero));

            for (Personal p: inmobiliaria.getPersonal()){
                salida.writeObject(p);
            }

            for (Vendedor v: inmobiliaria.getVendedores()){
                salida.writeObject(v);
            }

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
