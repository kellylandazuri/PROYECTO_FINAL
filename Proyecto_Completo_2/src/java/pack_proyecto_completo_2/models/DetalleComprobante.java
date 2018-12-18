/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kelog
 */
@Entity
@Table(name = "DETALLE_COMPROBANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleComprobante.findAll", query = "SELECT d FROM DetalleComprobante d")
    , @NamedQuery(name = "DetalleComprobante.findByCodigoDDetalle", query = "SELECT d FROM DetalleComprobante d WHERE d.codigoDDetalle = :codigoDDetalle")
    , @NamedQuery(name = "DetalleComprobante.findByCantidadDebe", query = "SELECT d FROM DetalleComprobante d WHERE d.cantidadDebe = :cantidadDebe")
    , @NamedQuery(name = "DetalleComprobante.findByCantidadHaber", query = "SELECT d FROM DetalleComprobante d WHERE d.cantidadHaber = :cantidadHaber")})
public class DetalleComprobante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_D_DETALLE")
    private Integer codigoDDetalle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD_DEBE")
    private BigDecimal cantidadDebe;
    @Column(name = "CANTIDAD_HABER")
    private BigDecimal cantidadHaber;
    @JoinColumn(name = "NUMERO_CABECERA", referencedColumnName = "NUMERO_CABECERA")
    @ManyToOne(optional = false)
    private CabeceraComprobante numeroCabecera;
    @JoinColumn(name = "CODIGO_CUENTA", referencedColumnName = "CODIGO_CUENTA")
    @ManyToOne(optional = false)
    private Cuenta codigoCuenta;

    public DetalleComprobante() {
    }

    public DetalleComprobante(Integer codigoDDetalle) {
        this.codigoDDetalle = codigoDDetalle;
    }

    public Integer getCodigoDDetalle() {
        return codigoDDetalle;
    }

    public void setCodigoDDetalle(Integer codigoDDetalle) {
        this.codigoDDetalle = codigoDDetalle;
    }

    public BigDecimal getCantidadDebe() {
        return cantidadDebe;
    }

    public void setCantidadDebe(BigDecimal cantidadDebe) {
        this.cantidadDebe = cantidadDebe;
    }

    public BigDecimal getCantidadHaber() {
        return cantidadHaber;
    }

    public void setCantidadHaber(BigDecimal cantidadHaber) {
        this.cantidadHaber = cantidadHaber;
    }

    public CabeceraComprobante getNumeroCabecera() {
        return numeroCabecera;
    }

    public void setNumeroCabecera(CabeceraComprobante numeroCabecera) {
        this.numeroCabecera = numeroCabecera;
    }

    public Cuenta getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(Cuenta codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDDetalle != null ? codigoDDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleComprobante)) {
            return false;
        }
        DetalleComprobante other = (DetalleComprobante) object;
        if ((this.codigoDDetalle == null && other.codigoDDetalle != null) || (this.codigoDDetalle != null && !this.codigoDDetalle.equals(other.codigoDDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack_proyecto_completo_2.bean.DetalleComprobante[ codigoDDetalle=" + codigoDDetalle + " ]";
    }
    
}
