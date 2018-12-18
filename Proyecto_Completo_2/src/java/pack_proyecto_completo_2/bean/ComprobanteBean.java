/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pack_proyecto_completo_2.models.CabeceraComprobante;
import pack_proyecto_completo_2.models.DetalleComprobante;
import pack_proyecto_completo_2.service.CabeceraComprobanteService;

/**
 *
 * @author Kelly Landazuri
 */
@Named
@ViewScoped
public class ComprobanteBean implements Serializable {

    List<DetalleComprobante> detalles;
    DetalleComprobante detalle;
    DetalleComprobante detalleSel;
    CabeceraComprobante cabeceraComprobante;
    Date fecha;
    String observaciones;
    
     private List<CabeceraComprobante> cabeceras;  
    
    @Inject
    CabeceraComprobanteService cabeceraComprobanteService;

    @PostConstruct
    public void init() {
        detalles = new ArrayList<>();
        detalleSel = new DetalleComprobante();
        cabeceraComprobante= new CabeceraComprobante();
        detalles.add(detalle);
    }

    public void nuevoDetalle() {
        detalleSel = new DetalleComprobante();
        detalles.add(detalleSel);
    }

    public List<DetalleComprobante> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleComprobante> detalles) {
        this.detalles = detalles;
    }

    public DetalleComprobante getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleComprobante detalle) {
        this.detalle = detalle;
    }

    public DetalleComprobante getDetalleSel() {
        return detalleSel;
    }

    public void setDetalleSel(DetalleComprobante detalleSel) {
        this.detalleSel = detalleSel;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    

}
