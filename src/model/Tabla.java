package model;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import view.View;

public class Tabla {
    public View v = null;
    public Colectivo colectivo = null;
    public Conductor conductor = null;
    public Repuesto repuesto = null;
    
    public Connection con = null;
    public PreparedStatement ppt = null;
    public Statement stm = null;
    public ResultSet rs = null;
    
    public SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    
    public String nombre = "";
    public String pk = "";
    //public String fk = "";
    //public String[] campos = null;
    
    //public JTextField[] buscadores = null;
    
    public final String COL_MATRICULA = "Matricula";
    public final String COL_RUT_CONDUCTOR = "RutConductor";
    public final String COL_COMPRA = "Compra";
    public final String COL_SEGURO = "Seguro";
    public final String COL_REVISION_TECNICA = "RevisionTecnica";
    public final String COL_KILOMETRAJE_ACTUAL = "KilometrajeActual";
    public final String COL_MARCA = "Marca";
    public final String COL_VIN = "Vin";
    public final String COL_MOTOR = "Motor";
    
    public String sqlInsertar = "";
    public String sqlModificar = "";
    public String sqlEliminar = "";
    
    public Tabla(View v, Connection con){
        try {
            this.v = v;
            this.con = con;
            this.stm = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String capitalizar(String s){
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }
    
    public boolean existe(String registro){
        try {
            ppt = con.prepareStatement("SELECT " + pk + " FROM " + nombre + " WHERE " + pk + " = ?;");
            ppt.setString(1, registro);
            return ppt.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void asignarDatos(String sql, Object[] datos){
        try {
            ppt = con.prepareStatement(sql);
            for (int i = 0; i < datos.length; i++) {
                if (datos[i] instanceof String) {
                    ppt.setString(i+1, datos[i].toString());
                }
                if (datos[i] instanceof Integer) {
                    ppt.setInt(i+1, (int)datos[i]);
                }
            }
            ppt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void quitar(String columna, String registro){
        try {
            ppt = con.prepareStatement("UPDATE " + nombre + " SET " + columna + " = '------' WHERE " + columna + " = ?;");
            ppt.setString(1, registro);
            ppt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void añadir(String columnaAModificar, String registroAAñadir, String columnaABuscar, String registroABuscar){
        try {
            ppt = con.prepareStatement("UPDATE " + nombre + " SET " + columnaAModificar + " = ? WHERE " + columnaABuscar + " = ?;");
            ppt.setString(1, registroAAñadir);
            ppt.setString(2, registroABuscar);
            ppt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*
    public void conectarTabla(Object tabla){
        if (tabla instanceof Colectivo) {
            this.colectivo = (Colectivo) tabla;
        }
        if (tabla instanceof Conductor) {
            this.conductor = (Conductor) tabla;
        }
        if (tabla instanceof Repuesto) {
            this.repuesto = (Repuesto) tabla;
        }
    }
    */
    /*
    public void insertar(Object[] datos){
        try {
            ppt = con.prepareStatement(sqlInsertar);
            asignarDatos(datos);
            ppt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void modificar(Object[] datos){
        try {
            ppt = con.prepareStatement(sqlModificar);
            asignarDatos(datos);
            ppt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminar(String registro){
        try {
            ppt = con.prepareStatement(sqlEliminar);
            ppt.setString(1, registro);
            ppt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
}
