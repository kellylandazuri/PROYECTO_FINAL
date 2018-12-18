/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.models;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kelog
 */
@Entity
@Table(name = "CABECERA_CUDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CabeceraCuda.findAll", query = "SELECT c FROM CabeceraCuda c")
    , @NamedQuery(name = "CabeceraCuda.findByNumeroPrestamo", query = "SELECT c FROM CabeceraCuda c WHERE c.numeroPrestamo = :numeroPrestamo")
    , @NamedQuery(name = "CabeceraCuda.findByFechaPrestamo", query = "SELECT c FROM CabeceraCuda c WHERE c.fechaPrestamo = :fechaPrestamo")
    , @NamedQuery(name = "CabeceraCuda.findByDescripcionPrestamo", query = "SELECT c FROM CabeceraCuda c WHERE c.descripcionPrestamo = :descripcionPrestamo")
    , @NamedQuery(name = "CabeceraCuda.findByFechaentregaPrestamo", query = "SELECT c FROM CabeceraCuda c WHERE c.fechaentregaPrestamo = :fechaentregaPrestamo")})
public class CabeceraCuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMERO_PRESTAMO")
    private Integer numeroPrestamo;
    @Column(name = "FECHA_PRESTAMO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrestamo;
    @Size(max = 256)
    @Column(name = "DESCRIPCION_PRESTAMO")
    private String descripcionPrestamo;
    @Column(name = "FECHAENTREGA_PRESTAMO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaentregaPrestamo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabeceraCuda")
    private List<DetalleCuda> detalleCudaList;

    public CabeceraCuda() {
    }

    public CabeceraCuda(Integer numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
    }

    public Integer getNumeroPrestamo() {
        return numeroPrestamo;
    }

    public void setNumeroPrestamo(Integer numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getDescripcionPrestamo() {
        return descripcionPrestamo;
    }

    public void setDescripcionPrestamo(String descripcionPrestamo) {
        this.descripcionPrestamo = descripcionPrestamo;
    }

    public Date getFechaentregaPrestamo() {
        return fechaentregaPrestamo;
    }

    public void setFechaentregaPrestamo(Date fechaentregaPrestamo) {
        this.fechaentregaPrestamo = fechaentregaPrestamo;
    }

    @XmlTransient
    public List<DetalleCuda> getDetalleCudaList() {
        return detalleCudaList;
    }

    public void setDetalleCudaList(List<DetalleCuda> detalleCudaList) {
        this.detalleCudaList = detalleCudaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroPrestamo != null ? numeroPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabeceraCuda)) {
            return false;
        }
        CabeceraCuda other = (CabeceraCuda) object;
        if ((this.numeroPrestamo == null && other.numeroPrestamo != null) || (this.numeroPrestamo != null && !this.numeroPrestamo.equals(other.numeroPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack_proyecto_completo_2.bean.CabeceraCuda[ numeroPrestamo=" + numeroPrestamo + " ]";
    }
    
}
