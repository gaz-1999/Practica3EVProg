package vista;

import controlador.Controlador;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.Element;

/**
 *
 * @author Gaz PC
 */
public class GUIPrincipal extends javax.swing.JFrame {
    
    Controlador controlador = new Controlador(this);
//    public ArrayList<JButton> botones = new ArrayList();
    ArrayList imgBotones = new ArrayList();

    public GUIPrincipal() {
        initComponents();
        botonInstrucciones.setActionCommand("botonInstrucciones");
        botonSalir.setActionCommand("botonSalir");
        nuevaPartida.setActionCommand("nuevaPartida");
        //Organizamos las figuras a adivinar en partes iguales en tres filas: 
        this.panelDeJuego.setLayout(new GridLayout(3, 0));

        //Centramos el panel y bloqueamos su capacidad de expansión/reducción:
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.dispose();
    }

    private void crearBotones(){
       controlador.generarBotones();
    }
    
//    public void generarBotones(ArrayList<JButton> misBotones){
//        
//        for (JButton botones : misBotones) {
//            this
//            
//        }   
//        
//        
//        
//        
//    }
    
    
    
//    private void crearBotones() {
//        imgBotones = Controlador.crearBotones();
//        for (int i = 0; i < imgBotones.size(); i++) {
//            JButton boton = new JButton(imgBotones[]);
//            boton.setText(imgBotones[i]);
//            boton.setActionCommand(imgBotones[i]);
//            botones.add(boton);
//            this.panelDeJuego.add(boton);
//            boton.setEnabled(false);
//        }
//
//    }
    public void conectarBotones(Controlador c){
             for (JButton boton : c.getButo()) {
            boton.addActionListener(c);
        }   
    }
    
    
    public void conectaControlador(Controlador c) {
        botonSalir.addActionListener(c);
        botonInstrucciones.addActionListener(c);
        nuevaPartida.addActionListener(c);
    }
    
//-----------------------------------GET Y SET----------------------------------

    public JPanel getPanelDeJuego() {
        return panelDeJuego;
    }

    public void setPanelDeJuego(JPanel panelDeJuego) {
        this.panelDeJuego = panelDeJuego;
    }

    public JLabel getOrdenLabel() {
        return ordenLabel;
    }

    
    

    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        imagenARecordarLabel = new javax.swing.JLabel();
        ordenLabel = new javax.swing.JLabel();
        panelDerecha = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        nuevaPartida = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        botonInstrucciones = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        botonSalir = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        panelDeJuego = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelContenedor.setMinimumSize(new java.awt.Dimension(500, 300));
        panelContenedor.setPreferredSize(new java.awt.Dimension(500, 350));
        panelContenedor.setLayout(new java.awt.BorderLayout());

        panelSuperior.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 50, 10, 150));
        panelSuperior.setMaximumSize(new java.awt.Dimension(400, 12));
        panelSuperior.setMinimumSize(new java.awt.Dimension(400, 80));
        panelSuperior.setLayout(new java.awt.BorderLayout());

        imagenARecordarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagenARecordarLabel.setText("La imagen a recordar es:");
        imagenARecordarLabel.setMaximumSize(new java.awt.Dimension(180, 40));
        imagenARecordarLabel.setMinimumSize(new java.awt.Dimension(150, 30));
        imagenARecordarLabel.setPreferredSize(new java.awt.Dimension(150, 35));
        panelSuperior.add(imagenARecordarLabel, java.awt.BorderLayout.LINE_START);

        ordenLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ordenLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ordenLabel.setMaximumSize(new java.awt.Dimension(100, 100));
        ordenLabel.setMinimumSize(new java.awt.Dimension(80, 80));
        ordenLabel.setName(""); // NOI18N
        ordenLabel.setPreferredSize(new java.awt.Dimension(90, 90));
        panelSuperior.add(ordenLabel, java.awt.BorderLayout.CENTER);

        panelContenedor.add(panelSuperior, java.awt.BorderLayout.PAGE_START);

        panelDerecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelDerecha.setLayout(new javax.swing.BoxLayout(panelDerecha, javax.swing.BoxLayout.PAGE_AXIS));
        panelDerecha.add(filler2);

        nuevaPartida.setText("Nueva Partida");
        nuevaPartida.setAlignmentX(0.5F);
        nuevaPartida.setMaximumSize(new java.awt.Dimension(150, 30));
        nuevaPartida.setMinimumSize(new java.awt.Dimension(80, 40));
        nuevaPartida.setPreferredSize(new java.awt.Dimension(130, 30));
        panelDerecha.add(nuevaPartida);
        panelDerecha.add(filler4);

        botonInstrucciones.setText("Instrucciones");
        botonInstrucciones.setAlignmentX(0.5F);
        botonInstrucciones.setMaximumSize(new java.awt.Dimension(150, 30));
        botonInstrucciones.setMinimumSize(new java.awt.Dimension(80, 40));
        botonInstrucciones.setPreferredSize(new java.awt.Dimension(130, 30));
        panelDerecha.add(botonInstrucciones);
        panelDerecha.add(filler1);

        botonSalir.setText("Salir");
        botonSalir.setAlignmentX(0.5F);
        botonSalir.setMaximumSize(new java.awt.Dimension(150, 30));
        botonSalir.setMinimumSize(new java.awt.Dimension(80, 40));
        botonSalir.setPreferredSize(new java.awt.Dimension(130, 30));
        panelDerecha.add(botonSalir);
        panelDerecha.add(filler3);

        panelContenedor.add(panelDerecha, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout panelDeJuegoLayout = new javax.swing.GroupLayout(panelDeJuego);
        panelDeJuego.setLayout(panelDeJuegoLayout);
        panelDeJuegoLayout.setHorizontalGroup(
            panelDeJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        panelDeJuegoLayout.setVerticalGroup(
            panelDeJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        panelContenedor.add(panelDeJuego, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelContenedor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonInstrucciones;
    private javax.swing.JButton botonSalir;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JLabel imagenARecordarLabel;
    private javax.swing.JButton nuevaPartida;
    private javax.swing.JLabel ordenLabel;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelDeJuego;
    private javax.swing.JPanel panelDerecha;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration//GEN-END:variables
}
