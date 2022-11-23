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


public class Conductor extends Tabla{
    private String rutConductor;
    private String matricula;
    private String nombre;
    private String direccion;
    private String telefono;
    
    public Conductor(View v, Connection con){
        super(v, con);
        this.tabla = "Conductor";
        this.columna_pk = "RutConductor";
        this.campos = new String[] {"RutConductor", "Matricula", "Nombre", "Direccion", "Telefono"};
        
        this.sqlInsertar = "INSERT INTO Conductor VALUES (?, ?, ?, ?);";
        this.sqlModificar = "UPDATE Conductor SET Matricula = ?, Nombre = ?, Direccion = ?, Telefono = ? WHERE RutConductor = ?";
        this.sqlEliminar = "DELETE FROM Conductor WHERE RutConductor = ?;";
    }
    
    public void getInput(){
        rutConductor = v.txtRutConductor.getText().strip();
        matricula = v.cmbColectivosConductor.getSelectedItem().toString();
        nombre = capitalizar(v.txtNombreConductor.getText().strip());
        direccion = capitalizar(v.txtDireccionConductor.getText().strip());
        telefono = v.txtTelefonoConductor.getText().strip();
    }
    
    public void enlazar(){
        colectivo.quitar(COL_RUT_CONDUCTOR, rutConductor);
        quitar(COL_MATRICULA, matricula);
        colectivo.añadir(COL_RUT_CONDUCTOR, rutConductor, COL_MATRICULA, matricula);
        añadir(COL_MATRICULA, matricula, COL_RUT_CONDUCTOR, rutConductor);
    }
    
    public void insertar(){
        getInput();
        if (!existe(rutConductor)) {
            super.insertar(new Object[] {rutConductor, "------", nombre, direccion, telefono});

            //Si se selecciono un Colectivo, se enlaza
            if (!matricula.equals("------")) {
                enlazar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Rut Duplicado.");
        }
    }
    
    //TERMINAR
    public void modificar(){
        getInput();
        if (existe(rutConductor)) {
            //Actualizar Conductor sin Colectivo
            super.modificar(new Object[] {matricula, nombre, direccion, telefono, rutConductor});

            //Quitar Matricula a conductor
            quitar(COL_MATRICULA, matricula);
            
            //Si se selecciono a un conductor
            if (!matricula.equals("------")) {
                enlazar();
            }

            //ACTUALIZAR VISTA
        } else {
            JOptionPane.showMessageDialog(null, "No existe Rut.");
        }
    }
    
    public void eliminar(){
        getInput();
        if (existe(rutConductor)) {
            colectivo.quitar(COL_RUT_CONDUCTOR, rutConductor);
            super.eliminar(matricula);
        }
    }
}