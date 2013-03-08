package Controler;

import Entidade.Backup;
import Entidade.Configuracao;
import Entidade.Conta.Conta;
import Entidade.Conta.ItensPlanoConta;
import Entidade.Conta.PlanoConta;
import Entidade.Funcionario;
import Util.Config;
import Util.DAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Fagner
 */
public class ControleConfiguracao {

    private static DAO dao;
    private static List<Object> confs;
    private ControleBackup controleBackup;

    public ControleConfiguracao() {
        dao = new DAO();
        confs = new ArrayList<Object>();
        controleBackup = new ControleBackup();
    }

    private void criarConfiguracao() {
        try {
            Configuracao configuracao = new Configuracao(
                    "C:/Program Files (x86)/Microsoft Office/Office14/WINWORD.exe",
                    "C:/Program Files (x86)/Microsoft Office/Office14/excel.exe",
                    "C:/Program Files (x86)/Microsoft Office/Office14/POWERPNT.exe",
                    "C:/Program Files (x86)/TeamViewer/Version7/TeamViewer.exe",
                    "C:/Windows/System32/calc.exe",
                    "C:/",
                    "127.0.0.1",
                    "/Imagens/logo.jpg",
                    "",
                    Calendar.getInstance());

            dao.create(configuracao);
        } catch (Exception erro) {
        }
    }

    public boolean verificar() {
        try {
            confs = dao.findObjectEntities(Configuracao.class);

            if (dao.getObjectCount(Funcionario.class) == 0) {
                salvarUsuario();
            }
            if (dao.getObjectCount(PlanoConta.class) == 0) {
                salvarPlanoDespesa();
                salvarPlanoReceita();
            }
            if (dao.getObjectCount(Conta.class) == 0) {
                salvarConta();
            }
            if (confs.size() > 0) {
                verificarBackup v = new verificarBackup();
                v.start();
                return true;
            } else {
                criarConfiguracao();
                verificarBackup v = new verificarBackup();
                v.start();
                return true;
            }

        } catch (Exception erro) {
            return false;
        }
    }

    public static Configuracao getCongiguracao() {

        Configuracao c = (Configuracao) confs.get(0);

        return c;
    }

    public static void salvarCongiguracao(Configuracao c) {
        try {

            dao.edit(c);
            JOptionPane.showMessageDialog(null, "Salvo");

        } catch (Exception erro) {
        }
    }

