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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import view.View;

public class Model {
    /*
    //INICIAR CON LOGIN
    String usuario = JOptionPane.showInputDialog("Usuario:");
    String contraseña = JOptionPane.showInputDialog("Contraseña:");
    */
    
    //INICIAR SIN LOGIN
    String usuario = "admin";
    String contraseña = "12345";
    
    
    String nombreDB = "colectivos";
    Connection con = null;
    PreparedStatement ppt = null;
    Statement stm = null;
    ResultSet rs = null;
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    
    View v = null;
    
    public Model(View v){
        try {
            con = conectar(usuario, contraseña);
            stm = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.v = v;
    }
    
    public ColectivoModel crearColectivo(){
        return new ColectivoModel(con);
    }
    
    public ConductorModel crearConductor(){
        return new ConductorModel(con);
    }
    
    public RepuestoModel crearRepuesto(){
        return new RepuestoModel(con);
    }
    
    public EventoModel crearEvento(){
        return new EventoModel(con);
    }
    
    
    private Connection conectar(String usuario, String contraseña){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            stm = con.createStatement();
            if(!existeDB(nombreDB)){
                crearDB();
            }
            ppt = con.prepareStatement("SELECT * FROM Administrador WHERE Usuario = ? AND Contraseña = ?;");
            ppt.setString(1, usuario);
            ppt.setString(2, contraseña);
            rs = ppt.executeQuery();
            
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
                System.exit(0);
            }
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos, porfavor inicie XAMPP.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return null;
    }
    
