/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhong
 */
@Entity
@Table(name = "abonos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Abonos.findAll", query = "SELECT a FROM Abonos a")
    , @NamedQuery(name = "Abonos.findById", query = "SELECT a FROM Abonos a WHERE a.id = :id")
    , @NamedQuery(name = "Abonos.findByTipoPago", query = "SELECT a FROM Abonos a WHERE a.tipoPago = :tipoPago")
    , @NamedQuery(name = "Abonos.findByValorAbono", query = "SELECT a FROM Abonos a WHERE a.valorAbono = :valorAbono")
    , @NamedQuery(name = "Abonos.findByFecha", query = "SELECT a FROM Abonos a WHERE a.fecha = :fecha")})
public class Abonos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipo_pago")
    private String tipoPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor_abono")
    private BigDecimal valorAbono;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idventa", referencedColumnName = "idventa")
    @ManyToOne(optional = false)
    private Ventas idventa;

    public Abonos() {
    }

    public Abonos(Integer id) {
        this.id = id;
    }

    public Abonos(Integer id, String tipoPago, BigDecimal valorAbono, Date fecha) {
        this.id = id;
        this.tipoPago = tipoPago;
        this.valorAbono = valorAbono;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public BigDecimal getValorAbono() {
        return valorAbono;
    }

    public void setValorAbono(BigDecimal valorAbono) {
        this.valorAbono = valorAbono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Ventas getIdventa() {
        return idventa;
    }

    public void setIdventa(Ventas idventa) {
        this.idventa = idventa;
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
        if (!(object instanceof Abonos)) {
            return false;
        }
        Abonos other = (Abonos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Abonos[ id=" + id + " ]";
    }
    
}
