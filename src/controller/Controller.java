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
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Colectivo;
import model.Conductor;
import model.Repuesto;

public class Controller implements ActionListener, MouseListener, KeyListener{
    private View v;
    private Model m;
    
    private Colectivo colectivo;
    private Conductor conductor;
    private Repuesto repuesto;
    
    boolean validoEmpty = true;
    boolean validoFormato = true;
    
    private List<Object> inputColectivo = new ArrayList<Object>();
    private List<Object> inputConductor = new ArrayList<Object>();
    private List<Object> inputRepuesto = new ArrayList<Object>();
    private List<Object> buscadorColectivo = new ArrayList<Object>();
    private List<Object> buscadorConductor = new ArrayList<Object>();
    private List<Object> buscadorRepuesto = new ArrayList<Object>();

    //LISTENERS
    public Controller(Model model, View view) {
        this.v = view;
        this.m = model;
        
        //GENERALES
        this.v.btnSalir.addActionListener(this);
        this.v.btnAñadirKilometraje.addActionListener(this);
        
        //BUSCADORES
        this.v.txtBusquedaTablaColectivosMatricula.addKeyListener(this);
        this.v.txtBusquedaTablaColectivosRut.addKeyListener(this);
        this.v.txtBusquedaTablaConductorNombre.addKeyListener(this);
        this.v.txtBusquedaTablaConductorRut.addKeyListener(this);
        
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
        this.v.btnLimpiarBuscadoresConductor.addActionListener(this);
        this.v.tblConductores.addMouseListener(this);
        
        //REPUESTO
        this.v.btnAñadirRepuesto.addActionListener(this);
        this.v.btnLimpiarRepuesto.addActionListener(this);
        this.v.btnModificarRepuesto.addActionListener(this);
        this.v.btnEliminarRepuesto.addActionListener(this);
        
        //EVENTO
    }
    
    //AÑADIR A LAS LISTAS
    public void iniciar(){
        v.pack();
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setLocationRelativeTo(null);
        v.setVisible(true);
        
        //AÑADIR A LAS LISTAS
        //COLECTIVO
        inputColectivo.add(v.txtMatriculaColectivo);
        inputColectivo.add(v.cmbConductoresColectivo);
        inputColectivo.add(v.dchCompraColectivo);
        inputColectivo.add(v.txtKilometrajeColectivo);
        inputColectivo.add(v.txtMarcaColectivo);
        inputColectivo.add(v.txtVinColectivo);
        inputColectivo.add(v.txtMotorColectivo);
        
        buscadorColectivo.add(v.txtBusquedaTablaColectivosMatricula);
        buscadorColectivo.add(v.txtBusquedaTablaColectivosRut);
        
        //CONDUCTOR
        inputConductor.add(v.txtRutConductor);
        inputConductor.add(v.cmbColectivosConductor);
        inputConductor.add(v.txtNombreConductor);
        inputConductor.add(v.txtDireccionConductor);
        inputConductor.add(v.txtTelefonoConductor);
        
        buscadorConductor.add(v.txtBusquedaTablaConductorNombre);
        buscadorConductor.add(v.txtBusquedaTablaConductorRut);
        
        //REPUESTO
        inputRepuesto.add(v.cmbMatriculaRepuesto);
        inputRepuesto.add(v.txtKilometrajeRepuesto);
        inputRepuesto.add(v.cmbTipoRepuesto);
        inputRepuesto.add(v.dchCompraRepuesto);
        
        
        //CREAR OBJETOS
        colectivo = m.crearColectivo(inputColectivo);
        conductor = m.crearConductor(inputColectivo);
        repuesto = m.crearRepuesto(inputColectivo);
        
        m.refrescar();
        /*
        colectivo.conectarTabla(conductor);
        colectivo.conectarTabla(repuesto);
        
        conductor.conectarTabla(colectivo);
        conductor.conectarTabla(repuesto);
        
        repuesto.conectarTabla(colectivo);
        repuesto.conectarTabla(conductor);
        */
    }
    
    //VALIDACIONES
    //TRUE = Es valido, FALSE = No es valido
    public boolean validarEmpty(List<Object> inputList){
        JTextField tf = null;
        JDateChooser dc = null;
        String elementosVacios = "";
        
        for (Object input : inputList) {
            if (input instanceof JTextField) {
                tf = (JTextField) input;
                if (tf.getText().strip().equals("")) {
                    elementosVacios += "\n" + tf.getName();
                }
            }
            if (input instanceof JDateChooser) {
                dc = (JDateChooser) input;
                if (dc.getDate() == null){
                    elementosVacios += "\n" + dc.getName();
                }
            }
        }
        if (elementosVacios.equals("")) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Ingrese datos en todos los campos:" + elementosVacios);
        return false;
    }
    
