package eam.desarrollo.agenda.DAO;


import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Conexion {
    private static java.sql.Connection con;
    private Statement stm;
    private ResultSet rs;

    

    public static Connection getConexion() throws SQLException {
        try {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            //String database = "agendaMedica";
            String database = "agendamedica";
            String usuario  = "root";
            //String clave    = "root";
            String clave    = "1234";
            con =  DriverManager.getConnection(
            "jdbc:mysql://localhost:3308/"+database+"?"
            + "user="+usuario+"&password="+clave);
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, e.getMessage().toString(), "Error",
					JOptionPane.INFORMATION_MESSAGE);
        	
        }
       
        return (Connection) con;
    }

}
