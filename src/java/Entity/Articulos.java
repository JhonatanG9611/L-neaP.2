/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhong
 */
@Entity
@Table(name = "articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulos.findAll", query = "SELECT a FROM Articulos a")
    , @NamedQuery(name = "Articulos.findByIdarticulo", query = "SELECT a FROM Articulos a WHERE a.idarticulo = :idarticulo")
    , @NamedQuery(name = "Articulos.findByNomArticulo", query = "SELECT a FROM Articulos a WHERE a.nomArticulo = :nomArticulo")
    , @NamedQuery(name = "Articulos.findByMedida", query = "SELECT a FROM Articulos a WHERE a.medida = :medida")
    , @NamedQuery(name = "Articulos.findByStock", query = "SELECT a FROM Articulos a WHERE a.stock = :stock")})
public class Articulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idarticulo")
    private Integer idarticulo;
    @Basic(optional = false)
    @Column(name = "nom_articulo")
    private String nomArticulo;
    @Basic(optional = false)
    @Column(name = "medida")
    private String medida;
    @Basic(optional = false)
    @Column(name = "stock")
    private int stock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarticulo")
    private Collection<AjusteInventario> ajusteInventarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarticulo")
    private Collection<DetalleProductos> detalleProductosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarticulo")
    private Collection<DetalleCompra> detalleCompraCollection;

    public Articulos() {
    }

    public Articulos(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }

    public Articulos(Integer idarticulo, String nomArticulo, String medida, int stock) {
        this.idarticulo = idarticulo;
        this.nomArticulo = nomArticulo;
        this.medida = medida;
        this.stock = stock;
    }

    public Integer getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }

    public String getNomArticulo() {
        return nomArticulo;
    }

    public void setNomArticulo(String nomArticulo) {
        this.nomArticulo = nomArticulo;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @XmlTransient
    public Collection<AjusteInventario> getAjusteInventarioCollection() {
        return ajusteInventarioCollection;
    }

    public void setAjusteInventarioCollection(Collection<AjusteInventario> ajusteInventarioCollection) {
        this.ajusteInventarioCollection = ajusteInventarioCollection;
    }

    @XmlTransient
    public Collection<DetalleProductos> getDetalleProductosCollection() {
        return detalleProductosCollection;
    }

    public void setDetalleProductosCollection(Collection<DetalleProductos> detalleProductosCollection) {
        this.detalleProductosCollection = detalleProductosCollection;
    }

    @XmlTransient
    public Collection<DetalleCompra> getDetalleCompraCollection() {
        return detalleCompraCollection;
    }

    public void setDetalleCompraCollection(Collection<DetalleCompra> detalleCompraCollection) {
        this.detalleCompraCollection = detalleCompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarticulo != null ? idarticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulos)) {
            return false;
        }
        Articulos other = (Articulos) object;
        if ((this.idarticulo == null && other.idarticulo != null) || (this.idarticulo != null && !this.idarticulo.equals(other.idarticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Articulos[ idarticulo=" + idarticulo + " ]";
    }
    
}
