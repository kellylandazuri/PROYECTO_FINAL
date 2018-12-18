/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pack_proyecto_completo_2.models.DetalleComprobante;
import pack_proyecto_completo_2.service.DetalleComprobanteService;

/**
 *
 * @author kelog
 */
@Named
@ViewScoped
public class DetalleComprobanteBean {

    private List<DetalleComprobante> detalles;

    @Inject
    DetalleComprobanteService detalleComprobanteService;

    public List<DetalleComprobante> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleComprobante> detalles) {
        this.detalles = detalles;
    }

}
