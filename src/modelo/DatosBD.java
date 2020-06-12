/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.GUIPrincipal;

/**
 *
 * @author Gaz PC
 */
public class DatosBD {
    int posicion;
    
    public int saberPosicionGlobal(int id) {
        try (Connection con = new ConexionBD().conectarBD();) {
        String sql = "SELECT * FROM ranking WHERE ID = (SELECT MAX(id) AS id FROM ranking) ORDER BY tiempo ASC";
          try (Statement st = con.createStatement();) {
              ResultSet rs = st.executeQuery(sql);
          
                posicion= rs.getConcurrency();
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
         catch (SQLException ex) {
            Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return posicion;
    }

    public static boolean insertPuntuacion(int tiempoEnSeg) {
        try (Connection con = new ConexionBD().conectarBD();) {
            String sql = "INSERT INTO ranking (id,tiempo) VALUES (null," + tiempoEnSeg + ")";
            System.out.println("Query: " + sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;

    }

}
