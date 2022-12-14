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
import view.GananciaView;
import view.View;


public class GananciaModel extends Tabla{
    private String fecha;
    private String matricula;
    private int ganancia;
    
    public GananciaModel(Connection con){
        super(con);
        this.nombre = "Ganancia";        
        
        this.sqlInsertar = "INSERT INTO Ganancia VALUES (?, ?, ?);";
        this.sqlModificar = "UPDATE Ganancia SET Fecha = ?, Matricula = ?, Ganancia= ? WHERE Fecha = ? AND Matricula = ?";
        this.sqlEliminar = "DELETE FROM Ganancia WHERE Fecha = ? AND Matricula = ?;";
    }
    
    public void getInput(View v){
        fecha = formato.format(v.dchGananciaFecha.getDate());
        matricula = v.cmbGananciaMatricula.getSelectedItem().toString();
        ganancia = (int) v.spnGananciaGanancia.getValue();
    }
    
    public void getInput(GananciaView v){
        fecha = formato.format(v.dchGananciaFecha.getDate());
        matricula = v.cmbGananciaMatricula.getSelectedItem().toString();
        ganancia = (int) v.spnGananciaGanancia.getValue();
    }
    
    public void CalcularSuma(View v){
        try {
            String sql = "SELECT SUM(Ganancia) FROM Ganancia WHERE Matricula = '" + v.cmbGananciaBusquedaMatricula.getSelectedItem().toString() + "'";
            if (v.dchGananciaBusquedaFechaInicial.getDate() != null) {
                sql += " AND Fecha >= '" + formato.format(v.dchGananciaBusquedaFechaInicial.getDate()) + "'";
            }
            if (v.dchGananciaBusquedaFechaFinal.getDate() != null) {
                sql += " AND Fecha <= '" + formato.format(v.dchGananciaBusquedaFechaFinal.getDate()) + "'";
            }
            ppt = con.prepareStatement(sql + ';');
            rs = ppt.executeQuery();
            if (rs.next()) {
                v.lblGananciaTotal.setText(String.valueOf(rs.getInt(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertar(){
        if (existe("Fecha", fecha) && existe("Matricula", matricula)) {
            JOptionPane.showMessageDialog(null, "Registro duplicado, favor de modificarlo en vez de ingresar otro.");
        } else {
            asignarDatos(sqlInsertar, new Object[] {fecha, matricula, ganancia});
        }
    }
    
    public void modificar(String fechaR, String matriculaR){
        asignarDatos(sqlModificar, new Object[] {fecha, matricula, ganancia, fechaR, matriculaR});
    }
    
    public void eliminar(String fechaR, String matriculaR){
        asignarDatos(sqlEliminar, new Object[] {fechaR, matriculaR});
    }
}