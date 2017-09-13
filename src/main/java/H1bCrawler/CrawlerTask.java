/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.H1bCrawler;

import DatabaseAccess.Database;
import Models.Case;
import Models.Status;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author xiej
 */
public class CrawlerTask implements Runnable{
    BlockingQueue<String> bq;
    Database db;
    private  String prefix;


    public CrawlerTask(BlockingQueue<String> bq){
        db = new Database();
        this.bq = bq;
        prefix ="http://www.worktheme.com/api/data/vcases17/?a=history&casenum=";
    }
    @Override
    public void run() {
    while(!bq.isEmpty()){
        try {
            String casePrefix =bq.take();
            for(int i=1;i<1000;i++){
               String caseSurfix = String.format("%03d", i);
               List<Status> statuses = GetContent(prefix+casePrefix + caseSurfix);
               if(statuses!=null && statuses.size()>0){
                   Case oneCase = new Case();
                   oneCase.CaseNumber = casePrefix+ caseSurfix;
                   oneCase.statuses = statuses;
                   db.insertOne(oneCase, "h1bstatus");
                   System.out.println(Thread.currentThread().getName() + " successfully insert one record: "+  oneCase.CaseNumber );
               }
            }
         
        } catch (InterruptedException ex) {
                ex.printStackTrace();
                
        }
        
    }
    }
    
    
    public List<Status>  GetContent(String url){
                        try {
                    String doc =   Jsoup.connect(url).ignoreContentType(true).execute().body();
                   Gson gson = new Gson();
                   Type listType = new TypeToken<List<Status>>(){}.getType();
                   List<Status> statuses = gson.fromJson(doc,listType);
                  return statuses;
                } catch (IOException ex) {
                    System.out.println(url);
                    //ex.printStackTrace();
                    return null;
                }
    }
    
}
