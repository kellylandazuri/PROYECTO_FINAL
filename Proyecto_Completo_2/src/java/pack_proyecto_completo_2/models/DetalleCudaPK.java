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
public class DetalleCudaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ISBN_LIBRO")
    private long isbnLibro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO_PRESTAMO")
    private int numeroPrestamo;

    public DetalleCudaPK() {
    }

    public DetalleCudaPK(long isbnLibro, int numeroPrestamo) {
        this.isbnLibro = isbnLibro;
        this.numeroPrestamo = numeroPrestamo;
    }

    public long getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(long isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public int getNumeroPrestamo() {
        return numeroPrestamo;
    }

    public void setNumeroPrestamo(int numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) isbnLibro;
        hash += (int) numeroPrestamo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCudaPK)) {
            return false;
        }
        DetalleCudaPK other = (DetalleCudaPK) object;
        if (this.isbnLibro != other.isbnLibro) {
            return false;
        }
        if (this.numeroPrestamo != other.numeroPrestamo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack_proyecto_completo_2.bean.DetalleCudaPK[ isbnLibro=" + isbnLibro + ", numeroPrestamo=" + numeroPrestamo + " ]";
    }
    
}
