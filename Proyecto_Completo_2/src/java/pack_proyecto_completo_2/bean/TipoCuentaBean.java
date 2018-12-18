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
import pack_proyecto_completo_2.models.TipoCuenta;
import pack_proyecto_completo_2.service.TipoCuentaService;

/**
 *
 * @author kelog
 */
@Named
@ViewScoped
public class TipoCuentaBean implements Serializable {
    
    private List<TipoCuenta> tipos;  
    
    @Inject
    TipoCuentaService tipoCuentaService;
    
     @PostConstruct
    public void init() {
        this.tipos = this.tipoCuentaService.obtenerTodos();
    }

    public List<TipoCuenta> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoCuenta> tipos) {
        this.tipos = tipos;
    }

    public TipoCuentaService getTipoCuentaService() {
        return tipoCuentaService;
    }

    public void setTipoCuentaService(TipoCuentaService tipoCuentaService) {
        this.tipoCuentaService = tipoCuentaService;
    }
    
    
    
}
