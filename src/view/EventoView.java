package view;

public class EventoView extends javax.swing.JFrame {
    public EventoView() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEventoFecha = new javax.swing.JLabel();
        dchEventoFecha = new com.toedter.calendar.JDateChooser();
        lblEventoTipo = new javax.swing.JLabel();
        cmbEventoTipo = new javax.swing.JComboBox<>();
        lblEventoNombre = new javax.swing.JLabel();
        txtEventoNombre = new javax.swing.JTextField();
        lblEventoBeneficio = new javax.swing.JLabel();
        spnEventoBeneficio = new javax.swing.JSpinner();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRestablecer = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        scpColectivos = new javax.swing.JScrollPane();
        lstColectivosImplicados = new javax.swing.JList<>();
        lblAñadirColectivos = new javax.swing.JLabel();
        cmbColectivos = new javax.swing.JComboBox<>();
        btnAñadirColectivo = new javax.swing.JButton();
        lblDescripcion = new javax.swing.JLabel();
        scpDescripcion = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblEventoFecha.setText("Fecha:");

        dchEventoFecha.setDateFormatString("yyyy-MM-dd");
        dchEventoFecha.setName("Fecha"); // NOI18N

        lblEventoTipo.setText("Tipo:");

        cmbEventoTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Otro", "Robo", "Accidente", "Renovacion" }));
        cmbEventoTipo.setToolTipText("");
        cmbEventoTipo.setName("Matricula"); // NOI18N

        lblEventoNombre.setText("Nombre:");

        txtEventoNombre.setToolTipText("Sin digito Verificador");
        txtEventoNombre.setName("Nombre"); // NOI18N
        txtEventoNombre.setPreferredSize(new java.awt.Dimension(200, 22));

        lblEventoBeneficio.setText("Beneficio:");

        spnEventoBeneficio.setModel(new javax.swing.SpinnerNumberModel(0, -9999999, 9999999, 1));

        btnModificar.setText("Modificar");

        btnEliminar.setText("Eliminar");

        btnRestablecer.setText("Restablecer");

        btnSalir.setText("Eliminar");

        scpColectivos.setViewportView(lstColectivosImplicados);

        lblAñadirColectivos.setText("Colectivo:");

        btnAñadirColectivo.setText("Añadir Colectivo");

        lblDescripcion.setText("Descripcion:");

        txaDescription.setColumns(30);
        txaDescription.setRows(5);
        scpDescripcion.setViewportView(txaDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRestablecer)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAñadirColectivos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAñadirColectivo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbColectivos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblEventoBeneficio)
                                .addComponent(lblEventoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEventoTipo)
                                .addComponent(lblEventoFecha))
                            .addGap(143, 143, 143)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(txtEventoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEventoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dchEventoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(spnEventoBeneficio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(54, 54, 54))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblDescripcion)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scpDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dchEventoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEventoFecha))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEventoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEventoTipo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEventoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEventoNombre))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnEventoBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEventoBeneficio)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAñadirColectivos)
                            .addComponent(cmbColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAñadirColectivo)
                        .addGap(18, 18, 18)
                        .addComponent(scpColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)
                            .addComponent(btnRestablecer)
                            .addComponent(btnSalir)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scpDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescripcion))
                        .addGap(0, 94, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAñadirColectivo;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnRestablecer;
    public javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbColectivos;
    public javax.swing.JComboBox<String> cmbEventoTipo;
    public com.toedter.calendar.JDateChooser dchEventoFecha;
    private javax.swing.JLabel lblAñadirColectivos;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEventoBeneficio;
    private javax.swing.JLabel lblEventoFecha;
    private javax.swing.JLabel lblEventoNombre;
    private javax.swing.JLabel lblEventoTipo;
    public javax.swing.JList<String> lstColectivosImplicados;
    private javax.swing.JScrollPane scpColectivos;
    private javax.swing.JScrollPane scpDescripcion;
    public javax.swing.JSpinner spnEventoBeneficio;
    private javax.swing.JTextArea txaDescription;
    public javax.swing.JTextField txtEventoNombre;
    // End of variables declaration//GEN-END:variables
}
