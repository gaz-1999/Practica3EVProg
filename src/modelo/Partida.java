package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Gaz PC
 */
public interface Partida {
//-----------------------------------Métodos------------------------------------
    void generarBotones();
    void generarBotonesOcultos();

    ImageIcon generarLabel(int img_Width, int img_Height);

    void comprobarConLabel(int idInferiorl);

    void reset();
    
    int tiempoTotal();
    

}
