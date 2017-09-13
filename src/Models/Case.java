/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.google.gson.GsonBuilder;
import java.util.List;

/**
 *
 * @author xiej
 */
public class Case {
    public String CaseNumber;
    public List<Status> statuses;
       public String toString(){
      GsonBuilder gb = new GsonBuilder();
      return gb.create().toJson(this)+"\n";
    }
}
