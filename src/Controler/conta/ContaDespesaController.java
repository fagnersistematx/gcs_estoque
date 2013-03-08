package Controler.conta;

import Entidade.Cliente;
import Entidade.Conta.Conta;
import Entidade.Conta.Despesa;
import Entidade.Conta.Exception.FluxoDespesaException;
import Entidade.Conta.ItensPlanoConta;
import Entidade.Fornecedor;
import Entidade.Funcionario;
import Entidade.Pessoa;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Fagner Silva Martins, fagner.silva@dce.ufpb.br
 * @version 1.0
 */
public class ContaDespesaController {

    private DAO dao;

    public ContaDespesaController() {
        dao = new DAO();
    }

    public Despesa criarFluxoDespesa(Despesa despesa) throws FluxoDespesaException {

        dao.create(despesa);
        return despesa;

    }

    public void alterarContaDespesa(Long id, String nome, float valor, String obs, Calendar criacao, Calendar data_fluxo,
            Pessoa pessoa, ItensPlanoConta itensPlanoConta) throws FluxoDespesaException {
        try {
            Despesa despesa = (Despesa) dao.findObject(id, Despesa.class);
            despesa.setCriacao(criacao);
            despesa.setNome(nome);
            despesa.setObs(obs);
            despesa.setValor(valor);
            despesa.setItensPlanoConta(itensPlanoConta);
            despesa.setData_fluxo(data_fluxo);
            dao.edit(despesa);
        } catch (ClassNotFoundException ex) {
            throw new FluxoDespesaException("Erro ao alterar despesa. " + ex.getMessage());
        } catch (NonexistentEntityException ex) {
            throw new FluxoDespesaException("Erro ao alterar despesa. " + ex.getMessage());
        } catch (Exception ex) {
            throw new FluxoDespesaException("Erro ao alterar despesa. " + ex.getMessage());
        }


    }

    public Despesa busca(Long id) throws FluxoDespesaException {
        Despesa despesa = null;
        try {
            despesa = (Despesa) dao.findObject(id, Despesa.class);
        } catch (Exception ex) {
            throw new FluxoDespesaException("Erro ao buscar despesa. " + ex.getMessage());
        }

        return despesa;
    }

    public void remover(Long id) throws FluxoDespesaException {
        try {
            dao.destroy(id, Despesa.class);
        } catch (NonexistentEntityException ex) {
            throw new FluxoDespesaException("Erro ao deletar despesa. " + ex.getMessage());
        }
    }

    public int cont() {
        return dao.getObjectCount(Despesa.class);
    }

    public List<Object> listaDespesa() {
        return dao.findObjectEntities(Despesa.class);
    }

    public List<Object> despesaConta(Conta conta, Pessoa pessoa, ItensPlanoConta itensPlanoConta) {
        String query = "";
        int cont = 0;
        if (conta != null) {
            query += " WHERE c.conta = " + conta.getId();
            cont++;
        }

        if (itensPlanoConta != null) {
            if (cont == 0) {
                query += " WHERE";
            } else {
                query += " AND";
            }
            query += " c.itensPlanoConta = " + itensPlanoConta.getId();
            cont++;
        }
        if (pessoa != null) {
            if (cont == 0) {
                query += " WHERE";
            } else {
                query += " AND";
            }
            if (pessoa instanceof Cliente) {
                Cliente c = (Cliente) pessoa;
                query += " c.cliente = " + c.getId();
            } else if (pessoa instanceof Fornecedor) {
                Fornecedor c = (Fornecedor) pessoa;
                query += " c.fornecedor = " + c.getId();
            } else if (pessoa instanceof Funcionario) {
                Funcionario c = (Funcionario) pessoa;
                query += " c.funcionario = " + c.getId();
            }
        }

        return dao.createQuerySelect("Despesa c" + query);
    }
}
