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


public class Colectivo extends Tabla{
    private String matricula;
    private String rutConductor;
    private String compra;
    private String seguro;
    private String revisionTecnica;
    private int kilometrajeActual;
    private String marca;
    private String vin;
    private String motor;
    
    public Colectivo(View v, Connection con){
        super(v, con);
        this.tabla = "Colectivo";
        this.columna_pk = "Matricula";
        this.campos = new String[] {"Matricula", "RutConductor", "Compra", "Seguro", "RevisionTecnica", "KilometrajeActual", "Marca", "Vin", "Motor"};
        this.sqlInsertar = "INSERT INTO Colectivo VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        this.sqlModificar = "UPDATE Colectivo SET RutConductor = ?, Compra = ?, Seguro = ?, RevisionTecnica = ?, KilometrajeActual = ?, Marca = ?, Vin = ?, Motor = ? WHERE Matricula = ?";
        this.sqlEliminar = "DELETE FROM Colectivo WHERE Matricula = ?;";
    }
    
    public void getInput(){
        matricula = v.txtMatriculaColectivo.getText().strip().toUpperCase();
        rutConductor = v.cmbConductoresColectivo.getSelectedItem().toString();
        compra = formato.format(v.dchCompraColectivo.getDate());
        seguro = formato.format(v.dchSeguroColectivo.getDate());
        revisionTecnica = formato.format(v.dchRevisionColectivo.getDate());
        kilometrajeActual = Integer.valueOf(v.txtKilometrajeColectivo.getText().strip());
        marca = capitalizar(v.txtMarcaColectivo.getText().strip());
        vin = v.txtVinColectivo.getText().strip().toUpperCase();
        motor = v.txtMotorColectivo.getText().strip().toUpperCase();
    }
    
    public void enlazar(){
        conductor.quitar(COL_MATRICULA, matricula);
        quitar(COL_RUT_CONDUCTOR, rutConductor);
        conductor.añadir(COL_MATRICULA, matricula, COL_RUT_CONDUCTOR, rutConductor);
        añadir(COL_RUT_CONDUCTOR, rutConductor, COL_MATRICULA, matricula);
    }
    
    public void insertar(){
        getInput();
        if (!existe(matricula)) {
            super.insertar(new Object[] {matricula, "------", compra, seguro, revisionTecnica, kilometrajeActual, marca, vin, motor});

            //Si se selecciono un conductor, se quita del colectivo actual, de la tabla conductores, ingresa al colectivo nuevo, y de la tabla conductores
            if (!rutConductor.equals("------")) {
                enlazar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Matricula Duplicada.");
        }
    }
    
    public void modificar(){
        getInput();
        if (existe(matricula)) {
            //Actualizar matricula sin conductor
            super.modificar(new Object[] {rutConductor, compra, seguro, revisionTecnica, kilometrajeActual, marca, vin, motor, matricula});
            //Quitar Matricula a conductor
            conductor.quitar(COL_MATRICULA, matricula);

            //Si se selecciono a un conductor
            if (!rutConductor.equals("------")) {
                enlazar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe Matricula.");
        }
    }
    
    public void eliminar(){
        getInput();
        if (existe(matricula)) {
            conductor.quitar(COL_MATRICULA, matricula);
            super.eliminar(matricula);
        }
    }
}
