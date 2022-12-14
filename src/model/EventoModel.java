package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.View;

public class EventoModel extends Tabla{
    private int id;
    private String fecha;
    private String tipo;
    private String nombre;
    private int beneficio;
    
    private String matricula;
    
    public EventoModel(Connection con){
        super(con);
        this.nombre = "Evento";
        this.pk = "IdEvento";
        
        this.sqlInsertar = "INSERT INTO Evento(Fecha, TipoEvento, NombreEvento, Beneficio) VALUES (?, ?, ?, ?);";
        this.sqlModificar = "UPDATE Evento SET Fecha = ?, TipoEvento = ?, NombreEvento = ?, Beneficio = ? WHERE IdEvento = ?";
        this.sqlEliminar = "DELETE FROM Evento WHERE IdEvento = ?;";
    }
    
    public void getInput(View v){
        fecha = formato.format(v.dchEventoFecha.getDate());
        tipo = v.cmbEventoTipo.getSelectedItem().toString();
        nombre = capitalizar(v.txtEventoNombre.getText().strip());
        beneficio = (Integer) v.spnEventoBeneficio.getValue();
    }
    
    public void añadirColectivo(){
        try {
            ppt = con.prepareStatement("INSERT INTO ColectivoEvento VALUES (?, ?);");
            ppt.setString(1, matricula);
            ppt.setInt(2, id);
            ppt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarColectivo(){
        try {
            ppt = con.prepareStatement("DELETE FROM ColectivoEvento WHERE Matricula = ? AND IdEvento = ?;");
            ppt.setString(1, matricula);
            ppt.setInt(2, id);
            ppt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //OK
    public void insertar(){
        asignarDatos(sqlInsertar, new Object[] {fecha, tipo, nombre, beneficio});
    }
    
    //OK
    public void modificar(){
        asignarDatos(sqlModificar, new Object[] {fecha, tipo, nombre, beneficio, id});
    }
    
    //OK
    public void eliminar(){
        asignarDatos(sqlEliminar, new Object[] {id});
    }
}