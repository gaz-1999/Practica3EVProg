package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public  class ConexionBD {

    public static String database = "memory";
    public static String host = "localhost";
    public static String puerto = "3306";
    public  static String url = "jdbc:mysql://" + host + ":" + puerto + "/" + database
            + "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
            + "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static String username = "root";
    public static String password = "";
    public  static Connection conn;

    public static Connection conectarBD() {
             
        try {
                      
            conn = DriverManager.getConnection(url, username, password);
        
            if(conn!=null){
                System.out.println("Conectado Correctamente a la Base de Datos Local");
            }else{
                System.err.println("Error conexion");
            }

        } catch (SQLException e) {
            System.err.println("Error de conexion: "+e);
        } catch (Exception e) {
            System.err.println("Error desconocido: "+e);
        }
        
        return conn;
    }

}