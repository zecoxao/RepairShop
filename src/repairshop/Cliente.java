/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repairshop;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;

/**
 *
 * @author zecoxao
 */
@Entity
@Table(name = "CLIENTE", catalog = "", schema = "ZECOXAO")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByClienteId", query = "SELECT c FROM Cliente c WHERE c.clienteId = :clienteId"),
    @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cliente.findByContacto", query = "SELECT c FROM Cliente c WHERE c.contacto = :contacto"),
    @NamedQuery(name = "Cliente.findByBi", query = "SELECT c FROM Cliente c WHERE c.bi = :bi"),
    @NamedQuery(name = "Cliente.findByNomeLike",query = "SELECT c FROM Cliente c WHERE c.nome LIKE :nome")})
public class Cliente implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CLIENTE_ID")
    private BigDecimal clienteId;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "CONTACTO")
    private int contacto;
    @Basic(optional = false)
    @Column(name = "BI")
    private int bi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Ficha> fichaList;

    public Cliente() {
    }

    public Cliente(BigDecimal clienteId) {
        this.clienteId = clienteId;
    }

    public Cliente(BigDecimal clienteId, String nome, int contacto, int bi) {
        this.clienteId = clienteId;
        this.nome = nome;
        this.contacto = contacto;
        this.bi = bi;
    }

    public BigDecimal getClienteId() {
        return clienteId;
    }

    public void setClienteId(BigDecimal clienteId) {
        BigDecimal oldClienteId = this.clienteId;
        this.clienteId = clienteId;
        changeSupport.firePropertyChange("clienteId", oldClienteId, clienteId);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        int oldContacto = this.contacto;
        this.contacto = contacto;
        changeSupport.firePropertyChange("contacto", oldContacto, contacto);
    }

    public int getBi() {
        return bi;
    }

    public void setBi(int bi) {
        int oldBi = this.bi;
        this.bi = bi;
        changeSupport.firePropertyChange("bi", oldBi, bi);
    }

    public List<Ficha> getFichaList() {
        return fichaList;
    }

    public void setFichaList(List<Ficha> fichaList) {
        this.fichaList = fichaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteId != null ? clienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clienteId == null && other.clienteId != null) || (this.clienteId != null && !this.clienteId.equals(other.clienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repairshop.Cliente[ clienteId=" + clienteId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
