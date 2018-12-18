/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kelog
 */
@Entity
@Table(name = "DETALLE_MANTENIMIENTO_JLAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleMantenimientoJlal.findAll", query = "SELECT d FROM DetalleMantenimientoJlal d")
    , @NamedQuery(name = "DetalleMantenimientoJlal.findByCodigoActividad", query = "SELECT d FROM DetalleMantenimientoJlal d WHERE d.detalleMantenimientoJlalPK.codigoActividad = :codigoActividad")
    , @NamedQuery(name = "DetalleMantenimientoJlal.findByCodigoActivo", query = "SELECT d FROM DetalleMantenimientoJlal d WHERE d.detalleMantenimientoJlalPK.codigoActivo = :codigoActivo")
    , @NamedQuery(name = "DetalleMantenimientoJlal.findByValorDMantenimiento", query = "SELECT d FROM DetalleMantenimientoJlal d WHERE d.valorDMantenimiento = :valorDMantenimiento")})
public class DetalleMantenimientoJlal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleMantenimientoJlalPK detalleMantenimientoJlalPK;
    @Column(name = "VALOR_D_MANTENIMIENTO")
    private Long valorDMantenimiento;
    @JoinColumn(name = "CODIGO_ACTIVIDAD", referencedColumnName = "CODIGO_ACTIVIDAD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ActividadJlal actividadJlal;
    @JoinColumn(name = "CODIGO_ACTIVO", referencedColumnName = "CODIGO_ACTIVO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ActivoJlal activoJlal;

    public DetalleMantenimientoJlal() {
    }

    public DetalleMantenimientoJlal(DetalleMantenimientoJlalPK detalleMantenimientoJlalPK) {
        this.detalleMantenimientoJlalPK = detalleMantenimientoJlalPK;
    }

    public DetalleMantenimientoJlal(int codigoActividad, int codigoActivo) {
        this.detalleMantenimientoJlalPK = new DetalleMantenimientoJlalPK(codigoActividad, codigoActivo);
    }

    public DetalleMantenimientoJlalPK getDetalleMantenimientoJlalPK() {
        return detalleMantenimientoJlalPK;
    }

    public void setDetalleMantenimientoJlalPK(DetalleMantenimientoJlalPK detalleMantenimientoJlalPK) {
        this.detalleMantenimientoJlalPK = detalleMantenimientoJlalPK;
    }

    public Long getValorDMantenimiento() {
        return valorDMantenimiento;
    }

    public void setValorDMantenimiento(Long valorDMantenimiento) {
        this.valorDMantenimiento = valorDMantenimiento;
    }

    public ActividadJlal getActividadJlal() {
        return actividadJlal;
    }

    public void setActividadJlal(ActividadJlal actividadJlal) {
        this.actividadJlal = actividadJlal;
    }

    public ActivoJlal getActivoJlal() {
        return activoJlal;
    }

    public void setActivoJlal(ActivoJlal activoJlal) {
        this.activoJlal = activoJlal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleMantenimientoJlalPK != null ? detalleMantenimientoJlalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleMantenimientoJlal)) {
            return false;
        }
        DetalleMantenimientoJlal other = (DetalleMantenimientoJlal) object;
        if ((this.detalleMantenimientoJlalPK == null && other.detalleMantenimientoJlalPK != null) || (this.detalleMantenimientoJlalPK != null && !this.detalleMantenimientoJlalPK.equals(other.detalleMantenimientoJlalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack_proyecto_completo_2.bean.DetalleMantenimientoJlal[ detalleMantenimientoJlalPK=" + detalleMantenimientoJlalPK + " ]";
    }
    
}
