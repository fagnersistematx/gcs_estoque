
package Util;

/**
 *
 * @author Fagner
 */
public class ThreadIniciadora extends Thread{
    
    private DAO dao;
    
    @Override
    public void  run(){
        dao = new DAO();
        Config.setConf(true);
    }
}
