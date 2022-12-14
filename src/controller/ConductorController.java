package controller;

import view.View;
import model.Model;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import model.ConductorModel;
import view.ConductorView;

public class ConductorController extends Controller{    
    
    private ConductorModel conductor;
    private ConductorView p = new ConductorView();
    
    private List<Object> inputMain = new ArrayList<Object>();    
    private List<Object> inputPopUp = new ArrayList<Object>();
    private List<Object> buscador = new ArrayList<Object>();

    //LISTENERS
    public ConductorController(Model m, View v) {
        super(m, v);
        
        //BUSCADORES
        v.txtBusquedaTablaConductorNombre.addKeyListener(this);
        v.txtBusquedaTablaConductorRut.addKeyListener(this);
        
        //MAIN
        v.btnConductorAñadir.addActionListener(this);
        v.btnConductorLimpiar.addActionListener(this);
        v.btnConductorLimpiarBuscadores.addActionListener(this);
        v.tblConductores.addMouseListener(this);
        
        //POPUP
        p.btnModificar.addActionListener(this);
        p.btnRestablecer.addActionListener(this);
        p.btnEliminar.addActionListener(this);
        p.btnSalir.addActionListener(this);
        
        conductor = m.crearConductor();
        
        //AÑADIR A LAS LISTAS
        inputMain.add(v.txtConductorRut);
        inputMain.add(v.cmbConductorColectivos);
        inputMain.add(v.txtConductorNombre);
        inputMain.add(v.txtConductorDireccion);
        inputMain.add(v.txtConductorTelefono);
        
        inputPopUp.add(p.txtConductorRut);
        inputPopUp.add(p.cmbConductorColectivos);
        inputPopUp.add(p.txtConductorNombre);
        inputPopUp.add(p.txtConductorDireccion);
        inputPopUp.add(p.txtConductorTelefono);
        
        buscador.add(v.txtBusquedaTablaConductorNombre);
        buscador.add(v.txtBusquedaTablaConductorRut);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        Object e = evt.getSource();
        
        //CONDUCTOR
        if (e == v.btnConductorAñadir) {
            validoEmpty = validarEmpty(inputMain);
            validoFormato = validarRut(v.txtConductorRut) && validarRegEx(v.txtConductorNombre, "^[a-zA-Z]${50}") && validarRegEx(v.txtConductorDireccion, "^[\\w\\-,.#\\\"'\\s]{1,150}$") && validarRegEx(v.txtConductorTelefono, "^\\+\\d{11}$");
            if (validoEmpty && validoFormato) {
                conductor.getInput(v);
                conductor.insertar();
                mensaje(p, "Conductor Insertado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e == v.btnConductorLimpiar) {
            limpiarInput(inputMain);
        }
        if (e == p.btnModificar) {
            validoEmpty = validarEmpty(inputPopUp);
            validoFormato = validarRut(p.txtConductorRut) && validarRegEx(p.txtConductorNombre, "^[a-zA-Z]${50}") && validarRegEx(p.txtConductorDireccion, "^[\\w\\-,.#\\\"'\\s]{1,150}$") && validarRegEx(p.txtConductorTelefono, "^\\+\\d{11}$");
            if (validoEmpty && validoFormato) {
                conductor.getInput(p);
                conductor.modificar(registro[0].toString());
                mensaje(p, "Conductor modificado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e == p.btnRestablecer) {
            m.restablecer(inputPopUp, registro);
        }
        if (e == p.btnEliminar) {
            conductor.eliminar(registro[0].toString());
            mensaje(p, "Colectivo Eliminado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e == p.btnSalir) {
            p.dispose();
        }
        
        //LIMPIAR BUSCADORES
        if (e == v.btnConductorLimpiarBuscadores) {
            limpiarInput(buscador);
        }
        
        m.refrescar();
    }

    @Override
    public void mouseClicked(MouseEvent evt){
        Object e = evt.getSource();
        
        if (e == v.tblConductores) {
            p.iniciar();
            m.refrescarCmb(p.cmbConductorColectivos, "Matricula", "Colectivo");
            p.cmbConductorColectivos.setSelectedItem(getValor(v.tblConductores, 1).toString());
            m.transferirValores(v.tblConductores, inputPopUp);
            registro = getRegistro(v.tblConductores);
        }
    }
}