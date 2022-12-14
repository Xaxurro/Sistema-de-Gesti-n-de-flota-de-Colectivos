package view;

import javax.swing.JFrame;

public class ConductorView extends javax.swing.JFrame {
    public ConductorView() {
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

        lblConductorRut = new javax.swing.JLabel();
        txtConductorRut = new javax.swing.JTextField();
        lblConductorNombre = new javax.swing.JLabel();
        txtConductorNombre = new javax.swing.JTextField();
        lblConductorDireccion = new javax.swing.JLabel();
        txtConductorDireccion = new javax.swing.JTextField();
        lblConductorTelefono = new javax.swing.JLabel();
        txtConductorTelefono = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblConductorColectivos = new javax.swing.JLabel();
        cmbConductorColectivos = new javax.swing.JComboBox<>();
        btnRestablecer = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblConductorRut.setText("RUT:");

        txtConductorRut.setToolTipText("Siga el formato 12345678-9");
        txtConductorRut.setName("Rut"); // NOI18N
        txtConductorRut.setPreferredSize(new java.awt.Dimension(200, 22));

        lblConductorNombre.setText("Nombre Completo:");

        txtConductorNombre.setToolTipText("Solo letras");
        txtConductorNombre.setName("Nombre"); // NOI18N
        txtConductorNombre.setPreferredSize(new java.awt.Dimension(100, 22));

        lblConductorDireccion.setText("Direccion:");

        txtConductorDireccion.setToolTipText("");
        txtConductorDireccion.setName("Dirección"); // NOI18N
        txtConductorDireccion.setPreferredSize(new java.awt.Dimension(200, 22));

        lblConductorTelefono.setText("Telefono:");

        txtConductorTelefono.setToolTipText("Siga el formato +12345678901");
        txtConductorTelefono.setName("Teléfono"); // NOI18N
        txtConductorTelefono.setPreferredSize(new java.awt.Dimension(200, 22));

        btnModificar.setText("Modificar");

        btnEliminar.setText("Eliminar");

        lblConductorColectivos.setText("Colectivo:");

        btnRestablecer.setText("Restablecer");

        btnSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblConductorRut)
                            .addComponent(lblConductorNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConductorRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConductorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblConductorDireccion)
                            .addComponent(lblConductorTelefono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConductorDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConductorTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRestablecer)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblConductorColectivos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbConductorColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblConductorRut)
                            .addComponent(txtConductorRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblConductorNombre)
                            .addComponent(txtConductorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblConductorDireccion)
                            .addComponent(txtConductorDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblConductorTelefono)
                            .addComponent(txtConductorTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbConductorColectivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConductorColectivos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar)
                        .addComponent(btnSalir))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar)
                        .addComponent(btnRestablecer)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnRestablecer;
    public javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cmbConductorColectivos;
    private javax.swing.JLabel lblConductorColectivos;
    private javax.swing.JLabel lblConductorDireccion;
    private javax.swing.JLabel lblConductorNombre;
    private javax.swing.JLabel lblConductorRut;
    private javax.swing.JLabel lblConductorTelefono;
    public javax.swing.JTextField txtConductorDireccion;
    public javax.swing.JTextField txtConductorNombre;
    public javax.swing.JTextField txtConductorRut;
    public javax.swing.JTextField txtConductorTelefono;
    // End of variables declaration//GEN-END:variables
}
