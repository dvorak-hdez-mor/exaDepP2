import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class InmobiliariaVista extends JFrame implements ActionListener {
    //Declaración de componentes
    private JPanel pBotones, pPersonal, pVendedor, pOpcionP, pOpcionV, pTitulo, pDatos, pDato;
    private JLabel lbInmov, lbTipo, lbClave, lbTamaño, lbCuarto, lbBaño, lbPrecio, lbStatus, lbDescri, lbPreL, lbUbi, lbSerie, lbNumInmueble;
    private JTextField txtTipo, txtClave, txtTamaño, txtCuartos, txtBaños, txtPrecio, txtStatus, txtPreL, txtUbi, txtSerie, txtNumInmueble;
    private JButton btPersonal, btVendedor, btEjecu1, btEjecu2, btTerminar, btImprimir, btConfirmar;
    private JTextArea txDes,txMostrar, txInfo;
    private JRadioButton[] opciones1, opciones2;
    private ButtonGroup grupo1, grupo2;
    private JComboBox buscar;
    private ModeloInmoviliaria modelo;
    private int identificador;
    float sueldo;
    ArrayList<Float> pagos = new ArrayList<Float>();

    public InmobiliariaVista(ModeloInmoviliaria modelo){
            super("EMPRESA DE MUEBLES");
            setLocation(150, 150);
            initComponentes();
            add(pTitulo, BorderLayout.NORTH);
            add(pBotones, BorderLayout.SOUTH);
            add(pPersonal);
            add(pVendedor);
            setSize(600, 500);
            setDefaultCloseOperation(this.EXIT_ON_CLOSE);
            this.modelo = modelo;
    } //constructor
    
    private void initComponentes(){
        pTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lbInmov = new JLabel("   INMOBILIARIA  ");
        pTitulo.add(lbInmov);
         
        pBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btPersonal = new JButton("Personal Inmueblerizado");
        btPersonal.addActionListener(this);
        btVendedor = new JButton("Vendedor");
        btVendedor.addActionListener(this);
        btTerminar = new JButton("Terminar");
        btTerminar.addActionListener(this);
        pBotones.add(btPersonal);
        pBotones.add(btVendedor);
        pBotones.add(btTerminar);
        
        pPersonal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pPersonal.setBackground(Color.YELLOW);
        pPersonal.setBounds(0, 20, 580, 400);
        pPersonal.setVisible(false);
        
        pVendedor = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pVendedor.setBackground(Color.CYAN);
        pVendedor.setBounds(0, 20, 600, 500);
        pVendedor.setVisible(false);
        
        componentesPanelPersonal(); //Inicializar componentes pPersonal
        componentesPanelVendedor(); //Inicializar componentes pVendedor
    }
    
    private void componentesPanelPersonal() {
        pDatos = new JPanel(new GridLayout(10,1));
        lbTipo = new JLabel("Tipo de inmueble: ");
        txtTipo = new JTextField("",10);
        lbClave = new JLabel("Clave de identificacion: ");
        txtClave = new JTextField("",10);
        lbUbi = new JLabel("Ubicacion: ");
        txtUbi = new JTextField("",10);
        lbTamaño = new JLabel("Tamaño del area: ");
        txtTamaño = new JTextField("",10);
        lbPrecio = new JLabel("Precio: ");
        txtPrecio = new JTextField("",10);
        lbCuarto = new JLabel("Num. de cuartos: ");
        txtCuartos = new JTextField("",10);
        lbBaño = new JLabel("Num. de baños: ");
        txtBaños = new JTextField("",10);
        lbDescri = new JLabel("Descripcion general: ");
        txDes = new JTextArea("",1,1);
        lbPreL = new JLabel("Precio de lista: ");
        txtPreL = new JTextField("",10);
        lbStatus = new JLabel("Status: ");
        txtStatus = new JTextField("",10);
        txInfo = new JTextArea("",15,15);
        txInfo.setVisible(false);
        
        pDatos.add(lbTipo);
        pDatos.add(txtTipo);
        pDatos.add(lbClave);
        pDatos.add(txtClave);
        pDatos.add(lbUbi);
        pDatos.add(txtUbi);
        pDatos.add(lbTamaño);
        pDatos.add(txtTamaño);
        pDatos.add(lbPrecio);
        pDatos.add(txtPrecio);
        pDatos.add(lbCuarto);
        pDatos.add(txtCuartos);
        pDatos.add(lbBaño);
        pDatos.add(txtBaños);
        pDatos.add(lbDescri);
        pDatos.add(txDes);
        pDatos.add(lbPreL);
        pDatos.add(txtPreL);
        pDatos.add(lbStatus);
        pDatos.add(txtStatus);
        JScrollPane pTxInfo = new JScrollPane(txInfo);
        
        btEjecu1 = new JButton("Ejecutar");
        btEjecu1.addActionListener(this);
        
        String[] elegir = { "Num.Cuartos", "Num.Baños", "Ubicacion", "Precio"};//opciones de combobox
        buscar = new JComboBox(elegir);
        buscar.setSelectedIndex(1);
        buscar.addActionListener(this);
        buscar.setVisible(false);
        
        pOpcionP = new JPanel ();
        pOpcionP.setLayout(new BoxLayout(pOpcionP, BoxLayout.X_AXIS));
        String []metodos = {
                "Altas", 
                "Bajas",
                "Modificaciones",
                "Visualizar",
        };
        opciones1 = new JRadioButton[metodos.length];
        grupo1 = new ButtonGroup();
        for(int i=0; i<metodos.length; i++)	{
                opciones1[i] = new JRadioButton(metodos[i]);
                opciones1[i].addActionListener(this);
                grupo1.add(opciones1[i]);
                pOpcionP.add(opciones1[i]);
        } 		
        opciones1[0].setSelected(true); //se establece la primera opcion como seleccionada
        pOpcionP.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        pOpcionP.setBorder(BorderFactory.createTitledBorder("Selecciona un metodo")); 
        
        pPersonal.add(pOpcionP);
        pPersonal.add(pDatos);
        pPersonal.add(txInfo);
        //pPersonal.add(pTxInfo);
        pPersonal.add(buscar);
        pPersonal.add(btEjecu1);
    }
    
    private void componentesPanelVendedor(){
        pDato = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lbSerie = new JLabel("Clave ");
        txtSerie = new JTextField("",10);
        txMostrar = new JTextArea("",15,30); // listado inmuebles
        txtNumInmueble = new JTextField("", 10);
        btEjecu2 = new JButton("Ejecutar");
        btEjecu2.addActionListener(this);
        btConfirmar = new JButton("Confirmar");
        btConfirmar.addActionListener(this);
        btConfirmar.setVisible(false);
        btImprimir = new JButton("Imprimir");
        btImprimir.addActionListener(this);
        btImprimir.setVisible(false);
        
        pDato.add(lbSerie);
        pDato.add(txtSerie);

        pOpcionV = new JPanel();
        pOpcionV.setLayout(new BoxLayout(pOpcionV, BoxLayout.X_AXIS));
        String []metodos = {
                "Visualizar", 
                "Cotizar en pagos",
                "Vender inmueble",
                "Apartar inmueble",
        };
        opciones2 = new JRadioButton[metodos.length];
        grupo2 = new ButtonGroup();
        for(int i=0; i<metodos.length; i++)	{
                opciones2[i] = new JRadioButton(metodos[i]);
                opciones2[i].addActionListener(this);
                grupo2.add(opciones2[i]);
                pOpcionV.add(opciones2[i]);
        } 		
        opciones2[0].setSelected(true); //se establece la primera opcion como seleccionada
        pOpcionV.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        pOpcionV.setBorder(BorderFactory.createTitledBorder("Selecciona un metodo")); 
      
        pVendedor.add(pOpcionV);
        pVendedor.add(pDato);

        //pDato.add(txMostrar);
        JScrollPane pTxtMostrar = new JScrollPane(txMostrar);
        pDato.add(pTxtMostrar);

        pVendedor.add(btEjecu2);
        pVendedor.add(btConfirmar);
        pVendedor.add(btImprimir);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String pass;
        
        if(e.getSource() == btPersonal) {  
	        pass = JOptionPane.showInputDialog(" Introduce tu contraseña: " );
            
            // Comprobar credenciales
            try {
                if (modelo.getInmobiliaria().logearse(pass)) {
                    pPersonal.setVisible(true);
                    pVendedor.setVisible(false);
                    txtClave.setText(Integer.toString(modelo.getInmobiliaria().getInmuebles().size()));
                    txtClave.setEditable(false);
                } else {
                    throw new ContraseniaIncorrectaException();
                }
            } catch (ContraseniaIncorrectaException err){
                JOptionPane.showMessageDialog(null, err.getMessage(), "Oops", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource() == btVendedor){
            pPersonal.setVisible(false);
            pVendedor.setVisible(true);
            // mostrar info inmuebles
            mostrarInfoInmuebles();
        }
        
        if(e.getSource() == btTerminar){
            System.exit(0);
        }
        
        int op = 0, n = 0;
        String inmueble, clave;
		if(e.getSource() == btEjecu1){
                    try{
                            //n = Integer.parseInt(txtClave.getText());	
                            op = getMetodoSeleccionado1();
                            switch(op){
                            case 0: //Altas
                                    String tipo = txtTipo.getText();
                                    String ubicacion = txtUbi.getText();
                                    float tamanioArea = Float.parseFloat(txtTamaño.getText());
                                    float precio = Float.parseFloat(txtPrecio.getText());
                                    int numCuartos = Integer.parseInt(txtCuartos.getText());
                                    int numBanios = Integer.parseInt(txtBaños.getText());
                                    String descripcion = txDes.getText();
                                    Float precioLista = Float.parseFloat(txtPreL.getText());
                                    String status = txtStatus.getText();

                                    Inmueble inmueble1 = new Inmueble(tipo, ubicacion, tamanioArea, precio, numCuartos, numBanios, descripcion, precioLista, status);
                                    modelo.getInmobiliaria().addInmueble(inmueble1);
                                    modelo.escribirArchivo();

                                    JOptionPane.showMessageDialog(null, "Se guardo el inmueble", "Exito", JOptionPane.INFORMATION_MESSAGE);
                                    resetTextField();
                                break;

                            case 1: //Bajas
                                    try {
                                        int identificador = Integer.parseInt(txtClave.getText());
                                        modelo.getInmobiliaria().eliminarInmueble(identificador);
                                        modelo.escribirArchivo();

                                        JOptionPane.showMessageDialog(null, "Se elimino el inmueble", "Exito", JOptionPane.INFORMATION_MESSAGE);

                                    } catch(Exception ex){
                                        JOptionPane.showMessageDialog(null, "No es posible realizar la baja", "Error datos", JOptionPane.ERROR_MESSAGE);
                                    }
                                    break;										
                            case 2: //Modificaciones
                                    try{
                                        // clave = JOptionPane.showInputDialog("Introduce la clave del inmueble: " );

                                        Inmueble inm = modelo.getInmobiliaria().getInmuebles().get(Integer.parseInt(txtClave.getText()));

                                        inm.setTipo(txtTipo.getText());
                                        inm.setUbicacion(txtUbi.getText());
                                        inm.setTamanioArea(Float.parseFloat(txtTamaño.getText()));
                                        inm.setPrecio(Float.parseFloat(txtPrecio.getText()));
                                        inm.setNumCuartos(Integer.parseInt(txtCuartos.getText()));
                                        inm.setNumBanios(Integer.parseInt(txtBaños.getText()));
                                        inm.setDescripcion(txDes.getText());
                                        inm.setPrecioLista(Float.parseFloat(txtPreL.getText()));
                                        inm.setStatus(txtStatus.getText());

                                        modelo.escribirArchivo();

                                        JOptionPane.showMessageDialog(null, "Se modifico el inmueble", "Exito", JOptionPane.INFORMATION_MESSAGE);
                                    } catch(Exception ex){
                                        JOptionPane.showMessageDialog(null, "La clave no existe o esta vacia", "Error datos", JOptionPane.ERROR_MESSAGE);
                                    }
                                     break;
                            case 3: //Visualizar
                                    
                                    break;
                            case 4: //Buscar dato
                                    
                                    break;
                            }
                    } catch(Exception ex) {
                            JOptionPane.showMessageDialog(null, "Dato de entrada no valido", "Error datos", JOptionPane.ERROR_MESSAGE);
                    }
 		} //if Ejecu1
 		
 		if(e.getSource() == opciones1[0] ) {//caso altas seleccionado
             resetTextField();
            pDatos.setVisible(true);
             txtClave.setEditable(false);
                        lbClave.setVisible(true);   txtClave.setVisible(true);
                        lbUbi.setVisible(true);    txtUbi.setVisible(true);
                        lbTipo.setVisible(true);   txtTipo.setVisible(true);
                        lbTamaño.setVisible(true); txtTamaño.setVisible(true);
                        lbPrecio.setVisible(true); txtPrecio.setVisible(true);
                        lbCuarto.setVisible(true);  txtCuartos.setVisible(true);
                        lbBaño.setVisible(true);    txtBaños.setVisible(true);
                        lbDescri.setVisible(true); txDes.setVisible(true);
                        lbPreL.setVisible(true);   txtPreL.setVisible(true);
                        lbStatus.setVisible(true); txtStatus.setVisible(true);
                        buscar.setVisible(false);     txInfo.setVisible(false);

                        txtClave.setText(Integer.toString(modelo.getInmobiliaria().getInmuebles().size()));
 		}
 		//otras opciones
 		if (e.getSource() == opciones1[1]){//caso bajas seleccionado
             resetTextField();
            pDatos.setVisible(true);
             txtClave.setEditable(true);
             txtClave.setText("");
                        lbClave.setVisible(true);   txtClave.setVisible(true);
                        lbUbi.setVisible(false);    txtUbi.setVisible(false);
                        lbTipo.setVisible(false);   txtTipo.setVisible(false);
                        lbTamaño.setVisible(false); txtTamaño.setVisible(false);
                        lbPrecio.setVisible(false); txtPrecio.setVisible(false);
                        lbCuarto.setVisible(false);  txtCuartos.setVisible(false);
                        lbBaño.setVisible(false);    txtBaños.setVisible(false);
                        lbDescri.setVisible(false); txDes.setVisible(false);
                        lbPreL.setVisible(false);   txtPreL.setVisible(false);
                        lbStatus.setVisible(false); txtStatus.setVisible(false);
                        buscar.setVisible(false);     txInfo.setVisible(false);
 		}
 		
 		if(e.getSource() == opciones1[2]){//caso modificaciones seleccionado
             resetTextField();
            pDatos.setVisible(true);
            txtClave.setText("");
            lbClave.setVisible(true);  txtClave.setVisible(true);
                                                   txtClave.setEditable(false);//desabilitamos el campo de la clave
                        lbUbi.setVisible(true);    txtUbi.setVisible(true);
                        lbTipo.setVisible(true);   txtTipo.setVisible(true);
                        lbTamaño.setVisible(true); txtTamaño.setVisible(true);
                        lbPrecio.setVisible(true); txtPrecio.setVisible(true);
                        lbCuarto.setVisible(true); txtCuartos.setVisible(true);
                        lbBaño.setVisible(true);   txtBaños.setVisible(true);
                        lbDescri.setVisible(true); txDes.setVisible(true);
                        lbPreL.setVisible(true);   txtPreL.setVisible(true);
                        lbStatus.setVisible(true); txtStatus.setVisible(true);
                        buscar.setVisible(false);     txInfo.setVisible(false);

                        // exception si el identificador no existe
                        try {
                            identificador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador: "));

                            Inmueble inm = modelo.getInmobiliaria().getInmuebles().get(identificador);

                            txtTipo.setText(inm.getTipo());
                            txtClave.setText(Integer.toString(identificador));
                            txtUbi.setText(inm.getUbicacion());
                            txtTamaño.setText(Float.toString(inm.getTamanioArea()));
                            txtPrecio.setText(Float.toString(inm.getPrecio()));
                            txtCuartos.setText(Integer.toString(inm.getNumCuartos()));
                            txtBaños.setText(Integer.toString(inm.getNumBanios()));
                            txDes.setText(inm.getDescripcion());
                            txtPreL.setText(Float.toString(inm.getPrecioLista()));
                            txtStatus.setText(inm.getStatus());
                        } catch (IndexOutOfBoundsException err){
                            JOptionPane.showMessageDialog(null, "El identificador no existe", "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (NumberFormatException err){
                            JOptionPane.showMessageDialog(null, "El indentificador es invalido o esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
                        }


 		}
                
                if(e.getSource() == opciones1[3]) {//caso visualizar seleccionado
                    resetTextField();
                    txtClave.setText("");
                        pDatos.setVisible(false);
                        buscar.setVisible(true);
                        txInfo.setVisible(true);
                        mostrarInfoInmuebles2();
                }

                if (e.getSource() == btImprimir){
                    try {
                        String nombreFichero = JOptionPane.showInputDialog(null, "Ingrese el nombre del archivo sin extension", "Nombre de archivo", JOptionPane.INFORMATION_MESSAGE);
                        modelo.getInmobiliaria().getVendedor().imprimirMensualidades(pagos, nombreFichero+".txt");
                        JOptionPane.showMessageDialog(null, "El archivo se guardo como: "+nombreFichero+".txt", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception err){

                    }
                }
                
                if(e.getSource() == btEjecu2){
                    try{
                            //n = Integer.parseInt(txtClave.getText());	
                            op = getMetodoSeleccionado2();
                            switch(op){
                            case 0: //Visualizar

                                    break;
                            case 1: //Cotizar en pagos
                                    //inmueble = JOptionPane.showInputDialog("Introduce el inmueble a seleccionar: ");
                                    try {
                                        int identificador = Integer.parseInt(txtSerie.getText());

                                        String status = modelo.getInmobiliaria().getInmuebles().get(identificador).getStatus();
                                        if (!status.equals("Disponible"))
                                            throw new InmuebleOcupadoException();
                                        //System.out.println(status);

                                        float costo = modelo.getInmobiliaria().getInmuebles().get(identificador).getPrecioLista();
                                        pagos.clear(); // reset pagos
                                        pagos = modelo.getInmobiliaria().getVendedor().cotizarPagos(costo, sueldo, pagos);

                                        String listaPagos = "# Mensualidad : Cantidad\n";
                                        int i = 1;
                                        for (float pago: pagos){
                                            listaPagos += i + " : " +"$"+pago+"\n";
                                            i++;
                                        }

                                        Inmueble inm = modelo.getInmobiliaria().getInmuebles().get(identificador);
                                        inm.setStatus("Cuotas");

                                        txMostrar.setText(listaPagos);
                                        btImprimir.setVisible(true);
                                        //modelo.escribirArchivo();

                                    } catch (NumberFormatException err){
                                        JOptionPane.showMessageDialog(null, "Valor de clave incorrecto", "Oops", JOptionPane.ERROR_MESSAGE);
                                    } catch (NullPointerException err){
                                        JOptionPane.showMessageDialog(null, "Valor de clave incorrecto", "Oops", JOptionPane.ERROR_MESSAGE);
                                    } catch (InmuebleOcupadoException err) {
                                        JOptionPane.showMessageDialog(null, err.getMessage(), "Oops", JOptionPane.ERROR_MESSAGE);
                                    }
                                    break;										
                            case 2: //Vender inmueble
                                    try {
                                        int identificador = Integer.parseInt(txtSerie.getText());
                                        String status = modelo.getInmobiliaria().getInmuebles().get(identificador).getStatus();

                                        if (!status.equals("Disponible"))
                                            throw new InmuebleOcupadoException();
                                        //System.out.println(status);

                                        Inmueble inm = modelo.getInmobiliaria().getInmuebles().get(identificador);

                                        inm.setStatus("Vendido");

                                        String nombreFichero = JOptionPane.showInputDialog(null, "Ingrese el nombre del archivo sin extension", "Generando factura", JOptionPane.INFORMATION_MESSAGE);

                                        modelo.getInmobiliaria().getVendedor().imprimirFactura(inm, nombreFichero+".txt");
                                        JOptionPane.showMessageDialog(null, "El archivo se guardo como: "+nombreFichero+".txt", "Exito", JOptionPane.INFORMATION_MESSAGE);
                                        mostrarInfoInmuebles();

                                        //modelo.escribirArchivo();
                                    } catch (NumberFormatException err){
                                        JOptionPane.showMessageDialog(null, "Valor de clave incorrecto", "Oops", JOptionPane.ERROR_MESSAGE);
                                    } catch (NullPointerException err){
                                        JOptionPane.showMessageDialog(null, "Valor de clave incorrecto", "Oops", JOptionPane.ERROR_MESSAGE);
                                    } catch (InmuebleOcupadoException err) {
                                        JOptionPane.showMessageDialog(null, err.getMessage(), "Oops", JOptionPane.ERROR_MESSAGE);
                                    }
                                     break;
                            case 3: //Apartar inmueble
                                try {
                                    int identificador = Integer.parseInt(txtSerie.getText());
                                    String status = modelo.getInmobiliaria().getInmuebles().get(identificador).getStatus();

                                    if (!status.equals("Disponible"))
                                        throw new InmuebleOcupadoException();
                                    //System.out.println(status);

                                    Inmueble inm = modelo.getInmobiliaria().getInmuebles().get(identificador);

                                    inm.setStatus("Apartado");

                                    String nombreFichero = JOptionPane.showInputDialog(null, "Ingrese el nombre del archivo sin extension", "Generando factura", JOptionPane.INFORMATION_MESSAGE);

                                    modelo.getInmobiliaria().getVendedor().imprimirFactura(inm, nombreFichero+".txt");
                                    JOptionPane.showMessageDialog(null, "El archivo se guardo como: "+nombreFichero+".txt", "Exito", JOptionPane.INFORMATION_MESSAGE);
                                    mostrarInfoInmuebles();

                                    //modelo.escribirArchivo();
                                } catch (NumberFormatException err){
                                    JOptionPane.showMessageDialog(null, "Valor de clave incorrecto", "Oops", JOptionPane.ERROR_MESSAGE);
                                } catch (NullPointerException err){
                                    JOptionPane.showMessageDialog(null, "Valor de clave incorrecto", "Oops", JOptionPane.ERROR_MESSAGE);
                                } catch (InmuebleOcupadoException err) {
                                    JOptionPane.showMessageDialog(null, err.getMessage(), "Oops", JOptionPane.ERROR_MESSAGE);
                                }

                                    break;
                            }
                    } catch(Exception ex) {
                            JOptionPane.showMessageDialog(null, "Dato de entrada no valido", "Error datos", JOptionPane.ERROR_MESSAGE);
                    }
                } //if Ejecu1
                if(e.getSource() == opciones2[0] ) {//caso visualizar seleccionado
                    txtSerie.setEditable(true);
                    mostrarInfoInmuebles();
                        lbSerie.setText("Clave: ");
                        txtSerie.setVisible(true);
                        txMostrar.setVisible(true);
                        btConfirmar.setVisible(false);
                        btImprimir.setVisible(false);
                }
                //otras opciones
                if (e.getSource() == opciones2[1]){//caso cotizar en pagos  seleccionado
                    txtSerie.setEditable(false);
                    mostrarInfoInmuebles();
                        lbSerie.setText("Clave: "); //restaura etiqueta
                        txtSerie.setVisible(true);
                        txMostrar.setVisible(true);
                        btConfirmar.setVisible(false);
                        btImprimir.setVisible(false);
                        try {
                            sueldo = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el sueldo del trabajador", "Sueldo", JOptionPane.INFORMATION_MESSAGE));
                            txtSerie.setEditable(true);
                        } catch (NumberFormatException err){
                            JOptionPane.showMessageDialog(null, "Valor de sueldo incorrecto", "Oops", JOptionPane.ERROR_MESSAGE);
                        } catch (NullPointerException err){

                        }

                }

                if(e.getSource() == opciones2[2]){//caso vender inmueble seleccionado
                    txtSerie.setEditable(true);
                    mostrarInfoInmuebles();
                        lbSerie.setText("Clave: ");
                        txtSerie.setVisible(true);
                        txMostrar.setVisible(true);
                        //btConfirmar.setVisible(true);
                        //btImprimir.setVisible(true);
                }

                if(e.getSource() == opciones2[3]) {//caso apartar inmueble seleccionado
                    txtSerie.setEditable(true);
                    mostrarInfoInmuebles();
                        lbSerie.setText("Clave: ");
                        txtSerie.setVisible(true);
                        txMostrar.setVisible(true);
                        //btConfirmar.setVisible(true);
                        //btImprimir.setVisible(false);
                }   
    } //Fin del oyente
    
    private int getMetodoSeleccionado1(){
     	for(int i=0; i<opciones1.length; i++)
     	{
            if(opciones1[i].isSelected())
     		return i;
     	}
     	return -1; //ninguna opcion fue seleccionada
        
     }
    
    private int getMetodoSeleccionado2(){
     	for(int i=0; i<opciones1.length; i++)
     	{
            if(opciones2[i].isSelected())
     		return i;
     	}
     	return -1; //ninguna opcion fue seleccionada
        
     }

     private void resetTextField(){
         txtTipo.setText("");
         txtUbi.setText("");
         txtTamaño.setText("");
         txtPrecio.setText("");
         txtCuartos.setText("");
         txtBaños.setText("");
         txDes.setText("");
         txtPreL.setText("");
         txtStatus.setText("");
     }

     private void mostrarInfoInmuebles(){
         String infoInmuebles = "";
         int contador = 0;

         for (Inmueble inm: modelo.getInmobiliaria().getInmuebles()){
             infoInmuebles += "Clave [ " + Integer.toString(contador) + " ]\n"+inm+"\n\n";
             contador++;
         }

         txMostrar.setText(infoInmuebles);
     }

    private void mostrarInfoInmuebles2(){
        String infoInmuebles = "";
        int contador = 0;

        for (Inmueble inm: modelo.getInmobiliaria().getInmuebles()){
            infoInmuebles += "Clave [ " + Integer.toString(contador) + " ]\n"+inm+"\n\n";
            contador++;
        }

        txInfo.setText(infoInmuebles);
    }
}
