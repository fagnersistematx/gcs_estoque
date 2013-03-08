package Entidade.Conta;

import Entidade.Cliente;
import Entidade.Fornecedor;
import Entidade.Funcionario;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author fagner
 */
@MappedSuperclass
public abstract class Fluxo {

    private String nome;
    private String obs;
    @OneToOne(cascade = {CascadeType.MERGE})
    private Conta conta;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar criacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar data_fluxo;
    @OneToOne(cascade = {CascadeType.MERGE})
    private Funcionario funcionario;
    @OneToOne(cascade = {CascadeType.MERGE})
    private Cliente cliente;
    @OneToOne(cascade = {CascadeType.MERGE})
    private Fornecedor fornecedor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Calendar getCriacao() {
        return criacao;
    }

    public void setCriacao(Calendar criacao) {
        this.criacao = criacao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Calendar getData_fluxo() {
        return data_fluxo;
    }

    public void setData_fluxo(Calendar data_fluxo) {
        this.data_fluxo = data_fluxo;
    }
}
