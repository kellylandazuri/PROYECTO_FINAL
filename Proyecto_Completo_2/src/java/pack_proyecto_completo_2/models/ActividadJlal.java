/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kelog
 */
@Entity
@Table(name = "ACTIVIDAD_JLAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadJlal.findAll", query = "SELECT a FROM ActividadJlal a")
    , @NamedQuery(name = "ActividadJlal.findByCodigoActividad", query = "SELECT a FROM ActividadJlal a WHERE a.codigoActividad = :codigoActividad")
    , @NamedQuery(name = "ActividadJlal.findByNombreActividad", query = "SELECT a FROM ActividadJlal a WHERE a.nombreActividad = :nombreActividad")})
public class ActividadJlal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_ACTIVIDAD")
    private Integer codigoActividad;
    @Size(max = 254)
    @Column(name = "NOMBRE_ACTIVIDAD")
    private String nombreActividad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadJlal")
    private List<DetalleMantenimientoJlal> detalleMantenimientoJlalList;

    public ActividadJlal() {
    }

    public ActividadJlal(Integer codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public Integer getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(Integer codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    @XmlTransient
    public List<DetalleMantenimientoJlal> getDetalleMantenimientoJlalList() {
        return detalleMantenimientoJlalList;
    }

    public void setDetalleMantenimientoJlalList(List<DetalleMantenimientoJlal> detalleMantenimientoJlalList) {
        this.detalleMantenimientoJlalList = detalleMantenimientoJlalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoActividad != null ? codigoActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadJlal)) {
            return false;
        }
        ActividadJlal other = (ActividadJlal) object;
        if ((this.codigoActividad == null && other.codigoActividad != null) || (this.codigoActividad != null && !this.codigoActividad.equals(other.codigoActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack_proyecto_completo_2.bean.ActividadJlal[ codigoActividad=" + codigoActividad + " ]";
    }
    
}
