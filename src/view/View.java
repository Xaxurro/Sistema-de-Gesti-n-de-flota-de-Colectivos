package view;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class View extends javax.swing.JFrame {
    
    public View() {  
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Vista = new javax.swing.JTabbedPane();
        pnlColectivo = new javax.swing.JPanel();
        lblColectivoMatricula = new javax.swing.JLabel();
        txtColectivoMatricula = new javax.swing.JTextField();
        lblColectivoCompra = new javax.swing.JLabel();
        dchColectivoCompra = new com.toedter.calendar.JDateChooser();
        lblColectivoKilometraje = new javax.swing.JLabel();
        lblColectivoMarca = new javax.swing.JLabel();
        txtColectivoMarca = new javax.swing.JTextField();
        lblColectivoVin = new javax.swing.JLabel();
        txtColectivoVin = new javax.swing.JTextField();
        lblColectivoMotor = new javax.swing.JLabel();
        txtColectivoMotor = new javax.swing.JTextField();
        lblBusquedaTablaColectivoMatricula = new javax.swing.JLabel();
        txtBusquedaTablaColectivoMatricula = new javax.swing.JTextField();
        lblColectivo1Motor = new javax.swing.JLabel();
        cmbColectivoConductores = new javax.swing.JComboBox<>();
        btnColectivoAñadir = new javax.swing.JButton();
        btnColectivoLimpiar = new javax.swing.JButton();
        btnColectivoModificar = new javax.swing.JButton();
        btnColectivoEliminar = new javax.swing.JButton();
        txtBusquedaTablaColectivoRut = new javax.swing.JTextField();
        lblBusquedaTablaColectivoRut = new javax.swing.JLabel();
        btnColectivoLimpiarBuscadores = new javax.swing.JButton();
        scpColectivos = new javax.swing.JScrollPane();
        tblColectivos = new javax.swing.JTable();
        spnColectivoKilometraje = new javax.swing.JSpinner();
        pnlConductor = new javax.swing.JPanel();
        lblConductorRut = new javax.swing.JLabel();
        txtConductorRut = new javax.swing.JTextField();
        lblConductorNombre = new javax.swing.JLabel();
        txtConductorNombre = new javax.swing.JTextField();
        lblConductorDireccion = new javax.swing.JLabel();
        txtConductorDireccion = new javax.swing.JTextField();
        lblConductorTelefono = new javax.swing.JLabel();
        txtConductorTelefono = new javax.swing.JTextField();
        scpConductores = new javax.swing.JScrollPane();
        tblConductores = new javax.swing.JTable();
        btnConductorAñadir = new javax.swing.JButton();
        btnConductorLimpiar = new javax.swing.JButton();
        btnConductorModificar = new javax.swing.JButton();
        btnConductorEliminar = new javax.swing.JButton();
        lblBusquedaTablaConductorNombre = new javax.swing.JLabel();
        txtBusquedaTablaConductorNombre = new javax.swing.JTextField();
        lblBusquedaTablaConductorRut = new javax.swing.JLabel();
        txtBusquedaTablaConductorRut = new javax.swing.JTextField();
        lblConductorColectivos = new javax.swing.JLabel();
        cmbConductorColectivos = new javax.swing.JComboBox<>();
        btnConductorLimpiarBuscadores = new javax.swing.JButton();
        pnlRepuesto = new javax.swing.JPanel();
        lblRepuestoTipo = new javax.swing.JLabel();
        txtRepuestoTipo = new javax.swing.JTextField();
        lblRepuestoCambio = new javax.swing.JLabel();
        dchRepuestoCambio = new com.toedter.calendar.JDateChooser();
        lblRepuestoKilometrajeMax = new javax.swing.JLabel();
        lblRepuestoKilometrajeUsado = new javax.swing.JLabel();
        lblRepuestoColectivos = new javax.swing.JLabel();
        cmbRepuestoColectivos = new javax.swing.JComboBox<>();
        btnRepuestoAñadir = new javax.swing.JButton();
        btnRepuestoLimpiar = new javax.swing.JButton();
        btnRepuestoModificar = new javax.swing.JButton();
        btnRepuestoEliminar = new javax.swing.JButton();
        scpRepuestos = new javax.swing.JScrollPane();
        tblRepuestos = new javax.swing.JTable();
        lblBusquedaTablaRepuestoMatricula = new javax.swing.JLabel();
        txtBusquedaTablaRepuestoMatricula = new javax.swing.JTextField();
        lblBusquedaTablaRepuestoTipo = new javax.swing.JLabel();
        txtBusquedaTablaRepuestoTipo = new javax.swing.JTextField();
        btnRepuestoLimpiarBuscadores = new javax.swing.JButton();
        cmbRepuestoCantidadTipo = new javax.swing.JComboBox<>();
        lblRepuestoCantidadTipo = new javax.swing.JLabel();
        lblRepuestoCantidad = new javax.swing.JLabel();
        lblRepuestoKilometrajeUsado1 = new javax.swing.JLabel();
        spnRepuestoCantidad = new javax.swing.JSpinner();
        spnRepuestoKilometrajeActual = new javax.swing.JSpinner();
        spnRepuestoKilometrajeMax = new javax.swing.JSpinner();
        pnlEventos = new javax.swing.JPanel();
        lblBusquedaTablaEventoFecha = new javax.swing.JLabel();
        dchBusquedaTablaEventoFecha = new com.toedter.calendar.JDateChooser();
        lblBusquedaTablaEventoNombre = new javax.swing.JLabel();
        txtBusquedaTablaEventoNombre = new javax.swing.JTextField();
        lblBusquedaTablaEventoTipo = new javax.swing.JLabel();
        cmbBusquedaTablaEventoTipo = new javax.swing.JComboBox<>();
        btnEventoAñadir = new javax.swing.JButton();
        btnEventoModificar = new javax.swing.JButton();
        btnEventoEliminar = new javax.swing.JButton();
        btnEventoLimpiar = new javax.swing.JButton();
        btnEventoLimpiarBuscadores = new javax.swing.JButton();
        scpEventos = new javax.swing.JScrollPane();
        tblEventos = new javax.swing.JTable();
        lblEventoFecha = new javax.swing.JLabel();
        dchEventoFecha = new com.toedter.calendar.JDateChooser();
        lblEventoNombre = new javax.swing.JLabel();
        txtEventoNombre = new javax.swing.JTextField();
        lblEventoTipo = new javax.swing.JLabel();
        cmbEventoTipo = new javax.swing.JComboBox<>();
        lblEventoBeneficio = new javax.swing.JLabel();
        lblEventoID = new javax.swing.JLabel();
        lblEventoIDActual = new javax.swing.JLabel();
        spnEventoBeneficio = new javax.swing.JSpinner();
        pnlGanancias = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        spnGanancias = new javax.swing.JSpinner();
        btnEventoAñadir1 = new javax.swing.JButton();
        btnEventoLimpiar1 = new javax.swing.JButton();
        btnEventoModificar1 = new javax.swing.JButton();
        btnEventoEliminar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        btnEventoLimpiarBuscadores1 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAñadirKilometraje = new javax.swing.JButton();
        btnReDo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestion de Flota de Colectivos");
        setResizable(false);

        Vista.setPreferredSize(new java.awt.Dimension(750, 550));

        pnlColectivo.setPreferredSize(new java.awt.Dimension(776, 510));

        lblColectivoMatricula.setText("Matricula:");

        txtColectivoMatricula.setToolTipText("Sin digito Verificador");
        txtColectivoMatricula.setName("Matricula"); // NOI18N
        txtColectivoMatricula.setPreferredSize(new java.awt.Dimension(200, 22));

        lblColectivoCompra.setText("Fecha de Compra:");

        dchColectivoCompra.setDateFormatString("yyyy-MM-dd");
        dchColectivoCompra.setName("Fecha de Compra"); // NOI18N

        lblColectivoKilometraje.setText("Kilometraje Actual:");

        lblColectivoMarca.setText("Marca:");

        txtColectivoMarca.setName("Marca"); // NOI18N
        txtColectivoMarca.setPreferredSize(new java.awt.Dimension(200, 22));

        lblColectivoVin.setText("Vin:");

        txtColectivoVin.setName("Vin"); // NOI18N
        txtColectivoVin.setPreferredSize(new java.awt.Dimension(200, 22));

        lblColectivoMotor.setText("Número de Motor:");

        txtColectivoMotor.setName("Número de Motor"); // NOI18N
        txtColectivoMotor.setPreferredSize(new java.awt.Dimension(200, 22));

        lblBusquedaTablaColectivoMatricula.setText("Buscar Matricula:");

        txtBusquedaTablaColectivoMatricula.setPreferredSize(new java.awt.Dimension(200, 22));

        lblColectivo1Motor.setText("Conductor:");

        cmbColectivoConductores.setName("Conductor"); // NOI18N

        btnColectivoAñadir.setText("Añadir");

        btnColectivoLimpiar.setText("Limpiar");

        btnColectivoModificar.setText("Modificar");

        btnColectivoEliminar.setText("Eliminar");

        txtBusquedaTablaColectivoRut.setPreferredSize(new java.awt.Dimension(200, 22));

        lblBusquedaTablaColectivoRut.setText("Buscar Rut:");

        btnColectivoLimpiarBuscadores.setText("Limpiar Buscadores");

        tblColectivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Conductor", "Compra", "Kilometraje Actual", "Marca", "Vin", "Motor"
            }
        ));
        tblColectivos.setToolTipText("");
        tblColectivos.setCellSelectionEnabled(true);
        tblColectivos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblColectivos.setShowGrid(true);
        scpColectivos.setViewportView(tblColectivos);

        spnColectivoKilometraje.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout pnlColectivoLayout = new javax.swing.GroupLayout(pnlColectivo);
        pnlColectivo.setLayout(pnlColectivoLayout);
        pnlColectivoLayout.setHorizontalGroup(
            pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColectivoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlColectivoLayout.createSequentialGroup()
                        .addComponent(btnColectivoAñadir)
                        .addGap(18, 18, 18)
                        .addComponent(btnColectivoLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnColectivoModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnColectivoEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                        .addComponent(lblColectivo1Motor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbColectivoConductores, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlColectivoLayout.createSequentialGroup()
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblColectivoMatricula)
                                .addGap(12, 12, 12)
                                .addComponent(txtColectivoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblColectivoCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dchColectivoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblColectivoKilometraje)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnColectivoKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 370, Short.MAX_VALUE)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblColectivoMarca)
                                .addGap(12, 12, 12)
                                .addComponent(txtColectivoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblColectivoVin)
                                .addGap(12, 12, 12)
                                .addComponent(txtColectivoVin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlColectivoLayout.createSequentialGroup()
                                .addComponent(lblColectivoMotor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtColectivoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18))
            .addGroup(pnlColectivoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblBusquedaTablaColectivoMatricula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusquedaTablaColectivoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBusquedaTablaColectivoRut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusquedaTablaColectivoRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnColectivoLimpiarBuscadores))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlColectivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpColectivos)
                .addContainerGap())
        );
        pnlColectivoLayout.setVerticalGroup(
            pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlColectivoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBusquedaTablaColectivoRut)
                        .addComponent(txtBusquedaTablaColectivoRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnColectivoLimpiarBuscadores))
                    .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBusquedaTablaColectivoMatricula)
                        .addComponent(txtBusquedaTablaColectivoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlColectivoLayout.createSequentialGroup()
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblColectivoMarca)
                            .addComponent(txtColectivoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblColectivoVin)
                            .addComponent(txtColectivoVin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtColectivoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColectivoMotor)))
                    .addGroup(pnlColectivoLayout.createSequentialGroup()
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblColectivoMatricula)
                            .addComponent(txtColectivoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dchColectivoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColectivoCompra))
                        .addGap(18, 18, 18)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblColectivoKilometraje)
                            .addComponent(spnColectivoKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnColectivoAñadir)
                        .addComponent(btnColectivoModificar)
                        .addComponent(btnColectivoEliminar)
                        .addComponent(btnColectivoLimpiar))
                    .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblColectivo1Motor)
                        .addComponent(cmbColectivoConductores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        Vista.addTab("Colectivo", pnlColectivo);

        pnlConductor.setPreferredSize(new java.awt.Dimension(734, 550));

        lblConductorRut.setText("RUT:");

        txtConductorRut.setToolTipText("Siga el formato 12345678-9");
        txtConductorRut.setName("Rut"); // NOI18N
        txtConductorRut.setPreferredSize(new java.awt.Dimension(200, 22));

        lblConductorNombre.setText("Nombre Completo:");

        txtConductorNombre.setName("Nombre"); // NOI18N
        txtConductorNombre.setPreferredSize(new java.awt.Dimension(100, 22));

        lblConductorDireccion.setText("Direccion:");

        txtConductorDireccion.setName("Dirección"); // NOI18N
        txtConductorDireccion.setPreferredSize(new java.awt.Dimension(200, 22));

        lblConductorTelefono.setText("Telefono:");

        txtConductorTelefono.setToolTipText("Siga el formato +12345678901");
        txtConductorTelefono.setName("Teléfono"); // NOI18N
        txtConductorTelefono.setPreferredSize(new java.awt.Dimension(200, 22));

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

        btnConductorAñadir.setText("Añadir");

        btnConductorLimpiar.setText("Limpiar");

        btnConductorModificar.setText("Modificar");

        btnConductorEliminar.setText("Eliminar");

        lblBusquedaTablaConductorNombre.setText("Buscar Nombre:");

        txtBusquedaTablaConductorNombre.setPreferredSize(new java.awt.Dimension(200, 22));

        lblBusquedaTablaConductorRut.setText("Buscar Rut:");

        txtBusquedaTablaConductorRut.setPreferredSize(new java.awt.Dimension(200, 22));

        lblConductorColectivos.setText("Colectivo:");

        btnConductorLimpiarBuscadores.setText("Limpiar Buscadores");

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
                                    .addComponent(lblConductorNombre)
                                    .addComponent(lblConductorRut))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtConductorRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtConductorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 407, Short.MAX_VALUE)
                                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblConductorDireccion)
                                    .addComponent(lblConductorTelefono)))
                            .addGroup(pnlConductorLayout.createSequentialGroup()
                                .addComponent(btnConductorAñadir)
                                .addGap(18, 18, 18)
                                .addComponent(btnConductorLimpiar)
                                .addGap(18, 18, 18)
                                .addComponent(btnConductorModificar)
                                .addGap(18, 18, 18)
                                .addComponent(btnConductorEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblConductorColectivos)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConductorDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConductorTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbConductorColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(btnConductorLimpiarBuscadores)
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
                        .addComponent(btnConductorLimpiarBuscadores))
                    .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBusquedaTablaConductorNombre)
                        .addComponent(txtBusquedaTablaConductorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(scpConductores, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlConductorLayout.createSequentialGroup()
                        .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblConductorRut)
                            .addComponent(txtConductorRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblConductorNombre)
                            .addComponent(txtConductorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlConductorLayout.createSequentialGroup()
                        .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblConductorDireccion)
                            .addComponent(txtConductorDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblConductorTelefono)
                            .addComponent(txtConductorTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(pnlConductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConductorAñadir)
                    .addComponent(btnConductorLimpiar)
                    .addComponent(btnConductorModificar)
                    .addComponent(btnConductorEliminar)
                    .addComponent(cmbConductorColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConductorColectivos))
                .addGap(10, 10, 10))
        );

        Vista.addTab("Conductor", pnlConductor);

        lblRepuestoTipo.setText("Tipo Repuesto:");

        txtRepuestoTipo.setName("Kilometraje Máximo"); // NOI18N
        txtRepuestoTipo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblRepuestoCambio.setText("Fecha de Cambio:");

        dchRepuestoCambio.setDateFormatString("yyyy-MM-dd");
        dchRepuestoCambio.setName("Fecha de Compra"); // NOI18N

        lblRepuestoKilometrajeMax.setText("Kilometraje Máximo:");

        lblRepuestoKilometrajeUsado.setText("Kilometraje Actual:");

        lblRepuestoColectivos.setText("Matricula:");

        cmbRepuestoColectivos.setToolTipText("");
        cmbRepuestoColectivos.setName("Matricula"); // NOI18N

        btnRepuestoAñadir.setText("Añadir");

        btnRepuestoLimpiar.setText("Limpiar");

        btnRepuestoModificar.setText("Modificar");

        btnRepuestoEliminar.setText("Eliminar");

        tblRepuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Repuesto", "Patente auto asociado", "Fecha de Cambio", "Kilometraje Máximo", "Kilometraje Actual"
            }
        ));
        scpRepuestos.setViewportView(tblRepuestos);

        lblBusquedaTablaRepuestoMatricula.setText("Matricula:");

        txtBusquedaTablaRepuestoMatricula.setPreferredSize(new java.awt.Dimension(200, 22));

        lblBusquedaTablaRepuestoTipo.setText("Tipo de Repuesto:");

        txtBusquedaTablaRepuestoTipo.setPreferredSize(new java.awt.Dimension(200, 22));

        btnRepuestoLimpiarBuscadores.setText("Limpiar Buscadores");

        cmbRepuestoCantidadTipo.setToolTipText("");
        cmbRepuestoCantidadTipo.setName("Matricula"); // NOI18N

        lblRepuestoCantidadTipo.setText("Tipo de repuesto a contar:");

        lblRepuestoKilometrajeUsado1.setText("Cantidad:");

        spnRepuestoCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        spnRepuestoKilometrajeActual.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spnRepuestoKilometrajeMax.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        javax.swing.GroupLayout pnlRepuestoLayout = new javax.swing.GroupLayout(pnlRepuesto);
        pnlRepuesto.setLayout(pnlRepuestoLayout);
        pnlRepuestoLayout.setHorizontalGroup(
            pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRepuestoLayout.createSequentialGroup()
                .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRepuestoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBusquedaTablaRepuestoTipo)
                        .addGap(6, 6, 6)
                        .addComponent(txtBusquedaTablaRepuestoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblBusquedaTablaRepuestoMatricula)
                        .addGap(6, 6, 6)
                        .addComponent(txtBusquedaTablaRepuestoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                        .addComponent(btnRepuestoLimpiarBuscadores))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlRepuestoLayout.createSequentialGroup()
                                .addComponent(lblRepuestoTipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRepuestoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlRepuestoLayout.createSequentialGroup()
                                .addComponent(lblRepuestoCambio)
                                .addGap(12, 12, 12)
                                .addComponent(dchRepuestoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestoLayout.createSequentialGroup()
                                .addComponent(lblRepuestoKilometrajeMax)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnRepuestoKilometrajeMax, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestoLayout.createSequentialGroup()
                                .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblRepuestoKilometrajeUsado)
                                    .addComponent(lblRepuestoKilometrajeUsado1))
                                .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlRepuestoLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(spnRepuestoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnRepuestoKilometrajeActual, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(pnlRepuestoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnRepuestoAñadir)
                        .addGap(18, 18, 18)
                        .addComponent(btnRepuestoLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRepuestoModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRepuestoEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRepuestoColectivos)
                        .addGap(12, 12, 12)
                        .addComponent(cmbRepuestoColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRepuestoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scpRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRepuestoCantidadTipo)
                            .addComponent(cmbRepuestoCantidadTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRepuestoCantidad))))
                .addContainerGap())
        );
        pnlRepuestoLayout.setVerticalGroup(
            pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBusquedaTablaRepuestoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBusquedaTablaRepuestoTipo))
                    .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBusquedaTablaRepuestoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBusquedaTablaRepuestoMatricula))
                    .addComponent(btnRepuestoLimpiarBuscadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpRepuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRepuestoLayout.createSequentialGroup()
                        .addComponent(lblRepuestoCantidadTipo)
                        .addGap(8, 8, 8)
                        .addComponent(cmbRepuestoCantidadTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(lblRepuestoCantidad)))
                .addGap(12, 12, 12)
                .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRepuestoKilometrajeMax)
                    .addComponent(lblRepuestoTipo)
                    .addComponent(txtRepuestoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnRepuestoKilometrajeMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRepuestoCambio)
                    .addComponent(dchRepuestoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRepuestoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRepuestoKilometrajeUsado)
                            .addComponent(spnRepuestoKilometrajeActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRepuestoKilometrajeUsado1)
                    .addComponent(spnRepuestoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRepuestoAñadir)
                    .addGroup(pnlRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRepuestoEliminar)
                        .addComponent(btnRepuestoLimpiar)
                        .addComponent(btnRepuestoModificar)
                        .addComponent(lblRepuestoColectivos)
                        .addComponent(cmbRepuestoColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        Vista.addTab("Repuestos en Uso", pnlRepuesto);

        pnlEventos.setPreferredSize(new java.awt.Dimension(776, 485));

        lblBusquedaTablaEventoFecha.setText("Buscar Fecha:");

        dchBusquedaTablaEventoFecha.setDateFormatString("yyyy-MM-dd");
        dchBusquedaTablaEventoFecha.setMinSelectableDate(new Date());
        dchBusquedaTablaEventoFecha.setName("Fecha de Compra"); // NOI18N

        lblBusquedaTablaEventoNombre.setText("Buscar Nombre:");

        txtBusquedaTablaEventoNombre.setPreferredSize(new java.awt.Dimension(200, 22));

        lblBusquedaTablaEventoTipo.setText("Buscar Tipo:");

        cmbBusquedaTablaEventoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Robo", "Accidente", "Renovacion", " " }));
        cmbBusquedaTablaEventoTipo.setToolTipText("");
        cmbBusquedaTablaEventoTipo.setName("Matricula"); // NOI18N

        btnEventoAñadir.setText("Añadir");

        btnEventoModificar.setText("Modificar");

        btnEventoEliminar.setText("Eliminar");

        btnEventoLimpiar.setText("Limpiar");

        btnEventoLimpiarBuscadores.setText("Limpiar Buscadores");

        tblEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Tipo", "Nombre", "Beneficio"
            }
        ));
        tblEventos.setToolTipText("");
        tblEventos.setCellSelectionEnabled(true);
        tblEventos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblEventos.setShowGrid(true);
        scpEventos.setViewportView(tblEventos);

        lblEventoFecha.setText("Fecha:");

        dchEventoFecha.setDateFormatString("yyyy-MM-dd");
        dchEventoFecha.setName("Fecha"); // NOI18N

        lblEventoNombre.setText("Nombre:");

        txtEventoNombre.setToolTipText("Sin digito Verificador");
        txtEventoNombre.setName("Nombre"); // NOI18N
        txtEventoNombre.setPreferredSize(new java.awt.Dimension(200, 22));

        lblEventoTipo.setText("Tipo:");

        cmbEventoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Otro", "Robo", "Accidente", "Renovacion" }));
        cmbEventoTipo.setToolTipText("");
        cmbEventoTipo.setName("Matricula"); // NOI18N

        lblEventoBeneficio.setText("Beneficio:");

        lblEventoID.setText("ID:");

        spnEventoBeneficio.setModel(new javax.swing.SpinnerNumberModel());

        javax.swing.GroupLayout pnlEventosLayout = new javax.swing.GroupLayout(pnlEventos);
        pnlEventos.setLayout(pnlEventosLayout);
        pnlEventosLayout.setHorizontalGroup(
            pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEventosLayout.createSequentialGroup()
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEventosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblBusquedaTablaEventoFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dchBusquedaTablaEventoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblBusquedaTablaEventoNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusquedaTablaEventoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBusquedaTablaEventoTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbBusquedaTablaEventoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(btnEventoLimpiarBuscadores))
                    .addGroup(pnlEventosLayout.createSequentialGroup()
                        .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEventosLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlEventosLayout.createSequentialGroup()
                                        .addComponent(btnEventoAñadir)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEventoLimpiar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEventoModificar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEventoEliminar))
                                    .addGroup(pnlEventosLayout.createSequentialGroup()
                                        .addComponent(lblEventoFecha)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dchEventoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlEventosLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblEventoTipo)
                                    .addComponent(lblEventoID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEventoIDActual)
                                    .addGroup(pnlEventosLayout.createSequentialGroup()
                                        .addComponent(cmbEventoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlEventosLayout.createSequentialGroup()
                                                .addGap(449, 449, 449)
                                                .addComponent(lblEventoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEventoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnlEventosLayout.createSequentialGroup()
                                                .addGap(443, 443, 443)
                                                .addComponent(lblEventoBeneficio)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spnEventoBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(pnlEventosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scpEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlEventosLayout.setVerticalGroup(
            pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEventosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBusquedaTablaEventoNombre)
                        .addComponent(txtBusquedaTablaEventoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBusquedaTablaEventoTipo)
                        .addComponent(cmbBusquedaTablaEventoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBusquedaTablaEventoFecha)
                        .addComponent(btnEventoLimpiarBuscadores))
                    .addComponent(dchBusquedaTablaEventoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scpEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEventoID)
                    .addComponent(lblEventoIDActual))
                .addGap(10, 10, 10)
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dchEventoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEventoFecha)
                        .addComponent(lblEventoNombre)
                        .addComponent(txtEventoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEventoTipo)
                    .addComponent(cmbEventoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEventoBeneficio)
                    .addComponent(spnEventoBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEventoAñadir)
                    .addComponent(btnEventoLimpiar)
                    .addComponent(btnEventoModificar)
                    .addComponent(btnEventoEliminar))
                .addGap(138, 138, 138))
        );

        Vista.addTab("Eventos", pnlEventos);

        pnlGanancias.setToolTipText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Matricula", "Ganancia"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Buscar Fecha:");

        jLabel2.setText("Buscar Matricula:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Matricula:");

        jLabel4.setText("Fecha:");

        jLabel5.setText("Ganancia:");

        spnGanancias.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        btnEventoAñadir1.setText("Añadir");

        btnEventoLimpiar1.setText("Limpiar");

        btnEventoModificar1.setText("Modificar");

        btnEventoEliminar1.setText("Eliminar");

        jLabel6.setText("Matricula:");

        jLabel7.setText("Primera fecha:");

        jLabel8.setText("Ultima Fecha");

        jLabel9.setText("Ganancia:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel10.setText("*Ganancia*");

        btnEventoLimpiarBuscadores1.setText("Limpiar Buscadores");

        javax.swing.GroupLayout pnlGananciasLayout = new javax.swing.GroupLayout(pnlGanancias);
        pnlGanancias.setLayout(pnlGananciasLayout);
        pnlGananciasLayout.setHorizontalGroup(
            pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGananciasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGananciasLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGananciasLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGananciasLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGananciasLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGananciasLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))))
                    .addGroup(pnlGananciasLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spnGanancias)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlGananciasLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE)
                        .addComponent(btnEventoLimpiarBuscadores1)))
                .addContainerGap())
            .addGroup(pnlGananciasLayout.createSequentialGroup()
                .addComponent(btnEventoAñadir1)
                .addGap(18, 18, 18)
                .addComponent(btnEventoLimpiar1)
                .addGap(18, 18, 18)
                .addComponent(btnEventoModificar1)
                .addGap(18, 18, 18)
                .addComponent(btnEventoEliminar1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlGananciasLayout.setVerticalGroup(
            pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGananciasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEventoLimpiarBuscadores1))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlGananciasLayout.createSequentialGroup()
                        .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))))
                .addGap(18, 18, 18)
                .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(spnGanancias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(pnlGananciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEventoAñadir1)
                    .addComponent(btnEventoLimpiar1)
                    .addComponent(btnEventoModificar1)
                    .addComponent(btnEventoEliminar1))
                .addContainerGap())
        );

        Vista.addTab("Ganancias", pnlGanancias);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 702, Short.MAX_VALUE)
                .addComponent(btnAñadirKilometraje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addContainerGap())
            .addComponent(Vista, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Vista, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnAñadirKilometraje)
                    .addComponent(btnReDo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Vista;
    public static javax.swing.JButton btnAñadirKilometraje;
    public static javax.swing.JButton btnColectivoAñadir;
    public static javax.swing.JButton btnColectivoEliminar;
    public static javax.swing.JButton btnColectivoLimpiar;
    public static javax.swing.JButton btnColectivoLimpiarBuscadores;
    public static javax.swing.JButton btnColectivoModificar;
    public static javax.swing.JButton btnConductorAñadir;
    public static javax.swing.JButton btnConductorEliminar;
    public static javax.swing.JButton btnConductorLimpiar;
    public static javax.swing.JButton btnConductorLimpiarBuscadores;
    public static javax.swing.JButton btnConductorModificar;
    public static javax.swing.JButton btnEventoAñadir;
    public static javax.swing.JButton btnEventoAñadir1;
    public static javax.swing.JButton btnEventoEliminar;
    public static javax.swing.JButton btnEventoEliminar1;
    public static javax.swing.JButton btnEventoLimpiar;
    public static javax.swing.JButton btnEventoLimpiar1;
    public static javax.swing.JButton btnEventoLimpiarBuscadores;
    public static javax.swing.JButton btnEventoLimpiarBuscadores1;
    public static javax.swing.JButton btnEventoModificar;
    public static javax.swing.JButton btnEventoModificar1;
    public static javax.swing.JButton btnReDo;
    public static javax.swing.JButton btnRepuestoAñadir;
    public static javax.swing.JButton btnRepuestoEliminar;
    public static javax.swing.JButton btnRepuestoLimpiar;
    public static javax.swing.JButton btnRepuestoLimpiarBuscadores;
    public static javax.swing.JButton btnRepuestoModificar;
    public static javax.swing.JButton btnSalir;
    public static javax.swing.JComboBox<String> cmbBusquedaTablaEventoTipo;
    public static javax.swing.JComboBox<String> cmbColectivoConductores;
    public static javax.swing.JComboBox<String> cmbConductorColectivos;
    public static javax.swing.JComboBox<String> cmbEventoTipo;
    public static javax.swing.JComboBox<String> cmbRepuestoCantidadTipo;
    public static javax.swing.JComboBox<String> cmbRepuestoColectivos;
    public static com.toedter.calendar.JDateChooser dchBusquedaTablaEventoFecha;
    public static com.toedter.calendar.JDateChooser dchColectivoCompra;
    public static com.toedter.calendar.JDateChooser dchEventoFecha;
    public static com.toedter.calendar.JDateChooser dchRepuestoCambio;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblBusquedaTablaColectivoMatricula;
    private javax.swing.JLabel lblBusquedaTablaColectivoRut;
    private javax.swing.JLabel lblBusquedaTablaConductorNombre;
    private javax.swing.JLabel lblBusquedaTablaConductorRut;
    private javax.swing.JLabel lblBusquedaTablaEventoFecha;
    private javax.swing.JLabel lblBusquedaTablaEventoNombre;
    private javax.swing.JLabel lblBusquedaTablaEventoTipo;
    private javax.swing.JLabel lblBusquedaTablaRepuestoMatricula;
    private javax.swing.JLabel lblBusquedaTablaRepuestoTipo;
    private javax.swing.JLabel lblColectivo1Motor;
    private javax.swing.JLabel lblColectivoCompra;
    private javax.swing.JLabel lblColectivoKilometraje;
    private javax.swing.JLabel lblColectivoMarca;
    private javax.swing.JLabel lblColectivoMatricula;
    private javax.swing.JLabel lblColectivoMotor;
    private javax.swing.JLabel lblColectivoVin;
    private javax.swing.JLabel lblConductorColectivos;
    private javax.swing.JLabel lblConductorDireccion;
    private javax.swing.JLabel lblConductorNombre;
    private javax.swing.JLabel lblConductorRut;
    private javax.swing.JLabel lblConductorTelefono;
    private javax.swing.JLabel lblEventoBeneficio;
    private javax.swing.JLabel lblEventoFecha;
    private javax.swing.JLabel lblEventoID;
    public static javax.swing.JLabel lblEventoIDActual;
    private javax.swing.JLabel lblEventoNombre;
    private javax.swing.JLabel lblEventoTipo;
    private javax.swing.JLabel lblRepuestoCambio;
    public static javax.swing.JLabel lblRepuestoCantidad;
    private javax.swing.JLabel lblRepuestoCantidadTipo;
    private javax.swing.JLabel lblRepuestoColectivos;
    private javax.swing.JLabel lblRepuestoKilometrajeMax;
    private javax.swing.JLabel lblRepuestoKilometrajeUsado;
    private javax.swing.JLabel lblRepuestoKilometrajeUsado1;
    private javax.swing.JLabel lblRepuestoTipo;
    private javax.swing.JPanel pnlColectivo;
    private javax.swing.JPanel pnlConductor;
    private javax.swing.JPanel pnlEventos;
    private javax.swing.JPanel pnlGanancias;
    private javax.swing.JPanel pnlRepuesto;
    private javax.swing.JScrollPane scpColectivos;
    private javax.swing.JScrollPane scpConductores;
    private javax.swing.JScrollPane scpEventos;
    private javax.swing.JScrollPane scpRepuestos;
    public static javax.swing.JSpinner spnColectivoKilometraje;
    public static javax.swing.JSpinner spnEventoBeneficio;
    public static javax.swing.JSpinner spnGanancias;
    public static javax.swing.JSpinner spnRepuestoCantidad;
    public static javax.swing.JSpinner spnRepuestoKilometrajeActual;
    public static javax.swing.JSpinner spnRepuestoKilometrajeMax;
    public static javax.swing.JTable tblColectivos;
    public static javax.swing.JTable tblConductores;
    public static javax.swing.JTable tblEventos;
    public static javax.swing.JTable tblRepuestos;
    public static javax.swing.JTextField txtBusquedaTablaColectivoMatricula;
    public static javax.swing.JTextField txtBusquedaTablaColectivoRut;
    public static javax.swing.JTextField txtBusquedaTablaConductorNombre;
    public static javax.swing.JTextField txtBusquedaTablaConductorRut;
    public static javax.swing.JTextField txtBusquedaTablaEventoNombre;
    public static javax.swing.JTextField txtBusquedaTablaRepuestoMatricula;
    public static javax.swing.JTextField txtBusquedaTablaRepuestoTipo;
    public static javax.swing.JTextField txtColectivoMarca;
    public static javax.swing.JTextField txtColectivoMatricula;
    public static javax.swing.JTextField txtColectivoMotor;
    public static javax.swing.JTextField txtColectivoVin;
    public static javax.swing.JTextField txtConductorDireccion;
    public static javax.swing.JTextField txtConductorNombre;
    public static javax.swing.JTextField txtConductorRut;
    public static javax.swing.JTextField txtConductorTelefono;
    public static javax.swing.JTextField txtEventoNombre;
    public static javax.swing.JTextField txtRepuestoTipo;
    // End of variables declaration//GEN-END:variables
}
