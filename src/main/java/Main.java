
import dao.InfoDAOImpl;
import java.util.List;
import dto.InfoDTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ingdeiver
 */
public class Main {
    public static void main(String[] args) {
        InfoDAOImpl dao = new InfoDAOImpl();
        
//        boolean saved = dao.save(new InfoBean("Información 1"));
//        System.out.println("Saved: " + saved);
        
        List<InfoDTO> data = dao.list();
        
        for (InfoDTO infoBean : data) {
            System.out.println(infoBean.toString());
        }
    }
}
