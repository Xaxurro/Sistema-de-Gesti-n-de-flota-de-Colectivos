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
import view.ConductorView;
import view.View;


public class ConductorModel extends Tabla{
    private String rutConductor;
    private String matricula;
    private String nombreConductor;
    private String direccion;
    private String telefono;
    
    public ConductorModel(Connection con){
        super(con);
        this.nombre = "Conductor";
        this.pk = "RutConductor";
        //this.campos = new String[] {"RutConductor", "Matricula", "Nombre", "Direccion", "Telefono"};
        
        this.sqlInsertar = "INSERT INTO Conductor VALUES (?, ?, ?, ?);";
        this.sqlModificar = "UPDATE Conductor SET RutConductor = ?, Nombre = ?, Direccion = ?, Telefono = ? WHERE RutConductor = ?";
        this.sqlEliminar = "DELETE FROM Conductor WHERE RutConductor = ?;";
    }
    
    public void getInput(View v){
        rutConductor = v.txtConductorRut.getText().strip();
        matricula = v.cmbConductorColectivos.getSelectedItem().toString();
        nombreConductor = capitalizar(v.txtConductorNombre.getText().strip());
        direccion = capitalizar(v.txtConductorDireccion.getText().strip());
        telefono = v.txtConductorTelefono.getText().strip();
    }
    
    public void getInput(ConductorView v){
        rutConductor = v.txtConductorRut.getText().strip();
        matricula = v.cmbConductorColectivos.getSelectedItem().toString();
        nombreConductor = capitalizar(v.txtConductorNombre.getText().strip());
        direccion = capitalizar(v.txtConductorDireccion.getText().strip());
        telefono = v.txtConductorTelefono.getText().strip();
    }
    
    private void quitarColectivo(){
        try {
            ppt = con.prepareStatement("UPDATE ColectivoConductor SET Estado = 0 WHERE Matricula = ? OR RutConductor = ?;");
            ppt.setString(1, matricula);
            ppt.setString(2, rutConductor);
            ppt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void añadirColectivo() {
        try {
            quitarColectivo();
            if (!matricula.equals("------")) {
                ppt = con.prepareStatement("SELECT Estado FROM ColectivoConductor WHERE Matricula = ? AND RutConductor = ?;");
                ppt.setString(1, matricula);
                ppt.setString(2, rutConductor);
                rs = ppt.executeQuery();
                if(rs.next()){
                    ppt = con.prepareStatement("UPDATE ColectivoConductor SET Estado = 1 WHERE Matricula = ? AND RutConductor = ?;");
                    ppt.setString(1, matricula);
                    ppt.setString(2, rutConductor);
                    ppt.executeUpdate();
                } else {
                    ppt = con.prepareStatement("INSERT INTO ColectivoConductor(Matricula, RutConductor, Estado) VALUES (?, ?, 1);");
                    ppt.setString(1, matricula);
                    ppt.setString(2, rutConductor);
                    ppt.execute();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertar(){
        if (!existe(rutConductor)) {
            asignarDatos(sqlInsertar, new Object[] {rutConductor, nombreConductor, direccion, telefono});
            
            añadirColectivo();
        } else {
            JOptionPane.showMessageDialog(null, "Rut Duplicado.");
        }
    }
    
    public boolean modificar(String registro){
        if (existe(rutConductor) && !rutConductor.equals(registro)) {
            JOptionPane.showMessageDialog(null, "Rut Duplicado.");
            return false;
        } else {
            asignarDatos(sqlModificar, new Object[] {rutConductor, nombreConductor, direccion, telefono, registro});
            añadirColectivo();
            return true;
        }
    }
    
    public void eliminar(String registro){
        asignarDatos(sqlEliminar, new Object[] {registro});
    }
}