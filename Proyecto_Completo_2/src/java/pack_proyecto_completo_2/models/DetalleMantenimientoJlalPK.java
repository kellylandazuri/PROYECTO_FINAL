/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kelog
 */
@Embeddable
public class DetalleMantenimientoJlalPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ACTIVIDAD")
    private int codigoActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ACTIVO")
    private int codigoActivo;

    public DetalleMantenimientoJlalPK() {
    }

    public DetalleMantenimientoJlalPK(int codigoActividad, int codigoActivo) {
        this.codigoActividad = codigoActividad;
        this.codigoActivo = codigoActivo;
    }

    public int getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(int codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public int getCodigoActivo() {
        return codigoActivo;
    }

    public void setCodigoActivo(int codigoActivo) {
        this.codigoActivo = codigoActivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoActividad;
        hash += (int) codigoActivo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleMantenimientoJlalPK)) {
            return false;
        }
        DetalleMantenimientoJlalPK other = (DetalleMantenimientoJlalPK) object;
        if (this.codigoActividad != other.codigoActividad) {
            return false;
        }
        if (this.codigoActivo != other.codigoActivo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack_proyecto_completo_2.bean.DetalleMantenimientoJlalPK[ codigoActividad=" + codigoActividad + ", codigoActivo=" + codigoActivo + " ]";
    }
    
}
