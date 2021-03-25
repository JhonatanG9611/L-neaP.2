/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jhong
 */
@Entity
@Table(name = "compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c")
    , @NamedQuery(name = "Compras.findByIdcompra", query = "SELECT c FROM Compras c WHERE c.idcompra = :idcompra")
    , @NamedQuery(name = "Compras.findByComprobante", query = "SELECT c FROM Compras c WHERE c.comprobante = :comprobante")
    , @NamedQuery(name = "Compras.findByNumComprobante", query = "SELECT c FROM Compras c WHERE c.numComprobante = :numComprobante")
    , @NamedQuery(name = "Compras.findByDescripcion", query = "SELECT c FROM Compras c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Compras.findByFecha", query = "SELECT c FROM Compras c WHERE c.fecha = :fecha")})
public class Compras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcompra")
    private Integer idcompra;
    @Basic(optional = false)
    @Column(name = "comprobante")
    private String comprobante;
    @Basic(optional = false)
    @Column(name = "num_comprobante")
    private int numComprobante;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuarios idusuario;
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor")
    @ManyToOne(optional = false)
    private Proveedores idproveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcompra")
    private Collection<DetalleCompra> detalleCompraCollection;

    public Compras() {
    }

    public Compras(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Compras(Integer idcompra, String comprobante, int numComprobante, String descripcion, Date fecha) {
        this.idcompra = idcompra;
        this.comprobante = comprobante;
        this.numComprobante = numComprobante;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public int getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(int numComprobante) {
        this.numComprobante = numComprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuarios getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
    }

    public Proveedores getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Proveedores idproveedor) {
        this.idproveedor = idproveedor;
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
        hash += (idcompra != null ? idcompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.idcompra == null && other.idcompra != null) || (this.idcompra != null && !this.idcompra.equals(other.idcompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Compras[ idcompra=" + idcompra + " ]";
    }
    
}
