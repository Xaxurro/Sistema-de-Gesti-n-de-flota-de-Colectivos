package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import view.EventoView;
import view.View;

public class EventoModel extends Tabla{
    private String fecha;
    private String tipo;
    private String nombre;
    private int beneficio;
    private String descripcion;
    
    private String matricula;
    
    public EventoModel(Connection con){
        super(con);
        this.nombre = "Evento";
        this.pk = "IdEvento";
        
        this.sqlInsertar = "INSERT INTO Evento(Fecha, TipoEvento, NombreEvento, Beneficio) VALUES (?, ?, ?, ?);";
        this.sqlModificar = "UPDATE Evento SET Fecha = ?, TipoEvento = ?, NombreEvento = ?, Descripcion = ?, Beneficio = ? WHERE IdEvento = ?";
        this.sqlEliminar = "DELETE FROM Evento WHERE IdEvento = ?;";
    }
    
    public void getInput(View v){
        fecha = formato.format(v.dchEventoFecha.getDate());
        tipo = v.cmbEventoTipo.getSelectedItem().toString();
        nombre = capitalizar(v.txtEventoNombre.getText().strip());
        beneficio = (Integer) v.spnEventoBeneficio.getValue();
    }
    
    public void getInput(EventoView v){
        fecha = formato.format(v.dchEventoFecha.getDate());
        tipo = v.cmbEventoTipo.getSelectedItem().toString();
        nombre = capitalizar(v.txtEventoNombre.getText().strip());
        beneficio = (int) v.spnEventoBeneficio.getValue();
        descripcion = capitalizar(v.txaDescription.getText().strip());
        matricula = v.cmbColectivos.getSelectedItem().toString();
    }
    
    public void refrescarPopUp(EventoView v, int id){
        try {
            DefaultListModel modeloLista = new DefaultListModel();
            ppt = con.prepareStatement("SELECT Matricula FROM ColectivoEvento WHERE IdEvento = ?;");
            ppt.setInt(1, id);
            rs = ppt.executeQuery();
            while (rs.next()) {
                modeloLista.addElement(rs.getString("Matricula"));
            }
            ppt = con.prepareStatement("SELECT Descripcion FROM Evento WHERE IdEvento = ?;");
            ppt.setInt(1, id);
            rs = ppt.executeQuery();
            if (rs.next()) {
                v.txaDescription.setText(rs.getString("Descripcion"));
            }
            v.lstColectivosImplicados.setModel(modeloLista);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void añadirColectivo(int id){
        try {
            ppt = con.prepareStatement("INSERT INTO ColectivoEvento VALUES (?, ?);");
            ppt.setString(1, matricula);
            ppt.setInt(2, id);
            ppt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarColectivo(String matricula, int id){
        try {
            System.out.println("model.EventoModel.eliminarColectivo()");
            System.out.println(matricula);
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
    public void modificar(int id){
        asignarDatos(sqlModificar, new Object[] {fecha, tipo, nombre, descripcion, beneficio, id});
    }
    
    //OK
    public void eliminar(int id){
        asignarDatos(sqlEliminar, new Object[] {id});
    }
}