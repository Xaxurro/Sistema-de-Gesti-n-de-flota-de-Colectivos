package controller;

import view.View;
import model.Model;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import model.ColectivoModel;
import view.ColectivoView;

public class ColectivoController extends Controller{    
    
    private ColectivoModel colectivo;
    private ColectivoView p = new ColectivoView();
    
    private List<Object> inputMain = new ArrayList<Object>();
    private List<Object> inputPopUp = new ArrayList<Object>();
    private List<Object> buscador = new ArrayList<Object>();

    //LISTENERS
    public ColectivoController(Model m, View v) {
        super(m, v);
        
        //BUSCADORES
        v.txtBusquedaTablaColectivoMatricula.addKeyListener(this);
        v.txtBusquedaTablaColectivoRut.addKeyListener(this);
        
        //MAIN
        v.btnColectivoAñadir.addActionListener(this);
        v.btnColectivoLimpiar.addActionListener(this);
        v.btnColectivoLimpiarBuscadores.addActionListener(this);
        v.tblColectivos.addMouseListener(this);
        
        //POPUP
        p.btnColectivoModificar.addActionListener(this);
        p.btnRestablecer.addActionListener(this);
        p.btnColectivoEliminar.addActionListener(this);
        p.btnSalir.addActionListener(this);
        
        colectivo = m.crearColectivo();
        
        //AÑADIR A LAS LISTAS
        inputMain.add(v.txtColectivoMatricula);
        inputMain.add(v.cmbColectivoConductores);
        inputMain.add(v.dchColectivoCompra);
        inputMain.add(v.spnColectivoKilometraje);
        inputMain.add(v.txtColectivoMarca);
        inputMain.add(v.txtColectivoVin);
        inputMain.add(v.txtColectivoMotor);
        
        inputPopUp.add(p.txtColectivoMatricula);
        inputPopUp.add(p.cmbColectivoConductores);
        inputPopUp.add(p.dchColectivoCompra);
        inputPopUp.add(p.spnColectivoKilometraje);
        inputPopUp.add(p.txtColectivoMarca);
        inputPopUp.add(p.txtColectivoVin);
        inputPopUp.add(p.txtColectivoMotor);
        
        buscador.add(v.txtBusquedaTablaColectivoMatricula);
        buscador.add(v.txtBusquedaTablaColectivoRut);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        Object e = evt.getSource();
        
        //COLECTIVO
        if (e == v.btnColectivoAñadir) {
            validoEmpty = validarEmpty(inputMain);
            validoFormato = validarRegEx(v.txtColectivoMatricula, "[0-9a-zA-Z]{6}") && validarRegEx(v.txtColectivoMarca, "^[^\\d&&\\w]{1,15}$") && validarRegEx(v.txtColectivoVin, "^[^iIoOqQñÑ_\\W]{1,17}$") && validarRegEx(v.txtColectivoMotor, "^[^iIoOqQñÑ_\\W]{1,12}$");
            if (validoFormato && validoEmpty) {
                colectivo.getInput(v);
                colectivo.insertar();
                mensaje(p, "Colectivo Insertado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e == v.btnColectivoLimpiar) {
            limpiarInput(inputMain);
        }
        if (e == p.btnColectivoModificar) {
            validoEmpty = validarEmpty(inputPopUp);
            validoFormato = validarRegEx(p.txtColectivoMatricula, "[0-9a-zA-Z]{6}") && validarRegEx(p.txtColectivoMarca, "^[^\\d&&\\w]{1,15}$") && validarRegEx(p.txtColectivoVin, "^[^iIoOqQñÑ_\\W]{1,17}$") && validarRegEx(p.txtColectivoMotor, "^[^iIoOqQñÑ_\\W]{1,12}$");
            if (validoFormato && validoEmpty) {
                colectivo.getInput(p);
                colectivo.modificar(registro[0].toString(), registro[5].toString(), registro[6].toString());
                mensaje(p, "Colectivo modificado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e == p.btnRestablecer) {
            m.restablecer(inputPopUp, registro);
        }
        if (e == p.btnColectivoEliminar) {
            colectivo.eliminar(registro[0].toString());
            mensaje(p, "Colectivo Eliminado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
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
        
        if (e == v.tblColectivos) {
            p.iniciar();
            registro = getRegistro(v.tblColectivos);
            m.refrescarCmb(p.cmbColectivoConductores, "RutConductor", "Conductor");
            p.cmbColectivoConductores.setSelectedItem(registro[1].toString());
            m.transferirValores(v.tblColectivos, inputPopUp);
        }
    }
}
