package view;

import javax.swing.JFrame;

public class GananciaView extends javax.swing.JFrame {
    public GananciaView() {
        initComponents();
    }
    public void iniciar(){
        setTitle("Ganancias");
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGananciaFecha = new javax.swing.JLabel();
        dchGananciaFecha = new com.toedter.calendar.JDateChooser();
        lblGananciaMatricula = new javax.swing.JLabel();
        cmbGananciaMatricula = new javax.swing.JComboBox<>();
        lblGananciaGanancia = new javax.swing.JLabel();
        spnGananciaGanancia = new javax.swing.JSpinner();
        btnModificar = new javax.swing.JButton();
        btnRestablecer = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblGananciaFecha.setText("Fecha:");

        dchGananciaFecha.setDateFormatString("yyyy-MM-dd");

        lblGananciaMatricula.setText("Matricula:");

        lblGananciaGanancia.setText("Ganancia:");

        spnGananciaGanancia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9999999, 1));

        btnModificar.setText("Modificar");

        btnRestablecer.setText("Restablecer");

        btnEliminar.setText("Eliminar");

        btnSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblGananciaGanancia)
                        .addGap(7, 7, 7)
                        .addComponent(spnGananciaGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGananciaMatricula)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblGananciaFecha)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dchGananciaFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbGananciaMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(btnRestablecer)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(106, 106, 106)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dchGananciaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGananciaFecha))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGananciaMatricula)
                    .addComponent(lblGananciaMatricula))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnGananciaGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGananciaGanancia))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnRestablecer)
                    .addComponent(btnSalir))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnRestablecer;
    public javax.swing.JButton btnSalir;
    public javax.swing.JComboBox<String> cmbGananciaMatricula;
    public com.toedter.calendar.JDateChooser dchGananciaFecha;
    private javax.swing.JLabel lblGananciaFecha;
    private javax.swing.JLabel lblGananciaGanancia;
    private javax.swing.JLabel lblGananciaMatricula;
    public javax.swing.JSpinner spnGananciaGanancia;
    // End of variables declaration//GEN-END:variables
}
