/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repairshop;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 *
 * @author zecoxao
 */
@Entity
@Table(name = "FICHA", catalog = "", schema = "ZECOXAO")
@NamedQueries({
    @NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f"),
    @NamedQuery(name = "Ficha.findByFichaId", query = "SELECT f FROM Ficha f WHERE f.fichaId = :fichaId"),
    @NamedQuery(name = "Ficha.findByRest", query = "SELECT f FROM Ficha f WHERE f.equipamento = :equipamento AND f.avaria = :avaria AND f.orcamento = :orcamento AND f.pagamentoCaucao = :pagamentoCaucao"),
    @NamedQuery(name = "Ficha.findByEquipamento", query = "SELECT f FROM Ficha f WHERE f.equipamento = :equipamento"),
    @NamedQuery(name = "Ficha.findByAvaria", query = "SELECT f FROM Ficha f WHERE f.avaria = :avaria"),
    @NamedQuery(name = "Ficha.findByOrcamento", query = "SELECT f FROM Ficha f WHERE f.orcamento = :orcamento"),
    @NamedQuery(name = "Ficha.findByPagamentoCaucao", query = "SELECT f FROM Ficha f WHERE f.pagamentoCaucao = :pagamentoCaucao"),
    @NamedQuery(name = "Ficha.findByDataEntrega", query = "SELECT f FROM Ficha f WHERE f.dataEntrega = :dataEntrega"),
    @NamedQuery(name = "Ficha.findByEquipamentoLike",query = "SELECT f FROM Ficha f WHERE f.equipamento LIKE :equipamento")})
public class Ficha implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SEQ",sequenceName = "zecoxao.ficha_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ" )
    @Basic(optional = false)
    @Column(name = "FICHA_ID")
    private BigDecimal fichaId;
    @Basic(optional = false)
    @Column(name = "EQUIPAMENTO")
    private String equipamento;
    @Basic(optional = false)
    @Column(name = "AVARIA")
    private String avaria;
    @Basic(optional = false)
    @Column(name = "ORCAMENTO")
    private BigDecimal orcamento;
    @Basic(optional = false)
    @Column(name = "PAGAMENTO_CAUCAO")
    private BigDecimal pagamentoCaucao;
    @Basic(optional = false)
    @Column(name = "DATA_ENTREGA")
    private String dataEntrega = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
    @JoinColumn(name = "CLIENTE", referencedColumnName = "CLIENTE_ID")
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Ficha() {
    }

    public Ficha(BigDecimal fichaId) {
        this.fichaId = fichaId;
    }

    public Ficha(BigDecimal fichaId, String equipamento, String avaria, BigDecimal orcamento, BigDecimal pagamentoCaucao, String dataEntrega) {
        this.fichaId = fichaId;
        this.equipamento = equipamento;
        this.avaria = avaria;
        this.orcamento = orcamento;
        this.pagamentoCaucao = pagamentoCaucao;
        this.dataEntrega = dataEntrega;
    }

    public BigDecimal getFichaId() {
        return fichaId;
    }

    public void setFichaId(BigDecimal fichaId) {
        BigDecimal oldFichaId = this.fichaId;
        this.fichaId = fichaId;
        changeSupport.firePropertyChange("fichaId", oldFichaId, fichaId);
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        String oldEquipamento = this.equipamento;
        this.equipamento = equipamento;
        changeSupport.firePropertyChange("equipamento", oldEquipamento, equipamento);
    }

    public String getAvaria() {
        return avaria;
    }

    public void setAvaria(String avaria) {
        String oldAvaria = this.avaria;
        this.avaria = avaria;
        changeSupport.firePropertyChange("avaria", oldAvaria, avaria);
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(BigDecimal orcamento) {
        BigDecimal oldOrcamento = this.orcamento;
        this.orcamento = orcamento;
        changeSupport.firePropertyChange("orcamento", oldOrcamento, orcamento);
    }

    public BigDecimal getPagamentoCaucao() {
        return pagamentoCaucao;
    }

    public void setPagamentoCaucao(BigDecimal pagamentoCaucao) {
        BigDecimal oldPagamentoCaucao = this.pagamentoCaucao;
        this.pagamentoCaucao = pagamentoCaucao;
        changeSupport.firePropertyChange("pagamentoCaucao", oldPagamentoCaucao, pagamentoCaucao);
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        String oldDataEntrega = this.dataEntrega;
        this.dataEntrega = dataEntrega;
        changeSupport.firePropertyChange("dataEntrega", oldDataEntrega, dataEntrega);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente oldCliente = this.cliente;
        this.cliente = cliente;
        changeSupport.firePropertyChange("cliente", oldCliente, cliente);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fichaId != null ? fichaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.fichaId == null && other.fichaId != null) || (this.fichaId != null && !this.fichaId.equals(other.fichaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repairshop.Ficha[ fichaId=" + fichaId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