    private boolean existeDB(String nombreDB){
        try {
            rs = con.getMetaData().getCatalogs();
            while (rs.next()) {
                String db = rs.getString(1);
                if(nombreDB.equals(db)){
                    stm.execute("USE Colectivos;");
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void crearDB(){
        try {
            stm.execute("CREATE DATABASE Colectivos;");
            stm.execute("USE Colectivos;");

            //TABLAS
            //Administrador
            stm.execute("CREATE TABLE Administrador("
                    + "Usuario VarChar(30) NOT NULL, "
                    + "Contraseña VarChar(30) NOT NULL, "
                    + "PRIMARY KEY (Usuario));");
            
            stm.execute("INSERT INTO Administrador VALUES ('admin', '12345');");
            
            //Colectivo
            stm.execute("CREATE TABLE Colectivo("
                    + "Matricula Char(6) NOT NULL, "
                    + "Compra Date, "
                    + "KilometrajeActual Int(7), "
                    + "Marca VarChar(15), "
                    + "Vin VarChar(17), "
                    + "Motor VarChar(12), "
                    + "PRIMARY KEY (Matricula));");
            
            //Colectivo-ConductorModel
            stm.execute("CREATE TABLE ColectivoConductor("
                    + "Matricula Char(6) NOT NULL, "
                    + "RutConductor Char(10) NOT NULL, "
                    + "Descripcion VarChar(50), "
                    + "Estado TinyInt(1) NOT NULL, "
                    + "PRIMARY KEY (Matricula, RutConductor));");
            
            //Conductor
            stm.execute("CREATE TABLE Conductor("
                    + "RutConductor Char(10) NOT NULL, "
                    + "Nombre VarChar(50), "
                    + "Direccion VarChar(150), "
                    + "Telefono VarChar(12), "
                    + "PRIMARY KEY (RutConductor));");
            
            //Colectivo-RepuestoModel
            stm.execute("CREATE TABLE ColectivoRepuesto("
                    + "Matricula Char(6) NOT NULL, "
                    + "IdRepuesto Int(3) NOT NULL, "
                    + "Cambio Date NOT NULL, "
                    + "Observacion VarChar(50), "
                    + "Estado TinyInt(1) NOT NULL, "
                    + "PRIMARY KEY (Matricula, IdRepuesto));");
            
            //Repuesto
            stm.execute("CREATE TABLE Repuesto("
                    + "IdRepuesto Int(3) NOT NULL AUTO_INCREMENT, "
                    + "TipoRepuesto VarChar(30), "
                    + "KilometrajeMax Int(7), "
                    + "KilometrajeDeUso Int(7), "
                    + "PRIMARY KEY (IdRepuesto));");
            
            /*
            //Repuesto-Compra
            stm.execute("CREATE TABLE RepuestoCompra("
                    + "IdRepuesto Int(3) NOT NULL,"
                    + "IdCompra Int(3) NOT NULL,"
                    + "PRIMARY KEY (IdRepuesto, IdCompra));");
            
            //Compra
            stm.execute("CREATE TABLE Compra("
                    + "IdCompra Int(3) NOT NULL AUTO_INCREMENT,"
                    + "Compra Date,"
                    + "Precio Int(7),"
                    + "PRIMARY KEY (IdCompra));");
            */
            
            //Colectivo-EventoModel
            stm.execute("CREATE TABLE ColectivoEvento("
                    + "Matricula Char(6) NOT NULL,"
                    + "IdEvento Int(3) NOT NULL,"
                    + "PRIMARY KEY (Matricula, IdEvento));");
            
            //Evento
            stm.execute("CREATE TABLE Evento("
                    + "IdEvento Int(3) NOT NULL AUTO_INCREMENT, "
                    + "Fecha Date, "
                    + "TipoEvento VarChar(30), "
                    + "NombreEvento VarChar(50), "
                    + "Descripcion VarChar(150), "
                    + "Beneficio Int(7), "
                    + "PRIMARY KEY (IdEvento));");
            
            //Repuesto-Ajuste
            stm.execute("CREATE TABLE RepuestoAjuste("
                    + "IdAjuste Int(3) NOT NULL,"
                    + "IdRepuesto Int(3) NOT NULL, "
                    + "PRIMARY KEY (IdRepuesto, IdAjuste));");
            
            //Ajuste
            stm.execute("CREATE TABLE Ajuste("
                    + "IdAjuste Int(3) NOT NULL AUTO_INCREMENT,"
                    + "Fecha Date,"
                    + "TipoAjuste VarChar(30),"
                    + "Motivo VarChar(150), "
                    + "PRIMARY KEY (IdAjuste));");
            
            //Ganancia
            stm.execute("CREATE TABLE Ganancia("
                    + "Fecha Date NOT NULL, "
                    + "Matricula Char(6) NOT NULL, "
                    + "Ganancia Int(7), "
                    + "PRIMARY KEY (Fecha, Matricula));");
            
            //CLAVES FORANEAS
            stm.execute("ALTER TABLE ColectivoConductor ADD CONSTRAINT FK_COLECTIVOCONDUCTOR_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula) ON DELETE CASCADE ON UPDATE CASCADE;");
            stm.execute("ALTER TABLE ColectivoConductor ADD CONSTRAINT FK_COLECTIVOCONDUCTOR_CONDUCTOR FOREIGN KEY (RutConductor) REFERENCES Conductor(RutConductor) ON DELETE CASCADE ON UPDATE CASCADE;");
            
            stm.execute("ALTER TABLE ColectivoRepuesto ADD CONSTRAINT FK_COLECTIVOREPUESTO_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula) ON DELETE CASCADE ON UPDATE CASCADE;");
            stm.execute("ALTER TABLE ColectivoRepuesto ADD CONSTRAINT FK_COLECTIVOREPUESTO_REPUESTO FOREIGN KEY (IdRepuesto) REFERENCES Repuesto(IdRepuesto) ON DELETE CASCADE ON UPDATE CASCADE;");
            /*
            stm.execute("ALTER TABLE RepuestoCompra ADD CONSTRAINT FK_REPUESTOCOMPRA_REPUESTO FOREIGN KEY (IdRepuesto) REFERENCES RepuestoModel(IdRepuesto) ON DELETE CASCADE;");
            stm.execute("ALTER TABLE RepuestoCompra ADD CONSTRAINT FK_REPUESTOCOMPRA_COMPRA FOREIGN KEY (IdCompra) REFERENCES Compra(IdCompra) ON DELETE CASCADE;");
            */
            stm.execute("ALTER TABLE ColectivoEvento ADD CONSTRAINT FK_COLECTIVOEVENTO_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula) ON DELETE CASCADE ON UPDATE CASCADE;");
            stm.execute("ALTER TABLE ColectivoEvento ADD CONSTRAINT FK_COLECTIVOEVENTO_EVENTO FOREIGN KEY (IdEvento) REFERENCES Evento(IdEvento) ON DELETE CASCADE ON UPDATE CASCADE;");
            
            stm.execute("ALTER TABLE RepuestoAjuste ADD CONSTRAINT FK_REPUESTOAJUSTE_REPUESTO FOREIGN KEY (IdRepuesto) REFERENCES Repuesto(IdRepuesto) ON DELETE CASCADE ON UPDATE CASCADE;");
            stm.execute("ALTER TABLE RepuestoAjuste ADD CONSTRAINT FK_REPUESTOAJUSTE_AJUSTE FOREIGN KEY (IdAjuste) REFERENCES Ajuste(IdAjuste) ON DELETE CASCADE ON UPDATE CASCADE;");
            
            //stm.execute("ALTER TABLE Ajuste ADD CONSTRAINT FK_AJUSTE_REPUESTO FOREIGN KEY (IdRepuesto) REFERENCES RepuestoModel(IdRepuesto) ON DELETE CASCADE;");
            
            stm.execute("ALTER TABLE Ganancia ADD CONSTRAINT FK_GANANCIA_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula) ON DELETE CASCADE ON UPDATE CASCADE;");
            
            //INSERTAR DATOS INICIALES
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarDB(){
        try {
            stm.execute("DROP DATABASE Colectivos;");
        } catch (Exception e) {
        }
    }
    
    public void refrescar(){
        try {
            // Colectivos
            JComboBox[] cmbColectivos = {v.cmbRepuestoColectivos, v.cmbConductorColectivos, v.cmbGananciaBusquedaMatricula, v.cmbGananciaMatricula};
            Model.this.refrescarCmb(cmbColectivos, "Matricula", "Colectivo");
            
            DefaultTableModel tmColectivos = (DefaultTableModel) v.tblColectivos.getModel();
            tmColectivos.setRowCount(0);
            
            String sql = "SELECT * FROM (SELECT c.Matricula, cc.RutConductor, c.Compra, c.KilometrajeActual, c.Marca, c.Vin, c.Motor FROM Colectivo c LEFT JOIN ColectivoConductor cc ON c.Matricula = cc.Matricula AND cc.Estado = 1)TB WHERE Matricula LIKE ? ";
            if (!v.txtBusquedaTablaColectivoRut.getText().strip().equals("")) {
                sql += "AND RutConductor LIKE '%" + v.txtBusquedaTablaColectivoRut.getText().strip() + "%' ";
            }
            ppt = con.prepareStatement(sql + "ORDER BY Matricula ASC;");
            ppt.setString(1, '%' + v.txtBusquedaTablaColectivoMatricula.getText().strip() + '%');
            rs = ppt.executeQuery();
            while (rs.next()) {
                String matricula = (rs.getString("Matricula") != null) ? rs.getString("Matricula") : "------";
                String rutConductor = (rs.getString("RutConductor") != null) ? rs.getString("RutConductor") : "------";
                Object [] fila = {matricula, rutConductor, rs.getString("Compra"), rs.getString("KilometrajeActual"), rs.getString("Marca"), rs.getString("Vin"), rs.getString("Motor")};
                tmColectivos.addRow(fila);
            }
            v.tblColectivos.setModel(tmColectivos);
            
            
            // Conductores
            refrescarCmb(v.cmbColectivoConductores, "RutConductor", "Conductor");
            
            DefaultTableModel tmConductores = (DefaultTableModel) v.tblConductores.getModel();
            tmConductores.setRowCount(0);
            
            ppt = con.prepareStatement("SELECT * FROM (SELECT c.RutConductor, cc.Matricula, c.Nombre, c.Direccion, c.Telefono FROM Conductor c LEFT JOIN ColectivoConductor cc ON c.RutConductor = cc.RutConductor AND cc.Estado = 1)TB WHERE Nombre LIKE ? AND RutConductor LIKE ? ORDER BY RutConductor ASC;");
            ppt.setString(1, '%' + v.txtBusquedaTablaConductorNombre.getText().strip() + '%');
            ppt.setString(2, '%' + v.txtBusquedaTablaConductorRut.getText().strip() + '%');
            rs = ppt.executeQuery();
            while (rs.next()) {
                String rutConductor = (rs.getString("RutConductor") != null) ? rs.getString("RutConductor") : "------";
                String matricula = (rs.getString("Matricula") != null) ? rs.getString("Matricula") : "------";
                Object [] fila = {rutConductor, matricula, rs.getString("Nombre"), rs.getString("Direccion"), rs.getString("Telefono")};
                tmConductores.addRow(fila);
            }
            v.tblConductores.setModel(tmConductores);
            
            // Repuestos
            JComboBox[] cmbRepuestos = {v.cmbRepuestoCantidadTipo};
            refrescarCmb(v.cmbRepuestoCantidadTipo, "TipoRepuesto", "Repuesto");
            
            DefaultTableModel tmRepuesto = (DefaultTableModel) v.tblRepuestos.getModel();
            tmRepuesto.setRowCount(0);
            
            sql = "SELECT * FROM (SELECT r.IdRepuesto, r.TipoRepuesto, cr.Matricula, cr.Cambio, r.KilometrajeMax, r.KilometrajeDeUso FROM Repuesto r LEFT JOIN ColectivoRepuesto cr ON r.IdRepuesto = cr.IdRepuesto AND cr.Estado = 1)TB WHERE TipoRepuesto LIKE ? ";
            if (!v.txtBusquedaTablaRepuestoMatricula.getText().strip().equals("")) {
                sql += "AND Matricula LIKE '%" + v.txtBusquedaTablaRepuestoMatricula.getText().strip() + "%' ";
            }
            ppt = con.prepareStatement(sql + "ORDER BY TipoRepuesto ASC;");
            ppt.setString(1, '%' + v.txtBusquedaTablaRepuestoTipo.getText().strip() + '%');
            rs = ppt.executeQuery();
            while (rs.next()) {
                String matricula = (rs.getString("Matricula") != null) ? rs.getString("Matricula") : "------";
                String cambio = (rs.getDate("Cambio") != null) ? rs.getDate("Cambio").toString() : "------";
                Object [] fila = {rs.getInt("IdRepuesto"), rs.getString("TipoRepuesto"), matricula, cambio,  rs.getInt("KilometrajeMax"), rs.getInt("KilometrajeDeUso")};
                tmRepuesto.addRow(fila);
            }
            v.tblRepuestos.setModel(tmRepuesto);
            
            //Eventos
            DefaultTableModel tmEventos = (DefaultTableModel) v.tblEventos.getModel();
            tmEventos.setRowCount(0);
            
            sql = "SELECT * FROM Evento WHERE Fecha >= ? AND NombreEvento LIKE ?";
            if (v.cmbBusquedaTablaEventoTipo.getSelectedIndex() != 0) {
                sql += " AND TipoEvento = '" + v.cmbBusquedaTablaEventoTipo.getSelectedItem().toString() + "'";
            }
            ppt = con.prepareStatement(sql + " ORDER BY Fecha ASC;");
            ppt.setString(1, formato.format((v.dchBusquedaTablaEventoFecha.getDate() == null) ? new Date(1L) : v.dchBusquedaTablaEventoFecha.getDate()));
            ppt.setString(2, '%' + v.txtBusquedaTablaEventoNombre.getText().strip() + '%');
            rs = ppt.executeQuery();
            while (rs.next()) {
                Object [] fila = {rs.getInt("IdEvento"), rs.getDate("Fecha"), rs.getString("TipoEvento"), rs.getString("NombreEvento"), rs.getInt("Beneficio")};
                tmEventos.addRow(fila);
            }
            v.tblEventos.setModel(tmEventos);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void refrescarCmb(JComboBox[] cmbs, String pk, String tabla){
        try {
            List<String> pks = new ArrayList<String>();
            ppt = con.prepareStatement("SELECT " + pk + " FROM " + tabla + ";");
            rs = ppt.executeQuery();
            while (rs.next()) {
                pks.add(rs.getString("Matricula"));
            }
            for (JComboBox cmb : cmbs) {
                cmb.removeAllItems();
                cmb.addItem("------");
                for (String matricula : pks) {
                    cmb.addItem(matricula);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public void refrescarCmb(JComboBox cmb, String pk, String tabla){
        try {
            List<String> pks = new ArrayList<String>();
            ppt = con.prepareStatement("SELECT DISTINCT " + pk + " FROM " + tabla + ";");
            rs = ppt.executeQuery();
            while (rs.next()) {
                pks.add(rs.getString(pk));
            }
            cmb.removeAllItems();
            cmb.addItem("------");
            for (String matricula : pks) {
                cmb.addItem(matricula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void setValor(Object input, Object valor){
        try {
            if (input instanceof JTextField) {
                ((JTextField) input).setText(valor.toString());
            }
            if (input instanceof JDateChooser) {
                    ((JDateChooser) input).setDate((valor != "------") ? formato.parse(valor.toString()) : null);
            }
            if (input instanceof JComboBox) {
                ((JComboBox) input).setSelectedItem(valor);
            }
            if (input instanceof JLabel) {
                ((JLabel) input).setText(valor.toString());
            }
            if (input instanceof JSpinner) {
                ((JSpinner) input).setValue(Integer.valueOf(valor.toString()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public void transferirValores(JTable tabla, List<Object> inputList){
        int fila = tabla.getSelectedRow();

        for (int i = 0; i < tabla.getColumnCount(); i++) {
            setValor(inputList.get(i), tabla.getValueAt(fila, i));
        }
    }

    public void restablecer(List<Object> inputList, Object[] data){
        for (int i = 0; i < data.length; i++) {
            setValor(inputList.get(i), data[i]);
        }
    }
    
    public void añadirKilometraje() {
        
    }
}
