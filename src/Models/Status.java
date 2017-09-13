/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author xiej
 */
public class Status {
    public String st;
    public String dt;
    public String toString(){
      GsonBuilder gb = new GsonBuilder();
      return gb.create().toJson(this)+"\n";
    }
}
