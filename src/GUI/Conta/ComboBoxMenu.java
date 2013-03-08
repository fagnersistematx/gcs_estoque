package GUI.Conta;

import Entidade.Conta.ItensPlanoConta;
import Entidade.Conta.PlanoConta;
import Util.DAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author FM
 */
public class ComboBoxMenu {

    private DAO dao;
    private ComboMenuBar comboMenu;

    public ComboBoxMenu(boolean tipo) {

        this.dao = new DAO();
        List<Object> planoConta = new ArrayList<Object>();
        planoConta = dao.findObjectEntities(PlanoConta.class);
        JMenu[] menus = new JMenu[planoConta.size()];

        int cont = 0;
        for (Object o : planoConta) {
            PlanoConta p = (PlanoConta) o;
            if (p.isTipo() == tipo) {
                JMenu j = new JMenu(p.getNome());
                j.setText(p.getNome());
                j.setName(p.getNome());
                menus[cont] = j;
                for (ItensPlanoConta i : p.getItensPlanoContas()) {
                    menus[cont].add(new JMenuItem(i.getNome()));
                }
                ++cont;
            }
        }

        JMenu menu = ComboMenuBar.createMenu("");

        for (int i = 0; i < cont; i++) {
            menu.add(menus[i]);
        }

        comboMenu = new ComboMenuBar(menu);

    }

    public ComboMenuBar getComboMenu() {
        return comboMenu;
    }   
}
