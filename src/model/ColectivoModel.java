package model;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.ColectivoView;
import view.View;


public class ColectivoModel extends Tabla{
    private String matricula;
    private String rutConductor;
    private String compra;
    private int kilometrajeActual;
    private String marca;
    private String vin;
    private String motor;
    
    public ColectivoModel(Connection con){
        super(con);
        this.nombre = "Colectivo";
        this.pk = "Matricula";
        
        this.sqlInsertar = "INSERT INTO Colectivo VALUES (?, ?, ?, ?, ?, ?);";
        this.sqlModificar = "UPDATE Colectivo SET Matricula = ?, Compra = ?, KilometrajeActual = ?, Marca = ?, Vin = ?, Motor = ? WHERE Matricula = ?";
        this.sqlEliminar = "DELETE FROM Colectivo WHERE Matricula = ?;";
    }
    
    public void getInput(View v){
        matricula = v.txtColectivoMatricula.getText().strip().toUpperCase();
        rutConductor = v.cmbColectivoConductores.getSelectedItem().toString();
        compra = formato.format(v.dchColectivoCompra.getDate());
        kilometrajeActual = (Integer) v.spnColectivoKilometraje.getValue();
        marca = capitalizar(v.txtColectivoMarca.getText().strip());
        vin = v.txtColectivoVin.getText().strip().toUpperCase();
        motor = v.txtColectivoMotor.getText().strip().toUpperCase();
    }
    
    public void getInput(ColectivoView v){
        matricula = v.txtColectivoMatricula.getText().strip().toUpperCase();
        rutConductor = v.cmbColectivoConductores.getSelectedItem().toString();
        compra = formato.format(v.dchColectivoCompra.getDate());
        kilometrajeActual = (Integer) v.spnColectivoKilometraje.getValue();
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
    
    public void insertar(){
        boolean valido = true;
        String error = "";
        if (existe(matricula)) {
            error += "Matricula duplicada.\n";
            valido = false;
        }
        if (existe("Vin", vin)) {
            error += "Vin duplicado.\n";
            valido = false;
        }
        if (existe("Motor", motor)) {
            error += "Número de motor duplicado.\n";
            valido = false;
        }
        
        if (valido) {
            asignarDatos(sqlInsertar, new Object[] {matricula, compra, kilometrajeActual, marca, vin, motor});   
            añadirConductor();
        } else {
            JOptionPane.showMessageDialog(null, error);
        }
    }
    
    public boolean modificar(String matriculaR, String vinR, String motorR){
        boolean valido = true;
        String error = "";
        if (existe(matricula) && !matricula.equals(matriculaR)) {
            error += "Matricula duplicada.\n";
            valido = false;
        }
        if (existe("Vin", vin) && !vin.equals(vinR)) {
            error += "Vin duplicado.\n";
            valido = false;
        }
        if (existe("Motor", motor) && !motor.equals(motorR)) {
            error += "Número de motor duplicado.\n";
            valido = false;
        }
        
        if (valido) {
            asignarDatos(sqlModificar, new Object[] {matricula, compra, kilometrajeActual, marca, vin, motor, matriculaR});
            añadirConductor();
        } else {
            JOptionPane.showMessageDialog(null, error);
        }
        return valido;
    }
    
    public void eliminar(String registro){
        asignarDatos(sqlEliminar, new Object[] {registro});
    }
}
