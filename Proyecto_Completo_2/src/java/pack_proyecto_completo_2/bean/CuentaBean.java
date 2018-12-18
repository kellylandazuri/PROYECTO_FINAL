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
import pack_proyecto_completo_2.models.Cuenta;
import pack_proyecto_completo_2.service.CuentaService;

/**
 *
 * @author kelog
 */
@Named
@ViewScoped
public class CuentaBean {
    
     private List<Cuenta> cuentas;  
    
    @Inject
    CuentaService CuentaService;
    
     @PostConstruct
    public void init() {
        this.cuentas = this.CuentaService.obtenerTodos();
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}
