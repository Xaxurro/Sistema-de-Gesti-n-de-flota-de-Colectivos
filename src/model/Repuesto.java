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


public class Repuesto extends Tabla{
    private int id;
    private String tipo;
    private String matricula;
    private String cambio;
    private int kilometrajeMax;
    private int kilometrajeDeUso;
    private int cantidad;
    
    public Repuesto(View v, Connection con){
        super(v, con);
        this.nombre = "Repuesto";
        this.pk = "IdRepuesto";
        //this.campos = new String[] {"IdRepuesto", "TipoRepuesto", "KilometrajeMaxc", "KilometrajeDeUso", "Repuesto"};
        this.sqlInsertar = "INSERT INTO Repuesto(TipoRepuesto, KilometrajeMax, KilometrajeDeUso) VALUES (?, ?, ?);";
        this.sqlModificar = "UPDATE Repuesto SET TipoRepuesto = ?, KilometrajeMax = ?, KilometrajeDeUso = ? WHERE IdRepuesto = ?";
        this.sqlEliminar = "DELETE FROM Repuesto WHERE IdRepuesto = ?;";
    }
    
    public void getInput(){
        id = (v.lblRepuestoIDActual.getText().equals("")) ? 0 : Integer.valueOf(v.lblRepuestoIDActual.getText());
        tipo = capitalizar(v.txtRepuestoTipo.getText().strip());
        matricula = v.cmbRepuestoColectivos.getSelectedItem().toString();
        cambio = formato.format(v.dchRepuestoCambio.getDate());
        kilometrajeMax = (int) v.spnRepuestoKilometrajeMax.getValue();
        kilometrajeDeUso = (int) v.spnRepuestoKilometrajeActual.getValue();
        cantidad = (int) v.spnRepuestoCantidad.getValue();
    }

    public void buscarCantidad() {
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
    
    private void añadirColectivo(){
        try {
            if (buscarColectivo()) {
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
    
    private void quitarColectivo() {
        try {
            if (buscarColectivo()) {
                ppt = con.prepareStatement("UPDATE ColectivoRepuesto SET Estado = 0 WHERE Matricula = ? AND IdRepuesto = ?;");
                ppt.setString(1, matricula);
                ppt.setInt(2, id);
                ppt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertar(){
        getInput();
        for (int i = 0; i < cantidad; i++) {
            asignarDatos(sqlInsertar, new Object[] {tipo, kilometrajeMax, kilometrajeDeUso});
            if (v.cmbRepuestoColectivos.getSelectedIndex() != 0) {
                try {
                    rs = con.prepareStatement("SELECT MAX(IdRepuesto) FROM Repuesto;").executeQuery();
                    if (rs.next()) {
                        id = rs.getInt(1);
                        quitarColectivo();
                        añadirColectivo();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /*
    public void modificar(){
        getInput();
        if (existe(rutConductor)) {
            asignarDatos(sqlModificar, new Object[] {nombreConductor, direccion, telefono, rutConductor});
            
            añadirColectivo();
        } else {
            JOptionPane.showMessageDialog(null, "No existe Rut.");
        }
    }
    */
    
    public void eliminar(){
        getInput();
        asignarDatos(sqlEliminar, new Object[] {id});
    }
    
}