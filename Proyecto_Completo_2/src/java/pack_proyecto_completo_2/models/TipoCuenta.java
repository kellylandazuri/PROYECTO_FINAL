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
@Table(name = "TIPO_CUENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCuenta.findAll", query = "SELECT t FROM TipoCuenta t")
    , @NamedQuery(name = "TipoCuenta.findByCodigoTipo", query = "SELECT t FROM TipoCuenta t WHERE t.codigoTipo = :codigoTipo")
    , @NamedQuery(name = "TipoCuenta.findByNombreTipo", query = "SELECT t FROM TipoCuenta t WHERE t.nombreTipo = :nombreTipo")})
public class TipoCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_TIPO")
    private Integer codigoTipo;
    @Size(max = 35)
    @Column(name = "NOMBRE_TIPO")
    private String nombreTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTipo")
    private List<Cuenta> cuentaList;

    public TipoCuenta() {
    }

    public TipoCuenta(Integer codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public Integer getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(Integer codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTipo != null ? codigoTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuenta)) {
            return false;
        }
        TipoCuenta other = (TipoCuenta) object;
        if ((this.codigoTipo == null && other.codigoTipo != null) || (this.codigoTipo != null && !this.codigoTipo.equals(other.codigoTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack_proyecto_completo_2.bean.TipoCuenta[ codigoTipo=" + codigoTipo + " ]";
    }
    
}
