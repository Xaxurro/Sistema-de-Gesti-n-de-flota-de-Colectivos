package controller;

import view.View;
import model.Model;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import model.RepuestoModel;
import view.RepuestoView;

public class RepuestoController extends Controller{    
    
    private RepuestoModel repuesto;
    private RepuestoView p = new RepuestoView();
    
    private List<Object> inputMain = new ArrayList<Object>();    
    private List<Object> inputPopUp = new ArrayList<Object>();
    private List<Object> buscador = new ArrayList<Object>();

    //LISTENERS
    public RepuestoController(Model m, View v) {
        super(m, v);
        
        //BUSCADORES
        v.txtBusquedaTablaRepuestoMatricula.addKeyListener(this);
        v.txtBusquedaTablaRepuestoTipo.addKeyListener(this);
        
        //MAIN
        v.btnRepuestoAñadir.addActionListener(this);
        v.btnRepuestoLimpiar.addActionListener(this);
        v.btnRepuestoLimpiarBuscadores.addActionListener(this);
        v.cmbRepuestoCantidadTipo.addItemListener(this);
        v.spnRepuestoKilometrajeMax.addChangeListener(this);
        v.tblRepuestos.addMouseListener(this);
        
        //POPUP
        p.btnModificar.addActionListener(this);
        p.btnRestablecer.addActionListener(this);
        p.btnEliminar.addActionListener(this);
        p.btnSalir.addActionListener(this);
        p.spnRepuestoKilometrajeMax.addChangeListener(this);
        
        repuesto = m.crearRepuesto();
        
        //AÑADIR A LAS LISTAS
        inputMain.add(v.txtRepuestoTipo);
        inputMain.add(v.cmbRepuestoColectivos);
        inputMain.add(v.dchRepuestoCambio);
        inputMain.add(v.spnRepuestoKilometrajeMax);
        inputMain.add(v.spnRepuestoKilometrajeActual);
        
        inputPopUp.add(p.txtRepuestoTipo);
        inputPopUp.add(p.cmbRepuestoColectivos);
        inputPopUp.add(p.dchRepuestoCambio);
        inputPopUp.add(p.spnRepuestoKilometrajeMax);
        inputPopUp.add(p.spnRepuestoKilometrajeActual);
        
        buscador.add(v.txtBusquedaTablaRepuestoTipo);
        buscador.add(v.txtBusquedaTablaRepuestoMatricula);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        Object e = evt.getSource();
        
        //CONDUCTOR
        if (e == v.btnRepuestoAñadir) {
            validoEmpty = validarEmpty(inputMain);
            validoFormato = validarRegEx(v.txtRepuestoTipo, "^\\w$");
            if (validoEmpty && validoFormato) {
                repuesto.getInput(v);
                repuesto.insertar();
                mensaje(p, "Repuesto Insertado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e == v.btnRepuestoLimpiar) {
            limpiarInput(inputMain);
        }
        if (e == p.btnModificar) {
            validoEmpty = validarEmpty(inputMain);
            validoFormato = validarRegEx(p.txtRepuestoTipo, "^\\w$");
            if (validoEmpty && validoFormato) {
                repuesto.getInput(p);
                repuesto.modificar(registro[0].toString());
                mensaje(p, "Repuesto modificado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e == p.btnRestablecer) {
            m.restablecer(inputPopUp, registro);
        }
        if (e == p.btnEliminar) {
            repuesto.eliminar(registro[0].toString());
            mensaje(p, "Repuesto Eliminado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e == v.cmbRepuestoCantidadTipo) {
            System.out.println("controller.Controller.actionPerformed()");
            repuesto.buscarCantidad(v);
        }
        
        //LIMPIAR BUSCADORES
        if (e == v.btnRepuestoLimpiarBuscadores) {
            limpiarInput(buscador);
        }
        
        m.refrescar();
    }

    @Override
    public void mouseClicked(MouseEvent evt){
        Object e = evt.getSource();
        
        if (e == v.tblRepuestos) {
            p.iniciar();
            m.refrescarCmb(p.cmbRepuestoColectivos, "Matricula", "Colectivo");
            p.cmbRepuestoColectivos.setSelectedItem(getValor(v.tblRepuestos, 2).toString());
            m.transferirValores(v.tblRepuestos, inputPopUp);
            registro = getRegistro(v.tblRepuestos);
        }
    }
    
    @Override
    public void itemStateChanged (ItemEvent evt){
        Object e = evt.getSource();
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (e == v.cmbRepuestoCantidadTipo) {
                repuesto.buscarCantidad(v);
            }
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent evt){
        Object e = ((JSpinner) evt.getSource());
        SpinnerNumberModel spnModel = null;
        int max = 0;
        if (e == v.spnRepuestoKilometrajeMax) {
            spnModel = (SpinnerNumberModel) v.spnRepuestoKilometrajeActual.getModel();
            max = (int) v.spnRepuestoKilometrajeMax.getValue();
        } 
        if (e == p.spnRepuestoKilometrajeMax){
            spnModel = (SpinnerNumberModel) p.spnRepuestoKilometrajeActual.getModel();
            max = (int) p.spnRepuestoKilometrajeMax.getValue();
        }
        
        if ((int) spnModel.getValue() >= max) {
            spnModel.setValue(max - 1);
        }
        spnModel.setMaximum(max - 1);
    }
}