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
@Table(name = "DETALLE_CUDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCuda.findAll", query = "SELECT d FROM DetalleCuda d")
    , @NamedQuery(name = "DetalleCuda.findByIsbnLibro", query = "SELECT d FROM DetalleCuda d WHERE d.detalleCudaPK.isbnLibro = :isbnLibro")
    , @NamedQuery(name = "DetalleCuda.findByNumeroPrestamo", query = "SELECT d FROM DetalleCuda d WHERE d.detalleCudaPK.numeroPrestamo = :numeroPrestamo")
    , @NamedQuery(name = "DetalleCuda.findByCantidad", query = "SELECT d FROM DetalleCuda d WHERE d.cantidad = :cantidad")})
public class DetalleCuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleCudaPK detalleCudaPK;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @JoinColumn(name = "NUMERO_PRESTAMO", referencedColumnName = "NUMERO_PRESTAMO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CabeceraCuda cabeceraCuda;
    @JoinColumn(name = "ISBN_LIBRO", referencedColumnName = "ISBN_LIBRO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LibroCuda libroCuda;

    public DetalleCuda() {
    }

    public DetalleCuda(DetalleCudaPK detalleCudaPK) {
        this.detalleCudaPK = detalleCudaPK;
    }

    public DetalleCuda(long isbnLibro, int numeroPrestamo) {
        this.detalleCudaPK = new DetalleCudaPK(isbnLibro, numeroPrestamo);
    }

    public DetalleCudaPK getDetalleCudaPK() {
        return detalleCudaPK;
    }

    public void setDetalleCudaPK(DetalleCudaPK detalleCudaPK) {
        this.detalleCudaPK = detalleCudaPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public CabeceraCuda getCabeceraCuda() {
        return cabeceraCuda;
    }

    public void setCabeceraCuda(CabeceraCuda cabeceraCuda) {
        this.cabeceraCuda = cabeceraCuda;
    }

    public LibroCuda getLibroCuda() {
        return libroCuda;
    }

    public void setLibroCuda(LibroCuda libroCuda) {
        this.libroCuda = libroCuda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleCudaPK != null ? detalleCudaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCuda)) {
            return false;
        }
        DetalleCuda other = (DetalleCuda) object;
        if ((this.detalleCudaPK == null && other.detalleCudaPK != null) || (this.detalleCudaPK != null && !this.detalleCudaPK.equals(other.detalleCudaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack_proyecto_completo_2.bean.DetalleCuda[ detalleCudaPK=" + detalleCudaPK + " ]";
    }
    
}
