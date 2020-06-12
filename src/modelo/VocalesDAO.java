/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Gaz PC
 */
public class VocalesDAO {

    private int id;
    private Image imagen;
    private ArrayList<JButton> listaBotones;

//----------------------------------CONSTRUCTORES-------------------------------
    public VocalesDAO(int id, Image imagen) {
        this.id = id;
        this.imagen = imagen;
    }

    public VocalesDAO() {
    }

//--------------------------------GET Y SET-------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

//-----------------------------MÉTODOS------------------------------------------
    public ArrayList<JButton> alABotones(ArrayList formitas) {
        listaBotones = new ArrayList<>();
        for (int i = 0; i < formitas.size(); i++) {
            VocalesDAO temp = new VocalesDAO();
            temp = (VocalesDAO) formitas.get(i);
            //Casteo la imagen a icono
            ImageIcon icon = new ImageIcon(temp.getImagen());
            //Genero un botón que tenga como icono su propia imagen
            JButton boton = new JButton(icon);
            //selecciono su acción con su id para identificarlos mejor
            boton.setActionCommand(Integer.toString(temp.getId()));
            //selecciono su nombre apra identificarlo con su id también
            boton.setName(Integer.toString(temp.getId()));
            //Añado el boton a una lista de botones para que sean más manejables posteriormente
            listaBotones.add(boton);

        }
        //Mezclo los botones para que vayan un poco moviditos
        Collections.shuffle(listaBotones);
        System.out.println("Salgo de asignar la lista de botones");
        return listaBotones;
    }

}
