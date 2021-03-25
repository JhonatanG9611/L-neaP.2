/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhong
 */
@Entity
@Table(name = "detalle_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleProductos.findAll", query = "SELECT d FROM DetalleProductos d")
    , @NamedQuery(name = "DetalleProductos.findById", query = "SELECT d FROM DetalleProductos d WHERE d.id = :id")
    , @NamedQuery(name = "DetalleProductos.findByCantidad", query = "SELECT d FROM DetalleProductos d WHERE d.cantidad = :cantidad")})
public class DetalleProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "idarticulo", referencedColumnName = "idarticulo")
    @ManyToOne(optional = false)
    private Articulos idarticulo;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Productos idproducto;

    public DetalleProductos() {
    }

    public DetalleProductos(Integer id) {
        this.id = id;
    }

    public DetalleProductos(Integer id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Articulos getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Articulos idarticulo) {
        this.idarticulo = idarticulo;
    }

    public Productos getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Productos idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleProductos)) {
            return false;
        }
        DetalleProductos other = (DetalleProductos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DetalleProductos[ id=" + id + " ]";
    }
    
}
