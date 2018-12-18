/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pack_proyecto_completo_2.models.CabeceraComprobante;
import pack_proyecto_completo_2.service.CabeceraComprobanteService;


/**
 *
 * @author kelog
 */
@Named
@ViewScoped
public class CabeceraComprobanteBean implements Serializable{
     private List<CabeceraComprobante> cabeceras; 
     CabeceraComprobante cabeceraComprobante;
     
    
    @Inject
    CabeceraComprobanteService cabeceraComprobanteService;
    
    @PostConstruct
    public void init() {
        this.cabeceras = this.cabeceraComprobanteService.obtenerTodos();
    }
    
    public void guardar() {
        this.cabeceraComprobanteService.crear(this.cabeceraComprobante);
    }

    public List<CabeceraComprobante> getCabeceras() {
        return cabeceras;
    }

    public void setCabeceras(List<CabeceraComprobante> cabeceras) {
        this.cabeceras = cabeceras;
    }

    public CabeceraComprobante getCabeceraComprobante() {
        return cabeceraComprobante;
    }

    public void setCabeceraComprobante(CabeceraComprobante cabeceraComprobante) {
        this.cabeceraComprobante = cabeceraComprobante;
    }
    
    
}
