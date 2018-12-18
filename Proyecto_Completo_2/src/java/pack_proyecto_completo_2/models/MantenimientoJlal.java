/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kelog
 */
@Entity
@Table(name = "MANTENIMIENTO_JLAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MantenimientoJlal.findAll", query = "SELECT m FROM MantenimientoJlal m")
    , @NamedQuery(name = "MantenimientoJlal.findByNumeroMantenimiento", query = "SELECT m FROM MantenimientoJlal m WHERE m.numeroMantenimiento = :numeroMantenimiento")
    , @NamedQuery(name = "MantenimientoJlal.findByFechaMantenimiento", query = "SELECT m FROM MantenimientoJlal m WHERE m.fechaMantenimiento = :fechaMantenimiento")
    , @NamedQuery(name = "MantenimientoJlal.findByResponsableMantenimiento", query = "SELECT m FROM MantenimientoJlal m WHERE m.responsableMantenimiento = :responsableMantenimiento")})
public class MantenimientoJlal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_MANTENIMIENTO")
    private Integer numeroMantenimiento;
    @Column(name = "FECHA_MANTENIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMantenimiento;
    @Size(max = 254)
    @Column(name = "RESPONSABLE_MANTENIMIENTO")
    private String responsableMantenimiento;

    public MantenimientoJlal() {
    }

    public MantenimientoJlal(Integer numeroMantenimiento) {
        this.numeroMantenimiento = numeroMantenimiento;
    }

    public Integer getNumeroMantenimiento() {
        return numeroMantenimiento;
    }

    public void setNumeroMantenimiento(Integer numeroMantenimiento) {
        this.numeroMantenimiento = numeroMantenimiento;
    }

    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public String getResponsableMantenimiento() {
        return responsableMantenimiento;
    }

    public void setResponsableMantenimiento(String responsableMantenimiento) {
        this.responsableMantenimiento = responsableMantenimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroMantenimiento != null ? numeroMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MantenimientoJlal)) {
            return false;
        }
        MantenimientoJlal other = (MantenimientoJlal) object;
        if ((this.numeroMantenimiento == null && other.numeroMantenimiento != null) || (this.numeroMantenimiento != null && !this.numeroMantenimiento.equals(other.numeroMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack_proyecto_completo_2.bean.MantenimientoJlal[ numeroMantenimiento=" + numeroMantenimiento + " ]";
    }
    
}
