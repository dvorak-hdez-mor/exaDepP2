import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
        // Leer y guardar usuarios e inmuebles
        Inmobiliaria via = new Inmobiliaria();
        ModeloInmoviliaria modelo = new ModeloInmoviliaria(via, "datos.bin");

        InmobiliariaVista vista = new InmobiliariaVista(modelo);
        vista.setVisible(true);

        // controlador (se activa con los eventos de la vista)
        // Personal p1 = new Personal("mahm","aaa", modelo.getInmobiliaria());
        // Vendedor v1 = new Vendedor( "nvc", modelo.getInmobiliaria());

        // alta de personal
        // modelo.getInmobiliaria().altaPersonal(p1);

        // alta de inmueble
        // via.getPersonal().get(0).altaInmueble("Urbano", "Puebla", 100.3f, 100000, 4, 2, "bonito", "foto", 99999, "Disponible");

        // logearse en el programa
        System.out.println(modelo.getInmobiliaria().logearse("mahm", "aaa"));

        // dar de baja a personal (?)
        //modelo.getInmobiliaria().bajaPersonal(p1);

        // alta de vendedores
        // modelo.getInmobiliaria().altaVendedor(v1);

        // ArrayList<Float> pagos = new ArrayList<Float>();
        // pagos = v1.cotizarPagos(80000, 20000, pagos);

        System.out.println("");

        // baja de inmueble
        //p1.bajaInmueble(0);

        // TEST: Carga de datos
        // cargaDatos(modelo);

        // Lectura de archivo y vista previa
        // Lectura de Personal

        System.out.println("Personal");
        for (Personal p: modelo.getInmobiliaria().getPersonal()){
            System.out.println(p.getUsuario());
            System.out.println(p.getContrasenia());
            System.out.println();
        }

        // Lectura de Vendedores
        System.out.println("Vendedores");
        for (Vendedor v: modelo.getInmobiliaria().getVendedores()){
            System.out.println(v.getUsuario());
            System.out.println();
        }

        System.out.println("Inmuebles");
        for (Inmueble inm: modelo.getInmobiliaria().getInmuebles()) {
            System.out.println(inm);
            System.out.println();
        }
        /*
        // Escribir / actualizar archivo
        // modelo.escribirArchivo();

        // Despues de la venta, sobreescribir el archivo con el nuevo status del inmueble

        // Generacion de cuotas
        modelo.getInmobiliaria().getVendedores().get(0).cuotas(0);
        float costo = modelo.getInmobiliaria().getInmuebles().get(0).getPrecioLista();
        ArrayList<Float> pagos = new ArrayList<Float>();
        pagos = modelo.getInmobiliaria().getVendedores().get(0).cotizarPagos(costo, 20000, pagos);
        modelo.getInmobiliaria().getVendedores().get(0).imprimirMensualidades(pagos, "pagos.txt");
         */
    }

    // TEST: Init datos iniciales hacia archivo
    public static void cargaDatos(ModeloInmoviliaria modelo){
        Personal p1 = new Personal("mahm","aaa", modelo.getInmobiliaria());
        Personal p2 = new Personal("nvc","eee", modelo.getInmobiliaria());
        Vendedor v1 = new Vendedor( "edm", modelo.getInmobiliaria());
        Vendedor v2 = new Vendedor( "rhg", modelo.getInmobiliaria());
        Vendedor v3 = new Vendedor( "whm", modelo.getInmobiliaria());

        modelo.getInmobiliaria().altaPersonal(p1);
        modelo.getInmobiliaria().altaPersonal(p2);
        modelo.getInmobiliaria().altaVendedor(v1);
        modelo.getInmobiliaria().altaVendedor(v2);
        modelo.getInmobiliaria().altaVendedor(v3);

        modelo.getInmobiliaria().getPersonal().get(0).altaInmueble("Urbano", "Puebla", 100.3f, 100000, 4, 2, "bonito", 99999, "Disponible");
        modelo.getInmobiliaria().getPersonal().get(1).altaInmueble("Urbano", "Puebla", 220.3f, 250000, 5, 3, "bonito", 99999, "Disponible");
        modelo.escribirArchivo();
    }
}
