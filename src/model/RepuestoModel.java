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
import view.RepuestoView;
import view.View;


public class RepuestoModel extends Tabla{
    private int id;
    private String tipo;
    private String matricula;
    private String cambio;
    private int kilometrajeMax;
    private int kilometrajeDeUso;
    private int cantidad;
    
    public RepuestoModel(Connection con){
        super(con);
        this.nombre = "Repuesto";
        this.pk = "IdRepuesto";
        this.sqlInsertar = "INSERT INTO Repuesto(TipoRepuesto, KilometrajeMax, KilometrajeDeUso) VALUES (?, ?, ?);";
        this.sqlModificar = "UPDATE Repuesto SET IdRepuesto = ?, TipoRepuesto = ?, KilometrajeMax = ?, KilometrajeDeUso = ? WHERE IdRepuesto = ?";
        this.sqlEliminar = "DELETE FROM Repuesto WHERE IdRepuesto = ?;";
    }
    
    public void getInput(View v){
        tipo = capitalizar(v.txtRepuestoTipo.getText().strip());
        matricula = v.cmbRepuestoColectivos.getSelectedItem().toString();
        cambio = formato.format(v.dchRepuestoCambio.getDate());
        kilometrajeMax = (int) v.spnRepuestoKilometrajeMax.getValue();
        kilometrajeDeUso = (int) v.spnRepuestoKilometrajeActual.getValue();
        cantidad = (int) v.spnRepuestoCantidad.getValue();
    }
    
    public void getInput(RepuestoView v){
        tipo = capitalizar(v.txtRepuestoTipo.getText().strip());
        matricula = v.cmbRepuestoColectivos.getSelectedItem().toString();
        cambio = formato.format(v.dchRepuestoCambio.getDate());
        kilometrajeMax = (int) v.spnRepuestoKilometrajeMax.getValue();
        kilometrajeDeUso = (int) v.spnRepuestoKilometrajeActual.getValue();
    }

    public void buscarCantidad(View v) {
        try {
            String sql = "SELECT Count(TipoRepuesto) FROM Repuesto";
            if (!v.cmbRepuestoCantidadTipo.getSelectedItem().toString().equals("Todos")) {
                sql += " WHERE TipoRepuesto = '" + v.cmbRepuestoCantidadTipo.getSelectedItem().toString() + "'";
            }
            rs = stm.executeQuery(sql + ";");
            if (rs.next()) {
                v.lblRepuestoCantidad.setText(String.valueOf(rs.getInt(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private boolean buscarColectivo(){
        try {
            ppt = con.prepareStatement("SELECT Estado FROM ColectivoRepuesto WHERE Matricula = ? AND IdRepuesto = ? AND Estado = 1;");
            ppt.setString(1, matricula);
            ppt.setInt(2, id);
            rs = ppt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    private void quitarColectivo() {
        try {
            ppt = con.prepareStatement("UPDATE ColectivoRepuesto SET Estado = 0 WHERE Matricula = ? AND IdRepuesto = ?;");
            ppt.setString(1, matricula);
            ppt.setInt(2, id);
            ppt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void añadirColectivo(){
        try {
            if (buscarColectivo()) {
                quitarColectivo();
                ppt = con.prepareStatement("UPDATE ColectivoRepuesto SET Cambio = ?, Estado = 1 WHERE Matricula = ? AND IdRepuesto = ?;");
                ppt.setString(1, cambio);
                ppt.setString(2, matricula);
                ppt.setInt(3, id);
                ppt.executeUpdate();
            } else {
                ppt = con.prepareStatement("INSERT INTO ColectivoRepuesto(Matricula, IdRepuesto, Cambio, Estado) VALUES (?, ?, ?, 1);");
                ppt.setString(1, matricula);
                ppt.setInt(2, id);
                ppt.setString(3, cambio);
                ppt.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertar(){
        for (int i = 0; i < cantidad; i++) {
            asignarDatos(sqlInsertar, new Object[] {tipo, kilometrajeMax, kilometrajeDeUso});
            if (!matricula.equals("------")) {
                añadirColectivo();
            }
        }
    }
    
    public void modificar(String registro){
        asignarDatos(sqlModificar, new Object[] {id, tipo, kilometrajeMax, kilometrajeDeUso, registro});
    }
    
    public void eliminar(String registro){
        asignarDatos(sqlEliminar, new Object[] {registro});
    }
    
}