package view;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
        txtColectivoKilometraje = new javax.swing.JTextField();
        lblColectivoMarca = new javax.swing.JLabel();
        txtColectivoMarca = new javax.swing.JTextField();
        lblColectivoVin = new javax.swing.JLabel();
        txtColectivoVin = new javax.swing.JTextField();
        lblColectivoMotor = new javax.swing.JLabel();
        txtColectivoMotor = new javax.swing.JTextField();
        btnColectivoAñadir = new javax.swing.JButton();
        lblBusquedaTablaColectivoMatricula = new javax.swing.JLabel();
        txtBusquedaTablaColectivoMatricula = new javax.swing.JTextField();
        lblColectivo1Motor = new javax.swing.JLabel();
        cmbColectivoConductores = new javax.swing.JComboBox<>();
        btnColectivoModificar = new javax.swing.JButton();
        btnColectivoEliminar = new javax.swing.JButton();
        btnColectivoLimpiar = new javax.swing.JButton();
        txtBusquedaTablaColectivoRut = new javax.swing.JTextField();
        lblBusquedaTablaColectivoRut = new javax.swing.JLabel();
        btnColectivoLimpiarBuscadores = new javax.swing.JButton();
        scpColectivos = new javax.swing.JScrollPane();
        tblColectivos = new javax.swing.JTable();
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
        btnConductorModificar = new javax.swing.JButton();
        btnConductorEliminar = new javax.swing.JButton();
        lblBusquedaTablaConductorNombre = new javax.swing.JLabel();
        txtBusquedaTablaConductorNombre = new javax.swing.JTextField();
        btnConductorLimpiar = new javax.swing.JButton();
        lblBusquedaTablaConductorRut = new javax.swing.JLabel();
        txtBusquedaTablaConductorRut = new javax.swing.JTextField();
        lblConductorColectivos = new javax.swing.JLabel();
        cmbConductorColectivos = new javax.swing.JComboBox<>();
        btnConductorLimpiarBuscadores = new javax.swing.JButton();
        pnlRepuestosStock = new javax.swing.JPanel();
        lblRepuestoCompra = new javax.swing.JLabel();
        dchRepuestoCompra = new com.toedter.calendar.JDateChooser();
        lblRepuestoKilometraje = new javax.swing.JLabel();
        txtRepuestoKilometraje = new javax.swing.JTextField();
        lblRepuestoTipo = new javax.swing.JLabel();
        btnRepuestoAñadir = new javax.swing.JButton();
        btnRepuestoLimpiar = new javax.swing.JButton();
        btnRepuestoModificar = new javax.swing.JButton();
        btnRepuestoEliminar = new javax.swing.JButton();
        lblBusquedaTablaRepuestoNombre = new javax.swing.JLabel();
        txtBusquedaTablaRepuestoNombre = new javax.swing.JTextField();
        scpRepuestos = new javax.swing.JScrollPane();
        tblRepuestos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtRepuesto2Kilometraje = new javax.swing.JTextField();
        lblRepuesto2Kilometraje = new javax.swing.JLabel();
        txtRepuesto3Kilometraje = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlRepuestosUso = new javax.swing.JPanel();
        lblRepuesto1Matricula = new javax.swing.JLabel();
        cmbRepuesto1Colectivos = new javax.swing.JComboBox<>();
        lblRepuesto1Compra = new javax.swing.JLabel();
        dchRepuesto1Compra = new com.toedter.calendar.JDateChooser();
        lblRepuesto1Kilometraje = new javax.swing.JLabel();
        txtRepuesto1Kilometraje = new javax.swing.JTextField();
        lblRepuesto1Tipo = new javax.swing.JLabel();
        btnRepuesto1Añadir = new javax.swing.JButton();
        btnRepuesto1Limpiar = new javax.swing.JButton();
        btnRepuesto1Modificar = new javax.swing.JButton();
        btnRepuesto1Eliminar = new javax.swing.JButton();
        lblBusquedaTablaRepuestoNombre1 = new javax.swing.JLabel();
        txtBusquedaTablaRepuestoNombre1 = new javax.swing.JTextField();
        scpRepuestos1 = new javax.swing.JScrollPane();
        tblRepuestos1 = new javax.swing.JTable();
        lblBusquedaTablaRepuestoNombre2 = new javax.swing.JLabel();
        txtBusquedaTablaRepuestoNombre2 = new javax.swing.JTextField();
        txtRepuesto4Kilometraje = new javax.swing.JTextField();
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
        txtEventoBeneficio = new javax.swing.JTextField();
        lblEventoID = new javax.swing.JLabel();
        lblEventoIDActual = new javax.swing.JLabel();
        pnlGanancias = new javax.swing.JPanel();
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

        txtColectivoKilometraje.setToolTipText("Solo números");
        txtColectivoKilometraje.setName("Kilometraje Actual"); // NOI18N
        txtColectivoKilometraje.setPreferredSize(new java.awt.Dimension(200, 22));

        lblColectivoMarca.setText("Marca:");

        txtColectivoMarca.setName("Marca"); // NOI18N
        txtColectivoMarca.setPreferredSize(new java.awt.Dimension(200, 22));

        lblColectivoVin.setText("Vin:");

        txtColectivoVin.setName("Vin"); // NOI18N
        txtColectivoVin.setPreferredSize(new java.awt.Dimension(200, 22));

        lblColectivoMotor.setText("Número de Motor:");

        txtColectivoMotor.setName("Número de Motor"); // NOI18N
        txtColectivoMotor.setPreferredSize(new java.awt.Dimension(200, 22));

        btnColectivoAñadir.setText("Añadir");

        lblBusquedaTablaColectivoMatricula.setText("Buscar Matricula:");

        txtBusquedaTablaColectivoMatricula.setPreferredSize(new java.awt.Dimension(200, 22));

        lblColectivo1Motor.setText("Conductor:");

        cmbColectivoConductores.setName("Conductor"); // NOI18N

        btnColectivoModificar.setText("Modificar");

        btnColectivoEliminar.setText("Eliminar");

        btnColectivoLimpiar.setText("Limpiar");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
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
                                .addGap(12, 12, 12)
                                .addComponent(txtColectivoKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
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
                            .addComponent(lblColectivoMatricula)
                            .addComponent(txtColectivoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dchColectivoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColectivoCompra))
                        .addGap(18, 18, 18)
                        .addGroup(pnlColectivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblColectivoKilometraje)
                            .addComponent(txtColectivoKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(lblColectivoMotor))))
                .addGap(58, 58, 58)
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

        btnConductorModificar.setText("Modificar");

        btnConductorEliminar.setText("Eliminar");

        lblBusquedaTablaConductorNombre.setText("Buscar Nombre:");

        txtBusquedaTablaConductorNombre.setPreferredSize(new java.awt.Dimension(200, 22));

        btnConductorLimpiar.setText("Limpiar");

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
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

        lblRepuestoCompra.setText("Fecha de Compra:");

        dchRepuestoCompra.setDateFormatString("yyyy-MM-dd");
        dchRepuestoCompra.setName("Fecha de Compra"); // NOI18N

        lblRepuestoKilometraje.setText("Kilometraje Máximo:");

        txtRepuestoKilometraje.setName("Kilometraje Máximo"); // NOI18N
        txtRepuestoKilometraje.setPreferredSize(new java.awt.Dimension(200, 22));

        lblRepuestoTipo.setText("Tipo Repuesto:");

        btnRepuestoAñadir.setText("Añadir");

        btnRepuestoLimpiar.setText("Limpiar");

        btnRepuestoModificar.setText("Modificar");

        btnRepuestoEliminar.setText("Eliminar");

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

        txtRepuesto2Kilometraje.setName("Kilometraje Máximo"); // NOI18N
        txtRepuesto2Kilometraje.setPreferredSize(new java.awt.Dimension(200, 22));

        lblRepuesto2Kilometraje.setText("Kilometraje Actual:");

        txtRepuesto3Kilometraje.setName("Kilometraje Máximo"); // NOI18N
        txtRepuesto3Kilometraje.setPreferredSize(new java.awt.Dimension(200, 22));

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
                        .addGap(21, 21, 21)
                        .addComponent(lblBusquedaTablaRepuestoNombre)
                        .addGap(6, 6, 6)
                        .addComponent(txtBusquedaTablaRepuestoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 375, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(59, 59, 59))
                    .addGroup(pnlRepuestosStockLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnRepuestoAñadir)
                        .addGap(18, 18, 18)
                        .addComponent(btnRepuestoLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRepuestoModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRepuestoEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlRepuestosStockLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlRepuestosStockLayout.createSequentialGroup()
                        .addComponent(lblRepuestoCompra)
                        .addGap(12, 12, 12)
                        .addComponent(dchRepuestoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRepuestosStockLayout.createSequentialGroup()
                        .addComponent(lblRepuestoTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRepuesto2Kilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestosStockLayout.createSequentialGroup()
                        .addComponent(lblRepuestoKilometraje)
                        .addGap(12, 12, 12)
                        .addComponent(txtRepuestoKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestosStockLayout.createSequentialGroup()
                        .addComponent(lblRepuesto2Kilometraje)
                        .addGap(12, 12, 12)
                        .addComponent(txtRepuesto3Kilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
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
                .addGap(12, 12, 12)
                .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRepuestosStockLayout.createSequentialGroup()
                        .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRepuestoTipo)
                            .addComponent(txtRepuesto2Kilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRepuestoCompra)
                            .addComponent(dchRepuestoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlRepuestosStockLayout.createSequentialGroup()
                        .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRepuestoKilometraje, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRepuestoKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRepuesto2Kilometraje)
                            .addComponent(txtRepuesto3Kilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRepuestoAñadir)
                    .addGroup(pnlRepuestosStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRepuestoEliminar)
                        .addComponent(btnRepuestoLimpiar)
                        .addComponent(btnRepuestoModificar)
                        .addComponent(jButton1)
                        .addComponent(jButton2)))
                .addGap(10, 10, 10))
        );

        Vista.addTab("Repuestos en Stock", pnlRepuestosStock);

        lblRepuesto1Matricula.setText("Matricula:");

        cmbRepuesto1Colectivos.setToolTipText("");
        cmbRepuesto1Colectivos.setName("Matricula"); // NOI18N

        lblRepuesto1Compra.setText("Fecha de Compra:");

        dchRepuesto1Compra.setDateFormatString("yyyy-MM-dd");
        dchRepuesto1Compra.setName("Fecha de Compra"); // NOI18N

        lblRepuesto1Kilometraje.setText("Kilometraje Máximo:");

        txtRepuesto1Kilometraje.setName("Kilometraje Máximo"); // NOI18N
        txtRepuesto1Kilometraje.setPreferredSize(new java.awt.Dimension(200, 22));

        lblRepuesto1Tipo.setText("Tipo Repuesto:");

        btnRepuesto1Añadir.setText("Añadir");

        btnRepuesto1Limpiar.setText("Limpiar");

        btnRepuesto1Modificar.setText("Modificar");

        btnRepuesto1Eliminar.setText("Eliminar");

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

        txtRepuesto4Kilometraje.setName("Kilometraje Máximo"); // NOI18N
        txtRepuesto4Kilometraje.setPreferredSize(new java.awt.Dimension(200, 22));

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
                                .addComponent(btnRepuesto1Añadir)
                                .addGap(18, 18, 18)
                                .addComponent(btnRepuesto1Limpiar)
                                .addGap(18, 18, 18)
                                .addComponent(btnRepuesto1Modificar)
                                .addGap(18, 18, 18)
                                .addComponent(btnRepuesto1Eliminar))
                            .addGroup(pnlRepuestosUsoLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(lblRepuesto1Matricula)
                                .addGap(12, 12, 12)
                                .addComponent(cmbRepuesto1Colectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
                                .addComponent(lblRepuesto1Kilometraje)
                                .addGap(12, 12, 12)
                                .addComponent(txtRepuesto1Kilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlRepuestosUsoLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblRepuesto1Tipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRepuesto4Kilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRepuesto1Compra)
                        .addGap(12, 12, 12)
                        .addComponent(dchRepuesto1Compra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlRepuestosUsoLayout.setVerticalGroup(
            pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRepuestosUsoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBusquedaTablaRepuestoNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBusquedaTablaRepuestoNombre2))
                    .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBusquedaTablaRepuestoNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBusquedaTablaRepuestoNombre1)))
                .addGap(18, 18, 18)
                .addComponent(scpRepuestos1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblRepuesto1Kilometraje, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtRepuesto1Kilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRepuesto1Matricula)
                        .addComponent(cmbRepuesto1Colectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRepuesto1Tipo)
                        .addComponent(txtRepuesto4Kilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblRepuesto1Compra)
                    .addComponent(dchRepuesto1Compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRepuesto1Añadir)
                    .addGroup(pnlRepuestosUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRepuesto1Eliminar)
                        .addComponent(btnRepuesto1Limpiar)
                        .addComponent(btnRepuesto1Modificar)))
                .addGap(10, 10, 10))
        );

        Vista.addTab("Repuestos en Uso", pnlRepuestosUso);

        pnlEventos.setPreferredSize(new java.awt.Dimension(776, 485));

        lblBusquedaTablaEventoFecha.setText("Buscar Fecha:");

        dchBusquedaTablaEventoFecha.setDateFormatString("yyyy-MM-dd");
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

        txtEventoBeneficio.setToolTipText("Sin digito Verificador");
        txtEventoBeneficio.setName("Beneficio"); // NOI18N
        txtEventoBeneficio.setPreferredSize(new java.awt.Dimension(200, 22));

        lblEventoID.setText("ID:");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
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
                                        .addGap(449, 449, 449)
                                        .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlEventosLayout.createSequentialGroup()
                                                .addComponent(lblEventoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEventoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnlEventosLayout.createSequentialGroup()
                                                .addComponent(lblEventoBeneficio)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEventoBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(pnlEventosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scpEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(txtEventoBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEventoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEventoBeneficio))
                .addGap(67, 67, 67)
                .addGroup(pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEventoAñadir)
                    .addComponent(btnEventoLimpiar)
                    .addComponent(btnEventoModificar)
                    .addComponent(btnEventoEliminar))
                .addGap(138, 138, 138))
        );

        Vista.addTab("Eventos", pnlEventos);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 697, Short.MAX_VALUE)
                .addComponent(btnAñadirKilometraje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addContainerGap())
            .addComponent(Vista, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Vista, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    public static javax.swing.JButton btnEventoEliminar;
    public static javax.swing.JButton btnEventoLimpiar;
    public static javax.swing.JButton btnEventoLimpiarBuscadores;
    public static javax.swing.JButton btnEventoModificar;
    public static javax.swing.JButton btnReDo;
    public static javax.swing.JButton btnRepuesto1Añadir;
    public static javax.swing.JButton btnRepuesto1Eliminar;
    public static javax.swing.JButton btnRepuesto1Limpiar;
    public static javax.swing.JButton btnRepuesto1Modificar;
    public static javax.swing.JButton btnRepuestoAñadir;
    public static javax.swing.JButton btnRepuestoEliminar;
    public static javax.swing.JButton btnRepuestoLimpiar;
    public static javax.swing.JButton btnRepuestoModificar;
    public static javax.swing.JButton btnSalir;
    public static javax.swing.JComboBox<String> cmbBusquedaTablaEventoTipo;
    public static javax.swing.JComboBox<String> cmbColectivoConductores;
    public static javax.swing.JComboBox<String> cmbConductorColectivos;
    public static javax.swing.JComboBox<String> cmbEventoTipo;
    public static javax.swing.JComboBox<String> cmbRepuesto1Colectivos;
    public static com.toedter.calendar.JDateChooser dchBusquedaTablaEventoFecha;
    public static com.toedter.calendar.JDateChooser dchColectivoCompra;
    public static com.toedter.calendar.JDateChooser dchEventoFecha;
    public static com.toedter.calendar.JDateChooser dchRepuesto1Compra;
    public static com.toedter.calendar.JDateChooser dchRepuestoCompra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblBusquedaTablaColectivoMatricula;
    private javax.swing.JLabel lblBusquedaTablaColectivoRut;
    private javax.swing.JLabel lblBusquedaTablaConductorNombre;
    private javax.swing.JLabel lblBusquedaTablaConductorRut;
    private javax.swing.JLabel lblBusquedaTablaEventoFecha;
    private javax.swing.JLabel lblBusquedaTablaEventoNombre;
    private javax.swing.JLabel lblBusquedaTablaEventoTipo;
    private javax.swing.JLabel lblBusquedaTablaRepuestoNombre;
    private javax.swing.JLabel lblBusquedaTablaRepuestoNombre1;
    private javax.swing.JLabel lblBusquedaTablaRepuestoNombre2;
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
    private javax.swing.JLabel lblRepuesto1Compra;
    private javax.swing.JLabel lblRepuesto1Kilometraje;
    private javax.swing.JLabel lblRepuesto1Matricula;
    private javax.swing.JLabel lblRepuesto1Tipo;
    private javax.swing.JLabel lblRepuesto2Kilometraje;
    private javax.swing.JLabel lblRepuestoCompra;
    private javax.swing.JLabel lblRepuestoKilometraje;
    private javax.swing.JLabel lblRepuestoTipo;
    private javax.swing.JPanel pnlColectivo;
    private javax.swing.JPanel pnlConductor;
    private javax.swing.JPanel pnlEventos;
    private javax.swing.JPanel pnlGanancias;
    private javax.swing.JPanel pnlRepuestosStock;
    private javax.swing.JPanel pnlRepuestosUso;
    private javax.swing.JScrollPane scpColectivos;
    private javax.swing.JScrollPane scpConductores;
    private javax.swing.JScrollPane scpEventos;
    private javax.swing.JScrollPane scpRepuestos;
    private javax.swing.JScrollPane scpRepuestos1;
    public static javax.swing.JTable tblColectivos;
    public static javax.swing.JTable tblConductores;
    public static javax.swing.JTable tblEventos;
    public static javax.swing.JTable tblRepuestos;
    public static javax.swing.JTable tblRepuestos1;
    public static javax.swing.JTextField txtBusquedaTablaColectivoMatricula;
    public static javax.swing.JTextField txtBusquedaTablaColectivoRut;
    public static javax.swing.JTextField txtBusquedaTablaConductorNombre;
    public static javax.swing.JTextField txtBusquedaTablaConductorRut;
    public static javax.swing.JTextField txtBusquedaTablaEventoNombre;
    public static javax.swing.JTextField txtBusquedaTablaRepuestoNombre;
    public static javax.swing.JTextField txtBusquedaTablaRepuestoNombre1;
    public static javax.swing.JTextField txtBusquedaTablaRepuestoNombre2;
    public static javax.swing.JTextField txtColectivoKilometraje;
    public static javax.swing.JTextField txtColectivoMarca;
    public static javax.swing.JTextField txtColectivoMatricula;
    public static javax.swing.JTextField txtColectivoMotor;
    public static javax.swing.JTextField txtColectivoVin;
    public static javax.swing.JTextField txtConductorDireccion;
    public static javax.swing.JTextField txtConductorNombre;
    public static javax.swing.JTextField txtConductorRut;
    public static javax.swing.JTextField txtConductorTelefono;
    public static javax.swing.JTextField txtEventoBeneficio;
    public static javax.swing.JTextField txtEventoNombre;
    public static javax.swing.JTextField txtRepuesto1Kilometraje;
    public static javax.swing.JTextField txtRepuesto2Kilometraje;
    public static javax.swing.JTextField txtRepuesto3Kilometraje;
    public static javax.swing.JTextField txtRepuesto4Kilometraje;
    public static javax.swing.JTextField txtRepuestoKilometraje;
    // End of variables declaration//GEN-END:variables
}