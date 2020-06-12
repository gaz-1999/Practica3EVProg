package modelo;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Gaz PC
 */
public class FormasDAO {

    private int id;
    private Image imagen;
    private ArrayList<JButton> listaBotones;

//----------------------------CONSTRUCTORES-------------------------------------
    public FormasDAO(int id, Image imagen) {
        this.id = id;
        this.imagen = imagen;
    }

    public FormasDAO() {
    }

//-----------------------------GET Y SET----------------------------------------
    public int getId() {
        return id;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

//-----------------------------MÉTODOS------------------------------------------
    public ArrayList<JButton> alABotones(ArrayList formitas) {
        listaBotones = new ArrayList<>();
        for (int i = 0; i < formitas.size(); i++) {
            FormasDAO temp = new FormasDAO();
            temp = (FormasDAO) formitas.get(i);
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
