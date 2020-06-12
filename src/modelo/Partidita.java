package modelo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author Gaz PC
 */
public class Partidita {

    private LocalDateTime empieza;
    private LocalDateTime acaba;
    private ArrayList<FormasDAO> formas;
    private ArrayList<VocalesDAO> vocales;
    private ArrayList<NumerosDAO> numeros;
    private VocalesDAO voc;
    private FormasDAO formitas;
    private NumerosDAO numeritos;
    
    //-----------------------------CONSTRUCTORES------------------------------
    public Partidita() {
        //Hacemos un comienzo de tiempo para que empiece a contar al empezar la partida
        this.empieza = LocalDateTime.now();
    }

//    public Partidita(ArrayList al) {
//        this.empieza = LocalDateTime.now();
//        al = formas;
//    }
//
//    public Partidita(ArrayList<VocalesDAO> vocales) {
//        this.empieza = LocalDateTime.now();
//        this.vocales = vocales;
//    }

    public Partidita(VocalesDAO voc) {
        this.empieza = LocalDateTime.now();
        this.voc = voc;
    }

    public Partidita(FormasDAO formitas) {
        this.empieza = LocalDateTime.now();
        this.formitas = formitas;
    }

    public Partidita(NumerosDAO numeritos) {
        this.empieza = LocalDateTime.now();
        this.numeritos = numeritos;
    }


    //---------------------------GET Y SET--------------------------------------
    public void setNumeritos(NumerosDAO numeritos) {
        this.numeritos = numeritos;
    }
    public VocalesDAO getVoc(){
        return voc;
    }

    public void setVoc(VocalesDAO voc) {
        this.voc = voc;
    }

    public FormasDAO getFormitas() {
        return formitas;
    }

    public void setFormitas(FormasDAO formitas) {
        this.formitas = formitas;
    }

    public NumerosDAO getNumeritos() {
        return numeritos;
    }
    //-------------------------------MÉTODOS-------------------------------------
    generarBotones();
    
    public int tiempoTotal() {
        acaba= LocalDateTime.now();
        //Capturamos los segundos, minutos e incluso horas que tardemos y los pasamos a segundos para saber cuántos segundos ha tardado y le restamos los 15 segundos de ojear la imágenes.
        int tiempo=((int) ChronoUnit.SECONDS.between(empieza, acaba) + ((int) ChronoUnit.MINUTES.between(empieza, acaba)*60) + ((int)ChronoUnit.HOURS.between(empieza, acaba)*3600))-15;
        System.out.println("Ha tardado " + tiempo);
        return tiempo;
    }
    public boolean comprobarImagen(int idComprobar){
        
        
      return true;
      
      
      
        
    }

    public static void main(String[] args) {
        FormasDAO formi= new FormasDAO();
        formi.
    }
    
}
