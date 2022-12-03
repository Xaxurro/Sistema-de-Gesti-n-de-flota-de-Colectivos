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
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    
    public Colectivo crearColectivo(List<Object> input){
        /*
        this.colectivo = new Colectivo(v, con);
        return this.colectivo;
        */
        return new Colectivo(v, con);
    }
    
    public Conductor crearConductor(List<Object> input){
        /*
        this.conductor = new Conductor(v, con);
        return this.conductor;
        */
        return new Conductor(v, con);
    }
    
    public Repuesto crearRepuesto(List<Object> input){
        /*
        this.repuesto = new Repuesto(v, con);
        return this.repuesto;
        */
        return new Repuesto(v, con);
    }
    
    public Evento crearEvento(List<Object> input){
        /*
        this.repuesto = new Repuesto(v, con);
        return this.repuesto;
        */
        return new Evento(v, con);
    }
    
    
    private Connection conectar(String usuario, String contraseña){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            stm = con.createStatement();
            if(!existeDB(con, rs, nombreDB)){
                crearDB();
            }
            ppt = con.prepareStatement("SELECT * FROM Administrador WHERE Usuario = ? AND Contraseña = ?;");
            ppt.setString(1, usuario);
            ppt.setString(2, contraseña);
            rs = ppt.executeQuery();
            
            /*
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
                System.exit(0);
            }
            */
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
    
    private boolean existeDB(Connection con, ResultSet rs, String nombreDB){
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
            //Colectivo
            stm.execute("CREATE TABLE Colectivo("
                    + "Matricula Char(6) NOT NULL, "
                    + "Compra Date, "
                    + "KilometrajeActual Int(7), "
                    + "Marca VarChar(15), "
                    + "Vin VarChar(17), "
                    + "Motor VarChar(12), "
                    + "PRIMARY KEY (Matricula));");
            
            //Colectivo-Conductor
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
            
            //Colectivo-Repuesto
            stm.execute("CREATE TABLE ColectivoRepuesto("
                    + "Matricula Char(6) NOT NULL, "
                    + "IdRepuesto Int(3) NOT NULL, "
                    + "Compra Date, "
                    + "Cantidad Int(3), "
                    + "Observacion VarChar(50), "
                    + "PRIMARY KEY (Matricula, IdRepuesto));");
            
            //Repuesto
            stm.execute("CREATE TABLE Repuesto("
                    + "IdRepuesto Int(3) NOT NULL AUTO_INCREMENT, "
                    + "TipoRepuesto VarChar(30), "
                    + "KilometrajeMax Int(7), "
                    + "KilometrajeDeUso Int(7), "
                    + "PRIMARY KEY (IdRepuesto));");
            
            //Repuesto-Compra
            stm.execute("CREATE TABLE RepuestoCompra("
                    + "IdRepuesto Int(3) NOT NULL,"
                    + "IdCompra Int(3) NOT NULL,"
                    + "PRIMARY KEY (IdRepuesto, IdCompra));");
            
            //Compra
            stm.execute("CREATE TABLE Compra("
                    + "IdCompra Int(3) NOT NULL AUTO_INCREMENT,"
                    + "Compra Date,"
                    + "Cantidad Int(3),"
                    + "Precio Int(7),"
                    + "PRIMARY KEY (IdCompra));");
            
            //Colectivo-Evento
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
                    + "Cantidad Int(3), "
                    + "PRIMARY KEY (IdAjuste));");
            
            //Ganancia
            stm.execute("CREATE TABLE Ganancia("
                    + "Fecha Date NOT NULL, "
                    + "Matricula Char(6) NOT NULL, "
                    + "Ganancia Int(7), "
                    + "PRIMARY KEY (Fecha, Matricula));");
            
            //Administrador
            stm.execute("CREATE TABLE Administrador("
                    + "Usuario VarChar(30) NOT NULL, "
                    + "Contraseña VarChar(30) NOT NULL, "
                    + "PRIMARY KEY (Usuario));");
            
            
            //CLAVES FORANEAS
            stm.execute("ALTER TABLE ColectivoConductor ADD CONSTRAINT FK_COLECTIVOCONDUCTOR_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula) ON DELETE CASCADE;");
            stm.execute("ALTER TABLE ColectivoConductor ADD CONSTRAINT FK_COLECTIVOCONDUCTOR_CONDUCTOR FOREIGN KEY (RutConductor) REFERENCES Conductor(RutConductor) ON DELETE CASCADE;");
            
            stm.execute("ALTER TABLE ColectivoRepuesto ADD CONSTRAINT FK_COLECTIVOREPUESTO_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula) ON DELETE CASCADE;");
            stm.execute("ALTER TABLE ColectivoRepuesto ADD CONSTRAINT FK_COLECTIVOREPUESTO_REPUESTO FOREIGN KEY (IdRepuesto) REFERENCES Repuesto(IdRepuesto) ON DELETE CASCADE;");
            
            stm.execute("ALTER TABLE RepuestoCompra ADD CONSTRAINT FK_REPUESTOCOMPRA_REPUESTO FOREIGN KEY (IdRepuesto) REFERENCES Repuesto(IdRepuesto) ON DELETE CASCADE;");
            stm.execute("ALTER TABLE RepuestoCompra ADD CONSTRAINT FK_REPUESTOCOMPRA_COMPRA FOREIGN KEY (IdCompra) REFERENCES Compra(IdCompra) ON DELETE CASCADE;");
            
            stm.execute("ALTER TABLE ColectivoEvento ADD CONSTRAINT FK_COLECTIVOEVENTO_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula) ON DELETE CASCADE;");
            stm.execute("ALTER TABLE ColectivoEvento ADD CONSTRAINT FK_COLECTIVOEVENTO_EVENTO FOREIGN KEY (IdEvento) REFERENCES Evento(IdEvento) ON DELETE CASCADE;");
            
            stm.execute("ALTER TABLE RepuestoAjuste ADD CONSTRAINT FK_REPUESTOAJUSTE_REPUESTO FOREIGN KEY (IdRepuesto) REFERENCES Repuesto(IdRepuesto) ON DELETE CASCADE;");
            stm.execute("ALTER TABLE RepuestoAjuste ADD CONSTRAINT FK_REPUESTOAJUSTE_AJUSTE FOREIGN KEY (IdAjuste) REFERENCES Ajuste(IdAjuste) ON DELETE CASCADE;");
            
            //stm.execute("ALTER TABLE Ajuste ADD CONSTRAINT FK_AJUSTE_REPUESTO FOREIGN KEY (IdRepuesto) REFERENCES Repuesto(IdRepuesto) ON DELETE CASCADE;");
            
            stm.execute("ALTER TABLE Ganancia ADD CONSTRAINT FK_GANANCIA_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula) ON DELETE CASCADE;");
            
            //INSERTAR DATOS INICIALES
            /*
            stm.execute("INSERT INTO Colectivo VALUES ('------', NULL, NULL, NULL, NULL, NULL);");
            */
            /*
            stm.execute("INSERT INTO Conductor VALUES ('------', '------', NULL, NULL, NULL);");
            */
            stm.execute("INSERT INTO Administrador VALUES ('admin', '12345');");
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
            v.cmbRepuestoColectivos.removeAllItems();
            v.cmbRepuestoColectivos.addItem("------");
            v.cmbConductorColectivos.removeAllItems();
            v.cmbConductorColectivos.addItem("------");
            DefaultTableModel tmColectivos = (DefaultTableModel) v.tblColectivos.getModel();
            tmColectivos.setRowCount(0);
            ppt = con.prepareStatement("SELECT c.Matricula, cc.RutConductor, c.Compra, c.KilometrajeActual, c.Marca, c.Vin, c.Motor FROM Colectivo c LEFT JOIN ColectivoConductor cc ON c.Matricula = cc.Matricula AND cc.Estado = 1 AND c.Matricula LIKE ? ORDER BY c.Matricula ASC;");
            ppt.setString(1, '%' + v.txtBusquedaTablaColectivoMatricula.getText().strip() + '%');
            rs = ppt.executeQuery();
            while (rs.next()) {
                Object [] fila = {rs.getString("Matricula"), rs.getString("RutConductor"), rs.getString("Compra"), rs.getString("KilometrajeActual"), rs.getString("Marca"), rs.getString("Vin"), rs.getString("Motor")};
                tmColectivos.addRow(fila);
                v.cmbRepuestoColectivos.addItem(rs.getString("Matricula"));
                v.cmbConductorColectivos.addItem(rs.getString("Matricula"));
            }
            v.tblColectivos.setModel(tmColectivos);
            
            
            // Conductores 
            v.cmbColectivoConductores.removeAllItems();
            v.cmbColectivoConductores.addItem("------");
            //v.cmbColectivoConductores.setSelectedIndex(0);
            DefaultTableModel tmConductores = (DefaultTableModel) v.tblConductores.getModel();
            tmConductores.setRowCount(0);
            ppt = con.prepareStatement("SELECT c.RutConductor, cc.Matricula, c.Nombre, c.Direccion, c.Telefono FROM Conductor c LEFT JOIN ColectivoConductor cc ON c.RutConductor = cc.RutConductor AND cc.Estado = 1 AND c.Nombre LIKE ? AND c.RutConductor LIKE ? ORDER BY c.RutConductor ASC;");
            ppt.setString(1, '%' + v.txtBusquedaTablaConductorNombre.getText().strip() + '%');
            ppt.setString(2, '%' + v.txtBusquedaTablaConductorRut.getText().strip() + '%');
            rs = ppt.executeQuery();
            while (rs.next()) {
                Object [] fila = {rs.getString("RutConductor"), rs.getString("Matricula"), rs.getString("Nombre"), rs.getString("Direccion"), rs.getString("Telefono")};
                tmConductores.addRow(fila);
                v.cmbColectivoConductores.addItem(rs.getString("RutConductor"));
            }
            v.tblConductores.setModel(tmConductores);
            
            // Repuestos
            DefaultTableModel tmRepuesto = (DefaultTableModel) v.tblRepuestos.getModel();
            tmRepuesto.setRowCount(0);
            rs = stm.executeQuery("SELECT * FROM Repuesto ORDER BY IdRepuesto ASC;");
            while (rs.next()) {
                Object [] fila = {rs.getString("TipoRepuesto"), rs.getInt("KilometrajeMax"), rs.getInt("KilometrajeDeUso"), rs.getInt("Stock")};
                tmRepuesto.addRow(fila);
            }
            v.tblRepuestos.setModel(tmRepuesto);
            
            //Eventos
            DefaultTableModel tmEventos = (DefaultTableModel) v.tblEventos.getModel();
            tmEventos.setRowCount(0);
            if (v.cmbBusquedaTablaEventoTipo.getSelectedIndex() == 0) {
                ppt = con.prepareStatement("SELECT * FROM Evento WHERE Fecha >= ? AND NombreEvento LIKE ? ORDER BY Fecha ASC;");
                ppt.setString(2, '%' + v.txtBusquedaTablaEventoNombre.getText().strip() + '%');
            } else {
                ppt = con.prepareStatement("SELECT * FROM Evento WHERE Fecha >= ? AND TipoEvento = ? AND NombreEvento LIKE ? ORDER BY Fecha ASC;");
                ppt.setString(2, v.cmbBusquedaTablaEventoTipo.getSelectedItem().toString());
                ppt.setString(3, '%' + v.txtBusquedaTablaEventoNombre.getText().strip() + '%');
            }
            ppt.setString(1, formato.format((v.dchBusquedaTablaEventoFecha.getDate() == null) ? new Date(1L) : v.dchBusquedaTablaEventoFecha.getDate()));
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
    
    public void consultarValores(JTable tabla, List<Object> inputList){
        try {
            int fila = tabla.getSelectedRow();
            Object input = null;
            Object valor = null;
            
            JComboBox cb = null;
            JTextField tf = null;
            JDateChooser dc = null;
            JLabel lbl = null;
            
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                input = inputList.get(i);
                valor = tabla.getValueAt(fila, i);
                if (input instanceof JTextField) {
                    tf = (JTextField) input;
                    tf.setText(valor.toString());
                }
                if (input instanceof JDateChooser) {
                    dc = (JDateChooser) input;
                    dc.setDate(formato.parse(valor.toString()));
                }
                if (input instanceof JComboBox) {
                    cb = (JComboBox) input;
                    cb.setSelectedItem(valor);
                }
                if (input instanceof JLabel) {
                    lbl = (JLabel) input;
                    lbl.setText(valor.toString());
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
