package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginModel extends Tabla{
    LoginModel(Connection con) {
        super(con);
        this.nombre = "Administrador";
        this.pk = "Usuario";
        
        this.sqlInsertar = "INSERT INTO Administrador VALUES (?, ?);";
    }
    
    public boolean inicioSesion(String usuario, String contraseña){
        try {
            ppt = con.prepareStatement("SELECT * FROM Administrador WHERE usuario = ? AND contraseña = ?;");
            ppt.setString(1, usuario);
            ppt.setString(2, contraseña);
            return ppt.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void registrarse(String usuario, String contraseña){
        asignarDatos(sqlInsertar, new String[] {usuario, contraseña});
    }
}
