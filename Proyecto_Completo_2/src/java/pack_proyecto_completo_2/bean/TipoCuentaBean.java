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
import pack_proyecto_completo_2.service.TipoCuentaService;

/**
 *
 * @author kelog
 */
@Named
@ViewScoped
public class TipoCuentaBean implements Serializable {

    private List<TipoCuenta> tipos;
    private TipoCuenta tipoCuenta;
    private TipoCuenta tipoCuentaSel;
    private Boolean enAgregar;
    private Boolean enModificar;
    private String codigoBusqueda;

    @Inject
    TipoCuentaService tipoCuentaService;

    @PostConstruct
    public void init() {
        this.tipos = this.tipoCuentaService.obtenerTodos();
        enAgregar = Boolean.FALSE;
        enModificar = Boolean.FALSE;
        this.tipoCuenta = new TipoCuenta();
    }

    public void agregar() {
        enAgregar = Boolean.TRUE;
        this.tipoCuenta = new TipoCuenta();
    }

    public void modificar() {
        enModificar = Boolean.TRUE;
        this.tipoCuenta = new TipoCuenta();
    }

    public void cancelar() {
        enAgregar = Boolean.FALSE;
        enModificar = Boolean.FALSE;
        this.tipoCuenta = new TipoCuenta();
        this.tipoCuentaSel = null;
    }

    public void guardar() {
        try {
            if (enAgregar) {
                this.tipoCuentaService.crear(this.tipoCuenta);
            } else {
                this.tipoCuenta.setCodigoTipo(this.tipoCuentaSel.getCodigoTipo());
                this.tipoCuenta.setNombreTipo(this.tipoCuentaSel.getNombreTipo());
                this.tipoCuentaService.modificar(tipoCuenta);
            }
        } catch (Exception ex) {
        }
        this.tipoCuenta = new TipoCuenta();
        this.tipos = this.tipoCuentaService.obtenerTodos();
        enAgregar = Boolean.FALSE;
        enModificar = Boolean.FALSE;
    }

    public void eliminar() {
        this.tipoCuentaService.eliminar(this.tipoCuentaSel);
        this.tipoCuenta = new TipoCuenta();
        this.tipos = this.tipoCuentaService.obtenerTodos();
    }

    public void buscar() {
        this.tipos = new ArrayList<>();
        List<TipoCuenta> usrEncontrado = this.tipoCuentaService.busquedaTipoCuenta(codigoBusqueda);
        if (usrEncontrado != null) {
            this.tipos.addAll(usrEncontrado);
        } else {
            this.tipos = null;
        }
        this.tipoCuenta = new TipoCuenta();
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

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public TipoCuenta getTipoCuentaSel() {
        return tipoCuentaSel;
    }

    public void setTipoCuentaSel(TipoCuenta tipoCuentaSel) {
        this.tipoCuentaSel = tipoCuentaSel;
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

    public String getCodigoBusqueda() {
        return codigoBusqueda;
    }

    public void setCodigoBusqueda(String codigoBusqueda) {
        this.codigoBusqueda = codigoBusqueda;
    }

}
