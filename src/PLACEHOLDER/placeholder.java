package PLACEHOLDER;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class placeholder extends javax.swing.JFrame {
    
    //INICIAR CON LOGIN
    String usuario = JOptionPane.showInputDialog("Usuario:");
    String contraseña = JOptionPane.showInputDialog("Contraseña:");
    
    /*
    //INICIAR SIN LOGIN
    String usuario = "root";
    String contraseña = "";
    */
    
    String nombreDB = "colectivos";
    //Connection con = conectar(usuario, contraseña);
    Connection con = null;
    Statement stm = null;
    ResultSet rs = null;
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    
    boolean valido;
    
    private Connection conectar(String usuario, String contraseña){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            stm = con.createStatement();
            if(!existeDB(con, rs, nombreDB)){
                crearDB();
            }
            rs = stm.executeQuery("SELECT * FROM Administrador WHERE Usuario = '" + usuario + "' AND Contraseña = '" + contraseña + "';");
            return (rs.next()) ? con : null;
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
        }
        return false;
    }
    
    private void crearDB(){
        try {
            stm.execute("CREATE DATABASE Colectivos;");
            stm.execute("USE Colectivos;");

            //TABLAS
            stm.execute("CREATE TABLE Colectivo(Matricula Char(6) NOT NULL, RutConductor VarChar(13), Compra Date, Seguro Date, RevisionTecnica Date, KilometrajeActual Int(7), Marca VarChar(15), Vin VarChar(17), Motor VarChar(12), PRIMARY KEY (Matricula));");
            stm.execute("CREATE TABLE Conductor(RutConductor Char(12) NOT NULL, Matricula Char(6), Nombre VarChar(50), Direccion VarChar(150), Telefono VarChar(12), PRIMARY KEY (RutConductor));");
            stm.execute("CREATE TABLE Repuesto(IdRepuesto int(3) NOT NULL AUTO_INCREMENT, TipoRepuesto VarChar(50), Compra Date, KilometrajeMax Int(7), KilometrajeActual Int(7), Matricula Char(6), PRIMARY KEY (IdRepuesto, TipoRepuesto));");
            stm.execute("CREATE TABLE Evento(IdEvento int(3) NOT NULL AUTO_INCREMENT, Fecha Date, NombreEvento VarChar(50), Descripcion VarChar(250), Beneficio Int(7), PRIMARY KEY (IdEvento, Fecha));");
            stm.execute("CREATE TABLE Ganancia(Fecha Date NOT NULL, Matricula Char(6) NOT NULL, Ganancia Int(7), PRIMARY KEY (Fecha, Matricula));");
            stm.execute("CREATE TABLE Administrador(Usuario VarChar(30) NOT NULL, Contraseña VarChar(30) NOT NULL, PRIMARY KEY (Usuario));");
            
            //CLAVES FORANEAS
            stm.execute("ALTER TABLE Colectivo ADD CONSTRAINT FK_COLECTIVO_CONDUCTOR FOREIGN KEY (RutConductor) REFERENCES Conductor(RutConductor);");
            stm.execute("ALTER TABLE Conductor ADD CONSTRAINT FK_CONDUCTOR_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula);");
            stm.execute("ALTER TABLE Repuesto ADD CONSTRAINT FK_REPUESTO_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula);");
            stm.execute("ALTER TABLE Ganancia ADD CONSTRAINT FK_GANANCIA_COLECTIVO FOREIGN KEY (Matricula) REFERENCES Colectivo(Matricula);");
            
            //INSERTAR USUARIO INICIAL
            stm.execute("INSERT INTO Administrador VALUES ('admin', '12345');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void refrescar(){
        try {  
            // Colectivos
            cmbMatriculaRepuesto.removeAllItems();
            cmbMatriculaRepuesto.addItem("------");
            cmbColectivosConductor.removeAllItems();
            cmbColectivosConductor.addItem("------");
            DefaultTableModel tmColectivos = (DefaultTableModel) tblColectivos.getModel();
            tmColectivos.setRowCount(0);
            rs = stm.executeQuery("SELECT * FROM Colectivo WHERE Matricula LIKE '%" + txtBusquedaTablaColectivosMatricula.getText().strip() + "%' AND RutConductor LIKE '%" + txtBusquedaTablaColectivosRut.getText().strip() + "%' ORDER BY Matricula ASC;");
            while (rs.next()) {
                Object [] fila = {rs.getString("Matricula"), rs.getString("RutConductor"), rs.getString("Compra"), rs.getString("Seguro"), rs.getString("RevisionTecnica"), rs.getString("KilometrajeActual"), rs.getString("Marca"), rs.getString("Vin"), rs.getString("Motor")};
                tmColectivos.addRow(fila);
                cmbMatriculaRepuesto.addItem(rs.getString("Matricula"));
                cmbColectivosConductor.addItem(rs.getString("Matricula"));
            }
            tblColectivos.setModel(tmColectivos);
            
            // Conductores 
            DefaultTableModel tmConductores = (DefaultTableModel) tblConductores.getModel();
            tmConductores.setRowCount(0);
            cmbConductoresColectivos.removeAllItems();
            cmbConductoresColectivos.addItem("------");
            rs = stm.executeQuery("SELECT * FROM Conductor WHERE Nombre LIKE '%" + txtBusquedaTablaConductorNombre.getText().strip() + "%' AND RutConductor LIKE '%" + txtBusquedaTablaConductorRut.getText().strip() + "%' ORDER BY RutConductor ASC;");
            while (rs.next()) {
                Object [] fila = {rs.getString("RutConductor"), rs.getString("Nombre"), rs.getString("Direccion"), rs.getString("Telefono"), rs.getString("Matricula")};
                tmConductores.addRow(fila);
                cmbConductoresColectivos.addItem(rs.getString("RutConductor"));
            }
            tblConductores.setModel(tmConductores);
            
            // Repuestos
            DefaultTableModel tmRepuestos = (DefaultTableModel) tblRepuestos.getModel();
            tmRepuestos.setRowCount(0);
            rs = stm.executeQuery("SELECT * FROM Repuesto ORDER BY Matricula ASC;");
            while (rs.next()) {
                Object [] fila = {rs.getString("TipoRepuesto"), rs.getString("Matricula"), rs.getString("Compra"), rs.getString("KilometrajeMax"), rs.getString("KilometrajeActual")};
                tmRepuestos.addRow(fila);
            }
            tblRepuestos.setModel(tmRepuestos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void eliminarDB(){
        try {
            stm.execute("DROP DATABASE Colectivos;");
        } catch (Exception e) {
        }
    }
    
    public Formulario() {
        try {
            con = conectar(usuario, contraseña);
            //stm = con.createStatement();
            /*
            //DESCOMENTAR EN CASO DE QUERER RE HACER DB
            eliminarDB();
            crearDB();
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        if (con != null) {

            initComponents();
            
            // Modificar Tamaño de las Columnas Jtables
            tblColectivos.getColumnModel().getColumn(0).setMinWidth(100);
            tblColectivos.getColumnModel().getColumn(1).setMinWidth(100);
            tblColectivos.getColumnModel().getColumn(2).setMinWidth(100);
            tblColectivos.getColumnModel().getColumn(3).setMinWidth(125);
            tblColectivos.getColumnModel().getColumn(4).setMinWidth(130);
            tblColectivos.getColumnModel().getColumn(5).setMinWidth(100);
            tblColectivos.getColumnModel().getColumn(6).setMinWidth(100);
            tblColectivos.getColumnModel().getColumn(7).setMinWidth(100);
            tblColectivos.getColumnModel().getColumn(8).setMinWidth(100);
            
            refrescar();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexion con la Base de Datos, o se ingresaron incorrectamente los datos de inicio de sesion.");
            System.exit(0);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlColectivo = new javax.swing.JPanel();
        lblMatriculaColectivo = new javax.swing.JLabel();
        txtMatriculaColectivo = new javax.swing.JTextField();
        lblCompraColectivo = new javax.swing.JLabel();
        dchCompraColectivo = new com.toedter.calendar.JDateChooser();
        lblSeguroColectivo = new javax.swing.JLabel();
        dchSeguroColectivo = new com.toedter.calendar.JDateChooser();
        lblRevisionColectivo = new javax.swing.JLabel();
        dchRevisionColectivo = new com.toedter.calendar.JDateChooser();
        lblKilometrajeColectivo = new javax.swing.JLabel();
        txtKilometrajeColectivo = new javax.swing.JTextField();
        lblMarcaColectivo = new javax.swing.JLabel();
        txtMarcaColectivo = new javax.swing.JTextField();
        lblVinColectivo = new javax.swing.JLabel();
        txtVinColectivo = new javax.swing.JTextField();
        lblMotorColectivo = new javax.swing.JLabel();
        txtMotorColectivo = new javax.swing.JTextField();
        btnAñadirColectivo = new javax.swing.JButton();
        scpColectivos = new javax.swing.JScrollPane();
        tblColectivos = new javax.swing.JTable();
        lblBusquedaTablaColectivosMatricula = new javax.swing.JLabel();
        txtBusquedaTablaColectivosMatricula = new javax.swing.JTextField();
        lblMotorColectivo1 = new javax.swing.JLabel();
        cmbConductoresColectivos = new javax.swing.JComboBox<>();
        btnModificarColectivo = new javax.swing.JButton();
        btnEliminarColectivo = new javax.swing.JButton();
        btnLimpiarColectivo = new javax.swing.JButton();
        txtBusquedaTablaColectivosRut = new javax.swing.JTextField();
        lblBusquedaTablaColectivosRut = new javax.swing.JLabel();
        btnLimpiarBuscadoresColectivo = new javax.swing.JButton();
        pnlConductor = new javax.swing.JPanel();
        lblRutConductor = new javax.swing.JLabel();
        txtRutConductor = new javax.swing.JTextField();
        lblNombreConductor = new javax.swing.JLabel();
        txtNombreConductor = new javax.swing.JTextField();
        lblDireccionConductor = new javax.swing.JLabel();
        txtDireccionConductor = new javax.swing.JTextField();
        lblTelefonoConductor = new javax.swing.JLabel();
        txtTelefonoConductor = new javax.swing.JTextField();
        scpConductores = new javax.swing.JScrollPane();
        tblConductores = new javax.swing.JTable();
        btnAñadirConductor = new javax.swing.JButton();
        btnModificarConductor = new javax.swing.JButton();
        btnEliminarConductor = new javax.swing.JButton();
        lblBusquedaTablaConductorNombre = new javax.swing.JLabel();
        txtBusquedaTablaConductorNombre = new javax.swing.JTextField();
        btnLimpiarConductor = new javax.swing.JButton();
        lblBusquedaTablaConductorRut = new javax.swing.JLabel();
        txtBusquedaTablaConductorRut = new javax.swing.JTextField();
        lblColectivosConductor = new javax.swing.JLabel();
        cmbColectivosConductor = new javax.swing.JComboBox<>();
        btnLimpiarBuscadoresConductor = new javax.swing.JButton();
        pnlRepuestos = new javax.swing.JPanel();
        lblMatriculaRepuesto = new javax.swing.JLabel();
        cmbMatriculaRepuesto = new javax.swing.JComboBox<>();
        lblCompraRepuesto = new javax.swing.JLabel();
        dchCompraRepuesto = new com.toedter.calendar.JDateChooser();
        lblKilometrajeRepuesto = new javax.swing.JLabel();
        txtKilometrajeRepuesto = new javax.swing.JTextField();
        lblTipoRepuesto = new javax.swing.JLabel();
        cmbTipoRepuesto = new javax.swing.JComboBox<>();
        btnAñadirRepuesto = new javax.swing.JButton();
        btnLimpiarRepuesto = new javax.swing.JButton();
        btnModificarRepuesto = new javax.swing.JButton();
        btnEliminarRepuesto = new javax.swing.JButton();
        lblBusquedaTablaRepuestoNombre = new javax.swing.JLabel();
        txtBusquedaTablaRepuestoNombre = new javax.swing.JTextField();
        scpRepuestos = new javax.swing.JScrollPane();
        tblRepuestos = new javax.swing.JTable();
        pnlEventos = new javax.swing.JPanel();
        cdrFechas = new com.toedter.calendar.JCalendar();
        lblNombreEvento = new javax.swing.JLabel();
        txtNombreEvento = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        scpDescripcionEvento = new javax.swing.JScrollPane();
        txaDescripcionEvento = new javax.swing.JTextArea();
        lblBusquedaTablaEventos = new javax.swing.JLabel();
        txtBusquedaTablaEventos = new javax.swing.JTextField();
        scpEventos = new javax.swing.JScrollPane();
        lstEventos = new javax.swing.JList<>();
        lvlNoEventos = new javax.swing.JLabel();
        btnAñadirEvento = new javax.swing.JButton();
        btnModificarEvento = new javax.swing.JButton();
        btnEliminarEvento = new javax.swing.JButton();
        pnlGanancias = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnAñadirKilometraje = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestion de Flota de Colectivos");
        setResizable(false);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(750, 550));

        pnlColectivo.setPreferredSize(new java.awt.Dimension(776, 510));

        lblMatriculaColectivo.setText("Matricula:");

        txtMatriculaColectivo.setToolTipText("Sin digito Verificador");
        txtMatriculaColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblCompraColectivo.setText("Fecha de Compra:");

        dchCompraColectivo.setDateFormatString("yyyy-MM-dd");

        lblSeguroColectivo.setText("Fecha Seguro:");

        dchSeguroColectivo.setDateFormatString("yyyy-MM-dd");

        lblRevisionColectivo.setText("Revision Tecnica:");

        dchRevisionColectivo.setDateFormatString("yyyy-MM-dd");

        lblKilometrajeColectivo.setText("Kilometraje Actual:");

        txtKilometrajeColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblMarcaColectivo.setText("Marca:");

        txtMarcaColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblVinColectivo.setText("Vin:");

        txtVinColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblMotorColectivo.setText("Número de Motor:");

        txtMotorColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        btnAñadirColectivo.setText("Añadir");
        btnAñadirColectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirColectivoActionPerformed(evt);
            }
        });

        scpColectivos.setViewportView(tblColectivos);

        tblColectivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Rut del Conductor", "Fecha de Compra", "Fecha de Último Seguro", "Fecha de Última Revision Técnica", "Kilometraje Actual", "Marca", "Vin", "Número de Motor"
            }
        ));
        tblColectivos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblColectivos.setCellSelectionEnabled(true);
        tblColectivos.setMinimumSize(new java.awt.Dimension(200, 0));
        tblColectivos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblColectivos.setShowGrid(true);
        tblColectivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblColectivosMouseClicked(evt);
            }
        });
        scpColectivos.setViewportView(tblColectivos);

        lblBusquedaTablaColectivosMatricula.setText("Buscar Matricula:");

        txtBusquedaTablaColectivosMatricula.setPreferredSize(new java.awt.Dimension(200, 22));
        txtBusquedaTablaColectivosMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaTablaColectivosMatriculaKeyReleased(evt);
            }
        });

        lblMotorColectivo1.setText("Conductor:");

        btnModificarColectivo.setText("Modificar");
        btnModificarColectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarColectivoActionPerformed(evt);
            }
        });

        btnEliminarColectivo.setText("Eliminar");
        btnEliminarColectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarColectivoActionPerformed(evt);
            }
        });

        btnLimpiarColectivo.setText("Limpiar");
        btnLimpiarColectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarColectivoActionPerformed(evt);
            }
        });

        txtBusquedaTablaColectivosRut.setPreferredSize(new java.awt.Dimension(200, 22));
        txtBusquedaTablaColectivosRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaTablaColectivosRutKeyReleased(evt);
            }
        });

        lblBusquedaTablaColectivosRut.setText("Buscar Rut:");

        btnLimpiarBuscadoresColectivo.setText("Limpiar Buscadores");
        btnLimpiarBuscadoresColectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarBuscadoresColectivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlColectivoLayout = new javax.swing.GroupLayout(pnlColectivo);
        pnlColectivo.setLayout(pnlColectivoLayout);
        pnlColectivoLayout.setHorizontalGroup(
            pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColectivoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlColectivoLayout.createSequentialGroup()
                        .addComponent(btnAñadirColectivo)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiarColectivo)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarColectivo)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarColectivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
                        .addComponent(lblMotorColectivo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbConductoresColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlColectivoLayout.createSequentialGroup()
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlColectivoLayout.createSequentialGroup()
                                    .addComponent(lblMatriculaColectivo)
                                    .addGap(12, 12, 12)
                                    .addComponent(txtMatriculaColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlColectivoLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblRevisionColectivo)
                                        .addComponent(lblSeguroColectivo))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dchRevisionColectivo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(dchSeguroColectivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblCompraColectivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dchCompraColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblMarcaColectivo)
                                .addGap(12, 12, 12)
                                .addComponent(txtMarcaColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblKilometrajeColectivo)
                                .addGap(12, 12, 12)
                                .addComponent(txtKilometrajeColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblVinColectivo)
                                .addGap(12, 12, 12)
                                .addComponent(txtVinColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblMotorColectivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMotorColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlColectivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpColectivos)
                .addContainerGap())
            .addGroup(pnlColectivoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblBusquedaTablaColectivosMatricula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusquedaTablaColectivosMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBusquedaTablaColectivosRut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusquedaTablaColectivosRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpiarBuscadoresColectivo)
                .addContainerGap())
        );
        pnlColectivoLayout.setVerticalGroup(
            pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColectivoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBusquedaTablaColectivosRut)
                        .addComponent(txtBusquedaTablaColectivosRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimpiarBuscadoresColectivo))
                    .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBusquedaTablaColectivosMatricula)
                        .addComponent(txtBusquedaTablaColectivosMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(scpColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlColectivoLayout.createSequentialGroup()
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMatriculaColectivo)
                            .addComponent(txtMatriculaColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dchCompraColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCompraColectivo))
                        .addGap(18, 18, 18)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dchSeguroColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSeguroColectivo))
                        .addGap(18, 18, 18)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRevisionColectivo)
                            .addComponent(dchRevisionColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlColectivoLayout.createSequentialGroup()
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKilometrajeColectivo)
                            .addComponent(txtKilometrajeColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMarcaColectivo)
                            .addComponent(txtMarcaColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVinColectivo)
                            .addComponent(txtVinColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMotorColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMotorColectivo))))
                .addGap(18, 18, 18)
                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAñadirColectivo)
                        .addComponent(btnModificarColectivo)
                        .addComponent(btnEliminarColectivo)
                        .addComponent(btnLimpiarColectivo))
                    .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMotorColectivo1)
                        .addComponent(cmbConductoresColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("Colectivo", pnlColectivo);

        pnlConductor.setPreferredSize(new java.awt.Dimension(734, 550));

        lblRutConductor.setText("RUT:");

        txtRutConductor.setToolTipText("Siga el formato 12345678-9");
        txtRutConductor.setPreferredSize(new java.awt.Dimension(200, 22));

        lblNombreConductor.setText("Nombre Completo:");

        txtNombreConductor.setPreferredSize(new java.awt.Dimension(100, 22));

        lblDireccionConductor.setText("Direccion:");

        txtDireccionConductor.setPreferredSize(new java.awt.Dimension(200, 22));

        lblTelefonoConductor.setText("Telefono:");

        txtTelefonoConductor.setToolTipText("Siga el formato +12345678901");
        txtTelefonoConductor.setPreferredSize(new java.awt.Dimension(200, 22));

        tblConductores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Nombre", "Direccion", "Telefono", "Colectivo"
            }
        ));
        tblConductores.setCellSelectionEnabled(true);
        tblConductores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblConductores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblConductores.setShowGrid(true);
        tblConductores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConductoresMouseClicked(evt);
            }
        });
        scpConductores.setViewportView(tblConductores);

        btnAñadirConductor.setText("Añadir");
        btnAñadirConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirConductorActionPerformed(evt);
            }
        });

        btnModificarConductor.setText("Modificar");
        btnModificarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarConductorActionPerformed(evt);
            }
        });

        btnEliminarConductor.setText("Eliminar");
        btnEliminarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarConductorActionPerformed(evt);
            }
        });

        lblBusquedaTablaConductorNombre.setText("Buscar Nombre:");

        txtBusquedaTablaConductorNombre.setPreferredSize(new java.awt.Dimension(200, 22));
        txtBusquedaTablaConductorNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaTablaConductorNombreKeyReleased(evt);
            }
        });

        btnLimpiarConductor.setText("Limpiar");
        btnLimpiarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarConductorActionPerformed(evt);
            }
        });

        lblBusquedaTablaConductorRut.setText("Buscar Rut:");

        txtBusquedaTablaConductorRut.setPreferredSize(new java.awt.Dimension(200, 22));
        txtBusquedaTablaConductorRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaTablaConductorRutKeyReleased(evt);
            }
        });

        lblColectivosConductor.setText("Colectivo:");

        btnLimpiarBuscadoresConductor.setText("Limpiar Buscadores");
        btnLimpiarBuscadoresConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarBuscadoresConductorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConductorLayout = new javax.swing.GroupLayout(pnlConductor);
        pnlConductor.setLayout(pnlConductorLayout);
        pnlConductorLayout.setHorizontalGroup(
            pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConductorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConductorLayout.createSequentialGroup()
                        .addComponent(scpConductores)
                        .addContainerGap())
                    .addGroup(pnlConductorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlConductorLayout.createSequentialGroup()
                                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNombreConductor)
                                    .addComponent(lblRutConductor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRutConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 367, Short.MAX_VALUE)
                                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDireccionConductor)
                                    .addComponent(lblTelefonoConductor)))
                            .addGroup(pnlConductorLayout.createSequentialGroup()
                                .addComponent(btnAñadirConductor)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiarConductor)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificarConductor)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarConductor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblColectivosConductor)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccionConductor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefonoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbColectivosConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
            .addGroup(pnlConductorLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblBusquedaTablaConductorNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusquedaTablaConductorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBusquedaTablaConductorRut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusquedaTablaConductorRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpiarBuscadoresConductor)
                .addContainerGap())
        );
        pnlConductorLayout.setVerticalGroup(
            pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConductorLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBusquedaTablaConductorRut)
                        .addComponent(txtBusquedaTablaConductorRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimpiarBuscadoresConductor))
                    .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBusquedaTablaConductorNombre)
                        .addComponent(txtBusquedaTablaConductorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(scpConductores, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlConductorLayout.createSequentialGroup()
                        .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRutConductor)
                            .addComponent(txtRutConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreConductor)
                            .addComponent(txtNombreConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlConductorLayout.createSequentialGroup()
                        .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDireccionConductor)
                            .addComponent(txtDireccionConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefonoConductor)
                            .addComponent(txtTelefonoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAñadirConductor)
                    .addComponent(btnLimpiarConductor)
                    .addComponent(btnModificarConductor)
                    .addComponent(btnEliminarConductor)
                    .addComponent(cmbColectivosConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColectivosConductor))
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("Conductor", pnlConductor);

        lblMatriculaRepuesto.setText("Matricula:");

        cmbMatriculaRepuesto.setToolTipText("");

        lblCompraRepuesto.setText("Fecha de Compra:");

        dchCompraRepuesto.setDateFormatString("yyyy-MM-dd");

        lblKilometrajeRepuesto.setText("Kilometraje Máximo:");

        txtKilometrajeRepuesto.setPreferredSize(new java.awt.Dimension(200, 22));

        lblTipoRepuesto.setText("Tipo Repuesto:");

        cmbTipoRepuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pastilla de Freno" }));
        cmbTipoRepuesto.setToolTipText("");

        btnAñadirRepuesto.setText("Añadir");
        btnAñadirRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirRepuestoActionPerformed(evt);
            }
        });

        btnLimpiarRepuesto.setText("Limpiar");

        btnModificarRepuesto.setText("Modificar");
        btnModificarRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarRepuestoActionPerformed(evt);
            }
        });

        btnEliminarRepuesto.setText("Eliminar");

        lblBusquedaTablaRepuestoNombre.setText("Matricula:");

        txtBusquedaTablaRepuestoNombre.setPreferredSize(new java.awt.Dimension(200, 22));
        txtBusquedaTablaRepuestoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaTablaRepuestoNombreKeyReleased(evt);
            }
        });

        tblRepuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Repuesto", "Patente auto asociado", "Fecha de Compra", "Kilometraje Máximo", "Kilometraje Actual"
            }
        ));
        scpRepuestos.setViewportView(tblRepuestos);

        javax.swing.GroupLayout pnlRepuestosLayout = new javax.swing.GroupLayout(pnlRepuestos);
        pnlRepuestos.setLayout(pnlRepuestosLayout);
        pnlRepuestosLayout.setHorizontalGroup(
            pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRepuestosLayout.createSequentialGroup()
                .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRepuestosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scpRepuestos))
                    .addGroup(pnlRepuestosLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblBusquedaTablaRepuestoNombre)
                        .addGap(6, 6, 6)
                        .addComponent(txtBusquedaTablaRepuestoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlRepuestosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRepuestosLayout.createSequentialGroup()
                                .addComponent(btnAñadirRepuesto)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiarRepuesto)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificarRepuesto)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarRepuesto))
                            .addGroup(pnlRepuestosLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(lblMatriculaRepuesto)
                                .addGap(12, 12, 12)
                                .addComponent(cmbMatriculaRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 321, Short.MAX_VALUE)
                                .addComponent(lblKilometrajeRepuesto)
                                .addGap(12, 12, 12)
                                .addComponent(txtKilometrajeRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlRepuestosLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblTipoRepuesto)
                        .addGap(12, 12, 12)
                        .addComponent(cmbTipoRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCompraRepuesto)
                        .addGap(12, 12, 12)
                        .addComponent(dchCompraRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlRepuestosLayout.setVerticalGroup(
            pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusquedaTablaRepuestoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBusquedaTablaRepuestoNombre))
                .addGap(18, 18, 18)
                .addComponent(scpRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblKilometrajeRepuesto, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtKilometrajeRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMatriculaRepuesto)
                        .addComponent(cmbMatriculaRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTipoRepuesto)
                        .addComponent(cmbTipoRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCompraRepuesto)
                    .addComponent(dchCompraRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAñadirRepuesto)
                    .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminarRepuesto)
                        .addComponent(btnLimpiarRepuesto)
                        .addComponent(btnModificarRepuesto)))
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("Repuestos", pnlRepuestos);

        cdrFechas.setAlignmentX(0.1F);
        cdrFechas.setAlignmentY(0.1F);
        cdrFechas.setDecorationBackgroundColor(new java.awt.Color(204, 204, 204));
        cdrFechas.setDecorationBordersVisible(true);
        cdrFechas.setTodayButtonText("Dia Actual");
        cdrFechas.setTodayButtonVisible(true);
        cdrFechas.setWeekOfYearVisible(false);
        cdrFechas.setWeekdayForeground(new java.awt.Color(0, 0, 0));

        lblNombreEvento.setText("Nombre Evento:");

        txtNombreEvento.setPreferredSize(new java.awt.Dimension(200, 22));

        jLabel22.setText("Descripcion:");

        txaDescripcionEvento.setColumns(20);
        txaDescripcionEvento.setRows(5);
        txaDescripcionEvento.setTabSize(5);
        txaDescripcionEvento.setWrapStyleWord(true);
        scpDescripcionEvento.setViewportView(txaDescripcionEvento);

        lblBusquedaTablaEventos.setText("Evento a buscar: ");

        txtBusquedaTablaEventos.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaTablaEventos.setPreferredSize(new java.awt.Dimension(200, 22));

        scpEventos.setViewportView(lstEventos);

        lvlNoEventos.setText("No hay eventos");
        lvlNoEventos.setEnabled(false);
        lvlNoEventos.setFocusable(false);

        btnAñadirEvento.setText("Añadir");

        btnModificarEvento.setText("Modificar");

        btnEliminarEvento.setText("Eliminar");

        javax.swing.GroupLayout pnlEventosLayout = new javax.swing.GroupLayout(pnlEventos);
        pnlEventos.setLayout(pnlEventosLayout);
        pnlEventosLayout.setHorizontalGroup(
            pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEventosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEventosLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(45, 45, 45)
                        .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scpDescripcionEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAñadirEvento)))
                    .addComponent(lblNombreEvento)
                    .addComponent(cdrFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lvlNoEventos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblBusquedaTablaEventos, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(12, 12, 12)
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBusquedaTablaEventos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scpEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlEventosLayout.createSequentialGroup()
                        .addComponent(btnModificarEvento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarEvento)))
                .addContainerGap())
        );
        pnlEventosLayout.setVerticalGroup(
            pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEventosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlEventosLayout.createSequentialGroup()
                        .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBusquedaTablaEventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBusquedaTablaEventos))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scpEventos)
                            .addGroup(pnlEventosLayout.createSequentialGroup()
                                .addComponent(lvlNoEventos)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(cdrFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEvento)
                    .addComponent(txtNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarEvento)
                    .addComponent(btnEliminarEvento))
                .addGap(18, 18, 18)
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(scpDescripcionEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAñadirEvento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Eventos", pnlEventos);

        javax.swing.GroupLayout pnlGananciasLayout = new javax.swing.GroupLayout(pnlGanancias);
        pnlGanancias.setLayout(pnlGananciasLayout);
        pnlGananciasLayout.setHorizontalGroup(
            pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlGananciasLayout.setVerticalGroup(
            pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Ganancias", pnlGanancias);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAñadirKilometraje.setText("Añadir Kilometraje");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAñadirKilometraje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnAñadirKilometraje))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }                                        

    private void btnAñadirColectivoActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        valido = true;
        try {
            if (dchCompraColectivo.getDate() == null || dchRevisionColectivo.getDate() == null || 
                    dchSeguroColectivo.getDate() == null || txtKilometrajeColectivo.getText().strip().equals("") || 
                    txtMarcaColectivo.getText().strip().equals("") || txtVinColectivo.getText().strip().equals("") || 
                    txtMotorColectivo.getText().strip().equals("") || !Pattern.matches("^\\d*$", txtKilometrajeColectivo.getText().strip())) {
                JOptionPane.showMessageDialog(null, "Ingrese datos en todos los campos.");
                valido = false;
            }
            if ((txtMatriculaColectivo.getText().strip().equals("") || txtMatriculaColectivo.getText().strip().length() != 6) && valido) {
                JOptionPane.showMessageDialog(null, "Ingrese una matricula válida.");
                valido = false;
            }
            rs = stm.executeQuery("SELECT Matricula FROM Colectivo WHERE Matricula = '" + txtMatriculaColectivo.getText().strip() + "';");
            if (rs.next() && valido) {
                JOptionPane.showMessageDialog(null, "Matricula duplicada.");
                valido = false;
            }
            if (valido) {
                stm.execute("INSERT INTO Colectivo VALUES ('" + txtMatriculaColectivo.getText().strip() + "', '" + cmbConductoresColectivos.getSelectedItem().toString() + "', '" + formato.format(dchCompraColectivo.getDate()) + "', '" 
                        + formato.format(dchSeguroColectivo.getDate()) + "', '" + formato.format(dchRevisionColectivo.getDate()) + "', " + txtKilometrajeColectivo.getText().strip() 
                        + ", '" + txtMarcaColectivo.getText().strip() + "', '" + txtVinColectivo.getText().strip() + "', '" + txtMotorColectivo.getText().strip() + "');");
                if (cmbConductoresColectivos.getSelectedIndex() != 0) {
                    stm.executeUpdate("UPDATE Conductor SET Matricula = '" + txtMatriculaColectivo.getText().strip() + "' WHERE RutConductor = '" + cmbConductoresColectivos.getSelectedItem()+ "';");
                }
                refrescar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }                                                  

    private void btnAñadirConductorActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        valido = true;
        try {
            if (txtRutConductor.getText().strip().equals("") || txtNombreConductor.getText().strip().equals("") || txtDireccionConductor.getText().strip().equals("") || txtTelefonoConductor.getText().strip().equals("") || !Pattern.matches("^[0-9]+-[0-9kK]{1}$", txtRutConductor.getText().strip()) || !Pattern.matches("^\\+\\d+$", txtTelefonoConductor.getText().strip())) {
                JOptionPane.showMessageDialog(null, "Ingrese datos validos en todos los campos.");
                valido = false;
            }
            rs = stm.executeQuery("SELECT RutConductor FROM Conductor WHERE RutConductor = '" + txtRutConductor.getText().strip() + "';");
            if (rs.next() && valido) {
                JOptionPane.showMessageDialog(null, "Rut duplicado.");
                valido = false;
            }
            if (valido) {   
                stm.execute("INSERT INTO Conductor VALUES ('" + txtRutConductor.getText().strip() + "', '------', '" + txtNombreConductor.getText().strip() + "', '" + txtDireccionConductor.getText().strip() + "', '" + txtTelefonoConductor.getText().strip() + "');");
                if (cmbColectivosConductor.getSelectedIndex() != 0) {
                    stm.executeUpdate("UPDATE Conductor SET Matricula = '" + cmbColectivosConductor.getSelectedItem() + "' WHERE RutConductor = '" + txtRutConductor.getText().strip()+ "';");
                }
                refrescar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }                                                  

    private void tblConductoresMouseClicked(java.awt.event.MouseEvent evt) {                                            
        if (evt.getClickCount() == 1) {
            JTable src = (JTable) evt.getSource();
            txtRutConductor.setText(src.getModel().getValueAt(src.getSelectedRow(), 0).toString());
            txtNombreConductor.setText(src.getModel().getValueAt(src.getSelectedRow(), 1).toString());
            txtDireccionConductor.setText(src.getModel().getValueAt(src.getSelectedRow(), 2).toString());
            txtTelefonoConductor.setText(src.getModel().getValueAt(src.getSelectedRow(), 3).toString());
        }
    }                                           

    private void btnEliminarConductorActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        valido = true;
        try {
            if (txtRutConductor.getText().strip().equals("") || txtNombreConductor.getText().strip().equals("") || txtDireccionConductor.getText().strip().equals("") || txtTelefonoConductor.getText().strip().equals("") || !Pattern.matches("^[0-9]+-[0-9kK]{1}$", txtRutConductor.getText().strip()) || !Pattern.matches("^\\+\\d+$", txtTelefonoConductor.getText().strip())) {
                JOptionPane.showMessageDialog(null, "Ingrese datos validos en todos los campos.");
                valido = false;
            }
            rs = stm.executeQuery("SELECT RutConductor FROM Conductor WHERE RutConductor = '" + txtRutConductor.getText().strip() + "';");
            if(!rs.next() && valido){
                JOptionPane.showMessageDialog(null, "Rut no encontrado.");
                valido = false;
            }
            if (valido) {
                stm.execute("DELETE FROM Conductor WHERE RutConductor = '" + txtRutConductor.getText().strip()+ "';");
                stm.executeUpdate("UPDATE Colectivo SET RutConductor = 'Sin Conductor' WHERE Matricula = '" + txtMatriculaColectivo.getText().strip() + "';");
                refrescar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }                                                    

    private void btnModificarConductorActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        valido = true;
        try {
            if (txtRutConductor.getText().strip().equals("") || txtDireccionConductor.getText().strip().equals("") || txtNombreConductor.getText().strip().equals("") || txtTelefonoConductor.getText().strip().equals("") || !Pattern.matches("^[0-9]+-[0-9kK]{1}$", txtRutConductor.getText().strip()) || !Pattern.matches("^\\+\\d+$", txtTelefonoConductor.getText().strip())) {
                JOptionPane.showMessageDialog(null, "Ingrese datos validos en todos los campos.");
                valido = false;
            }
            rs = stm.executeQuery("SELECT RutConductor FROM Conductor WHERE RutConductor = '" + txtRutConductor.getText().strip() + "';");
            if(!rs.next() && valido){
                JOptionPane.showMessageDialog(null, "Rut no encontrado.");
                valido = false;
            }
            if (valido) {   
                stm.executeUpdate("UPDATE Conductor SET Nombre = '" + txtNombreConductor.getText().strip() + "', Matricula = '" + cmbColectivosConductor.getSelectedItem() + "', Direccion = '" + txtDireccionConductor.getText().strip() + "', Telefono = '" + txtTelefonoConductor.getText().strip() + "' WHERE RutConductor = '" + txtRutConductor.getText().strip() + "';");
                stm.executeUpdate("UPDATE Colectivo SET RutConductor = '------' WHERE RutConductor = '" + txtRutConductor.getText().strip() + "';");
                stm.executeUpdate("UPDATE Colectivo SET RutConductor = '" + txtRutConductor.getText().strip() + "' WHERE Matricula = '" + cmbColectivosConductor.getSelectedItem() + "';");
                refrescar();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }                                                     

    private void btnModificarColectivoActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        valido = true;
        try {
            if(dchCompraColectivo.getDate() == null || dchRevisionColectivo.getDate() == null || 
                    dchSeguroColectivo.getDate() == null || txtKilometrajeColectivo.getText().strip().equals("") || 
                    txtMarcaColectivo.getText().strip().equals("") || txtVinColectivo.getText().strip().equals("") || 
                    txtMotorColectivo.getText().strip().equals("") || !Pattern.matches("^\\d*$", txtKilometrajeColectivo.getText().strip())) {
                JOptionPane.showMessageDialog(null, "Ingrese datos validos en todos los campos.");
                valido = false;
            }
            rs = stm.executeQuery("SELECT Matricula FROM Colectivo WHERE Matricula = '" + txtMatriculaColectivo.getText().strip() + "';");
            if(!rs.next() && valido){
                JOptionPane.showMessageDialog(null, "Matricula no encontrada.");
                valido = false;
            }
            if (valido) {
                stm.executeUpdate("UPDATE Colectivo SET RutConductor = '" + cmbConductoresColectivos.getSelectedItem()+ "', Compra = '" + formato.format(dchCompraColectivo.getDate()) + "', Seguro = '" + formato.format(dchSeguroColectivo.getDate()) + "', RevisionTecnica = '" + formato.format(dchRevisionColectivo.getDate()) + "', KilometrajeActual = " + txtKilometrajeColectivo.getText().strip() + ", Marca = '" + txtMarcaColectivo.getText().strip() + "', Vin = '" + txtVinColectivo.getText().strip() + "', Motor = '" + txtMotorColectivo.getText().strip() + "' WHERE Matricula = '" + txtMatriculaColectivo.getText().strip() + "';");
                stm.executeUpdate("UPDATE Conductor SET Matricula = '------' WHERE Matricula = '" + txtMatriculaColectivo.getText().strip() + "';");
                stm.executeUpdate("UPDATE Conductor SET Matricula = '" + txtMatriculaColectivo.getText().strip() + "' WHERE RutConductor = '" + cmbConductoresColectivos.getSelectedItem()+ "';");
                refrescar();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }                                                     

    private void btnEliminarColectivoActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        valido = true;
        try {
            if (txtMatriculaColectivo.getText().strip().equals("") || txtMatriculaColectivo.getText().strip().length() != 6) {
                JOptionPane.showMessageDialog(null, "Ingrese una matricula valida.");
                valido = false;
            }
            rs = stm.executeQuery("SELECT Matricula FROM Colectivo WHERE Matricula = '" + txtMatriculaColectivo.getText().strip() + "';");
            if(!rs.next() && valido){
                JOptionPane.showMessageDialog(null, "Matricula no encontrada.");
                valido = false;
            }
            if (valido) {   
                stm.execute("DELETE FROM Colectivo WHERE Matricula = '" + txtMatriculaColectivo.getText().strip() + "';");
                stm.executeUpdate("UPDATE Conductor SET Matricula = '------' WHERE Matricula = '" + txtMatriculaColectivo.getText().strip() + "';");
                refrescar();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }                                                    

    private void tblColectivosMouseClicked(java.awt.event.MouseEvent evt) {                                           
        try {
            if (evt.getClickCount() == 1) {
                JTable src = (JTable) evt.getSource();
                txtMatriculaColectivo.setText(src.getModel().getValueAt(src.getSelectedRow(), 0).toString());
                cmbConductoresColectivos.setSelectedItem(src.getModel().getValueAt(src.getSelectedRow(), 1).toString());
                dchCompraColectivo.setDate(formato.parse(src.getModel().getValueAt(src.getSelectedRow(), 2).toString()));
                dchSeguroColectivo.setDate(formato.parse(src.getModel().getValueAt(src.getSelectedRow(), 3).toString()));
                dchRevisionColectivo.setDate(formato.parse(src.getModel().getValueAt(src.getSelectedRow(), 4).toString()));
                txtKilometrajeColectivo.setText(src.getModel().getValueAt(src.getSelectedRow(), 5).toString());
                txtMarcaColectivo.setText(src.getModel().getValueAt(src.getSelectedRow(), 6).toString());
                txtVinColectivo.setText(src.getModel().getValueAt(src.getSelectedRow(), 7).toString());
                txtMotorColectivo.setText(src.getModel().getValueAt(src.getSelectedRow(), 8).toString());
            }
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
    }                                          

    private void btnLimpiarColectivoActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        txtMatriculaColectivo.setText("");
        dchCompraColectivo.setCalendar(null);
        dchSeguroColectivo.setCalendar(null);
        dchRevisionColectivo.setCalendar(null);
        txtKilometrajeColectivo.setText("");
        txtMarcaColectivo.setText("");
        txtVinColectivo.setText("");
        txtMotorColectivo.setText("");
        cmbConductoresColectivos.setSelectedIndex(0);
    }                                                   

    private void txtBusquedaTablaColectivosMatriculaKeyReleased(java.awt.event.KeyEvent evt) {                                                                
        refrescar();
    }                                                               

    private void btnLimpiarConductorActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        txtRutConductor.setText("");
        txtNombreConductor.setText("");
        txtDireccionConductor.setText("");
        txtTelefonoConductor.setText("");
    }                                                   

    private void txtBusquedaTablaConductorRutKeyReleased(java.awt.event.KeyEvent evt) {                                                         
        refrescar();
    }                                                        

    private void txtBusquedaTablaConductorNombreKeyReleased(java.awt.event.KeyEvent evt) {                                                            
        refrescar();
    }                                                           

    private void txtBusquedaTablaRepuestoNombreKeyReleased(java.awt.event.KeyEvent evt) {                                                           
        // TODO add your handling code here:
    }                                                          

    private void btnAñadirRepuestoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        try {
            valido = true;
            if(dchCompraRepuesto.getDate() != null && !txtKilometrajeRepuesto.getText().equals("") && Pattern.matches("^\\d*$", txtKilometrajeRepuesto.getText().strip())){
                JOptionPane.showMessageDialog(null, "Ingrese datos en todos los campos.");
            }
            if (valido) {   
                stm.execute("INSERT INTO Repuesto (tipoRepuesto, Compra, KilometrajeMax, KilometrajeActual, Matricula) VALUES ('" + cmbTipoRepuesto.getSelectedItem() + "', '" + formato.format(dchCompraRepuesto.getDate()) + "', " + txtKilometrajeRepuesto.getText().strip() + ", 0, '" + cmbMatriculaRepuesto.getSelectedItem() + "');");
                refrescar();
            }
        } catch (Exception e) {
        }
    }                                                 

    private void btnModificarRepuestoActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        try {
            if(dchCompraRepuesto.getDate() != null && !txtKilometrajeRepuesto.getText().equals("") && Pattern.matches("^\\d*$", txtKilometrajeRepuesto.getText().strip())){
                stm.execute("UPDATE Repuesto SET TipoRepuesto;");
                refrescar();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese datos en todos los campos.");
            }
        } catch (Exception e) {
        }
    }                                                    

    private void txtBusquedaTablaColectivosRutKeyReleased(java.awt.event.KeyEvent evt) {                                                          
        refrescar();
    }                                                         

    private void btnLimpiarBuscadoresColectivoActionPerformed(java.awt.event.ActionEvent evt) {                                                              
        txtBusquedaTablaColectivosMatricula.setText("");
        txtBusquedaTablaColectivosRut.setText("");
        refrescar();
    }                                                             

    private void btnLimpiarBuscadoresConductorActionPerformed(java.awt.event.ActionEvent evt) {                                                              
        txtBusquedaTablaConductorNombre.setText("");
        txtBusquedaTablaConductorRut.setText("");
        refrescar();
    }                                                             

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(view.View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view.View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view.View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view.View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view.View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAñadirColectivo;
    private javax.swing.JButton btnAñadirConductor;
    private javax.swing.JButton btnAñadirEvento;
    private javax.swing.JButton btnAñadirKilometraje;
    private javax.swing.JButton btnAñadirRepuesto;
    private javax.swing.JButton btnEliminarColectivo;
    private javax.swing.JButton btnEliminarConductor;
    private javax.swing.JButton btnEliminarEvento;
    private javax.swing.JButton btnEliminarRepuesto;
    private javax.swing.JButton btnLimpiarBuscadoresColectivo;
    private javax.swing.JButton btnLimpiarBuscadoresConductor;
    private javax.swing.JButton btnLimpiarColectivo;
    private javax.swing.JButton btnLimpiarConductor;
    private javax.swing.JButton btnLimpiarRepuesto;
    private javax.swing.JButton btnModificarColectivo;
    private javax.swing.JButton btnModificarConductor;
    private javax.swing.JButton btnModificarEvento;
    private javax.swing.JButton btnModificarRepuesto;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JCalendar cdrFechas;
    private javax.swing.JComboBox<String> cmbColectivosConductor;
    private javax.swing.JComboBox<String> cmbConductoresColectivos;
    private javax.swing.JComboBox<String> cmbMatriculaRepuesto;
    private javax.swing.JComboBox<String> cmbTipoRepuesto;
    private com.toedter.calendar.JDateChooser dchCompraColectivo;
    private com.toedter.calendar.JDateChooser dchCompraRepuesto;
    private com.toedter.calendar.JDateChooser dchRevisionColectivo;
    private com.toedter.calendar.JDateChooser dchSeguroColectivo;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblBusquedaTablaColectivosMatricula;
    private javax.swing.JLabel lblBusquedaTablaColectivosRut;
    private javax.swing.JLabel lblBusquedaTablaConductorNombre;
    private javax.swing.JLabel lblBusquedaTablaConductorRut;
    private javax.swing.JLabel lblBusquedaTablaEventos;
    private javax.swing.JLabel lblBusquedaTablaRepuestoNombre;
    private javax.swing.JLabel lblColectivosConductor;
    private javax.swing.JLabel lblCompraColectivo;
    private javax.swing.JLabel lblCompraRepuesto;
    private javax.swing.JLabel lblDireccionConductor;
    private javax.swing.JLabel lblKilometrajeColectivo;
    private javax.swing.JLabel lblKilometrajeRepuesto;
    private javax.swing.JLabel lblMarcaColectivo;
    private javax.swing.JLabel lblMatriculaColectivo;
    private javax.swing.JLabel lblMatriculaRepuesto;
    private javax.swing.JLabel lblMotorColectivo;
    private javax.swing.JLabel lblMotorColectivo1;
    private javax.swing.JLabel lblNombreConductor;
    private javax.swing.JLabel lblNombreEvento;
    private javax.swing.JLabel lblRevisionColectivo;
    private javax.swing.JLabel lblRutConductor;
    private javax.swing.JLabel lblSeguroColectivo;
    private javax.swing.JLabel lblTelefonoConductor;
    private javax.swing.JLabel lblTipoRepuesto;
    private javax.swing.JLabel lblVinColectivo;
    private javax.swing.JList<String> lstEventos;
    private javax.swing.JLabel lvlNoEventos;
    private javax.swing.JPanel pnlColectivo;
    private javax.swing.JPanel pnlConductor;
    private javax.swing.JPanel pnlEventos;
    private javax.swing.JPanel pnlGanancias;
    private javax.swing.JPanel pnlRepuestos;
    private javax.swing.JScrollPane scpColectivos;
    private javax.swing.JScrollPane scpConductores;
    private javax.swing.JScrollPane scpDescripcionEvento;
    private javax.swing.JScrollPane scpEventos;
    private javax.swing.JScrollPane scpRepuestos;
    private javax.swing.JTable tblColectivos;
    private javax.swing.JTable tblConductores;
    private javax.swing.JTable tblRepuestos;
    private javax.swing.JTextArea txaDescripcionEvento;
    private javax.swing.JTextField txtBusquedaTablaColectivosMatricula;
    private javax.swing.JTextField txtBusquedaTablaColectivosRut;
    private javax.swing.JTextField txtBusquedaTablaConductorNombre;
    private javax.swing.JTextField txtBusquedaTablaConductorRut;
    private javax.swing.JTextField txtBusquedaTablaEventos;
    private javax.swing.JTextField txtBusquedaTablaRepuestoNombre;
    private javax.swing.JTextField txtDireccionConductor;
    private javax.swing.JTextField txtKilometrajeColectivo;
    private javax.swing.JTextField txtKilometrajeRepuesto;
    private javax.swing.JTextField txtMarcaColectivo;
    private javax.swing.JTextField txtMatriculaColectivo;
    private javax.swing.JTextField txtMotorColectivo;
    private javax.swing.JTextField txtNombreConductor;
    private javax.swing.JTextField txtNombreEvento;
    private javax.swing.JTextField txtRutConductor;
    private javax.swing.JTextField txtTelefonoConductor;
    private javax.swing.JTextField txtVinColectivo;
    // End of variables declaration                   
}