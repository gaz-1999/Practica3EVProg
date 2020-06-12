package controlador;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Robot;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.FormasBD;
import modelo.FormasDAO;
import modelo.Instruc;
import modelo.NumerosBD;
import modelo.NumerosDAO;
import modelo.PartidaFormas;
import modelo.PartidaNumeros;
import modelo.PartidaVocales;
import modelo.Partidita;
import modelo.VocalesBD;
import modelo.VocalesDAO;
import vista.GUIInstrucciones;
import vista.GUIPrincipal;

/**
 *
 * @author Gaz PC
 */
public class Controlador implements ActionListener {

    private GUIPrincipal gp;
    private String opcionesDeJuego[] = {"Vocales", "Figuras geométricas", "Números"};
    private PartidaVocales partidaV;
    private PartidaFormas partidaF;
    private PartidaNumeros partidaN;
    private ArrayList<JButton> buto = new ArrayList<>();
    private int opcion;

//---------------------------CONSTRUCTOR------------------------------------    
    public Controlador(GUIPrincipal gp) {
        this.gp = gp;
    }

    public ArrayList<JButton> getButo() {
        return buto;
    }

//--------------------------RESTO DE MÉTODOS--------------------------------
    public static String LeerInstrucciones() throws IOException {
        String instrucciones = "No hay instrucciones disponibles";

        if (Instruc.leerIntstruccionestxt() != null) {
            instrucciones = Instruc.leerIntstruccionestxt();
            return instrucciones;
        } else {
            return instrucciones;
        }
    }

    public void generarBotones() {
        //añado los botones desde el ArrayList
        for (JButton boton : buto) {
            this.gp.getPanelDeJuego().add(boton);
        }
        //.getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_DEFAULT) para escalar imagen
        gp.pack();
        gp.repaint();
        
    }

    public void actBotones() {
        switch (opcion) {
            case 0:
                buto = partidaV.getListaBotonesOcultos();
                gp.getPanelDeJuego().removeAll();
                generarBotones();
                break;

            case 1:
                buto = partidaF.getListaBotones();
                generarBotones();
                break;
            case 2:
                buto = partidaN.getListaBotones();
                generarBotones();
                break;
        }

    }

    public void actLabel() {
        Icon icono = null;

        switch (opcion) {
            case 0:
                icono = partidaV.generarLabel(gp.getOrdenLabel().getWidth(), gp.getOrdenLabel().getHeight());
                break;

            case 1:
                icono = partidaF.generarLabel(gp.getOrdenLabel().getWidth(), gp.getOrdenLabel().getHeight());
                break;
            case 2:
                icono = partidaN.generarLabel(gp.getOrdenLabel().getWidth(), gp.getOrdenLabel().getHeight());
                break;
        }
        gp.getOrdenLabel().setIcon(icono);
        gp.getOrdenLabel().repaint();

    }

//    public void extraerImagenes() {
//        //Mezclador de arrays para que los botones se ordenen de manera random
//        Collections.shuffle(buto);
//        System.out.println("Mezclo los botones");
//    }
//    public void MisBotones() {
//        
//        
////        for (int i = 0; i < buto.size(); i++) {
////        JButton boton = new JButton(buto.)
////        
////        }
//        
//
////            VocalesDAO vocal = new VocalesDAO();
//////            lista.get(i) = vocal;
////
////            JButton boton = new JButton((Icon) vocal.getImagen());
////            buto.add(boton);
//    }
    public void pepe() {
        try {
            Thread.sleep(5000);
            System.out.println("nepe");
        } catch (InterruptedException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "botonInstrucciones": 
                try {
                GUIInstrucciones gi = new GUIInstrucciones();
                gi.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            case "botonSalir":
                int resp = JOptionPane.showConfirmDialog(null, "Si pulsa a 'Sí' y sale se perderá todo el progreso del juego. Si no quiere salir pulse 'No'.", "¿Estás seguro?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                //    si marca sí devolverá 0, si marca no, devolverá 1
                if (resp == 0) {
                    System.out.println("Salir");
                    gp.dispose();
                    System.exit(0);
                }
                break;

            case "nuevaPartida":
                int res = JOptionPane.showConfirmDialog(null, "Si pulsa a 'Sí' y reinicia se perderá todo el progreso del juego. Si no quiere empezar una nueva partida pulse 'No'.", "¿Estás seguro?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (res == 0) {
                    opcion = JOptionPane.showOptionDialog(null, "Elija entre las siguientes su opción para jugar", "¿Qué quieres adivinar hoy?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesDeJuego, opcionesDeJuego[1]);
                    if (opcion == -1) {
                        JOptionPane.showMessageDialog(gp, "Parece que ha cancelado la selección de los elementos de partida, se cancelará la nueva partida.", "¿Te has arrepentido?", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        gp.getOrdenLabel().removeAll();
                        gp.getPanelDeJuego().removeAll();

                        switch (opcion) {
                            case 0:
                                //Opoción si elije vocales
                                System.out.println("Elige Vocales");
                                partidaV = new PartidaVocales();                             
                                buto = partidaV.getListaBotones();
                                generarBotones();
                                buto = partidaV.getListaBotonesOcultos();
                                actLabel();
                                actBotones();
                                gp.conectarBotones(this);
//                                partidaV.generarBotonesOcultos();
                                break;

                            case 1:
                                //Opción si elige figuras geométricas
                                System.out.println("Elige Firguras Geométricas");
                                partidaF = new PartidaFormas();
                                buto = partidaF.getListaBotones();
                                generarBotones();
                                gp.conectarBotones(this);
                                actLabel();
                                break;

                            case 2:
                                //Opción si elige números.
                                System.out.println("Elige Números");
                                partidaN = new PartidaNumeros();
                                buto = partidaN.getListaBotones();
                                generarBotones();
                                gp.conectarBotones(this);
                                actLabel();
                                break;
                        }

//                        for (JButton boton : this.gp.botones) {
//                        }
                        //restablezco los botones de las imagenes
//                        for (JButton boton : this.gp.botones) {
//                            boton.setEnabled(true);
//                            boton.repaint();
//                        }
                    }
                }
                System.out.println("Anis");
                
//            try {
//                Thread.sleep(3000);
//                System.out.println("i");
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
//            }
                    
                
                break;

            default:
                JButton boton = (JButton) e.getSource();
                System.out.println(boton.getActionCommand());
                String imagenId = boton.getName();
                int id = Integer.parseInt(imagenId);
                switch (opcion) {
                    case 0:
                        partidaV.comprobarConLabel(id);
                        actLabel();
                        actBotones();
                        break;

                    case 1:
                        partidaF.comprobarConLabel(id);
                        actLabel();
                        actBotones();
                        break;
                    case 2:
                        partidaN.comprobarConLabel(id);
                        actLabel();
                        actBotones();
                        break;
                }
//                partida.comprobarImagen(id);
//                vidasParaTodos(partida.comprobarLetra(letraPulsada));
                break;

        }
//        for (JButton boton : this.gp.botones) {
//        }
    }

}
