/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class NumerosBD {
    private ConexionBD conBD;
    private String sql;
        
    
    
//---------------------------------------CONSTRUCTOR----------------------------

    public NumerosBD() {
        this.conBD = new ConexionBD();
    }
    
//----------------------------------MÉTODOS-------------------------------------
    public ArrayList cargarNumeros() {
        ArrayList<NumerosDAO> numeros = new ArrayList<>();
        try (Connection con = conBD.conectarBD()) {
            sql = "SELECT * FROM numeros";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Blob blob = rs.getBlob("imagen");
                byte[] data = blob.getBytes(1,(int) blob.length() );
                BufferedImage img = null;
                try{
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (IOException ex) {
                    Logger.getLogger(VocalesBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                numeros.add(new NumerosDAO(rs.getInt("id"), img));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VocalesBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numeros;
    }
    
    
    
}
