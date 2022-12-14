package controller;

import view.View;
import model.Model;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import model.GananciaModel;
import view.GananciaView;

public class GananciaController extends Controller{    
    
    private GananciaModel Ganancia;
    private GananciaView p = new GananciaView();
    
    private List<Object> inputMain = new ArrayList<Object>();
    private List<Object> inputPopUp = new ArrayList<Object>();
    private List<Object> buscador = new ArrayList<Object>();

    //LISTENERS
    public GananciaController(Model m, View v) {
        super(m, v);
        
        //BUSCADORES
        v.dchBusquedaTablaGananciaFecha.addPropertyChangeListener(this);
        v.txtBusquedaTablaGananciaMatricula.addKeyListener(this);
        
        //MAIN
        v.btnGananciaAñadir.addActionListener(this);
        v.btnGananciaLimpiar.addActionListener(this);
        v.btnGananciaLimpiarBuscadores.addActionListener(this);
        v.cmbGananciaBusquedaMatricula.addItemListener(this);
        v.dchGananciaBusquedaFechaInicial.addPropertyChangeListener(this);
        v.dchGananciaBusquedaFechaFinal.addPropertyChangeListener(this);
        v.tblGanancias.addMouseListener(this);
        
        //POPUP
        p.btnModificar.addActionListener(this);
        p.btnRestablecer.addActionListener(this);
        p.btnEliminar.addActionListener(this);
        p.btnSalir.addActionListener(this);

        Ganancia = m.crearGanancia();
        
        buscador.add(v.dchBusquedaTablaGananciaFecha);
        buscador.add(v.txtBusquedaTablaGananciaMatricula);
        
        //AÑADIR A LAS LISTAS
        inputMain.add(v.dchGananciaFecha);
        inputMain.add(v.cmbGananciaMatricula);
        inputMain.add(v.spnGananciaGanancia);
        
        inputPopUp.add(p.dchGananciaFecha);
        inputPopUp.add(p.cmbGananciaMatricula);
        inputPopUp.add(p.spnGananciaGanancia);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        Object e = evt.getSource();
        
        //COLECTIVO
        if (e == v.btnGananciaAñadir) {
            validoEmpty = validarEmpty(inputMain);
            if (validoFormato) {
                Ganancia.getInput(v);
                Ganancia.insertar();
                mensaje(p, "Registro Insertado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e == v.btnGananciaLimpiar) {
            limpiarInput(inputMain);
        }
        if (e == p.btnModificar) {
            validoEmpty = validarEmpty(inputPopUp);
            if (validoFormato) {
                Ganancia.getInput(p);
                Ganancia.modificar(registro[0].toString(), registro[1].toString());
                mensaje(p, "Registro modificado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e == p.btnRestablecer) {
            m.restablecer(inputPopUp, registro);
        }
        if (e == p.btnEliminar) {
            Ganancia.eliminar(registro[0].toString(), registro[1].toString());
            mensaje(p, "Registro  Eliminado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e == p.btnSalir) {
            p.dispose();
        }
        
        //LIMPIAR BUSCADORES
        if (e == v.btnGananciaLimpiarBuscadores) {
            limpiarInput(buscador);
        }
        
        m.refrescar();
    }

    @Override
    public void mouseClicked(MouseEvent evt){
        Object e = evt.getSource();
        
        if (e == v.tblGanancias) {
            p.iniciar();
            registro = getRegistro(v.tblGanancias);
            m.refrescarCmb(p.cmbGananciaMatricula, "Matricula", "Colectivo");
            p.cmbGananciaMatricula.setSelectedItem("------");
            m.transferirValores(v.tblGanancias, inputPopUp);
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent evt) {
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Ganancia.CalcularSuma(v);
        }
    }
    
    @Override
    public void propertyChange (PropertyChangeEvent evt){
        Ganancia.CalcularSuma(v);
    }
}
