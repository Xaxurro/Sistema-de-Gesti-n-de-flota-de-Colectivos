package view;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class View extends javax.swing.JFrame {
    
    boolean valido;
    
    //
    /*
    
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

    private void btnLimpiarConductorActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        txtRutConductor.setText("");
        txtNombreConductor.setText("");
        txtDireccionConductor.setText("");
        txtTelefonoConductor.setText("");
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

    */
    //
    
    public View() {  
        initComponents();
            
        /*
        // Modificar Tamaño de las Columnas Jtables
        tblColectivos.getColumnModel().getColumn(0).setMinWidth(100);
        tblColectivos.getColumnModel().getColumn(1).setMinWidth(100);
        tblColectivos.getColumnModel().getColumn(2).setMinWidth(100);
        tblColectivos.getColumnModel().getColumn(3).setMinWidth(125);
        tblColectivos.getColumnModel().getColumn(4).setMinWidth(130);
        tblColectivos.getColumnModel().getColumn(5).setMinWidth(100);
        tblColectivos.getColumnModel().getColumn(6).setMinWidth(100);
        */  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlColectivo = new javax.swing.JPanel();
        lblMatriculaColectivo = new javax.swing.JLabel();
        txtMatriculaColectivo = new javax.swing.JTextField();
        lblCompraColectivo = new javax.swing.JLabel();
        dchCompraColectivo = new com.toedter.calendar.JDateChooser();
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
        cmbConductoresColectivo = new javax.swing.JComboBox<>();
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
        pnlRepuestosStock = new javax.swing.JPanel();
        lblCompraRepuesto = new javax.swing.JLabel();
        dchCompraRepuesto = new com.toedter.calendar.JDateChooser();
        lblKilometrajeRepuesto = new javax.swing.JLabel();
        txtKilometrajeRepuesto = new javax.swing.JTextField();
        lblTipoRepuesto = new javax.swing.JLabel();
        btnAñadirRepuesto = new javax.swing.JButton();
        btnLimpiarRepuesto = new javax.swing.JButton();
        btnModificarRepuesto = new javax.swing.JButton();
        btnEliminarRepuesto = new javax.swing.JButton();
        lblBusquedaTablaRepuestoNombre = new javax.swing.JLabel();
        txtBusquedaTablaRepuestoNombre = new javax.swing.JTextField();
        scpRepuestos = new javax.swing.JScrollPane();
        tblRepuestos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtKilometrajeRepuesto2 = new javax.swing.JTextField();
        lblKilometrajeRepuesto2 = new javax.swing.JLabel();
        txtKilometrajeRepuesto3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlRepuestosUso = new javax.swing.JPanel();
        lblMatriculaRepuesto1 = new javax.swing.JLabel();
        cmbMatriculaRepuesto1 = new javax.swing.JComboBox<>();
        lblCompraRepuesto1 = new javax.swing.JLabel();
        dchCompraRepuesto1 = new com.toedter.calendar.JDateChooser();
        lblKilometrajeRepuesto1 = new javax.swing.JLabel();
        txtKilometrajeRepuesto1 = new javax.swing.JTextField();
        lblTipoRepuesto1 = new javax.swing.JLabel();
        cmbTipoRepuesto1 = new javax.swing.JComboBox<>();
        btnAñadirRepuesto1 = new javax.swing.JButton();
        btnLimpiarRepuesto1 = new javax.swing.JButton();
        btnModificarRepuesto1 = new javax.swing.JButton();
        btnEliminarRepuesto1 = new javax.swing.JButton();
        lblBusquedaTablaRepuestoNombre1 = new javax.swing.JLabel();
        txtBusquedaTablaRepuestoNombre1 = new javax.swing.JTextField();
        scpRepuestos1 = new javax.swing.JScrollPane();
        tblRepuestos1 = new javax.swing.JTable();
        lblBusquedaTablaRepuestoNombre2 = new javax.swing.JLabel();
        txtBusquedaTablaRepuestoNombre2 = new javax.swing.JTextField();
        pnlEventos = new javax.swing.JPanel();
        lblNombreEvento = new javax.swing.JLabel();
        txtNombreEvento = new javax.swing.JTextField();
        lblDescripcionEvento = new javax.swing.JLabel();
        scpDescripcionEvento = new javax.swing.JScrollPane();
        txaDescripcionEvento = new javax.swing.JTextArea();
        lblBusquedaTablaEventos = new javax.swing.JLabel();
        txtBusquedaTablaEventos = new javax.swing.JTextField();
        scpEventos = new javax.swing.JScrollPane();
        lvlNoEventos = new javax.swing.JLabel();
        btnAñadirEvento = new javax.swing.JButton();
        btnModificarEvento = new javax.swing.JButton();
        btnEliminarEvento = new javax.swing.JButton();
        lstEventos = new javax.swing.JList<>();
        cldEvento = new com.toedter.calendar.JCalendar();
        pnlGanancias = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnAñadirKilometraje = new javax.swing.JButton();
        btnReDo = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestion de Flota de Colectivos");
        setResizable(false);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(750, 550));

        pnlColectivo.setPreferredSize(new java.awt.Dimension(776, 510));

        lblMatriculaColectivo.setText("Matricula:");

        txtMatriculaColectivo.setToolTipText("Sin digito Verificador");
        txtMatriculaColectivo.setName("Matricula"); // NOI18N
        txtMatriculaColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblCompraColectivo.setText("Fecha de Compra:");

        dchCompraColectivo.setDateFormatString("yyyy-MM-dd");
        dchCompraColectivo.setName("Fecha de Compra"); // NOI18N

        lblKilometrajeColectivo.setText("Kilometraje Actual:");

        txtKilometrajeColectivo.setToolTipText("Solo números");
        txtKilometrajeColectivo.setName("Kilometraje Actual"); // NOI18N
        txtKilometrajeColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblMarcaColectivo.setText("Marca:");

        txtMarcaColectivo.setName("Marca"); // NOI18N
        txtMarcaColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblVinColectivo.setText("Vin:");

        txtVinColectivo.setName("Vin"); // NOI18N
        txtVinColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblMotorColectivo.setText("Número de Motor:");

        txtMotorColectivo.setName("Número de Motor"); // NOI18N
        txtMotorColectivo.setPreferredSize(new java.awt.Dimension(200, 22));

        btnAñadirColectivo.setText("Añadir");

        scpColectivos.setViewportView(tblColectivos);

        tblColectivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Rut del Conductor", "Fecha de Compra", "Kilometraje Actual", "Marca", "Vin", "Número de Motor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblColectivos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblColectivos.setCellSelectionEnabled(true);
        tblColectivos.setMinimumSize(new java.awt.Dimension(200, 0));
        tblColectivos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblColectivos.setShowGrid(true);
        scpColectivos.setViewportView(tblColectivos);

        lblBusquedaTablaColectivosMatricula.setText("Buscar Matricula:");

        txtBusquedaTablaColectivosMatricula.setPreferredSize(new java.awt.Dimension(200, 22));

        lblMotorColectivo1.setText("Conductor:");

        cmbConductoresColectivo.setName("Conductor"); // NOI18N

        btnModificarColectivo.setText("Modificar");

        btnEliminarColectivo.setText("Eliminar");

        btnLimpiarColectivo.setText("Limpiar");

        txtBusquedaTablaColectivosRut.setPreferredSize(new java.awt.Dimension(200, 22));

        lblBusquedaTablaColectivosRut.setText("Buscar Rut:");

        btnLimpiarBuscadoresColectivo.setText("Limpiar Buscadores");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                        .addComponent(lblMotorColectivo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbConductoresColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlColectivoLayout.createSequentialGroup()
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblMatriculaColectivo)
                                .addGap(12, 12, 12)
                                .addComponent(txtMatriculaColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblCompraColectivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dchCompraColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblKilometrajeColectivo)
                                .addGap(12, 12, 12)
                                .addComponent(txtKilometrajeColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 342, Short.MAX_VALUE)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblMarcaColectivo)
                                .addGap(12, 12, 12)
                                .addComponent(txtMarcaColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(btnLimpiarBuscadoresColectivo))
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
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKilometrajeColectivo)
                            .addComponent(txtKilometrajeColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlColectivoLayout.createSequentialGroup()
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
                .addGap(58, 58, 58)
                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAñadirColectivo)
                        .addComponent(btnModificarColectivo)
                        .addComponent(btnEliminarColectivo)
                        .addComponent(btnLimpiarColectivo))
                    .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMotorColectivo1)
                        .addComponent(cmbConductoresColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("Colectivo", pnlColectivo);

        pnlConductor.setPreferredSize(new java.awt.Dimension(734, 550));

        lblRutConductor.setText("RUT:");

        txtRutConductor.setToolTipText("Siga el formato 12345678-9");
        txtRutConductor.setName("Rut"); // NOI18N
        txtRutConductor.setPreferredSize(new java.awt.Dimension(200, 22));

        lblNombreConductor.setText("Nombre Completo:");

        txtNombreConductor.setName("Nombre"); // NOI18N
        txtNombreConductor.setPreferredSize(new java.awt.Dimension(100, 22));

        lblDireccionConductor.setText("Direccion:");

        txtDireccionConductor.setName("Dirección"); // NOI18N
        txtDireccionConductor.setPreferredSize(new java.awt.Dimension(200, 22));

        lblTelefonoConductor.setText("Telefono:");

        txtTelefonoConductor.setToolTipText("Siga el formato +12345678901");
        txtTelefonoConductor.setName("Teléfono"); // NOI18N
        txtTelefonoConductor.setPreferredSize(new java.awt.Dimension(200, 22));

        tblConductores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Colectivo", "Nombre", "Direccion", "Telefono"
            }
        ));
        tblConductores.setToolTipText("");
        tblConductores.setCellSelectionEnabled(true);
        tblConductores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblConductores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblConductores.setShowGrid(true);
        scpConductores.setViewportView(tblConductores);

        btnAñadirConductor.setText("Añadir");

        btnModificarConductor.setText("Modificar");

        btnEliminarConductor.setText("Eliminar");

        lblBusquedaTablaConductorNombre.setText("Buscar Nombre:");

        txtBusquedaTablaConductorNombre.setPreferredSize(new java.awt.Dimension(200, 22));

        btnLimpiarConductor.setText("Limpiar");

        lblBusquedaTablaConductorRut.setText("Buscar Rut:");

        txtBusquedaTablaConductorRut.setPreferredSize(new java.awt.Dimension(200, 22));

        lblColectivosConductor.setText("Colectivo:");

        btnLimpiarBuscadoresConductor.setText("Limpiar Buscadores");

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 379, Short.MAX_VALUE)
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

        lblCompraRepuesto.setText("Fecha de Compra:");

        dchCompraRepuesto.setDateFormatString("yyyy-MM-dd");
        dchCompraRepuesto.setName("Fecha de Compra"); // NOI18N

        lblKilometrajeRepuesto.setText("Kilometraje Máximo:");

        txtKilometrajeRepuesto.setName("Kilometraje Máximo"); // NOI18N
        txtKilometrajeRepuesto.setPreferredSize(new java.awt.Dimension(200, 22));

        lblTipoRepuesto.setText("Tipo Repuesto:");

        btnAñadirRepuesto.setText("Añadir");

        btnLimpiarRepuesto.setText("Limpiar");

        btnModificarRepuesto.setText("Modificar");

        btnEliminarRepuesto.setText("Eliminar");

        lblBusquedaTablaRepuestoNombre.setText("Tipo de Repuesto:");

        txtBusquedaTablaRepuestoNombre.setPreferredSize(new java.awt.Dimension(200, 22));

        tblRepuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Repuesto", "Kilometraje Máximo", "Kilometraje Actual", "Stock Actual"
            }
        ));
        scpRepuestos.setViewportView(tblRepuestos);

        jButton1.setText("Añadir Stock");

        jButton2.setText("Ajustar Stock");

        txtKilometrajeRepuesto2.setName("Kilometraje Máximo"); // NOI18N
        txtKilometrajeRepuesto2.setPreferredSize(new java.awt.Dimension(200, 22));

        lblKilometrajeRepuesto2.setText("Kilometraje Actual:");

        txtKilometrajeRepuesto3.setName("Kilometraje Máximo"); // NOI18N
        txtKilometrajeRepuesto3.setPreferredSize(new java.awt.Dimension(200, 22));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText(": (número)");

        jLabel2.setText("Cantidad de");

        javax.swing.GroupLayout pnlRepuestosStockLayout = new javax.swing.GroupLayout(pnlRepuestosStock);
        pnlRepuestosStock.setLayout(pnlRepuestosStockLayout);
        pnlRepuestosStockLayout.setHorizontalGroup(
            pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRepuestosStockLayout.createSequentialGroup()
                .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRepuestosStockLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scpRepuestos))
                    .addGroup(pnlRepuestosStockLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlRepuestosStockLayout.createSequentialGroup()
                                .addComponent(lblCompraRepuesto)
                                .addGap(12, 12, 12)
                                .addComponent(dchCompraRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlRepuestosStockLayout.createSequentialGroup()
                                .addComponent(lblTipoRepuesto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtKilometrajeRepuesto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                        .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestosStockLayout.createSequentialGroup()
                                .addComponent(lblKilometrajeRepuesto)
                                .addGap(12, 12, 12)
                                .addComponent(txtKilometrajeRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestosStockLayout.createSequentialGroup()
                                .addComponent(lblKilometrajeRepuesto2)
                                .addGap(12, 12, 12)
                                .addComponent(txtKilometrajeRepuesto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlRepuestosStockLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnAñadirRepuesto)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiarRepuesto)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarRepuesto)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarRepuesto)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlRepuestosStockLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblBusquedaTablaRepuestoNombre)
                        .addGap(6, 6, 6)
                        .addComponent(txtBusquedaTablaRepuestoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(59, 59, 59)))
                .addContainerGap())
        );
        pnlRepuestosStockLayout.setVerticalGroup(
            pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestosStockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusquedaTablaRepuestoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBusquedaTablaRepuestoNombre)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(scpRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblKilometrajeRepuesto)
                        .addComponent(lblTipoRepuesto)
                        .addComponent(txtKilometrajeRepuesto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtKilometrajeRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCompraRepuesto)
                    .addComponent(dchCompraRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblKilometrajeRepuesto2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtKilometrajeRepuesto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAñadirRepuesto)
                    .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminarRepuesto)
                        .addComponent(btnLimpiarRepuesto)
                        .addComponent(btnModificarRepuesto)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("Repuestos en Stock", pnlRepuestosStock);

        lblMatriculaRepuesto1.setText("Matricula:");

        cmbMatriculaRepuesto1.setToolTipText("");
        cmbMatriculaRepuesto1.setName("Matricula"); // NOI18N

        lblCompraRepuesto1.setText("Fecha de Compra:");

        dchCompraRepuesto1.setDateFormatString("yyyy-MM-dd");
        dchCompraRepuesto1.setName("Fecha de Compra"); // NOI18N

        lblKilometrajeRepuesto1.setText("Kilometraje Máximo:");

        txtKilometrajeRepuesto1.setName("Kilometraje Máximo"); // NOI18N
        txtKilometrajeRepuesto1.setPreferredSize(new java.awt.Dimension(200, 22));

        lblTipoRepuesto1.setText("Tipo Repuesto:");

        cmbTipoRepuesto1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pastilla de Freno" }));
        cmbTipoRepuesto1.setToolTipText("");
        cmbTipoRepuesto1.setName("Tipo de Repuesto"); // NOI18N

        btnAñadirRepuesto1.setText("Añadir");

        btnLimpiarRepuesto1.setText("Limpiar");

        btnModificarRepuesto1.setText("Modificar");

        btnEliminarRepuesto1.setText("Eliminar");

        lblBusquedaTablaRepuestoNombre1.setText("Matricula:");

        txtBusquedaTablaRepuestoNombre1.setPreferredSize(new java.awt.Dimension(200, 22));

        tblRepuestos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Repuesto", "Patente auto asociado", "Fecha de Compra", "Kilometraje Repuesto Máximo", "Kilometraje Repuesto Actual"
            }
        ));
        scpRepuestos1.setViewportView(tblRepuestos1);

        lblBusquedaTablaRepuestoNombre2.setText("Tipo de Repuesto:");

        txtBusquedaTablaRepuestoNombre2.setPreferredSize(new java.awt.Dimension(200, 22));

        javax.swing.GroupLayout pnlRepuestosUsoLayout = new javax.swing.GroupLayout(pnlRepuestosUso);
        pnlRepuestosUso.setLayout(pnlRepuestosUsoLayout);
        pnlRepuestosUsoLayout.setHorizontalGroup(
            pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRepuestosUsoLayout.createSequentialGroup()
                .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRepuestosUsoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scpRepuestos1))
                    .addGroup(pnlRepuestosUsoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBusquedaTablaRepuestoNombre2)
                        .addGap(6, 6, 6)
                        .addComponent(txtBusquedaTablaRepuestoNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblBusquedaTablaRepuestoNombre1)
                        .addGap(6, 6, 6)
                        .addComponent(txtBusquedaTablaRepuestoNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlRepuestosUsoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRepuestosUsoLayout.createSequentialGroup()
                                .addComponent(btnAñadirRepuesto1)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiarRepuesto1)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificarRepuesto1)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarRepuesto1))
                            .addGroup(pnlRepuestosUsoLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(lblMatriculaRepuesto1)
                                .addGap(12, 12, 12)
                                .addComponent(cmbMatriculaRepuesto1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                                .addComponent(lblKilometrajeRepuesto1)
                                .addGap(12, 12, 12)
                                .addComponent(txtKilometrajeRepuesto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlRepuestosUsoLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblTipoRepuesto1)
                        .addGap(12, 12, 12)
                        .addComponent(cmbTipoRepuesto1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCompraRepuesto1)
                        .addGap(12, 12, 12)
                        .addComponent(dchCompraRepuesto1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlRepuestosUsoLayout.setVerticalGroup(
            pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestosUsoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusquedaTablaRepuestoNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBusquedaTablaRepuestoNombre1)
                    .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBusquedaTablaRepuestoNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBusquedaTablaRepuestoNombre2)))
                .addGap(18, 18, 18)
                .addComponent(scpRepuestos1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblKilometrajeRepuesto1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtKilometrajeRepuesto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMatriculaRepuesto1)
                        .addComponent(cmbMatriculaRepuesto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTipoRepuesto1)
                        .addComponent(cmbTipoRepuesto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCompraRepuesto1)
                    .addComponent(dchCompraRepuesto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAñadirRepuesto1)
                    .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminarRepuesto1)
                        .addComponent(btnLimpiarRepuesto1)
                        .addComponent(btnModificarRepuesto1)))
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("Repuestos en Uso", pnlRepuestosUso);

        lblNombreEvento.setText("Nombre Evento:");

        txtNombreEvento.setPreferredSize(new java.awt.Dimension(200, 22));

        lblDescripcionEvento.setText("Descripcion:");

        txaDescripcionEvento.setColumns(20);
        txaDescripcionEvento.setRows(5);
        txaDescripcionEvento.setTabSize(5);
        txaDescripcionEvento.setWrapStyleWord(true);
        scpDescripcionEvento.setViewportView(txaDescripcionEvento);

        lblBusquedaTablaEventos.setText("Evento a buscar: ");

        txtBusquedaTablaEventos.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaTablaEventos.setPreferredSize(new java.awt.Dimension(200, 22));

        lvlNoEventos.setText("No hay eventos");
        lvlNoEventos.setEnabled(false);
        lvlNoEventos.setFocusable(false);

        btnAñadirEvento.setText("Añadir");

        btnModificarEvento.setText("Modificar");

        btnEliminarEvento.setText("Eliminar");

        cldEvento.setDecorationBackgroundVisible(false);

        javax.swing.GroupLayout pnlEventosLayout = new javax.swing.GroupLayout(pnlEventos);
        pnlEventos.setLayout(pnlEventosLayout);
        pnlEventosLayout.setHorizontalGroup(
            pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEventosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlEventosLayout.createSequentialGroup()
                        .addComponent(lblDescripcionEvento)
                        .addGap(45, 45, 45)
                        .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scpDescripcionEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAñadirEvento)))
                    .addComponent(lblNombreEvento)
                    .addComponent(cldEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
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
            .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEventosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lstEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
                        .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scpEventos)
                            .addGroup(pnlEventosLayout.createSequentialGroup()
                                .addComponent(lvlNoEventos)
                                .addGap(0, 174, Short.MAX_VALUE))))
                    .addComponent(cldEvento, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEvento)
                    .addComponent(txtNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarEvento)
                    .addComponent(btnEliminarEvento))
                .addGap(18, 18, 18)
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcionEvento)
                    .addComponent(scpDescripcionEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAñadirEvento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEventosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lstEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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

        btnAñadirKilometraje.setText("Añadir Kilometraje");

        btnReDo.setText("Re-Crear DB");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnReDo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 674, Short.MAX_VALUE)
                .addComponent(btnAñadirKilometraje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addContainerGap())
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnAñadirKilometraje)
                    .addComponent(btnReDo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAñadirColectivo;
    public static javax.swing.JButton btnAñadirConductor;
    public static javax.swing.JButton btnAñadirEvento;
    public static javax.swing.JButton btnAñadirKilometraje;
    public static javax.swing.JButton btnAñadirRepuesto;
    public static javax.swing.JButton btnAñadirRepuesto1;
    public static javax.swing.JButton btnEliminarColectivo;
    public static javax.swing.JButton btnEliminarConductor;
    public static javax.swing.JButton btnEliminarEvento;
    public static javax.swing.JButton btnEliminarRepuesto;
    public static javax.swing.JButton btnEliminarRepuesto1;
    public static javax.swing.JButton btnLimpiarBuscadoresColectivo;
    public static javax.swing.JButton btnLimpiarBuscadoresConductor;
    public static javax.swing.JButton btnLimpiarColectivo;
    public static javax.swing.JButton btnLimpiarConductor;
    public static javax.swing.JButton btnLimpiarRepuesto;
    public static javax.swing.JButton btnLimpiarRepuesto1;
    public static javax.swing.JButton btnModificarColectivo;
    public static javax.swing.JButton btnModificarConductor;
    public static javax.swing.JButton btnModificarEvento;
    public static javax.swing.JButton btnModificarRepuesto;
    public static javax.swing.JButton btnModificarRepuesto1;
    public static javax.swing.JButton btnReDo;
    public static javax.swing.JButton btnSalir;
    private com.toedter.calendar.JCalendar cldEvento;
    public static javax.swing.JComboBox<String> cmbColectivosConductor;
    public static javax.swing.JComboBox<String> cmbConductoresColectivo;
    public static javax.swing.JComboBox<String> cmbMatriculaRepuesto1;
    public static javax.swing.JComboBox<String> cmbTipoRepuesto1;
    public static com.toedter.calendar.JDateChooser dchCompraColectivo;
    public static com.toedter.calendar.JDateChooser dchCompraRepuesto;
    public static com.toedter.calendar.JDateChooser dchCompraRepuesto1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblBusquedaTablaColectivosMatricula;
    private javax.swing.JLabel lblBusquedaTablaColectivosRut;
    private javax.swing.JLabel lblBusquedaTablaConductorNombre;
    private javax.swing.JLabel lblBusquedaTablaConductorRut;
    private javax.swing.JLabel lblBusquedaTablaEventos;
    private javax.swing.JLabel lblBusquedaTablaRepuestoNombre;
    private javax.swing.JLabel lblBusquedaTablaRepuestoNombre1;
    private javax.swing.JLabel lblBusquedaTablaRepuestoNombre2;
    private javax.swing.JLabel lblColectivosConductor;
    private javax.swing.JLabel lblCompraColectivo;
    private javax.swing.JLabel lblCompraRepuesto;
    private javax.swing.JLabel lblCompraRepuesto1;
    private javax.swing.JLabel lblDescripcionEvento;
    private javax.swing.JLabel lblDireccionConductor;
    private javax.swing.JLabel lblKilometrajeColectivo;
    private javax.swing.JLabel lblKilometrajeRepuesto;
    private javax.swing.JLabel lblKilometrajeRepuesto1;
    private javax.swing.JLabel lblKilometrajeRepuesto2;
    private javax.swing.JLabel lblMarcaColectivo;
    private javax.swing.JLabel lblMatriculaColectivo;
    private javax.swing.JLabel lblMatriculaRepuesto1;
    private javax.swing.JLabel lblMotorColectivo;
    private javax.swing.JLabel lblMotorColectivo1;
    private javax.swing.JLabel lblNombreConductor;
    private javax.swing.JLabel lblNombreEvento;
    private javax.swing.JLabel lblRutConductor;
    private javax.swing.JLabel lblTelefonoConductor;
    private javax.swing.JLabel lblTipoRepuesto;
    private javax.swing.JLabel lblTipoRepuesto1;
    private javax.swing.JLabel lblVinColectivo;
    public static javax.swing.JList<String> lstEventos;
    private javax.swing.JLabel lvlNoEventos;
    private javax.swing.JPanel pnlColectivo;
    private javax.swing.JPanel pnlConductor;
    private javax.swing.JPanel pnlEventos;
    private javax.swing.JPanel pnlGanancias;
    private javax.swing.JPanel pnlRepuestosStock;
    private javax.swing.JPanel pnlRepuestosUso;
    private javax.swing.JScrollPane scpColectivos;
    private javax.swing.JScrollPane scpConductores;
    private javax.swing.JScrollPane scpDescripcionEvento;
    public static javax.swing.JScrollPane scpEventos;
    private javax.swing.JScrollPane scpRepuestos;
    private javax.swing.JScrollPane scpRepuestos1;
    public static javax.swing.JTable tblColectivos;
    public static javax.swing.JTable tblConductores;
    public static javax.swing.JTable tblRepuestos;
    public static javax.swing.JTable tblRepuestos1;
    public static javax.swing.JTextArea txaDescripcionEvento;
    public static javax.swing.JTextField txtBusquedaTablaColectivosMatricula;
    public static javax.swing.JTextField txtBusquedaTablaColectivosRut;
    public static javax.swing.JTextField txtBusquedaTablaConductorNombre;
    public static javax.swing.JTextField txtBusquedaTablaConductorRut;
    public static javax.swing.JTextField txtBusquedaTablaEventos;
    public static javax.swing.JTextField txtBusquedaTablaRepuestoNombre;
    public static javax.swing.JTextField txtBusquedaTablaRepuestoNombre1;
    public static javax.swing.JTextField txtBusquedaTablaRepuestoNombre2;
    public static javax.swing.JTextField txtDireccionConductor;
    public static javax.swing.JTextField txtKilometrajeColectivo;
    public static javax.swing.JTextField txtKilometrajeRepuesto;
    public static javax.swing.JTextField txtKilometrajeRepuesto1;
    public static javax.swing.JTextField txtKilometrajeRepuesto2;
    public static javax.swing.JTextField txtKilometrajeRepuesto3;
    public static javax.swing.JTextField txtMarcaColectivo;
    public static javax.swing.JTextField txtMatriculaColectivo;
    public static javax.swing.JTextField txtMotorColectivo;
    public static javax.swing.JTextField txtNombreConductor;
    public static javax.swing.JTextField txtNombreEvento;
    public static javax.swing.JTextField txtRutConductor;
    public static javax.swing.JTextField txtTelefonoConductor;
    public static javax.swing.JTextField txtVinColectivo;
    // End of variables declaration//GEN-END:variables
}