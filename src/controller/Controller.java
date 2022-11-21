package controller;

import com.toedter.calendar.JDateChooser;
import view.View;
import model.Model;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Controller implements ActionListener, MouseListener, KeyListener{
    private View v;
    private Model m;
    
    boolean validoEmpty = true;
    boolean validoFormato = true;
    
    private List<Object> inputColectivo = new ArrayList<Object>();
    private List<Object> inputConductor = new ArrayList<Object>();
    private List<Object> inputRepuesto = new ArrayList<Object>();
    private List<Object> buscadorColectivo = new ArrayList<Object>();
    private List<Object> buscadorConductor = new ArrayList<Object>();
    private List<Object> buscadorRepuesto = new ArrayList<Object>();

    public Controller(Model model, View view) {
        this.v = view;
        this.m = model;
        
        //LISTENERS
        //GENERALES
        this.v.btnSalir.addActionListener(this);
        this.v.btnAñadirKilometraje.addActionListener(this);
        
        //BUSCADORES
        this.v.txtBusquedaTablaColectivosMatricula.addKeyListener(this);
        this.v.txtBusquedaTablaColectivosRut.addKeyListener(this);
        
        //DEBUG (BORRAR)
        this.v.btnReDo.addActionListener(this);
        
        //COLECTIVO
        this.v.btnAñadirColectivo.addActionListener(this);
        this.v.btnLimpiarColectivo.addActionListener(this);
        this.v.btnModificarColectivo.addActionListener(this);
        this.v.btnEliminarColectivo.addActionListener(this);
        this.v.btnLimpiarBuscadoresColectivo.addActionListener(this);
        this.v.tblColectivos.addMouseListener(this);
        
        //CONDUCTOR
        this.v.btnAñadirConductor.addActionListener(this);
        this.v.btnLimpiarConductor.addActionListener(this);
        this.v.btnModificarConductor.addActionListener(this);
        this.v.btnEliminarConductor.addActionListener(this);
        
        //REPUESTO
        this.v.btnAñadirRepuesto.addActionListener(this);
        this.v.btnLimpiarRepuesto.addActionListener(this);
        this.v.btnModificarRepuesto.addActionListener(this);
        this.v.btnEliminarRepuesto.addActionListener(this);
        
        //EVENTO
    }
    
    public void iniciar(){
        v.pack();
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setLocationRelativeTo(null);
        v.setVisible(true);
        
        //AÑADIR A LAS LISTAS
        //COLECTIVO
        inputColectivo.add(v.txtMatriculaColectivo);
        inputColectivo.add(v.cmbConductoresColectivos);
        inputColectivo.add(v.dchCompraColectivo);
        inputColectivo.add(v.dchSeguroColectivo);
        inputColectivo.add(v.dchRevisionColectivo);
        inputColectivo.add(v.txtKilometrajeColectivo);
        inputColectivo.add(v.txtMarcaColectivo);
        inputColectivo.add(v.txtVinColectivo);
        inputColectivo.add(v.txtMotorColectivo);
        
        buscadorColectivo.add(v.txtBusquedaTablaColectivosMatricula);
        buscadorColectivo.add(v.txtBusquedaTablaColectivosRut);
        
        //CONDUCTOR
        inputConductor.add(v.txtRutConductor);
        inputConductor.add(v.txtDireccionConductor);
        inputConductor.add(v.txtNombreConductor);
        inputConductor.add(v.txtTelefonoConductor);
        
        //REPUESTO
        inputRepuesto.add(v.cmbMatriculaRepuesto);
        inputRepuesto.add(v.txtKilometrajeRepuesto);
        inputRepuesto.add(v.cmbTipoRepuesto);
        inputRepuesto.add(v.dchCompraRepuesto);
    }
    
    //TRUE = Es valido, FALSE = No es valido
    public boolean validarEmpty(List<Object> inputList){
        JTextField tf = null;
        JDateChooser dc = null;
        
        for (Object input : inputList) {
            if (input instanceof JTextField) {
                tf = (JTextField) input;
                if (tf.getText().strip().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ingrese datos en todos los campos.");
                    return false;
                }
            }
            if (input instanceof JDateChooser) {
                dc = (JDateChooser) input;
                if (dc.getDate() == null){
                    JOptionPane.showMessageDialog(null, "Ingrese datos en todos los campos.");
                    return false;
                }
            }
        }
        return true;
    }
    
    public void limpiarInput(List<Object> inputList){
        JComboBox cb = null;
        JTextField tf = null;
        JDateChooser dc = null;
        
        for (Object input : inputList){
            if (input instanceof JTextField) {
                tf = (JTextField) input;
                tf.setText("");
            }
            if (input instanceof JDateChooser) {
                dc = (JDateChooser) input;
                dc.setDate(null);
            }
            if (input instanceof JComboBox) {
                cb = (JComboBox) input;
                cb.setSelectedIndex(0);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        Object e = evt.getSource();
        //GENERAL
        if (e == v.btnSalir) {
            System.exit(0);
        }
        if (e == v.btnAñadirKilometraje) {
            
        }
        if (e == v.btnReDo) {
            m.eliminarDB();
            m.crearDB();
        }
        
        //COLECTIVO
        if (e == v.btnAñadirColectivo) {
            validoEmpty = validarEmpty(inputColectivo);
            validoFormato = v.txtMatriculaColectivo.getText().strip().length() == 6;
            if (validoFormato && validoEmpty) {
                m.insertarColectivo();
            }
        }
        if (e == v.btnLimpiarColectivo) {
            limpiarInput(inputColectivo);
        }
        if (e == v.btnModificarColectivo) {
            validoEmpty = validarEmpty(inputColectivo);
            validoFormato = v.txtMatriculaColectivo.getText().strip().length() == 6;
            if (validoFormato && validoEmpty) {
                m.modificarColectivo();
            }
        }
        if (e == v.btnEliminarColectivo) {
            validoEmpty = validarEmpty(inputColectivo);
            validoFormato = v.txtMatriculaColectivo.getText().strip().length() == 6;
            if (validoFormato && validoEmpty) {
                m.eliminarColectivo();
            }
        }
        
        //CONDUCTOR
        if (e == v.btnAñadirConductor) {
            
        }
        if (e == v.btnLimpiarConductor) {
            
        }
        if (e == v.btnModificarConductor) {
            
        }
        if (e == v.btnEliminarConductor) {
            
        }
        
        //REPUESTO
        if (e == v.btnAñadirRepuesto) {
            
        }
        if (e == v.btnLimpiarRepuesto) {
            
        }
        if (e == v.btnModificarRepuesto) {
            
        }
        if (e == v.btnEliminarRepuesto) {
            
        }
        
        //LIMPIAR BUSCADORES
        if (e == v.btnLimpiarBuscadoresColectivo) {
            
        }
        if (e == v.btnLimpiarBuscadoresConductor) {
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt){
        Object e = evt.getSource();
        
        if (e == v.tblColectivos) {
            m.consultar(v.tblColectivos, v.tblColectivos.getSelectedRow(), inputColectivo);
        }
    }
    
    public void keyReleased (KeyEvent evt){
        m.refrescar();
    }
    
    public void mousePressed(MouseEvent eve){};
    public void mouseReleased(MouseEvent eve){};
    public void mouseEntered(MouseEvent eve){};
    public void mouseExited(MouseEvent eve){};
    public void keyPressed (KeyEvent e){}
    public void keyTyped (KeyEvent e){};    
}
