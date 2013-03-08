package Controler.conta;

import Entidade.Cliente;
import Entidade.Conta.Conta;
import Entidade.Conta.Exception.FluxoReceitaException;
import Entidade.Conta.ItensPlanoConta;
import Entidade.Conta.PlanoConta;
import Entidade.Conta.Receita;
import Entidade.Fornecedor;
import Entidade.Funcionario;
import Entidade.Pessoa;
import Util.DAO;
import br.com.Banco.DAO.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author Fagner Silva Martins
 * @version 1.0
 */
public class ContaReceitaController {

    private DAO dao;

    public ContaReceitaController() {
        dao = new DAO();
    }

    public Receita criarFluxoReceita(Receita receita) throws FluxoReceitaException {
        dao.create(receita);
        return receita;
    }

    public void alterarContaReceita(Receita receita) throws FluxoReceitaException {
        try {
            dao.edit(receita);
        } catch (ClassNotFoundException ex) {
            throw new FluxoReceitaException("Erro ao alterar receita. " + ex.getMessage());
        } catch (NonexistentEntityException ex) {
            throw new FluxoReceitaException("Erro ao alterar receita. " + ex.getMessage());
        } catch (Exception ex) {
            throw new FluxoReceitaException("Erro ao alterar receita. " + ex.getMessage());
        }


    }

    public Receita busca(Long id) throws FluxoReceitaException {
        Receita receita = null;
        try {
            receita = (Receita) dao.findObject(id, Receita.class);
        } catch (Exception ex) {
            throw new FluxoReceitaException("Erro ao buscar receita. " + ex.getMessage());
        }

        return receita;
    }

    public List<Object> listaReceita() {
        return dao.findObjectEntities(Receita.class);
    }

    public void remover(Long id) throws FluxoReceitaException {
        try {
            dao.destroy(id, Receita.class);
        } catch (NonexistentEntityException ex) {
            throw new FluxoReceitaException("Erro ao deletar receita. " + ex.getMessage());
        }
    }

    public int cont() {
        return dao.getObjectCount(Receita.class);
    }

    public List<Object> receitaConta(Conta conta, Pessoa pessoa, ItensPlanoConta itensPlanoConta) {
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
            query += " c.plano = " + itensPlanoConta.getId();
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

        return dao.createQuerySelect("Receita c" + query);
    }
}
