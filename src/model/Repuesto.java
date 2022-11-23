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
    private String matricula;
    private String rutConductor;
    private String compra;
    private String seguro;
    private String revisionTecnica;
    private int kilometrajeActual;
    private String marca;
    private String vin;
    private String motor;
    
    public Repuesto(View v, Connection con){
        super(v, con);
        this.tabla = "Colectivo";
        this.columna_pk = "Matricula";
        this.campos = new String[] {"RutConductor", "Compra", "Seguro", "RevisionTecnica", "KilometrajeActual", "Marca", "Vin", "Motor"};
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
    
    public void insertar(){
        getInput();
        if (!existe(matricula)) {
            super.insertar(new Object[] {matricula, "------", compra, seguro, revisionTecnica, kilometrajeActual, marca, vin, motor});

            //Si se selecciono un conductor, se quita del colectivo actual, de la tabla conductores, ingresa al colectivo nuevo, y de la tabla conductores
            if (!rutConductor.equals("------")) {
                quitar("RutConductor", rutConductor);
                
            }

            //ACTUALIZAR VISTA
        } else {
            JOptionPane.showMessageDialog(null, "Matricula Duplicada.");
        }
    }
}