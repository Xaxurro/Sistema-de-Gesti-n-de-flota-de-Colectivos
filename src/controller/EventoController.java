package controller;

import view.View;
import model.Model;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import model.EventoModel;
import view.EventoView;

public class EventoController extends Controller{    
    
    private EventoModel evento;
    private EventoView p = new EventoView();
    
    private List<Object> inputMain = new ArrayList<Object>();
    private List<Object> inputPopUp = new ArrayList<Object>();
    private List<Object> buscador = new ArrayList<Object>();

    //LISTENERS
    public EventoController(Model m, View v) {
        super(m, v);
        
        //BUSCADORES
        v.dchBusquedaTablaEventoFecha.addPropertyChangeListener(this);
        v.txtBusquedaTablaEventoNombre.addKeyListener(this);
        v.cmbBusquedaTablaEventoTipo.addActionListener(this);
        
        //MAIN
        v.btnEventoAñadir.addActionListener(this);
        v.btnEventoLimpiar.addActionListener(this);
        v.btnEventoLimpiarBuscadores.addActionListener(this);
        v.cmbEventoTipo.addItemListener(this);
        v.tblEventos.addMouseListener(this);
        
        //POPUP
        p.btnModificar.addActionListener(this);
        p.btnAñadirColectivo.addActionListener(this);
        p.btnEliminarColectivo.addActionListener(this);
        p.btnRestablecer.addActionListener(this);
        p.btnEliminar.addActionListener(this);
        p.btnSalir.addActionListener(this);
        
        evento = m.crearEvento();
        
        buscador.add(v.dchBusquedaTablaEventoFecha);
        buscador.add(v.txtBusquedaTablaEventoNombre);
        buscador.add(v.cmbBusquedaTablaEventoTipo);
        
        //AÑADIR A LAS LISTAS
        inputMain.add(v.dchEventoFecha);
        inputMain.add(v.cmbEventoTipo);
        inputMain.add(v.txtEventoNombre);
        inputMain.add(v.spnEventoBeneficio);
        
        inputPopUp.add(p.dchEventoFecha);
        inputPopUp.add(p.cmbEventoTipo);
        inputPopUp.add(p.txtEventoNombre);
        inputPopUp.add(p.spnEventoBeneficio);
        inputPopUp.add(p.txaDescription);
        inputPopUp.add(p.cmbColectivos);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        Object e = evt.getSource();
        
        //COLECTIVO
        if (e == v.btnEventoAñadir) {
            validoEmpty = validarEmpty(inputMain);
            validoFormato = validarRegEx(p.txtEventoNombre, "^[\\w\\s]{1,50}$");
            if (validoFormato && validoEmpty) {
                evento.getInput(v);
                evento.insertar();
                mensaje(p, "Evento Insertado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e == v.btnEventoLimpiar) {
            limpiarInput(inputMain);
        }
        if (e == p.btnModificar) {
            validoEmpty = validarEmpty(inputPopUp);
            validoFormato = validarRegEx(p.txtEventoNombre, "^[\\w\\s]{1,50}$") && validarRegEx(p.txaDescription, ".{1,150}");
            if (validoFormato && validoEmpty) {
                evento.getInput(p);
                evento.modificar(Integer.valueOf(registro[0].toString()));
                mensaje(p, "Evento modificado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e == p.btnAñadirColectivo) {
            evento.getInput(p);
            if (p.cmbColectivos.getSelectedIndex() > 0) {
                evento.añadirColectivo(Integer.valueOf(registro[0].toString()));
                evento.refrescarPopUp(p, Integer.valueOf(registro[0].toString()));
            } else {
                JOptionPane.showMessageDialog(null, "Porfavor seleccione un colectivo para añadr al evento.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e == p.btnEliminarColectivo) {
            evento.eliminarColectivo(p.lstColectivosImplicados.getSelectedValue(), Integer.valueOf(registro[0].toString()));
            evento.refrescarPopUp(p, Integer.valueOf(registro[0].toString()));
        }
        if (e == p.btnRestablecer) {
            m.restablecer(inputPopUp, registro);
        }
        if (e == p.btnEliminar) {
            evento.eliminar(Integer.valueOf(registro[0].toString()));
            mensaje(p, "Evento Eliminado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e == p.btnSalir) {
            p.dispose();
        }
        
        //LIMPIAR BUSCADORES
        if (e == v.btnColectivoLimpiarBuscadores) {
            limpiarInput(buscador);
        }
        
        m.refrescar();
    }

    @Override
    public void mouseClicked(MouseEvent evt){
        Object e = evt.getSource();
        
        if (e == v.tblEventos) {
            p.iniciar();
            registro = getRegistro(v.tblEventos);
            m.refrescarCmb(p.cmbColectivos, "Matricula", "Colectivo");
            p.cmbColectivos.setSelectedItem("------");
            m.transferirValores(v.tblEventos, inputPopUp);
            evento.refrescarPopUp(p, Integer.valueOf(registro[0].toString()));
        }
    }
}
