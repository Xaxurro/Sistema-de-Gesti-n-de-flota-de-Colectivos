package view;

import javax.swing.JFrame;

public class ColectivoView extends javax.swing.JFrame {    
    public ColectivoView(){
        initComponents();
    }
    
    public void iniciar(){
        setTitle("Modificar Colectivo");
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblColectivoMatricula = new javax.swing.JLabel();
        txtColectivoMatricula = new javax.swing.JTextField();
        lblColectivoCompra = new javax.swing.JLabel();
        dchColectivoCompra = new com.toedter.calendar.JDateChooser();
        lblColectivoKilometraje = new javax.swing.JLabel();
        spnColectivoKilometraje = new javax.swing.JSpinner();
        lblColectivoMarca = new javax.swing.JLabel();
        txtColectivoMarca = new javax.swing.JTextField();
        lblColectivoVin = new javax.swing.JLabel();
        txtColectivoVin = new javax.swing.JTextField();
        lblColectivoMotor = new javax.swing.JLabel();
        txtColectivoMotor = new javax.swing.JTextField();
        btnColectivoModificar = new javax.swing.JButton();
        btnRestablecer = new javax.swing.JButton();
        btnColectivoEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblColectivo1Motor = new javax.swing.JLabel();
        cmbColectivoConductores = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblColectivoMatricula.setText("Matricula:");

        txtColectivoMatricula.setToolTipText("Sin digito Verificador");
        txtColectivoMatricula.setName("Matricula"); // NOI18N
        txtColectivoMatricula.setPreferredSize(new java.awt.Dimension(200, 22));

        lblColectivoCompra.setText("Fecha de Compra:");

        dchColectivoCompra.setDateFormatString("yyyy-MM-dd");
        dchColectivoCompra.setName("Fecha de Compra"); // NOI18N

        lblColectivoKilometraje.setText("Kilometraje Actual:");

        spnColectivoKilometraje.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        lblColectivoMarca.setText("Marca:");

        txtColectivoMarca.setName("Marca"); // NOI18N
        txtColectivoMarca.setPreferredSize(new java.awt.Dimension(200, 22));

        lblColectivoVin.setText("Vin:");

        txtColectivoVin.setName("Vin"); // NOI18N
        txtColectivoVin.setPreferredSize(new java.awt.Dimension(200, 22));

        lblColectivoMotor.setText("Número de Motor:");

        txtColectivoMotor.setName("Número de Motor"); // NOI18N
        txtColectivoMotor.setPreferredSize(new java.awt.Dimension(200, 22));

        btnColectivoModificar.setText("Modificar");

        btnRestablecer.setText("Restablecer");

        btnColectivoEliminar.setText("Eliminar");

        btnSalir.setText("Salir");

        lblColectivo1Motor.setText("Conductor:");

        cmbColectivoConductores.setName("Conductor"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(363, 363, 363)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblColectivoVin)
                    .addComponent(lblColectivoMarca))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblColectivoMatricula)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblColectivoKilometraje, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblColectivoCompra)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtColectivoMatricula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dchColectivoCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnColectivoKilometraje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblColectivo1Motor)
                            .addComponent(lblColectivoMotor))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtColectivoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtColectivoMarca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtColectivoVin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbColectivoConductores, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnColectivoModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRestablecer)
                        .addGap(18, 18, 18)
                        .addComponent(btnColectivoEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblColectivoMatricula)
                            .addComponent(txtColectivoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dchColectivoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColectivoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnColectivoKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColectivoKilometraje)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblColectivoMarca)
                            .addComponent(txtColectivoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblColectivoVin)
                            .addComponent(txtColectivoVin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtColectivoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColectivoMotor))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColectivo1Motor)
                    .addComponent(cmbColectivoConductores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnColectivoModificar)
                    .addComponent(btnRestablecer)
                    .addComponent(btnColectivoEliminar)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnColectivoEliminar;
    public javax.swing.JButton btnColectivoModificar;
    public javax.swing.JButton btnRestablecer;
    public javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cmbColectivoConductores;
    public com.toedter.calendar.JDateChooser dchColectivoCompra;
    private javax.swing.JLabel lblColectivo1Motor;
    private javax.swing.JLabel lblColectivoCompra;
    private javax.swing.JLabel lblColectivoKilometraje;
    private javax.swing.JLabel lblColectivoMarca;
    private javax.swing.JLabel lblColectivoMatricula;
    private javax.swing.JLabel lblColectivoMotor;
    private javax.swing.JLabel lblColectivoVin;
    public javax.swing.JSpinner spnColectivoKilometraje;
    public javax.swing.JTextField txtColectivoMarca;
    public javax.swing.JTextField txtColectivoMatricula;
    public javax.swing.JTextField txtColectivoMotor;
    public javax.swing.JTextField txtColectivoVin;
    // End of variables declaration//GEN-END:variables
}
