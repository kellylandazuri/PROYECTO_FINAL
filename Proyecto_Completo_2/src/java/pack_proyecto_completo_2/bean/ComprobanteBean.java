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
import javax.inject.Named;

/**
 *
 * @author Kelly Landazuri
 */
@Named
@ViewScoped
public class ComprobanteBean implements Serializable {

    List<String> detalles;
    String detalle;
    String detalleSel;
    Date fecha;
    String observaciones;

    @PostConstruct
    public void init() {
        detalles = new ArrayList<>();
        detalleSel = new String();
        detalles.add(detalle);
    }

    public void nuevoDetalle() {
        detalleSel = new String();
        detalles.add(detalleSel);
    }

    public List<String> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<String> detalles) {
        this.detalles = detalles;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDetalleSel() {
        return detalleSel;
    }

    public void setDetalleSel(String detalleSel) {
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
