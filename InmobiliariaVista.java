/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Meryr
 */ 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InmobiliariaVista extends JFrame implements ActionListener {
    //Declaración de componentes
    private JPanel pBotones, pPersonal, pVendedor, pOpcionP, pOpcionV, pTitulo, pDatos;
    private JLabel lbInmov, lbTipo, lbClave, lbTamaño, lbCuarto, lbBaño, lbPrecio, lbStatus, lbDescri, lbPreL, lbFoto;
    private JTextField txtTipo, txtClave, txtTamaño, txtCuartos, txtBaños, txtPrecio, txtStatus, txtPreL;
    private JButton btPersonal, btVendedor, btEjecu1, btEjecu2;
    private JTextArea txtDes;
    private JRadioButton[] opciones;
    private ButtonGroup grupo;
    private ModeloInmoviliaria modelo;
    
    public InmobiliariaVista(ModeloInmoviliaria modelo){
            super("EMPRESA DE MUEBLES");
            setLocation(150, 150);
            initComponentes();
            add(pTitulo, BorderLayout.NORTH);
            add(pBotones, BorderLayout.SOUTH);
            add(pPersonal);
            add(pVendedor);
            setSize(580, 400);
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
        pBotones.add(btPersonal);
        pBotones.add(btVendedor);
        
        pPersonal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pPersonal.setBackground(Color.YELLOW);
        pPersonal.setBounds(0, 20, 580, 400);
        pPersonal.setVisible(false);
        
        pVendedor = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pVendedor.setBackground(Color.CYAN);
        pVendedor.setBounds(0, 20, 580, 400);
        pVendedor.setVisible(false);
        
        componentesPanelPersonal(); //Inicializar componentes pPersonal
        componentesPanelVendedor(); //Inicializar componentes pVendedor
    }
    
    private void componentesPanelPersonal() {
        pDatos = new JPanel(new GridLayout(9,1));
        lbTipo = new JLabel("Tipo de inmueble: ");
        txtTipo = new JTextField("",10);
        lbClave = new JLabel("Clave de identificacion: ");
        txtClave = new JTextField("",10);
        lbTamaño = new JLabel("Tamaño del area: ");
        txtTamaño = new JTextField("",10);
        lbPrecio = new JLabel("Precio: ");
        txtPrecio = new JTextField("",10);
        lbCuarto = new JLabel("Num. de cuartos: ");
        txtCuartos = new JTextField("",10);
        lbBaño = new JLabel("Num. de baños: ");
        txtBaños = new JTextField("",10);
        lbDescri = new JLabel("Descripcion general: ");
        txtDes = new JTextArea("",1,1);
        //lbFoto = new JLabel("Foto: ");
        lbPreL = new JLabel("Precio de lista: ");
        txtPreL = new JTextField("",10);
        lbStatus = new JLabel("Status: ");
        txtStatus = new JTextField("",10);
        
        pDatos.add(lbTipo);
        pDatos.add(txtTipo);
        pDatos.add(lbClave);
        pDatos.add(txtClave);
        pDatos.add(lbTamaño);
        pDatos.add(txtTamaño);
        pDatos.add(lbPrecio);
        pDatos.add(txtPrecio);
        pDatos.add(lbCuarto);
        pDatos.add(txtCuartos);
        pDatos.add(lbBaño);
        pDatos.add(txtBaños);
        pDatos.add(lbDescri);
        pDatos.add(txtDes);
        //pDatos.add(lbFoto);
        pDatos.add(lbPreL);
        pDatos.add(txtPreL);
        pDatos.add(lbStatus);
        pDatos.add(txtStatus);
        
        btEjecu1 = new JButton("Ejecutar");
        btEjecu1.addActionListener(this);
        
        pOpcionP = new JPanel ();
        pOpcionP.setLayout(new BoxLayout(pOpcionP, BoxLayout.X_AXIS));
        String []metodos = {
                "Altas", 
                "Bajas",
                "Modificaciones",
                "Visualizar",
        };
        opciones = new JRadioButton[metodos.length];
        grupo = new ButtonGroup();
        for(int i=0; i<metodos.length; i++)	{
                opciones[i] = new JRadioButton(metodos[i]);
                opciones[i].addActionListener(this);
                grupo.add(opciones[i]);
                pOpcionP.add(opciones[i]);
        } 		
        opciones[0].setSelected(true); //se establece la primera opci�n como seleccionada
        pOpcionP.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        pOpcionP.setBorder(BorderFactory.createTitledBorder("Selecciona un metodo")); 
        
        pPersonal.add(pOpcionP);
        pPersonal.add(pDatos);
        pPersonal.add(btEjecu1);
    }
    
    private void componentesPanelVendedor() {
        pOpcionV = new JPanel();
        pOpcionV.setLayout(new BoxLayout(pOpcionV, BoxLayout.X_AXIS));
        String []metodos = {
                "Visualizar", 
                "Cotizar en pagos",
                "Vender inmueble",
                "Apartar inmueble",
                "Terminar",
        };
        opciones = new JRadioButton[metodos.length];
        grupo = new ButtonGroup();
        for(int i=0; i<metodos.length; i++)	{
                opciones[i] = new JRadioButton(metodos[i]);
                opciones[i].addActionListener(this);
                grupo.add(opciones[i]);
                pOpcionV.add(opciones[i]);
        } 		
        opciones[0].setSelected(true); //se establece la primera opci�n como seleccionada
        pOpcionV.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        pOpcionV.setBorder(BorderFactory.createTitledBorder("Selecciona un metodo")); 
        
        btEjecu2 = new JButton("Ejecutar");
        btEjecu2.addActionListener(this);
        
        pVendedor.add(pOpcionV); 
        pVendedor.add(btEjecu2);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario, pass;
        
        if(e.getSource() == btPersonal) {  
            usuario = JOptionPane.showInputDialog(" Introduce tu usuario " );
	        pass = JOptionPane.showInputDialog(" Introduce tu contraseña: " );

            // Comprobar credenciales
            try {
                if (modelo.getInmobiliaria().logearse(usuario, pass)) {
                    pPersonal.setVisible(true);
                    pVendedor.setVisible(false);
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
        }
        
        int op = 0, n = 0;
		if(e.getSource() == btEjecu1){
                    try{
                            // n = Integer.parseInt(txtClave.getText());
                            op = getMetodoSeleccionado();
                            switch(op){
                            case 0: //Altas
                                    try{
                                      
                                    } catch(Exception ex){
                                        JOptionPane.showMessageDialog(null, "No es posible realizar la baja", "Error datos de entrada", JOptionPane.ERROR_MESSAGE);
                                    }
                                    break;										
                            case 1: //Bajas
                                    
                                    break;										
                            case 2: //Modificaciones
                                    
                                     break;
                            case 3: //Visualizar
                                    
                                    break;
                            case 4: //Buscar dato
                                    
                                    break;
                            }
                    } catch(Exception ex) {
                            JOptionPane.showMessageDialog(null, "Dato de entrada no valido", "Error datos de entrada", JOptionPane.ERROR_MESSAGE);
                    }
 		} //if Ejecu1
 		
 		if(e.getSource() == opciones[0] ) {//caso altas seleccionado			
                        pDatos.setVisible(true);
 		}
 		//otras opciones
 		if (e.getSource() == opciones[1]){//caso bajas seleccionado 		                     
                        lbClave.setVisible(true);
                        txtClave.setVisible(true);
                        pDatos.setVisible(false);
 		}
 		
 		if(e.getSource() == opciones[2]){//caso modificaciones seleccionado
                        lbClave.setVisible(true);
                        txtClave.setVisible(true);
 			//pDatos.setVisible(false);		
 		}
                
                if(e.getSource() == opciones[3]) {//caso visualizar seleccionado
                        lbClave.setVisible(true);
                        txtClave.setVisible(true);
                        txtDes.setVisible(true);			
                }   
                
            if(e.getSource() == btEjecu2){
                try{
                        //n = Integer.parseInt(txtClave.getText());
                        op = getMetodoSeleccionado();
                        switch(op){
                        case 0: //Visualizar
                                System.out.println("hi");
                                break;										
                        case 1: //Cotizar en pagos

                                break;										
                        case 2: //Vender inmueble

                                 break;
                        case 3: //Apartar inmueble 

                                break;
                        case 4: //Terminar

                                break;
                        }
                } catch(Exception ex) {
                        JOptionPane.showMessageDialog(null, "Dato de entrada no valido", "Error datos de entrada", JOptionPane.ERROR_MESSAGE);
                        System.out.println(ex.getClass());
                }
            } //if Ejecu1

            if(e.getSource() == opciones[0] ) {//caso visualizar seleccionado			
                    lbClave.setVisible(true);
                    txtClave.setVisible(true);
                    pDatos.setVisible(false);
            }
            //otras opciones
            if (e.getSource() == opciones[1]){//caso cotizar en pagos  seleccionado 		                     
                    lbClave.setVisible(true);
                    txtClave.setVisible(true);
                    txtDes.setVisible(true);
                    pDatos.setVisible(false);
            }

            if(e.getSource() == opciones[2]){//caso vender inmueble seleccionado
                    lbClave.setVisible(true);
                    txtClave.setVisible(true);
                    pDatos.setVisible(false);		
            }

            if(e.getSource() == opciones[3]) {//caso apartar inmueble seleccionado
                    lbClave.setVisible(true);
                    txtClave.setVisible(true);
                    txtDes.setVisible(true);			
            }   
    }
    
    private int getMetodoSeleccionado(){
     	for(int i=0; i<opciones.length; i++)
     	{
            if(opciones[i].isSelected())
     		    return i;
     	}
     	return -1; //ninguna opcion fue seleccionada
     }
}
