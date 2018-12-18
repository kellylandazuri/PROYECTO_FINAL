/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pack_proyecto_completo_2.models.Cuenta;
import pack_proyecto_completo_2.models.TipoCuenta;
import pack_proyecto_completo_2.service.CuentaService;
import pack_proyecto_completo_2.service.TipoCuentaService;

/**
 *
 * @author kelog
 */
@Named
@ViewScoped
public class CuentaBean implements Serializable{
    
     private List<Cuenta> cuentas; 
     private List<TipoCuenta> tipoCuentas; 
     private Cuenta cuenta;
    private Cuenta cuentaSel;
    private TipoCuenta tipoCuentaSel;
    private Boolean enAgregar;
    private Boolean enModificar;
    private String codigoBusqueda;
    
    @Inject
    CuentaService cuentaService;
    
    @Inject
    TipoCuentaService tipoCuentaService;
    
     @PostConstruct
    public void init() {
        this.cuentas = this.cuentaService.obtenerTodos();
        enAgregar = Boolean.FALSE;
        enModificar = Boolean.FALSE;
        this.cuenta = new Cuenta();
        this.tipoCuentas= tipoCuentaService.obtenerTodos();
    }

    
    public void agregar() {
        enAgregar = Boolean.TRUE;
        this.cuenta = new Cuenta();
    }

    public void modificar() {
        enModificar = Boolean.TRUE;
        this.cuenta = new Cuenta();
    }

    public void cancelar() {
        enAgregar = Boolean.FALSE;
        enModificar = Boolean.FALSE;
        this.cuenta = new Cuenta();
        this.cuentaSel = null;
    }

    public void guardar() {
        try {
            if (enAgregar) {
                this.cuentaService.crear(this.cuenta);
            } else {
                this.cuenta.setCodigoCuenta(this.cuentaSel.getCodigoCuenta());
                this.cuenta.setNombreCuenta(this.cuentaSel.getNombreCuenta());
                this.cuenta.setCodigoTipo(this.tipoCuentaSel);
                this.cuentaService.modificar(cuenta);
            }
        } catch (Exception ex) {
        }
        this.cuenta = new Cuenta();
        this.cuentas = this.cuentaService.obtenerTodos();
        enAgregar = Boolean.FALSE;
        enModificar = Boolean.FALSE;
    }

    public void eliminar() {
        this.cuentaService.eliminar(this.cuentaSel);
        this.cuenta = new Cuenta();
        this.cuentas = this.cuentaService.obtenerTodos();
    }

    public void buscar() {
        this.cuentas = new ArrayList<>();
        List<Cuenta> usrEncontrado = this.cuentaService.busquedaCuenta(codigoBusqueda);
        if (usrEncontrado != null) {
            this.cuentas.addAll(usrEncontrado);
        } else {
            this.cuentas = null;
        }
        this.cuenta = new Cuenta();
    }

    
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cuenta getCuentaSel() {
        return cuentaSel;
    }

    public void setCuentaSel(Cuenta cuentaSel) {
        this.cuentaSel = cuentaSel;
    }

    public Boolean getEnAgregar() {
        return enAgregar;
    }

    public void setEnAgregar(Boolean enAgregar) {
        this.enAgregar = enAgregar;
    }

    public Boolean getEnModificar() {
        return enModificar;
    }

    public void setEnModificar(Boolean enModificar) {
        this.enModificar = enModificar;
    }

    public List<TipoCuenta> getTipoCuentas() {
        return tipoCuentas;
    }

    public void setTipoCuentas(List<TipoCuenta> tipoCuentas) {
        this.tipoCuentas = tipoCuentas;
    }

    public TipoCuenta getTipoCuentaSel() {
        return tipoCuentaSel;
    }

    public void setTipoCuentaSel(TipoCuenta tipoCuentaSel) {
        this.tipoCuentaSel = tipoCuentaSel;
    }

    public String getCodigoBusqueda() {
        return codigoBusqueda;
    }

    public void setCodigoBusqueda(String codigoBusqueda) {
        this.codigoBusqueda = codigoBusqueda;
    }
    
}
