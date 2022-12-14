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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.ColectivoModel;
import model.ConductorModel;
import model.RepuestoModel;
import model.EventoModel;
import model.LoginModel;
import view.ColectivoView;
import view.LoginView;
import view.RegistroView;

public class Controller implements ActionListener, MouseListener, KeyListener, PropertyChangeListener, ItemListener, ChangeListener{
    public View v;
    public Model m;
    
    LoginView vl = new LoginView();
    RegistroView vr = new RegistroView();
    LoginModel login;
    
    private ColectivoController colectivo = null;
    private ConductorController conductor = null;
    private RepuestoController repuesto = null;
    private EventoController evento = null;
    private GananciaController ganancia = null;
    
    boolean validoEmpty = true;
    boolean validoFormato = true;
    
    private List<Object> inputLogin = new ArrayList<Object>();
    private List<Object> inputRegistro = new ArrayList<Object>();
    
    private List<Object> buscadorColectivo = new ArrayList<Object>();
    private List<Object> buscadorConductor = new ArrayList<Object>();
    private List<Object> buscadorRepuesto = new ArrayList<Object>();
    private List<Object> buscadorEvento = new ArrayList<Object>();
    private List<Object> buscadorGanancia = new ArrayList<Object>();
    
    public Object[] registro = null;

    //LISTENERS
    public Controller(Model model, View view) {
        this.v = view;
        this.m = model;
        
        //GENERALES
        v.btnSalir.addActionListener(this);
        v.btnAñadirKilometraje.addActionListener(this);
        
        v.btnReDo.addActionListener(this);
        
        vl.btnIniciarSesion.addActionListener(this);
        vl.btnRegistrarse.addActionListener(this);
        
        vr.btnRegistrarse.addActionListener(this);
        vr.btnVolver.addActionListener(this);
        
        login = m.crearLogin();
        
        inputLogin.add(vl.txtUsuario);
        inputLogin.add(vl.pwdContraseña);
        
        inputRegistro.add(vr.txtUsuario);
        inputRegistro.add(vr.pwdContraseña);
        inputRegistro.add(vr.pwdContraseñaConfirmar);
    }
    
    public void iniciar(boolean debug){
        if (debug){
            crearView();
        } else {
            vl.iniciar();
        }
    }
    
    public void crearView(){
        v.pack();
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setLocationRelativeTo(null);
        v.setVisible(true);

        //CREAR OBJETOS
        colectivo = new ColectivoController(m, v);
        conductor = new ConductorController(m, v);
        repuesto = new RepuestoController(m, v);
        evento = new EventoController(m, v);
        ganancia = new GananciaController(m, v);

        m.refrescar();
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
    
    public boolean validarRut(JTextField txt){
        String rut = txt.getText().strip().toUpperCase();
        if(!Pattern.matches("^[0-9]+-[0-9kK]{1}$", rut) || !(rut.length() >= 9)){
            JOptionPane.showMessageDialog(null, "Ingrese el formato valido en Rut.\n(Coloque el mouse encima de este campo para ver el formato).");
            return false;
        }
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
    
    public boolean validarRegEx(JTextArea input, String regex){
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
    
    public Object getValor(JTable tabla, int columna){
        return tabla.getModel().getValueAt(tabla.getSelectedRow(), columna);
    }
    
    public Object[] getRegistro(JTable tabla){
        List<Object> registro = new ArrayList<Object>();
        for (int i = 0; i < tabla.getModel().getColumnCount(); i++) {
            registro.add(getValor(tabla, i));
        }
        return registro.toArray();
    }
    
    public void mensaje(JFrame jframe, String mensaje, String titulo, int tipo){
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
        jframe.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        Object e = evt.getSource();
        if (e == vl.btnIniciarSesion){
            validoEmpty = validarEmpty(inputLogin);
            if (validoEmpty) {
                if (login.inicioSesion(vl.txtUsuario.getText().strip(), new String(vl.pwdContraseña.getPassword()))) {
                    crearView();
                } else {
                    mensaje(vl, "Usuario o Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }
        }
        if (e == vl.btnRegistrarse){
            vl.dispose();
            vr.iniciar();
        }
        if (e == vr.btnRegistrarse){
            validoEmpty = validarEmpty(inputRegistro);
            if (validoEmpty) {
                if (new String (vr.pwdContraseña.getPassword()).equals(new String (vr.pwdContraseñaConfirmar.getPassword()))){
                    login.registrarse(vr.txtUsuario.getText().strip(), new String (vr.pwdContraseña.getPassword()));
                    vr.dispose();
                    crearView();
                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e == vr.btnVolver){
            vr.dispose();
            vl.iniciar();
        }
        
        //GENERAL
        if (e == v.btnSalir) {
            System.exit(0);
        }
        if (e == v.btnAñadirKilometraje) {
            String kilometraje = JOptionPane.showInputDialog(null, "Ingrese un número");
            if (kilometraje != null && validarRegEx(kilometraje)) {
                m.añadirKilometraje();
            }
        }
        if (e == v.btnReDo) {
            m.eliminarDB();
            m.crearDB();
            System.out.println("DB Recreada.");
        }
        
        //LIMPIAR BUSCADORES
        if (e == v.btnColectivoLimpiarBuscadores) {
            limpiarInput(buscadorColectivo);
        }
        if (e == v.btnConductorLimpiarBuscadores) {
            limpiarInput(buscadorConductor);
        }
        if (e == v.btnRepuestoLimpiarBuscadores) {
            limpiarInput(buscadorRepuesto);
        }
        if (e == v.btnEventoLimpiarBuscadores) {
            limpiarInput(buscadorEvento);
        }
        if (e == v.btnGananciaLimpiarBuscadores) {
            limpiarInput(buscadorGanancia);
        }
        
        m.refrescar();
    }

    @Override
    public void mouseClicked(MouseEvent evt){
    }
    
    @Override
    public void keyReleased (KeyEvent evt){
        m.refrescar();
    }
    
    @Override
    public void propertyChange (PropertyChangeEvent evt){
        m.refrescar();
    }
    
    public void itemStateChanged (ItemEvent evt){}
    public void stateChanged(ChangeEvent evt){} 
    public void mousePressed(MouseEvent eve){}
    public void mouseReleased(MouseEvent eve){}
    public void mouseEntered(MouseEvent eve){}
    public void mouseExited(MouseEvent eve){}
    public void keyPressed (KeyEvent e){}
    public void keyTyped (KeyEvent e){}
}