    private static void salvarUsuario() {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome("Sistema GCS");
            funcionario.setLogin("GCS");
            funcionario.setSenha("GCS");
            dao.create(funcionario);
        } catch (Exception erro) {
        }
    }

    private void salvarConta() {
        try {
            Conta conta = new Conta();
            conta.setNome("Caixa");
            conta.setValor(0);
            dao.create(conta);
        } catch (Exception erro) {
        }
    }

    private class verificarBackup extends Thread {

        private ControleBackup controleBackup;

        @Override
        public void run() {
            controleBackup = new ControleBackup();
            verificarBackup();
        }

        private void verificarBackup() {
            List<Backup> backups = new ArrayList<Backup>();
            backups = controleBackup.pesquisar(1, Calendar.getInstance());

            if (backups.isEmpty()) {
                BackupAutomatico();
                return;
            }

            Calendar aux = backups.get(0).getData_bkp();

            for (int i = 0; i < backups.size(); ++i) {
                if (aux.before(backups.get(i).getData_bkp()) && !backups.get(i).getTipo().equalsIgnoreCase("Restauração")) {
                    aux = backups.get(i).getData_bkp();
                }
            }

            if (getCongiguracao().getTempo_backup().equalsIgnoreCase("")) {
                return;
            } else if (getCongiguracao().getTempo_backup().equalsIgnoreCase("Anual")) {

                if (aux.get(Calendar.YEAR) != Calendar.getInstance().get(Calendar.YEAR)) {

                    BackupAutomatico();

                }

            } else if (getCongiguracao().getTempo_backup().equalsIgnoreCase("Desativado")) {
                return;
            } else if (getCongiguracao().getTempo_backup().equalsIgnoreCase("Diario")) {

                BackupAutomatico();

            } else if (getCongiguracao().getTempo_backup().equalsIgnoreCase("Mensal")) {
                if (aux.get(Calendar.MONTH) != Calendar.getInstance().get(Calendar.MONTH)) {

                    BackupAutomatico();

                }

            } else if (getCongiguracao().getTempo_backup().equalsIgnoreCase("Semanal")) {

                if (aux.get(Calendar.WEEK_OF_YEAR) != Calendar.getInstance().get(Calendar.WEEK_OF_YEAR)) {
                    BackupAutomatico();
                }
            }
        }
    }

    private void BackupAutomatico() {
        try {
            Funcionario u = new Funcionario();
            u.setNome("Sistema GCS");
            Config.setUsuario(u);
            String arquivo = null;
            arquivo = getCongiguracao().getPath_backup() + "/backup_sistema.sql";
            String MYSQL_PATH = "C:/xampp/mysql/bin/";
            String DATABASES = "gcs";
            List<String> dbList = new ArrayList<String>();

            String command = MYSQL_PATH + "mysqldump.exe";

            String[] databases = DATABASES.split(" ");

            for (int i = 0; i < databases.length; i++) {
                dbList.add(databases[i]);
            }

            int i = 1;
            long time1, time2, time;

            time1 = System.currentTimeMillis();

            for (String dbName : dbList) {

                ProcessBuilder pb = new ProcessBuilder(
                        command,
                        "--user=root",
                        "--password=",
                        dbName,
                        "--result-file=" + arquivo);

                try {

                    pb.start();

                } catch (Exception e) {

                    e.printStackTrace();

                }
                i++;
            }

            time2 = System.currentTimeMillis();
            time = time2 - time1;

            try {

                Thread.sleep(2000);

            } catch (Exception e) {
            }

            controleBackup.cadastraBackup(Backup.TIPOAUTO, arquivo);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no Backup manual.", "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salvarPlanoDespesa() {

        List<PlanoConta> planoContas = new ArrayList<PlanoConta>();

        String[] menuStr = {"Escritório", "Financeiro", "Impostos", "Manutenção", "Pessoal",
            "Serviços Públicos", "Suprimentos", "Transporte", "Vendas", "Viagem"};

        for (int i = 0; i < menuStr.length; i++) {
            planoContas.add(new PlanoConta(menuStr[i], false));
        }

        String[] itensEscritorio = {"Aluguel", "Equipamentos", "Jornais/Revistas",
            "Móveis"};

        List<ItensPlanoConta> ipcsEscritorio = new ArrayList<ItensPlanoConta>();
        for (int i = 0; i < itensEscritorio.length; i++) {
            ipcsEscritorio.add(new ItensPlanoConta(itensEscritorio[i]));
        }
        planoContas.get(0).setItensPlanoContas(ipcsEscritorio);


        String[] itens = {"Cobrança", "Contabilidade", "Juros", "Saque",
            "Tarifa Bancária", "Transferência"};

        List<ItensPlanoConta> ipcsFinanceiro = new ArrayList<ItensPlanoConta>();
        for (int i = 0; i < itens.length; i++) {
            ipcsFinanceiro.add(new ItensPlanoConta(itens[i]));
        }
        planoContas.get(1).setItensPlanoContas(ipcsFinanceiro);

        String[] itensImpostos = {"COFINS", "CPMF", "CSLL", "ICMS", "INSS", "IOF",
            "IPTU", "IRPJ", "ISS", "Importação", "PIS"};

        List<ItensPlanoConta> ipcsImpostos = new ArrayList<ItensPlanoConta>();
        for (int i = 0; i < itensImpostos.length; i++) {
            ipcsImpostos.add(new ItensPlanoConta(itensImpostos[i]));
        }
        planoContas.get(2).setItensPlanoContas(ipcsImpostos);

        String[] itensManutencao = {"Jardinagem", "Limpeza", "Pintura", "Reparos",
            "Outras Despesas"};

        List<ItensPlanoConta> ipcsManutencao = new ArrayList<ItensPlanoConta>();
        for (int i = 0; i < itensManutencao.length; i++) {
            ipcsManutencao.add(new ItensPlanoConta(itensManutencao[i]));
        }
        planoContas.get(3).setItensPlanoContas(ipcsManutencao);

        String[] itensPessoal = {"13º. Salário", "Cesta Básica", "FGTS", "Férias",
            "Horas Extras", "Plano de Saúde", "Salário", "Vale Transporte"};

        List<ItensPlanoConta> ipcsPessoal = new ArrayList<ItensPlanoConta>();
        for (int i = 0; i < itensPessoal.length; i++) {
            ipcsPessoal.add(new ItensPlanoConta(itensPessoal[i]));
        }
        planoContas.get(4).setItensPlanoContas(ipcsPessoal);

        String[] itensServicosPublicos = {"Eletricidade", "Gás", "Internet", "Segurança",
            "Telefone Celular", "Telefone Fixo", "Água e Esgoto"};

        List<ItensPlanoConta> ipcsServicosPublicos = new ArrayList<ItensPlanoConta>();
        for (int i = 0; i < itensServicosPublicos.length; i++) {
            ipcsServicosPublicos.add(new ItensPlanoConta(itensServicosPublicos[i]));
        }
        planoContas.get(5).setItensPlanoContas(ipcsServicosPublicos);

        String[] itensSuplimentos = {"Despensa", "Impressora/Fax", "Limpeza/Higiene", "Papelaria"};

        List<ItensPlanoConta> ipcsSuplimentos = new ArrayList<ItensPlanoConta>();
        for (int i = 0; i < itensSuplimentos.length; i++) {
            ipcsSuplimentos.add(new ItensPlanoConta(itensSuplimentos[i]));
        }
        planoContas.get(6).setItensPlanoContas(ipcsSuplimentos);

        String[] itensTransporte = {"Combustível", "Estacionamento", "Manutenção", "Multa"};

        List<ItensPlanoConta> ipcsTransporte = new ArrayList<ItensPlanoConta>();
        for (int i = 0; i < itensTransporte.length; i++) {
            ipcsTransporte.add(new ItensPlanoConta(itensTransporte[i]));
        }
        planoContas.get(7).setItensPlanoContas(ipcsTransporte);

        String[] itensVenda = {"Comissão"};

        List<ItensPlanoConta> ipcsComissao = new ArrayList<ItensPlanoConta>();
        for (int i = 0; i < itensVenda.length; i++) {
            ipcsComissao.add(new ItensPlanoConta(itensVenda[i]));
        }
        planoContas.get(8).setItensPlanoContas(ipcsComissao);

        String[] itensViagens = {"Aluguel de Carro", "Combustível", "Hospedagem",
            "Ligações Telefônicas", "Passagens", "Restaurantes"};

        List<ItensPlanoConta> ipcsViagens = new ArrayList<ItensPlanoConta>();
        for (int i = 0; i < itensViagens.length; i++) {
            ipcsViagens.add(new ItensPlanoConta(itensViagens[i]));
        }
        planoContas.get(9).setItensPlanoContas(ipcsViagens);

        for (PlanoConta pc : planoContas) {
            dao.create(pc);
        }
    }

    private void salvarPlanoReceita() {

        List<PlanoConta> planoContas = new ArrayList<PlanoConta>();

        String[] menuStr = {"Comercial", "Financeiro", "Investimentos"};

        for (int i = 0; i < menuStr.length; i++) {
            planoContas.add(new PlanoConta(menuStr[i], true));
        }

        String[] itensComercial = {"Serviços", "Vendas"};
        List<ItensPlanoConta> ipcsComercial = new ArrayList<ItensPlanoConta>();
        for (int i = 0; i < itensComercial.length; i++) {
            ipcsComercial.add(new ItensPlanoConta(itensComercial[i]));
        }
        planoContas.get(0).setItensPlanoContas(ipcsComercial);

        String[] itensFinanceiro = {"Depósito", "Reembolso"};

        List<ItensPlanoConta> ipcsFinanceiro = new ArrayList<ItensPlanoConta>();
        for (int i = 0; i < itensFinanceiro.length; i++) {
            ipcsFinanceiro.add(new ItensPlanoConta(itensFinanceiro[i]));
        }
        planoContas.get(1).setItensPlanoContas(ipcsFinanceiro);

        String[] itensInvestimento = {"Dividendos", "Ganhos de Capital", "Juros"};

        List<ItensPlanoConta> ipcsInvestimento = new ArrayList<ItensPlanoConta>();
        for (int i = 0; i < itensInvestimento.length; i++) {
            ipcsInvestimento.add(new ItensPlanoConta(itensInvestimento[i]));
        }
        planoContas.get(2).setItensPlanoContas(ipcsInvestimento);

        for (PlanoConta pc : planoContas) {
            dao.create(pc);
        }
    }
}
