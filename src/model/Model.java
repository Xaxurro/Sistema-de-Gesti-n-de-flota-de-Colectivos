package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import view.View;

public class Model {
    //INICIAR CON LOGIN
    String usuario = JOptionPane.showInputDialog("Usuario:");
    String contraseña = JOptionPane.showInputDialog("Contraseña:");
    
    /*
    //INICIAR SIN LOGIN
    String usuario = "root";
    String contraseña = "";
    */
    
    String nombreDB = "colectivos";
    //Connection con = conectar(usuario, contraseña);
    Connection con = null;
    Statement stm = null;
    ResultSet rs = null;
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    
    private Connection conectar(String usuario, String contraseña){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            stm = con.createStatement();
            if(!existeDB(con, rs, nombreDB)){
                crearDB();
            }
            rs = stm.executeQuery("SELECT * FROM Administrador WHERE Usuario = '" + usuario + "' AND Contraseña = '" + contraseña + "';");
            return (rs.next()) ? con : null;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
        }
        return null;
    }
    
    private boolean existeDB(Connection con, ResultSet rs, String nombreDB){
        try {
            rs = con.getMetaData().getCatalogs();
            while (rs.next()) {
                String db = rs.getString(1);
                if(nombreDB.equals(db)){
                    stm.execute("USE Colectivos;");
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    private void crearDB(){
        try {
            stm.execute("CREATE DATABASE Colectivos;");
            stm.execute("USE Colectivos;");

            //TABLAS
            stm.execute("CREATE TABLE Colectivo(Matricula Char(6) NOT NULL, RutConductor VarChar(13), Compra Date, Seguro Date, RevisionTecnica Date, KilometrajeActual Int(7), Marca VarChar(15), Vin VarChar(17), Motor VarChar(12), PRIMARY KEY (Matricula));");
            stm.execute("CREATE TABLE Conductor(RutConductor Char(12) NOT NULL, Matricula Char(6), Nombre VarChar(50), Direccion VarChar(150), Telefono VarChar(12), PRIMARY KEY (RutConductor));");
            stm.execute("CREATE TABLE Repuesto(IdRepuesto int(3) NOT NULL AUTO_INCREMENT, TipoRepuesto VarChar(50), Compra Date, KilometrajeMax Int(7), KilometrajeActual Int(7), Matricula Char(6), PRIMARY KEY (IdRepuesto, TipoRepuesto));");
            stm.execute("CREATE TABLE Evento(IdEvento int(3) NOT NULL AUTO_INCREMENT, Fecha Date, NombreEvento VarChar(50), Descripcion VarChar(250), Beneficio Int(7), PRIMARY KEY (IdEvento, Fecha));");
            stm.execute("CREATE TABLE Ganancia(Fecha Date NOT NULL, Matricula Char(6) NOT NULL, Ganancia Int(7), PRIMARY KEY (Fecha, Matricula));");
            stm.execute("CREATE TABLE Administrador(Usuario VarChar(30) NOT NULL, Contraseña VarChar(30) NOT NULL, PRIMARY KEY (Usuario));");
            
            //CLAVES FORANEAS
            stm.execute("ALTER TABLE Colectivo ADD CONSTRAINT FK_COLECTIVO_CONDUCTOR FOREIGN KEY (RutConductor) REFERENCES Conductor(RutConductor);");
            stm.execute("ALTER TABLE Conductor ADD CONSTRAINT FK_CONDUCTOR_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula);");
            stm.execute("ALTER TABLE Repuesto ADD CONSTRAINT FK_REPUESTO_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula);");
            stm.execute("ALTER TABLE Ganancia ADD CONSTRAINT FK_GANANCIA_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula);");
            
            //INSERTAR USUARIO INICIAL
            stm.execute("INSERT INTO Administrador VALUES ('admin', '12345');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
