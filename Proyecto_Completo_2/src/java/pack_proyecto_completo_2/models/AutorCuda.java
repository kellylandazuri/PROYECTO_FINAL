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
@Table(name = "AUTOR_CUDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutorCuda.findAll", query = "SELECT a FROM AutorCuda a")
    , @NamedQuery(name = "AutorCuda.findByCodigoAutor", query = "SELECT a FROM AutorCuda a WHERE a.codigoAutor = :codigoAutor")
    , @NamedQuery(name = "AutorCuda.findByNombreAutor", query = "SELECT a FROM AutorCuda a WHERE a.nombreAutor = :nombreAutor")
    , @NamedQuery(name = "AutorCuda.findByApellidoAutor", query = "SELECT a FROM AutorCuda a WHERE a.apellidoAutor = :apellidoAutor")})
public class AutorCuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_AUTOR")
    private Integer codigoAutor;
    @Size(max = 50)
    @Column(name = "NOMBRE_AUTOR")
    private String nombreAutor;
    @Size(max = 50)
    @Column(name = "APELLIDO_AUTOR")
    private String apellidoAutor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoAutor")
    private List<LibroCuda> libroCudaList;

    public AutorCuda() {
    }

    public AutorCuda(Integer codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public Integer getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(Integer codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }

    public void setApellidoAutor(String apellidoAutor) {
        this.apellidoAutor = apellidoAutor;
    }

    @XmlTransient
    public List<LibroCuda> getLibroCudaList() {
        return libroCudaList;
    }

    public void setLibroCudaList(List<LibroCuda> libroCudaList) {
        this.libroCudaList = libroCudaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAutor != null ? codigoAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorCuda)) {
            return false;
        }
        AutorCuda other = (AutorCuda) object;
        if ((this.codigoAutor == null && other.codigoAutor != null) || (this.codigoAutor != null && !this.codigoAutor.equals(other.codigoAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack_proyecto_completo_2.bean.AutorCuda[ codigoAutor=" + codigoAutor + " ]";
    }
    
}
