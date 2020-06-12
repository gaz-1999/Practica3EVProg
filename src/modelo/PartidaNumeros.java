/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Image;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Gaz PC
 */
public class PartidaNumeros implements Partida {

    NumerosBD nBD;
    NumerosDAO nDAO;
    ArrayList<JButton> listaBotones = new ArrayList<>();
    ArrayList<JButton> listaBotonesOcultos = new ArrayList<>();
    ArrayList<NumerosDAO> alnumeros;
    ArrayList<NumerosDAO> nLabel;
    private LocalDateTime empieza;
    private LocalDateTime acaba;
    private int contador;

//--------------------------------CONSTRUCTOR-----------------------------------
    public PartidaNumeros() {
        this.nBD = new NumerosBD();
        this.nDAO = new NumerosDAO();
        this.alnumeros = nBD.cargarNumeros();
        this.nLabel = nBD.cargarNumeros();
        Collections.shuffle(nLabel);
        generarBotones();
        generarBotonesOcultos();
        this.empieza = LocalDateTime.now();
        this.contador = 0;
    }
//--------------------------------GET Y SET-------------------------------------

    public ArrayList<JButton> getListaBotones() {
        return listaBotones;
    }

    public void setListaBotones(ArrayList<JButton> listaBotones) {
        this.listaBotones = listaBotones;
    }

    public ArrayList<JButton> getListaBotonesOcultos() {
        return listaBotonesOcultos;
    }

    public void setListaBotonesOcultos(ArrayList<JButton> listaBotonesOcultos) {
        this.listaBotonesOcultos = listaBotonesOcultos;
    }

//----------------------------------MÉTODOS-------------------------------------
    @Override
    public void generarBotones() {
        ArrayList<JButton> botonesTemp = new ArrayList<>();
        for (int i = 0; i < alnumeros.size(); i++) {
            nDAO = alnumeros.get(i);
            //Genero un botón
            JButton boton = new JButton();
            //Casteo y escalo la imagen a icono
            ImageIcon icon = new ImageIcon(new ImageIcon(nDAO.getImagen()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
            //Pongo la imagen de boton como la imagen casteada y escalada
            boton.setIcon(icon);
            //selecciono su acción con su id para identificarlos mejor
            boton.setActionCommand(Integer.toString(nDAO.getId()));
            //selecciono su nombre apra identificarlo con su id también
            boton.setName(Integer.toString(nDAO.getId()));
            //Los pongo enabled
            boton.setEnabled(true);
            //Añado el boton a una lista de botones para que sean más manejables posteriormente
            botonesTemp.add(boton);

        }
        //Mezclo los botones para que vayan un poco moviditos
        Collections.shuffle(botonesTemp);
        //se lo asigno a mi al de botones y esta a los ocultos
        listaBotones = botonesTemp;
        listaBotonesOcultos = listaBotones;
    }

    @Override
    public ImageIcon generarLabel(int img_Width, int img_Height) {
        if (contador >= nLabel.size()) {
            Image imgTemp = nLabel.get(nLabel.size() - 1).getImagen().getScaledInstance(img_Width, img_Height, Image.SCALE_SMOOTH);
            ImageIcon imagenLabel = new ImageIcon(imgTemp);
            return imagenLabel;
        } else {
            //Cargo la imagen que ocupe la posición del contador en el label
            Image imgTemp = nLabel.get(contador).getImagen().getScaledInstance(img_Width, img_Height, Image.SCALE_SMOOTH);
            ImageIcon imagenLabel = new ImageIcon(imgTemp);
            return imagenLabel;
        }
    }

    @Override
    public void comprobarConLabel(int idInferior) {
        if (idInferior == nLabel.get(contador).getId()) {
            //Hacer que el botón se gire y SE QUEDE DADO LA VUELTA
            for (int i = 0; i < listaBotones.size(); i++) {
                if (idInferior == Integer.parseInt(listaBotones.get(i).getActionCommand())) {
                    listaBotones.get(i);
                    listaBotonesOcultos.set(i, listaBotones.get(i));
                }
            }
            contador++;
            if (contador == nLabel.size()) {
                //Si el cont es igual que el label, has ganado porque no te queda más que adivinar:
                System.out.println("YouWIn");
            }
//            if (contador < vLabel.size()) {
//                //Sumo el contador para saber que voy avanzando:
//                contador++;
//            } else {
//                
//            }
        } else {
            //Si no coinciden es que te has equivocado:
            reset();
            for (JButton boton : listaBotones) {
                boton.setEnabled(true);
            }
            System.out.println("Fallaste pendejo");
        }
    }

    @Override
    public void reset() {
        contador = 0;
        for (JButton boton : listaBotones) {
            boton.setEnabled(true);
        }
        //Llamo al método del controlador para actualizar el label en cosnsecuencia:
        //Hago que todos los botones se pongan por defecto: 
    }

    @Override
    public int tiempoTotal() {
        acaba = LocalDateTime.now();
        //Capturamos los segundos, minutos e incluso horas que tardemos y los pasamos a segundos para saber cuántos segundos ha tardado y le restamos los 15 segundos de ojear la imágenes.
        int tiempo = ((int) ChronoUnit.SECONDS.between(empieza, acaba) + ((int) ChronoUnit.MINUTES.between(empieza, acaba) * 60) + ((int) ChronoUnit.HOURS.between(empieza, acaba) * 3600)) - 15;
        System.out.println("Ha tardado " + tiempo);
        return tiempo;
    }

    @Override
    public void generarBotonesOcultos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
