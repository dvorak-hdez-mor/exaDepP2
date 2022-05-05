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
        // aqui se inicializa el metodo para la lectura del archivo
        this.fichero = fichero;
        this.leerArchivo();
    }

    // pendiente hacer metodos para la lectura del archivo de usuarios y de la inmobiliaria

    public void leerArchivo(){
        try {
            this.entrada = new ObjectInputStream(new FileInputStream(this.fichero));
            Object empleado;

            empleado = this.entrada.readObject(); // Primera lectura

            while (empleado != null){
                if (empleado instanceof Vendedor)
                    this.inmobiliaria.altaVendedor((Vendedor) empleado);
                if (empleado instanceof Personal)
                    this.inmobiliaria.altaPersonal((Personal) empleado);
                empleado = this.entrada.readObject();
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
