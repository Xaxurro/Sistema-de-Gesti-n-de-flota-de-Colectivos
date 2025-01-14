package controller;

import com.toedter.calendar.JDateChooser;
import view.View;
import model.Model;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.Colectivo;
import model.Conductor;
import model.Repuesto;
import model.Evento;

public class Controller implements ActionListener, MouseListener, KeyListener, PropertyChangeListener, ItemListener, ChangeListener{
    private View v;
    private Model m;
    
    private Colectivo colectivo;
    private Conductor conductor;
    private Repuesto repuesto;
    private Evento evento;
    
    boolean validoEmpty = true;
    boolean validoFormato = true;
    
    private List<Object> inputColectivo = new ArrayList<Object>();
    private List<Object> inputConductor = new ArrayList<Object>();
    private List<Object> inputRepuesto = new ArrayList<Object>();
    private List<Object> inputEvento = new ArrayList<Object>();
    private List<Object> buscadorColectivo = new ArrayList<Object>();
    private List<Object> buscadorConductor = new ArrayList<Object>();
    private List<Object> buscadorRepuesto = new ArrayList<Object>();
    private List<Object> buscadorEvento = new ArrayList<Object>();

    //LISTENERS
    public Controller(Model model, View view) {
        this.v = view;
        this.m = model;
        
        //GENERALES
        v.btnSalir.addActionListener(this);
        v.btnAñadirKilometraje.addActionListener(this);
        
        //BUSCADORES
        v.txtBusquedaTablaColectivoMatricula.addKeyListener(this);
        v.txtBusquedaTablaColectivoRut.addKeyListener(this);
        v.txtBusquedaTablaConductorNombre.addKeyListener(this);
        v.txtBusquedaTablaConductorRut.addKeyListener(this);
        v.txtBusquedaTablaRepuestoTipo.addKeyListener(this);
        v.txtBusquedaTablaRepuestoMatricula.addKeyListener(this);
        v.dchBusquedaTablaEventoFecha.addPropertyChangeListener(this);
        v.txtBusquedaTablaEventoNombre.addKeyListener(this);
        v.cmbBusquedaTablaEventoTipo.addActionListener(this);
        
        //DEBUG (BORRAR)
        v.btnReDo.addActionListener(this);
        
        //COLECTIVO
        v.btnColectivoAñadir.addActionListener(this);
        v.btnColectivoLimpiar.addActionListener(this);
        v.btnColectivoModificar.addActionListener(this);
        v.btnColectivoEliminar.addActionListener(this);
        v.btnColectivoLimpiarBuscadores.addActionListener(this);
        v.tblColectivos.addMouseListener(this);
        
        //CONDUCTOR
        v.btnConductorAñadir.addActionListener(this);
        v.btnConductorLimpiar.addActionListener(this);
        v.btnConductorModificar.addActionListener(this);
        v.btnConductorEliminar.addActionListener(this);
        v.btnConductorLimpiarBuscadores.addActionListener(this);
        v.tblConductores.addMouseListener(this);
        
        //REPUESTO
        v.btnRepuestoAñadir.addActionListener(this);
        v.btnRepuestoLimpiar.addActionListener(this);
        v.btnRepuestoModificar.addActionListener(this);
        v.btnRepuestoEliminar.addActionListener(this);
        v.cmbRepuestoCantidadTipo.addItemListener(this);
        v.spnRepuestoKilometrajeMax.addChangeListener(this);
        v.tblRepuestos.addMouseListener(this);
        
        //EVENTO
        v.btnEventoAñadir.addActionListener(this);
        v.btnEventoLimpiar.addActionListener(this);
        v.btnEventoModificar.addActionListener(this);
        v.btnEventoEliminar.addActionListener(this);
        v.btnEventoLimpiarBuscadores.addActionListener(this);
        v.cmbEventoTipo.addItemListener(this);
        v.tblEventos.addMouseListener(this);
    }
    
