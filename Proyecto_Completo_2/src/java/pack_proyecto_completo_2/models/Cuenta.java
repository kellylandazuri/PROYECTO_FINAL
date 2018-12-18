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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CUENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
    , @NamedQuery(name = "Cuenta.findByCodigoCuenta", query = "SELECT c FROM Cuenta c WHERE c.codigoCuenta = :codigoCuenta")
    , @NamedQuery(name = "Cuenta.findByNombreCuenta", query = "SELECT c FROM Cuenta c WHERE c.nombreCuenta = :nombreCuenta")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_CUENTA")
    private Integer codigoCuenta;
    @Size(max = 35)
    @Column(name = "NOMBRE_CUENTA")
    private String nombreCuenta;
    @JoinColumn(name = "CODIGO_TIPO", referencedColumnName = "CODIGO_TIPO")
    @ManyToOne(optional = false)
    private TipoCuenta codigoTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCuenta")
    private List<DetalleComprobante> detalleComprobanteList;

    public Cuenta() {
    }

    public Cuenta(Integer codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public Integer getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(Integer codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public TipoCuenta getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(TipoCuenta codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    @XmlTransient
    public List<DetalleComprobante> getDetalleComprobanteList() {
        return detalleComprobanteList;
    }

    public void setDetalleComprobanteList(List<DetalleComprobante> detalleComprobanteList) {
        this.detalleComprobanteList = detalleComprobanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCuenta != null ? codigoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.codigoCuenta == null && other.codigoCuenta != null) || (this.codigoCuenta != null && !this.codigoCuenta.equals(other.codigoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack_proyecto_completo_2.bean.Cuenta[ codigoCuenta=" + codigoCuenta + " ]";
    }
    
}
