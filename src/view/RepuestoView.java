package view;

import javax.swing.JFrame;

public class RepuestoView extends javax.swing.JFrame {
    public RepuestoView() {
        initComponents();
    }
    
    public void iniciar(){
        setTitle("Modificar Conductor");
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRepuestoTipo = new javax.swing.JLabel();
        txtRepuestoTipo = new javax.swing.JTextField();
        lblRepuestoCambio = new javax.swing.JLabel();
        dchRepuestoCambio = new com.toedter.calendar.JDateChooser();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblRepuestoColectivos = new javax.swing.JLabel();
        cmbRepuestoColectivos = new javax.swing.JComboBox<>();
        lblRepuestoKilometrajeUsado = new javax.swing.JLabel();
        spnRepuestoKilometrajeActual = new javax.swing.JSpinner();
        lblRepuestoKilometrajeMax = new javax.swing.JLabel();
        spnRepuestoKilometrajeMax = new javax.swing.JSpinner();
        btnSalir = new javax.swing.JButton();
        btnRestablecer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRepuestoTipo.setText("Tipo Repuesto:");

        txtRepuestoTipo.setToolTipText("Solo letras y números");
        txtRepuestoTipo.setName("Kilometraje Máximo"); // NOI18N
        txtRepuestoTipo.setPreferredSize(new java.awt.Dimension(200, 22));

        lblRepuestoCambio.setText("Fecha de Cambio:");

        dchRepuestoCambio.setDateFormatString("yyyy-MM-dd");
        dchRepuestoCambio.setName("Fecha de Compra"); // NOI18N

        btnModificar.setText("Modificar");

        btnEliminar.setText("Eliminar");

        lblRepuestoColectivos.setText("Matricula:");

        cmbRepuestoColectivos.setToolTipText("");
        cmbRepuestoColectivos.setName("Matricula"); // NOI18N

        lblRepuestoKilometrajeUsado.setText("Kilometraje Actual:");

        spnRepuestoKilometrajeActual.setModel(new javax.swing.SpinnerNumberModel(0, 0, 0, 1));

        lblRepuestoKilometrajeMax.setText("Kilometraje Máximo:");

        spnRepuestoKilometrajeMax.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9999999, 1));

        btnSalir.setText("Salir");

        btnRestablecer.setText("Restablecer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRestablecer)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRepuestoCambio)
                            .addComponent(lblRepuestoTipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dchRepuestoCambio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRepuestoTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRepuestoColectivos)
                        .addGap(69, 69, 69)
                        .addComponent(cmbRepuestoColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblRepuestoKilometrajeMax)
                                .addComponent(lblRepuestoKilometrajeUsado))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(spnRepuestoKilometrajeMax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(spnRepuestoKilometrajeActual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRepuestoKilometrajeMax)
                            .addComponent(spnRepuestoKilometrajeMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRepuestoKilometrajeUsado)
                            .addComponent(spnRepuestoKilometrajeActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRepuestoTipo)
                            .addComponent(txtRepuestoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRepuestoCambio)
                            .addComponent(dchRepuestoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRepuestoColectivos)
                    .addComponent(cmbRepuestoColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar)
                    .addComponent(btnSalir)
                    .addComponent(btnRestablecer))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnRestablecer;
    public javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cmbRepuestoColectivos;
    public com.toedter.calendar.JDateChooser dchRepuestoCambio;
    private javax.swing.JLabel lblRepuestoCambio;
    private javax.swing.JLabel lblRepuestoColectivos;
    private javax.swing.JLabel lblRepuestoKilometrajeMax;
    private javax.swing.JLabel lblRepuestoKilometrajeUsado;
    private javax.swing.JLabel lblRepuestoTipo;
    public javax.swing.JSpinner spnRepuestoKilometrajeActual;
    public javax.swing.JSpinner spnRepuestoKilometrajeMax;
    public javax.swing.JTextField txtRepuestoTipo;
    // End of variables declaration//GEN-END:variables
}
