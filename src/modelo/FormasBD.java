package modelo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Gaz PC
 */
public class FormasBD {

    private ConexionBD conBD;
    private String sql;
    private ArrayList<FormasDAO> formas;

//---------------------------------------CONSTRUCTOR----------------------------
    public FormasBD() {
        this.conBD = new ConexionBD();
    }

//-----------------------------------GETER Y SETTER-----------------------------

    public ArrayList<FormasDAO> getFormas() {
        return formas;
    }

    public void setFormas(ArrayList<FormasDAO> formas) {
        this.formas = formas;
    }
    
    
    
    //----------------------------------MÉTODOS-------------------------------------
    public ArrayList cargarFormas() {
        formas = new ArrayList<>();
        try (Connection con = conBD.conectarBD()) {
            sql = "SELECT * FROM formas";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Blob blob = rs.getBlob("imagen");
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (IOException ex) {
                    Logger.getLogger(VocalesBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                formas.add(new FormasDAO(rs.getInt("id"), img));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VocalesBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return formas;
    }
}
