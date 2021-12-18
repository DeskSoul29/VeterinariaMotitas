package Conexion;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Conectar {
    
     
    private static com.mysql.jdbc.Connection con;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String url = "jdbc:mysql://localhost:3306/db_veterinaria";
     
     public Connection getConexion(){
         // Reseteamos a null la conexion a la bd
         con=null;
         try{
             Class.forName(driver);
             // Nos conectamos a la bd
             con= (com.mysql.jdbc.Connection) DriverManager.getConnection(url, user, pass);
             // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
             if (con!=null){
                System.out.println("Conexion establecida");
             }
         }
         // Si la conexion NO fue exitosa mostramos un mensaje de error
         catch (ClassNotFoundException | SQLException e){
              System.out.println("Error de conexion" + e);
         }
         return con;
     }

}