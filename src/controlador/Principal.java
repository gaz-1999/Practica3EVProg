package controlador;

import vista.GUIPrincipal;

/**
 *
 * @author Gaz PC
 */
public class Principal {
    public static void main(String[] args) {
            GUIPrincipal gp = new GUIPrincipal();
        gp.setVisible(true);
        Controlador control = new Controlador(gp);
        gp.conectaControlador(control);     
    }    
}