    public boolean validarRut(){
        if(!Pattern.matches("^[0-9]+-[0-9kK]{1}$", v.txtRutConductor.getText().strip()) || !(v.txtRutConductor.getText().strip().length() >= 9)){
            if (!(v.txtRutConductor.getText().strip().equals(""))) {
                JOptionPane.showMessageDialog(null, "Ingrese el formato valido en Rut.\n(Coloque el mouse encima de este campo para ver el formato).");
            }
            return false;
        }
        String rut = v.txtRutConductor.getText().strip().toUpperCase();
        int suma = 0;
        char digitoV = 0;
        int i = 2;
        for (char digito : new StringBuilder(rut).reverse().substring(2).toString().toCharArray()) {
            suma += i * (digito - '0');
            i++;
            if (i == 8) {
                i = 2;
            }
        }
        digitoV = (char) (11 - (suma - suma / 11 * 11));
        switch (digitoV) {
            case 10:
                digitoV = 'K';
            break;
            case 11:
                digitoV = '0';
            break;
            default:
                digitoV += '0';
        }
        if(rut.charAt(rut.length()-1) != digitoV){
            JOptionPane.showMessageDialog(null, "Rut no valido.");
            return false;
        }
        return true;
    }
    
    public boolean validarRegEx(JTextField input, String regex, String campo){
        if(!Pattern.matches(regex, input.getText().strip())){
            if (!(input.getText().strip().equals(""))) {
                JOptionPane.showMessageDialog(null, "Ingrese el formato valido en " + campo + ".\n(Coloque el mouse encima de este campo para ver el formato).");
            }
            return false;
        }
        return true;
    }
    
    //ACCIONES GENERALES
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
            validoFormato = validarRegEx(v.txtMatriculaColectivo, "[0-9a-zA-Z]{6}", "Matricula") && validarRegEx(v.txtKilometrajeColectivo, "^\\d*$", "Kilometraje");
            if (validoFormato && validoEmpty) {
                colectivo.insertar();
            }
        }
        if (e == v.btnLimpiarColectivo) {
            limpiarInput(inputColectivo);
        }
        if (e == v.btnModificarColectivo) {
            validoEmpty = validarEmpty(inputColectivo);
            validoFormato = validarRegEx(v.txtMatriculaColectivo, "[0-9a-zA-Z]{6}", "Matricula");
            if (validoFormato && validoEmpty) {
                //m.modificarColectivo();
                colectivo.modificar();
            }
        }
        if (e == v.btnEliminarColectivo) {
            validoEmpty = validarEmpty(inputColectivo);
            validoFormato = validarRegEx(v.txtMatriculaColectivo, "[0-9a-zA-Z]{6}", "Matricula");
            if (validoFormato && validoEmpty) {
                //m.eliminarColectivo();
                colectivo.eliminar();
            }
        }
        
        //CONDUCTOR
        if (e == v.btnAñadirConductor) {
            validoEmpty = validarEmpty(inputConductor);
            validoFormato = validarRut() && validarRegEx(v.txtTelefonoConductor, "^\\+\\d+$", "Telefono");
            if (validoEmpty && validoFormato) {
                conductor.insertar();
            }
        }
        if (e == v.btnLimpiarConductor) {
            limpiarInput(inputConductor);
        }
        if (e == v.btnModificarConductor) {
            validoEmpty = validarEmpty(inputConductor);
            validoFormato = validarRut() && validarRegEx(v.txtTelefonoConductor, "^\\+\\d+$", "Telefono");
            if (validoEmpty && validoFormato) {
                conductor.modificar();
            }
        }
        if (e == v.btnEliminarConductor) {
            validoEmpty = validarEmpty(inputConductor);
            validoFormato = validarRut() && validarRegEx(v.txtTelefonoConductor, "^\\+\\d+$", "Telefono");
            if (validoEmpty && validoFormato) {
                conductor.eliminar();
            }
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
            limpiarInput(buscadorColectivo);
        }
        if (e == v.btnLimpiarBuscadoresConductor) {
            limpiarInput(buscadorConductor);
        }
        m.refrescar();
    }

    @Override
    public void mouseClicked(MouseEvent evt){
        Object e = evt.getSource();
        
        if (e == v.tblColectivos) {
            m.consultarValores(v.tblColectivos, inputColectivo);
        }
        if (e == v.tblConductores) {
            m.consultarValores(v.tblConductores, inputConductor);
        }
    }
    
    @Override
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
