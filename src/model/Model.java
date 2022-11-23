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
import java.util.List;
import javax.swing.JComboBox;
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
        refrescar();
    }
    
    public Colectivo crearColectivo(List<Object> input){
        return new Colectivo(v, con);
    }
    
    public Conductor crearConductor(List<Object> input){
        return new Conductor(v, con);
    }
    
    public Repuesto crearRepuesto(List<Object> input){
        return new Repuesto(v, con);
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
            
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta.");
                System.exit(0);
            }
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
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
                    + "Stock Int(3), "
                    + "PRIMARY KEY (IdRepuesto));");
            
            //Repuesto-Compra
            stm.execute("CREATE TABLE RepuestoCompra("
                    + "IdRepuesto Int(3) NOT NULL,"
                    + "IdCompra Int(3) NOT NULL,"
                    + "Cantidad Int(3),"
                    + "Precio Int(7),"
                    + "PRIMARY KEY (IdRepuesto, IdCompra));");
            
            //Compra
            stm.execute("CREATE TABLE Compra("
                    + "IdCompra Int(3) NOT NULL AUTO_INCREMENT,"
                    + "Compra Date,"
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
            stm.execute("ALTER TABLE ColectivoConductor ADD CONSTRAINT FK_COLECTIVOCONDUCTOR_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula);");
            stm.execute("ALTER TABLE ColectivoConductor ADD CONSTRAINT FK_COLECTIVOCONDUCTOR_CONDUCTOR FOREIGN KEY (RutConductor) REFERENCES Conductor(RutConductor);");
            
            stm.execute("ALTER TABLE ColectivoRepuesto ADD CONSTRAINT FK_COLECTIVOREPUESTO_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula);");
            stm.execute("ALTER TABLE ColectivoRepuesto ADD CONSTRAINT FK_COLECTIVOREPUESTO_REPUESTO FOREIGN KEY (IdRepuesto) REFERENCES Repuesto(IdRepuesto);");
            
            stm.execute("ALTER TABLE RepuestoCompra ADD CONSTRAINT FK_REPUESTOCOMPRA_REPUESTO FOREIGN KEY (IdRepuesto) REFERENCES Repuesto(IdRepuesto);");
            stm.execute("ALTER TABLE RepuestoCompra ADD CONSTRAINT FK_REPUESTOCOMPRA_COMPRA FOREIGN KEY (IdCompra) REFERENCES Compra(IdCompra);");
            
            stm.execute("ALTER TABLE ColectivoEvento ADD CONSTRAINT FK_COLECTIVOEVENTO_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula);");
            stm.execute("ALTER TABLE ColectivoEvento ADD CONSTRAINT FK_COLECTIVOEVENTO_EVENTO FOREIGN KEY (IdEvento) REFERENCES Evento(IdEvento);");
            
            stm.execute("ALTER TABLE Ganancia ADD CONSTRAINT FK_GANANCIA_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula);");
            
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
            v.cmbMatriculaRepuesto.removeAllItems();
            v.cmbMatriculaRepuesto.addItem("------");
            v.cmbMatriculaRepuesto.setSelectedIndex(0);
            v.cmbColectivosConductor.removeAllItems();
            v.cmbColectivosConductor.addItem("------");
            v.cmbColectivosConductor.setSelectedIndex(0);
            DefaultTableModel tmColectivos = (DefaultTableModel) v.tblColectivos.getModel();
            tmColectivos.setRowCount(0);
            ppt = con.prepareStatement("SELECT * FROM Colectivo WHERE Matricula LIKE ? AND RutConductor LIKE ? AND Matricula != ? ORDER BY Matricula ASC;");
            ppt.setString(1, '%' + v.txtBusquedaTablaColectivosMatricula.getText().strip() + '%');
            ppt.setString(2, '%' + v.txtBusquedaTablaColectivosRut.getText().strip() + '%');
            ppt.setString(3, "------");
            rs = ppt.executeQuery();
            while (rs.next()) {
                Object [] fila = {rs.getString("Matricula"), rs.getString("RutConductor"), rs.getString("Compra"), rs.getString("Seguro"), rs.getString("RevisionTecnica"), rs.getString("KilometrajeActual"), rs.getString("Marca"), rs.getString("Vin"), rs.getString("Motor")};
                tmColectivos.addRow(fila);
                v.cmbMatriculaRepuesto.addItem(rs.getString("Matricula"));
                v.cmbColectivosConductor.addItem(rs.getString("Matricula"));
            }
            v.tblColectivos.setModel(tmColectivos);
            
            // Conductores 
            v.cmbConductoresColectivo.removeAllItems();
            v.cmbConductoresColectivo.addItem("------");
            v.cmbConductoresColectivo.setSelectedIndex(0);
            DefaultTableModel tmConductores = (DefaultTableModel) v.tblConductores.getModel();
            tmConductores.setRowCount(0);
            ppt = con.prepareStatement("SELECT * FROM Conductor WHERE Nombre LIKE ? AND RutConductor LIKE ? AND RutConductor != ? ORDER BY RutConductor ASC;");
            ppt.setString(1, '%' + v.txtBusquedaTablaConductorNombre.getText().strip() + '%');
            ppt.setString(2, '%' + v.txtBusquedaTablaConductorRut.getText().strip() + '%');
            ppt.setString(3, "------");
            rs = ppt.executeQuery();
            while (rs.next()) {
                Object [] fila = {rs.getString("RutConductor"), rs.getString("Nombre"), rs.getString("Direccion"), rs.getString("Telefono"), rs.getString("Matricula")};
                tmConductores.addRow(fila);
                v.cmbConductoresColectivo.addItem(rs.getString("RutConductor"));
            }
            v.tblConductores.setModel(tmConductores);
            
            // Repuestos
            DefaultTableModel tmRepuestos = (DefaultTableModel) v.tblRepuestos.getModel();
            tmRepuestos.setRowCount(0);
            rs = stm.executeQuery("SELECT * FROM Repuesto ORDER BY Matricula ASC;");
            while (rs.next()) {
                Object [] fila = {rs.getString("TipoRepuesto"), rs.getString("Matricula"), rs.getString("Compra"), rs.getString("KilometrajeMax"), rs.getString("KilometrajeActual")};
                tmRepuestos.addRow(fila);
            }
            v.tblRepuestos.setModel(tmRepuestos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void consultarValores(JTable tabla, List<Object> inputList){
        try {
            int fila = tabla.getSelectedRow();
            
            JComboBox cb = null;
            JTextField tf = null;
            JDateChooser dc = null;
            Object input = null;
            Object valor = null;
            
            for (int i = 0; i < inputList.size(); i++) {
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
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
      
    /*
    public void insertarConductor(){
        try {
            if (!existeRut(v.txtRutConductor.getText().strip())) {
                //Insertar conductor nuevo sin matricula
                ppt = con.prepareStatement("INSERT INTO Conductor VALUES (?, ?, ?, ?, ?);");
                ppt.setString(1, v.txtRutConductor.getText().strip().toUpperCase());
                ppt.setString(2, "------");
                ppt.setString(3, capitalizar(v.txtNombreConductor.getText().strip()));
                ppt.setString(4, capitalizar(v.txtDireccionConductor.getText().strip()));
                ppt.setString(5, v.txtTelefonoConductor.getText().strip());
                ppt.execute();
                
                //Si se selecciono un colectivo
                if (v.cmbColectivosConductor.getSelectedIndex() != 0) {
                    //Colocarle colectivo a conductor
                    ppt = con.prepareStatement("UPDATE Conductor SET Matricula = ? WHERE RutConductor = ?;");
                    ppt.setString(1, v.cmbColectivosConductor.getSelectedItem().toString());
                    ppt.setString(2, v.txtRutConductor.getText().strip());
                    ppt.executeUpdate();

                    //Colocarle conductor a colectivo
                    ppt = con.prepareStatement("UPDATE Colectivo SET RutConductor = ? WHERE Matricula = ?;");
                    ppt.setString(1, v.txtRutConductor.getText().strip());
                    ppt.setString(2, v.cmbColectivosConductor.getSelectedItem().toString());
                    ppt.executeUpdate();
                }
                
                refrescar();
            } else {
                JOptionPane.showMessageDialog(null, "Rut Duplicado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void modificarConductor(){
        try {
            if (existeRut(v.txtRutConductor.getText().strip().toUpperCase())) {
                //Actualizar conductor sin matricula
                ppt = con.prepareStatement("UPDATE Conductor SET Matricula = ?, Nombre = ?, Direccion = ?, Telefono= ? WHERE RutConductor = ?;");
                ppt.setString(1, "------");
                ppt.setString(2, capitalizar(v.txtNombreConductor.getText().strip()));
                ppt.setString(3, capitalizar(v.txtDireccionConductor.getText().strip()));
                ppt.setString(4, v.txtTelefonoConductor.getText().strip());
                ppt.setString(5, v.txtRutConductor.getText().strip());
                ppt.executeUpdate();
                
                //Quitar conductor de colectivo
                ppt = con.prepareStatement("UPDATE Colectivo SET RutConductor = '------' WHERE RutConductor = ?;");
                ppt.setString(1, v.txtRutConductor.getText().strip());
                ppt.executeUpdate();
                
                //Si se selecciono a un conductor
                if (v.cmbColectivosConductor.getSelectedIndex() != 0) {
                    //Quitar colectivo de conductor
                    ppt = con.prepareStatement("UPDATE Conductor SET Matricula = '------' WHERE Matricula = ?;");
                    ppt.setString(1, v.cmbColectivosConductor.getSelectedItem().toString());
                    ppt.executeUpdate();
                    
                    //Colocarle la matricula al conductor
                    ppt = con.prepareStatement("UPDATE Conductor SET Matricula = ? WHERE RutConductor = ?;");
                    ppt.setString(1, v.cmbColectivosConductor.getSelectedItem().toString());
                    ppt.setString(2, v.txtRutConductor.getText().strip());
                    ppt.executeUpdate();
                    
                    //Colocarle el conductor a la matricula
                    ppt = con.prepareStatement("UPDATE Colectivo SET RutConductor = ? WHERE Matricula = ?;");
                    ppt.setString(1, v.txtRutConductor.getText().strip());
                    ppt.setString(2, v.cmbColectivosConductor.getSelectedItem().toString());
                    ppt.executeUpdate();
                }
                
                refrescar();
            } else {
                JOptionPane.showMessageDialog(null, "No existe Rut.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarConductor(){
        try {
            if (existeRut(v.txtRutConductor.getText().strip().toUpperCase())) {
                //Quitarle conductor a colectivo
                ppt = con.prepareStatement("UPDATE Colectivo SET RutConductor = '------' WHERE RutConductor = ?;");
                ppt.setString(1, v.txtRutConductor.getText().strip());
                ppt.executeUpdate();
                
                //Eliminar Conductor
                ppt = con.prepareStatement("DELETE FROM Conductor WHERE RutConductor = ?;");
                ppt.setString(1, v.txtRutConductor.getText().strip());
                ppt.execute();
                
                refrescar();
            } else {
                JOptionPane.showMessageDialog(null, "No existe Rut.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
}
