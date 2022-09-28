import java.sql.*;
import javax.swing.JOptionPane;

public class Formulario extends javax.swing.JFrame {

    String usuario = JOptionPane.showInputDialog("Usuario:");
    String contraseña = JOptionPane.showInputDialog("Contraseña:");
    String url = "jdbc:mysql://localhost:3306/";
    String nombreDB = "colectivos";
    Connection con = conectar(url, usuario, contraseña);
    Statement stm = null;
    ResultSet rs = null;
    
    private Connection conectar(String url, String usuario, String contraseña){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Conectado");
            return DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException e) {
            System.out.println("No se pudo establecer conexion con la Base de Datos, o se ingresaron incorrectamente los datos de inicio de sesion.\n");
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
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    private void crearDB(Connection con, ResultSet rs, String nombreDB, Statement stm){
        try {
            stm = con.createStatement();
            stm.execute("CREATE DATABASE Colectivos;");
            stm.execute("USE Colectivos;");
            stm.execute("CREATE TABLE Colectivo(Matricula Char(6), RutConductor VarChar(12), KilometrajeActual Int(7), Compra Date, RevisionTecnica Date, Seguro Date, Marca VarChar(15), Vin VarChar(17), NMotor VarChar(12));");
            stm.execute("CREATE TABLE Conductor(RutConductor Char(12), Matricula Char(6), Nombre VarChar(50), Direccion VarChar(150), Telefono VarChar(12);");
            stm.execute("CREATE TABLE (RutConductor Char(12), Matricula Char(6), Nombre VarChar(50), Direccion VarChar(150), Telefono VarChar(12);");
            System.out.println("a");
        } catch (SQLException e) {
        }
    }
    
    public Formulario() {
        if(!existeDB(con, rs, nombreDB)){
            crearDB(con, rs, nombreDB, stm);
        }
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlColectivo = new javax.swing.JPanel();
        lblPatenteColectivo = new javax.swing.JLabel();
        txtPatenteColectivo = new javax.swing.JTextField();
        lblSeguroColectivo = new javax.swing.JLabel();
        dchSeguroColectivo = new com.toedter.calendar.JDateChooser();
        lblCompraColectivo = new javax.swing.JLabel();
        dchCompraColectivo = new com.toedter.calendar.JDateChooser();
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
        lblBusquedaTablaColectivos = new javax.swing.JLabel();
        txtBusquedaTablaColectivos = new javax.swing.JTextField();
        scpColectivos = new javax.swing.JScrollPane();
        lstColectivos = new javax.swing.JList<>();
        btnAñadirColectivo = new javax.swing.JButton();
        btnModificarColectivo = new javax.swing.JButton();
        btnEliminarColectivo = new javax.swing.JButton();
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
        pnlRepuestos = new javax.swing.JPanel();
        lblNombreRepuesto = new javax.swing.JLabel();
        txtNombreRepuesto = new javax.swing.JTextField();
        lblCompraRepuesto = new javax.swing.JLabel();
        dcsCompraRepuesto = new com.toedter.calendar.JDateChooser();
        lblKilometrajeRepuesto = new javax.swing.JLabel();
        txtKilometrajeRepuesto = new javax.swing.JTextField();
        scpRepuestos = new javax.swing.JScrollPane();
        tblRepuestos = new javax.swing.JTable();
        btnAñadirRepuesto = new javax.swing.JButton();
        btnModificarRepuesto = new javax.swing.JButton();
        btnEliminarRepuesto = new javax.swing.JButton();
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
        cmbColectivoSeleccionado = new javax.swing.JComboBox<>();
        lblColectivoSeleccionado = new javax.swing.JLabel();
        btnDebug = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PLACEHOLDER");
        setResizable(false);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(750, 550));

        lblPatenteColectivo.setText("Patente:");

        txtPatenteColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblSeguroColectivo.setText("Fecha Seguro:");

        lblCompraColectivo.setText("Fecha de Compra:");

        lblRevisionColectivo.setText("Revision Tecnica:");

        lblKilometrajeColectivo.setText("Kilometraje Actual:");

        txtKilometrajeColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblMarcaColectivo.setText("Marca:");

        txtMarcaColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblVinColectivo.setText("Vin:");

        txtVinColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblMotorColectivo.setText("Número de Motor:");

        txtMotorColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblBusquedaTablaColectivos.setText("Placa a buscar:");

        txtBusquedaTablaColectivos.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaTablaColectivos.setPreferredSize(new java.awt.Dimension(200, 22));

        scpColectivos.setViewportView(lstColectivos);

        btnAñadirColectivo.setText("Añadir");
        btnAñadirColectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirColectivoActionPerformed(evt);
            }
        });

        btnModificarColectivo.setText("Modificar");
        btnModificarColectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarColectivoActionPerformed(evt);
            }
        });

        btnEliminarColectivo.setText("Eliminar");

        javax.swing.GroupLayout pnlColectivoLayout = new javax.swing.GroupLayout(pnlColectivo);
        pnlColectivo.setLayout(pnlColectivoLayout);
        pnlColectivoLayout.setHorizontalGroup(
            pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColectivoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlColectivoLayout.createSequentialGroup()
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblPatenteColectivo)
                                .addGap(12, 12, 12)
                                .addComponent(txtPatenteColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblSeguroColectivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dchSeguroColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addGroup(pnlColectivoLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCompraColectivo)
                                    .addComponent(lblRevisionColectivo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dchRevisionColectivo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(dchCompraColectivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblMotorColectivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMotorColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                        .addComponent(lblBusquedaTablaColectivos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(scpColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtBusquedaTablaColectivos, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                    .addGroup(pnlColectivoLayout.createSequentialGroup()
                        .addComponent(btnAñadirColectivo)
                        .addGap(12, 12, 12)
                        .addComponent(btnModificarColectivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarColectivo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlColectivoLayout.setVerticalGroup(
            pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColectivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatenteColectivo)
                    .addComponent(txtPatenteColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusquedaTablaColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBusquedaTablaColectivos))
                .addGap(18, 18, 18)
                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlColectivoLayout.createSequentialGroup()
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSeguroColectivo)
                            .addComponent(dchSeguroColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCompraColectivo)
                            .addComponent(dchCompraColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRevisionColectivo)
                            .addComponent(dchRevisionColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
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
                            .addComponent(lblMotorColectivo)))
                    .addComponent(scpColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAñadirColectivo)
                    .addComponent(btnModificarColectivo)
                    .addComponent(btnEliminarColectivo))
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Colectivo", pnlColectivo);

        pnlConductor.setPreferredSize(new java.awt.Dimension(734, 550));

        lblRutConductor.setText("RUT:");

        txtRutConductor.setPreferredSize(new java.awt.Dimension(200, 22));

        lblNombreConductor.setText("Nombre Completo:");

        txtNombreConductor.setPreferredSize(new java.awt.Dimension(100, 22));

        lblDireccionConductor.setText("Direccion:");

        txtDireccionConductor.setPreferredSize(new java.awt.Dimension(200, 22));

        lblTelefonoConductor.setText("Telefono:");

        txtTelefonoConductor.setPreferredSize(new java.awt.Dimension(200, 22));

        tblConductores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Nombre", "Direccion", "Telefono", "Colectivo"
            }
        ));
        scpConductores.setViewportView(tblConductores);

        btnAñadirConductor.setText("Añadir");

        btnModificarConductor.setText("Modificar");

        btnEliminarConductor.setText("Eliminar");

        javax.swing.GroupLayout pnlConductorLayout = new javax.swing.GroupLayout(pnlConductor);
        pnlConductor.setLayout(pnlConductorLayout);
        pnlConductorLayout.setHorizontalGroup(
            pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConductorLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTelefonoConductor)
                    .addComponent(lblNombreConductor)
                    .addComponent(lblRutConductor)
                    .addComponent(lblDireccionConductor)
                    .addComponent(btnAñadirConductor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRutConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDireccionConductor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombreConductor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtTelefonoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlConductorLayout.createSequentialGroup()
                        .addComponent(btnModificarConductor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarConductor)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlConductorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpConductores, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlConductorLayout.setVerticalGroup(
            pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConductorLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRutConductor)
                    .addComponent(txtRutConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreConductor)
                    .addComponent(txtNombreConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionConductor)
                    .addComponent(txtDireccionConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefonoConductor)
                    .addComponent(txtTelefonoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAñadirConductor)
                    .addComponent(btnModificarConductor)
                    .addComponent(btnEliminarConductor))
                .addGap(18, 18, 18)
                .addComponent(scpConductores, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Conductor", pnlConductor);

        lblNombreRepuesto.setText("Nombre:");

        txtNombreRepuesto.setPreferredSize(new java.awt.Dimension(200, 22));

        lblCompraRepuesto.setText("Fecha de Compra:");

        lblKilometrajeRepuesto.setText("Kilometraje Máximo:");

        txtKilometrajeRepuesto.setPreferredSize(new java.awt.Dimension(200, 22));

        tblRepuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Repuesto", "Patente auto asociado", "Fecha de Compra", "Kilometraje Máximo", "Kilometraje Actual"
            }
        ));
        scpRepuestos.setViewportView(tblRepuestos);

        btnAñadirRepuesto.setText("Añadir");

        btnModificarRepuesto.setText("Modificar");

        btnEliminarRepuesto.setText("Eliminar");

        javax.swing.GroupLayout pnlRepuestosLayout = new javax.swing.GroupLayout(pnlRepuestos);
        pnlRepuestos.setLayout(pnlRepuestosLayout);
        pnlRepuestosLayout.setHorizontalGroup(
            pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRepuestosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpRepuestos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                    .addGroup(pnlRepuestosLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCompraRepuesto)
                            .addComponent(lblNombreRepuesto)
                            .addComponent(lblKilometrajeRepuesto)
                            .addComponent(btnAñadirRepuesto))
                        .addGap(12, 12, 12)
                        .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlRepuestosLayout.createSequentialGroup()
                                .addComponent(btnModificarRepuesto)
                                .addGap(22, 22, 22)
                                .addComponent(btnEliminarRepuesto))
                            .addComponent(txtNombreRepuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKilometrajeRepuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcsCompraRepuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlRepuestosLayout.setVerticalGroup(
            pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreRepuesto)
                    .addComponent(txtNombreRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCompraRepuesto)
                    .addComponent(dcsCompraRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKilometrajeRepuesto)
                    .addComponent(txtKilometrajeRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAñadirRepuesto)
                    .addGroup(pnlRepuestosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminarRepuesto)
                        .addComponent(btnModificarRepuesto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(scpRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
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
                        .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlEventosLayout.createSequentialGroup()
                                .addComponent(lblNombreEvento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cdrFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEventosLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAñadirEvento)
                            .addComponent(scpDescripcionEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
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
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Eventos", pnlEventos);

        javax.swing.GroupLayout pnlGananciasLayout = new javax.swing.GroupLayout(pnlGanancias);
        pnlGanancias.setLayout(pnlGananciasLayout);
        pnlGananciasLayout.setHorizontalGroup(
            pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 771, Short.MAX_VALUE)
        );
        pnlGananciasLayout.setVerticalGroup(
            pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Ganancias", pnlGanancias);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAñadirKilometraje.setText("Añadir Kilometraje");

        lblColectivoSeleccionado.setText("Colectivo a Añadir Kilometraje:");

        btnDebug.setText("DEBUG");
        btnDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDebugActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDebug)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblColectivoSeleccionado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbColectivoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnAñadirKilometraje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnAñadirKilometraje)
                    .addComponent(cmbColectivoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColectivoSeleccionado)
                    .addComponent(btnDebug))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAñadirColectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirColectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAñadirColectivoActionPerformed

    private void btnModificarColectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarColectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarColectivoActionPerformed

    private void btnDebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDebugActionPerformed
        try {
            stm = con.createStatement();
            stm.execute("DROP DATABASE Colectivos;");
            System.out.println("Deberia eliminarse la DB");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDebugActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirColectivo;
    private javax.swing.JButton btnAñadirConductor;
    private javax.swing.JButton btnAñadirEvento;
    private javax.swing.JButton btnAñadirKilometraje;
    private javax.swing.JButton btnAñadirRepuesto;
    private javax.swing.JButton btnDebug;
    private javax.swing.JButton btnEliminarColectivo;
    private javax.swing.JButton btnEliminarConductor;
    private javax.swing.JButton btnEliminarEvento;
    private javax.swing.JButton btnEliminarRepuesto;
    private javax.swing.JButton btnModificarColectivo;
    private javax.swing.JButton btnModificarConductor;
    private javax.swing.JButton btnModificarEvento;
    private javax.swing.JButton btnModificarRepuesto;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JCalendar cdrFechas;
    private javax.swing.JComboBox<String> cmbColectivoSeleccionado;
    private com.toedter.calendar.JDateChooser dchCompraColectivo;
    private com.toedter.calendar.JDateChooser dchRevisionColectivo;
    private com.toedter.calendar.JDateChooser dchSeguroColectivo;
    private com.toedter.calendar.JDateChooser dcsCompraRepuesto;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblBusquedaTablaColectivos;
    private javax.swing.JLabel lblBusquedaTablaEventos;
    private javax.swing.JLabel lblColectivoSeleccionado;
    private javax.swing.JLabel lblCompraColectivo;
    private javax.swing.JLabel lblCompraRepuesto;
    private javax.swing.JLabel lblDireccionConductor;
    private javax.swing.JLabel lblKilometrajeColectivo;
    private javax.swing.JLabel lblKilometrajeRepuesto;
    private javax.swing.JLabel lblMarcaColectivo;
    private javax.swing.JLabel lblMotorColectivo;
    private javax.swing.JLabel lblNombreConductor;
    private javax.swing.JLabel lblNombreEvento;
    private javax.swing.JLabel lblNombreRepuesto;
    private javax.swing.JLabel lblPatenteColectivo;
    private javax.swing.JLabel lblRevisionColectivo;
    private javax.swing.JLabel lblRutConductor;
    private javax.swing.JLabel lblSeguroColectivo;
    private javax.swing.JLabel lblTelefonoConductor;
    private javax.swing.JLabel lblVinColectivo;
    private javax.swing.JList<String> lstColectivos;
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
    private javax.swing.JTable tblConductores;
    private javax.swing.JTable tblRepuestos;
    private javax.swing.JTextArea txaDescripcionEvento;
    private javax.swing.JTextField txtBusquedaTablaColectivos;
    private javax.swing.JTextField txtBusquedaTablaEventos;
    private javax.swing.JTextField txtDireccionConductor;
    private javax.swing.JTextField txtKilometrajeColectivo;
    private javax.swing.JTextField txtKilometrajeRepuesto;
    private javax.swing.JTextField txtMarcaColectivo;
    private javax.swing.JTextField txtMotorColectivo;
    private javax.swing.JTextField txtNombreConductor;
    private javax.swing.JTextField txtNombreEvento;
    private javax.swing.JTextField txtNombreRepuesto;
    private javax.swing.JTextField txtPatenteColectivo;
    private javax.swing.JTextField txtRutConductor;
    private javax.swing.JTextField txtTelefonoConductor;
    private javax.swing.JTextField txtVinColectivo;
    // End of variables declaration//GEN-END:variables
}