    //AÑADIR A LAS LISTAS
    public void iniciar(){
        v.pack();
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setLocationRelativeTo(null);
        v.setVisible(true);
        
        //AÑADIR A LAS LISTAS
        //COLECTIVO
        inputColectivo.add(v.txtColectivoMatricula);
        inputColectivo.add(v.cmbColectivoConductores);
        inputColectivo.add(v.dchColectivoCompra);
        inputColectivo.add(v.spnColectivoKilometraje);
        inputColectivo.add(v.txtColectivoMarca);
        inputColectivo.add(v.txtColectivoVin);
        inputColectivo.add(v.txtColectivoMotor);
        
        buscadorColectivo.add(v.txtBusquedaTablaColectivoMatricula);
        buscadorColectivo.add(v.txtBusquedaTablaColectivoRut);
        
        //CONDUCTOR
        inputConductor.add(v.txtConductorRut);
        inputConductor.add(v.cmbConductorColectivos);
        inputConductor.add(v.txtConductorNombre);
        inputConductor.add(v.txtConductorDireccion);
        inputConductor.add(v.txtConductorTelefono);
        
        buscadorConductor.add(v.txtBusquedaTablaConductorNombre);
        buscadorConductor.add(v.txtBusquedaTablaConductorRut);
        
        //REPUESTO
        inputRepuesto.add(v.lblRepuestoIDActual);
        inputRepuesto.add(v.txtRepuestoTipo);
        inputRepuesto.add(v.cmbRepuestoColectivos);
        inputRepuesto.add(v.dchRepuestoCambio);
        inputRepuesto.add(v.spnRepuestoKilometrajeMax);
        inputRepuesto.add(v.spnRepuestoKilometrajeActual);
        
        //Evento
        inputEvento.add(v.lblEventoIDActual);
        inputEvento.add(v.dchEventoFecha);
        inputEvento.add(v.cmbEventoTipo);
        inputEvento.add(v.txtEventoNombre);
        inputEvento.add(v.spnEventoBeneficio);
        
        buscadorEvento.add(v.dchBusquedaTablaEventoFecha);
        buscadorEvento.add(v.txtBusquedaTablaEventoNombre);
        buscadorEvento.add(v.cmbBusquedaTablaEventoTipo);
        
        //CREAR OBJETOS
        colectivo = m.crearColectivo();
        conductor = m.crearConductor();
        repuesto = m.crearRepuesto();
        evento = m.crearEvento();
        
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
        if(!Pattern.matches("^[0-9]+-[0-9kK]{1}$", v.txtConductorRut.getText().strip()) || !(v.txtConductorRut.getText().strip().length() >= 9)){
            if (!(v.txtConductorRut.getText().strip().equals(""))) {
                JOptionPane.showMessageDialog(null, "Ingrese el formato valido en Rut.\n(Coloque el mouse encima de este campo para ver el formato).");
            }
            return false;
        }
        String rut = v.txtConductorRut.getText().strip().toUpperCase();
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
    
    public boolean validarRegEx(JTextField input, String regex){
        if(!Pattern.matches(regex, input.getText().strip())){
            if (!(input.getText().strip().equals(""))) {
                JOptionPane.showMessageDialog(null, "Ingrese el formato valido en " + input.getName() + ".\n(Coloque el mouse encima de este campo para ver el formato).");
            }
            return false;
        }
        return true;
    }
    
    public boolean validarRegEx(String input){
        if(!Pattern.matches("^\\d{1,7}$", input.strip())){
            if (!(input.strip().equals(""))) {
                JOptionPane.showMessageDialog(null, "Ingrese el un número valido.");
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
        JLabel lbl = null;
        JSpinner spn = null;
        
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
            if (input instanceof JLabel) {
                lbl = (JLabel) input;
                lbl.setText("");
            }
            if (input instanceof JSpinner) {
                spn = (JSpinner) input;
                if (((SpinnerNumberModel) spn.getModel()).getMinimum() == null) {
                    spn.setValue(0);
                } else {
                    spn.setValue(((SpinnerNumberModel) spn.getModel()).getMinimum());
                }
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
            String kilometraje = JOptionPane.showInputDialog(null, "Ingrese un numero");
            if (validarRegEx(kilometraje)) {
                m.añadirKilometraje();
            }
        }
        if (e == v.btnReDo) {
            m.eliminarDB();
            m.crearDB();
        }
        
        //COLECTIVO
        if (e == v.btnColectivoAñadir) {
            validoEmpty = validarEmpty(inputColectivo);
            validoFormato = validarRegEx(v.txtColectivoMatricula, "[0-9a-zA-Z]{6}");
            if (validoFormato && validoEmpty) {
                colectivo.insertar();
            }
        }
        if (e == v.btnColectivoLimpiar) {
            limpiarInput(inputColectivo);
        }
        if (e == v.btnColectivoModificar) {
            validoEmpty = validarEmpty(inputColectivo);
            validoFormato = validarRegEx(v.txtColectivoMatricula, "[0-9a-zA-Z]{6}");
            if (validoFormato && validoEmpty) {
                colectivo.modificar();
            }
        }
        if (e == v.btnColectivoEliminar) {
            validoEmpty = validarEmpty(inputColectivo);
            validoFormato = validarRegEx(v.txtColectivoMatricula, "[0-9a-zA-Z]{6}");
            if (validoFormato && validoEmpty) {
                colectivo.eliminar();
            }
        }
        
        //CONDUCTOR
        if (e == v.btnConductorAñadir) {
            validoEmpty = validarEmpty(inputConductor);
            validoFormato = validarRut() && validarRegEx(v.txtConductorTelefono, "^\\+\\d{11}$");
            if (validoEmpty && validoFormato) {
                conductor.insertar();
            }
        }
        if (e == v.btnConductorLimpiar) {
            limpiarInput(inputConductor);
        }
        if (e == v.btnConductorModificar) {
            validoEmpty = validarEmpty(inputConductor);
            validoFormato = validarRut() && validarRegEx(v.txtConductorTelefono, "^\\+\\d{11}$");
            if (validoEmpty && validoFormato) {
                conductor.modificar();
            }
        }
        if (e == v.btnConductorEliminar) {
            validoEmpty = validarEmpty(inputConductor);
            validoFormato = validarRut() && validarRegEx(v.txtConductorTelefono, "^\\+\\d{11}$");
            if (validoEmpty && validoFormato) {
                conductor.eliminar();
            }
        }
        
        //REPUESTO
        if (e == v.btnRepuestoAñadir) {
            
        }
        if (e == v.btnRepuestoLimpiar) {
            
        }
        if (e == v.btnRepuestoModificar) {
            
        }
        if (e == v.btnRepuestoEliminar) {
            
        }
        if (e == v.cmbRepuestoCantidadTipo) {
            repuesto.buscarCantidad();
        }
        
        //EVENTO
        if (e == v.btnEventoAñadir) {
            validoEmpty = validarEmpty(inputEvento);
            if (validoEmpty) {
                evento.insertar();
            }
        }
        if (e == v.btnEventoLimpiar) {
            limpiarInput(inputEvento);
        }
        if (e == v.btnEventoModificar) {
            validoEmpty = validarEmpty(inputEvento);
            if (validoEmpty) {
                evento.modificar();
            }
        }
        if (e == v.btnEventoEliminar) {
            validoEmpty = validarEmpty(inputEvento);
            if (validoEmpty) {
                evento.eliminar();
            }
        }
        
        //LIMPIAR BUSCADORES
        if (e == v.btnColectivoLimpiarBuscadores) {
            limpiarInput(buscadorColectivo);
        }
        if (e == v.btnConductorLimpiarBuscadores) {
            limpiarInput(buscadorConductor);
        }
        if (e == v.btnEventoLimpiarBuscadores) {
            limpiarInput(buscadorEvento);
        }
        
        m.refrescar();
    }

    @Override
    public void mouseClicked(MouseEvent evt){
        Object e = evt.getSource();
        
        //TODO HACER QUE CUANDO SE DE DOBLE CLICK QUE SALGA UN POP UP PARA 
        //MODIFICAR VALORES DE LA TABLA EN VEZ DE USAR LOS INPUTS
        if (evt.getClickCount() == 1) {
            if (e == v.tblColectivos) {
                m.consultarValores(v.tblColectivos, inputColectivo);
            }
            if (e == v.tblConductores) {
                m.consultarValores(v.tblConductores, inputConductor);
            }
            if (e == v.tblRepuestos) {
                m.consultarValores(v.tblRepuestos, inputRepuesto);
            }
            if (e == v.tblEventos) {
                m.consultarValores(v.tblEventos, inputEvento);
            }
        } else {
            
        }
    }
    
    @Override
    public void keyReleased (KeyEvent evt){
        m.refrescar();
    }
    
    @Override
    public void propertyChange (PropertyChangeEvent evt){
        m.refrescar();
    }
    
    @Override
    public void itemStateChanged (ItemEvent evt){
        Object e = evt.getSource();
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (e == v.cmbRepuestoCantidadTipo) {
                repuesto.buscarCantidad();
            }
            if (e == v.cmbEventoTipo) {
                if (v.cmbEventoTipo.getSelectedItem() == "Robo" || v.cmbEventoTipo.getSelectedItem() == "Accidente") {
                    System.out.println("controller.Controller.itemStateChanged()");
                }
            }
        }
    }
    
    public void stateChanged(ChangeEvent evt){
        System.out.println("controller.Controller.stateChanged()");
        SpinnerNumberModel spnModel = (SpinnerNumberModel) v.spnRepuestoKilometrajeActual.getModel();
        int max = (int) v.spnRepuestoKilometrajeMax.getValue();
        if ((int) spnModel.getValue() >= max) {
            spnModel.setValue(max - 1);
        }
        spnModel.setMaximum(max - 1);
    }
    
    public void mousePressed(MouseEvent eve){};
    public void mouseReleased(MouseEvent eve){};
    public void mouseEntered(MouseEvent eve){};
    public void mouseExited(MouseEvent eve){};
    public void keyPressed (KeyEvent e){}
    public void keyTyped (KeyEvent e){};
}
