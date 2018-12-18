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
@Table(name = "LIBRO_CUDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibroCuda.findAll", query = "SELECT l FROM LibroCuda l")
    , @NamedQuery(name = "LibroCuda.findByIsbnLibro", query = "SELECT l FROM LibroCuda l WHERE l.isbnLibro = :isbnLibro")
    , @NamedQuery(name = "LibroCuda.findByTituloLibro", query = "SELECT l FROM LibroCuda l WHERE l.tituloLibro = :tituloLibro")
    , @NamedQuery(name = "LibroCuda.findByValorLibro", query = "SELECT l FROM LibroCuda l WHERE l.valorLibro = :valorLibro")
    , @NamedQuery(name = "LibroCuda.findByCantidadLibro", query = "SELECT l FROM LibroCuda l WHERE l.cantidadLibro = :cantidadLibro")})
public class LibroCuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ISBN_LIBRO")
    private Long isbnLibro;
    @Size(max = 256)
    @Column(name = "TITULO_LIBRO")
    private String tituloLibro;
    @Column(name = "VALOR_LIBRO")
    private Long valorLibro;
    @Column(name = "CANTIDAD_LIBRO")
    private Integer cantidadLibro;
    @JoinColumn(name = "CODIGO_AUTOR", referencedColumnName = "CODIGO_AUTOR")
    @ManyToOne(optional = false)
    private AutorCuda codigoAutor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "libroCuda")
    private List<DetalleCuda> detalleCudaList;

    public LibroCuda() {
    }

    public LibroCuda(Long isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public Long getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(Long isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public Long getValorLibro() {
        return valorLibro;
    }

    public void setValorLibro(Long valorLibro) {
        this.valorLibro = valorLibro;
    }

    public Integer getCantidadLibro() {
        return cantidadLibro;
    }

    public void setCantidadLibro(Integer cantidadLibro) {
        this.cantidadLibro = cantidadLibro;
    }

    public AutorCuda getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(AutorCuda codigoAutor) {
        this.codigoAutor = codigoAutor;
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
        hash += (isbnLibro != null ? isbnLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroCuda)) {
            return false;
        }
        LibroCuda other = (LibroCuda) object;
        if ((this.isbnLibro == null && other.isbnLibro != null) || (this.isbnLibro != null && !this.isbnLibro.equals(other.isbnLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack_proyecto_completo_2.bean.LibroCuda[ isbnLibro=" + isbnLibro + " ]";
    }
    
}
