package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Instruc {

    public String InstruccionesLeidas;

    public static String leerIntstruccionestxt() throws FileNotFoundException, IOException {
        String cadena;
        String texto = "";
        FileReader f = new FileReader("./Archivos/Instrucciones.txt");
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            texto = texto + "\n" + cadena;
        }
        b.close();
        return texto;

    }

}
