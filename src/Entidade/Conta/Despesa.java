package Entidade.Conta;

import Entidade.Cliente;
import Entidade.Fornecedor;
import Entidade.Funcionario;
import Entidade.Pessoa;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author fagner
 */
@Entity
@Table(name = "despesa")
public class Despesa extends Fluxo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float valor;    
    @OneToOne(cascade = {CascadeType.MERGE})
    private ItensPlanoConta itensPlanoConta;

    public Despesa() {
    }

    public Despesa(String nome, float valor, String obs, Calendar criacao, Calendar data_fluxo, Pessoa pessoa, ItensPlanoConta itensPlanoConta, Conta conta) {
       
        if ((pessoa instanceof Fornecedor)) {
            Fornecedor f = (Fornecedor) pessoa;
            super.setFornecedor(f);
        } else if ((pessoa instanceof Funcionario)) {
            Funcionario f = (Funcionario) pessoa;   
            super.setFuncionario(f);
        } else if ((pessoa instanceof Cliente)) {
            Cliente c = (Cliente) pessoa;
            super.setCliente(c);
        }
        this.valor = valor;
        this.itensPlanoConta = itensPlanoConta;
        super.setData_fluxo(data_fluxo);
        super.setNome(nome);
        super.setObs(obs);
        super.setCriacao(criacao);
        super.setConta(conta);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public ItensPlanoConta getItensPlanoConta() {
        return itensPlanoConta;
    }

    public void setItensPlanoConta(ItensPlanoConta itensPlanoConta) {
        this.itensPlanoConta = itensPlanoConta;
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
        if (!(object instanceof Despesa)) {
            return false;
        }
        Despesa other = (Despesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Despesa{" + "id=" + id + ", valor=" + valor + ", itensPlanoConta=" + itensPlanoConta + '}'+getConta().getId();
    }
}
