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
        id = (v.lblRepuestoIDActual.getText().equals("")) ? Integer.valueOf(v.lblEventoIDActual.getText()) : 0;
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
    
    private void añadirColectivo(){
        
    }
    
    public void insertar(){
        getInput();
        for (int i = 0; i < cantidad; i++) {
            asignarDatos(sqlInsertar, new Object[] {tipo, kilometrajeMax, kilometrajeDeUso});
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
    
    public void eliminar(){
        getInput();
        if (existe(rutConductor)) {
            asignarDatos(sqlEliminar, new Object[] {rutConductor});
        }
    }
    */
}