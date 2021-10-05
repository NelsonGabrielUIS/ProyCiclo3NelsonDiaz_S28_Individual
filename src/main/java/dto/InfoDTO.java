/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author ingdeiver
 */
public class InfoDTO  implements  Serializable {
    public static final String  TABLE_NAME = "infos";
    
    private String info;
    private int id;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public InfoDTO() {
    }

    public InfoDTO(String info, int id) {
        this.info = info;
        this.id = id;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "InfoBean{" + "info=" + info + ", id=" + id + '}';
    }
    
    
}
