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
public class PartidaFormas implements Partida {

    FormasBD fBD;
    FormasDAO fDAO;
    ArrayList<JButton> listaBotones = new ArrayList<>();
    ArrayList<FormasDAO> fLabel;
    ArrayList<FormasDAO> alformas;
    private LocalDateTime empieza;
    private LocalDateTime acaba;
    private int contador;

//--------------------------------CONSTRUCTOR-----------------------------------
    public PartidaFormas() {
        this.fBD = new FormasBD();
        this.fDAO = new FormasDAO();
        this.alformas = fBD.cargarFormas();
        this.fLabel = fBD.cargarFormas();
        Collections.shuffle(fLabel);
        generarBotones();
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

//----------------------------------MÉTODOS-------------------------------------
    @Override
    public void generarBotones() {
        ArrayList<JButton> botonesTemp = new ArrayList<>();
        for (int i = 0; i < alformas.size(); i++) {
            fDAO =alformas.get(i);
            //Genero un botón
            JButton boton = new JButton();
            //Casteo y escalo la imagen a icono
            ImageIcon icon= new ImageIcon(new ImageIcon(fDAO.getImagen()).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));            //Pongo la imagen de boton como la imagen casteada y escalada
            boton.setIcon(icon);
            //selecciono su acción con su id para identificarlos mejor
            boton.setActionCommand(Integer.toString(fDAO.getId()));
            //selecciono su nombre apra identificarlo con su id también
            boton.setName(Integer.toString(fDAO.getId()));
            //Añado el boton a una lista de botones para que sean más manejables posteriormente
            botonesTemp.add(boton);

        }
        //Mezclo los botones para que vayan un poco moviditos
        Collections.shuffle(botonesTemp);
        System.out.println("Salgo de asignar la lista de botones");
        listaBotones = botonesTemp;

    }

    @Override
    public ImageIcon generarLabel(int img_Width, int img_Height) {
        //Cargo la imagen que ocupe la posición del contador en el label
        Image imgTemp = fLabel.get(contador).getImagen().getScaledInstance(img_Width, img_Height, Image.SCALE_SMOOTH);
        ImageIcon imagenLabel = new ImageIcon(imgTemp);

        return imagenLabel;
    }

    @Override
    public void comprobarConLabel(int idinferior) {
        if (idinferior == fLabel.get(contador).getId()) {
            //Hacer que el botón se gire y SE QUEDE DADO LA VUELTA
            //--CÓDIGO--

            if (contador != fLabel.size()) {
                //Sumo el contador para saber que voy avanzando:
                contador++;

            } else {
                //Si el cont es igual que el label, has ganado porque no te queda más que adivinar:

            }
        } else {
            //Si no coinciden es que te has equivocado:
            reset();
        }

    }

    @Override
    public void reset() {
        contador = 0;
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
