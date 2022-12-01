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
    private int kilometrajeActual;
    private String marca;
    private String vin;
    private String motor;
    
    public Colectivo(View v, Connection con){
        super(v, con);
        this.nombre = "Colectivo";
        this.pk = "Matricula";
        //this.fk = "RutConductor";
        //this.campos = new String[] {"Matricula", "Compra", "KilometrajeActual", "Marca", "Vin", "Motor"};
        //this.buscadores = new JTextField[] {v.txtBusquedaTablaColectivoMatricula, v.txtBusquedaTablaColectivoRut};
        
        this.sqlInsertar = "INSERT INTO Colectivo VALUES (?, ?, ?, ?, ?, ?);";
        this.sqlModificar = "UPDATE Colectivo SET Compra = ?, KilometrajeActual = ?, Marca = ?, Vin = ?, Motor = ? WHERE Matricula = ?";
        this.sqlEliminar = "DELETE FROM Colectivo WHERE Matricula = ?;";
    }
    
    public void getInput(){
        matricula = v.txtColectivoMatricula.getText().strip().toUpperCase();
        rutConductor = v.cmbColectivoConductores.getSelectedItem().toString();
        compra = formato.format(v.dchColectivoCompra.getDate());
        kilometrajeActual = Integer.valueOf(v.txtColectivoKilometraje.getText().strip());
        marca = capitalizar(v.txtColectivoMarca.getText().strip());
        vin = v.txtColectivoVin.getText().strip().toUpperCase();
        motor = v.txtColectivoMotor.getText().strip().toUpperCase();
    }
    
    private void quitarConductor(){
        try {
            ppt = con.prepareStatement("UPDATE ColectivoConductor SET Estado = 0 WHERE Matricula = ? OR RutConductor = ?;");
            ppt.setString(1, matricula);
            ppt.setString(2, rutConductor);
            ppt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void añadirConductor() {
        try {
            quitarConductor();
            if (!rutConductor.equals("------")) {
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
    
    //OK
    public void insertar(){
        getInput();
        if (!existe(matricula)) {
            asignarDatos(sqlInsertar, new Object[] {matricula, compra, kilometrajeActual, marca, vin, motor});
            
            añadirConductor();
        } else {
            JOptionPane.showMessageDialog(null, "Matricula Duplicada.");
        }
    }
    
    //OK
    public void modificar(){
        getInput();
        if (existe(matricula)) {
            asignarDatos(sqlModificar, new Object[] {compra, kilometrajeActual, marca, vin, motor, matricula});
            
            añadirConductor();
        } else {
            JOptionPane.showMessageDialog(null, "No existe Matricula.");
        }
    }
    
    //OK
    public void eliminar(){
        getInput();
        if (existe(matricula)) {
            asignarDatos(sqlEliminar, new Object[] {matricula});
        }
    }
}
