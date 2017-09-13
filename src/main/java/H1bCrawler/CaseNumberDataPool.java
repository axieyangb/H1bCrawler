/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.H1bCrawler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author xiej
 */
public final class CaseNumberDataPool {
    private static  BlockingQueue<String> bq;
    private CaseNumberDataPool(){
        bq = new LinkedBlockingQueue<>();
        loadData();
    } 
    private  static class CaseNumberDataPoolHelper{
        public final static CaseNumberDataPool _instance = new CaseNumberDataPool();
    }
    
    public static CaseNumberDataPool getInstance(){
        return CaseNumberDataPoolHelper._instance;
    }
    public BlockingQueue<String> getQueue(){
        return this.bq;
    }
    public void loadData(){
        bq.offer("EAC1714452");
bq.offer("WAC1714952");
bq.offer("EAC1713654");
bq.offer("EAC1713553");
bq.offer("EAC1713854");
bq.offer("EAC1714255");
bq.offer("WAC1713652");
bq.offer("EAC1714551");
bq.offer("EAC1713550");
bq.offer("EAC1714055");
bq.offer("EAC1713750");
bq.offer("EAC1714955");
bq.offer("WAC1713252");
bq.offer("EAC1713551");
bq.offer("EAC1713450");
bq.offer("EAC1714550");
bq.offer("EAC1713451");
bq.offer("EAC1714351");
bq.offer("EAC1713752");
bq.offer("EAC1713754");
bq.offer("EAC1713850");
bq.offer("EAC1714450");
bq.offer("EAC1713851");
bq.offer("EAC1713650");
bq.offer("EAC1714655");
bq.offer("EAC1713452");
bq.offer("EAC1713950");
bq.offer("EAC1714852");
bq.offer("EAC1714855");
bq.offer("EAC1713651");
bq.offer("EAC1713853");
bq.offer("EAC1713951");
bq.offer("EAC1713751");
bq.offer("EAC1713552");
bq.offer("EAC1714350");
bq.offer("EAC1713653");
bq.offer("EAC1713753");
bq.offer("EAC1713852");
bq.offer("WAC1713855");
bq.offer("EAC1713652");
bq.offer("EAC1714352");
bq.offer("EAC1714555");
bq.offer("EAC1714750");
bq.offer("EAC1714754");
bq.offer("EAC1713952");
bq.offer("EAC1714851");
bq.offer("EAC1714552");
bq.offer("EAC1714451");
bq.offer("EAC1714755");
bq.offer("WAC1714354");
bq.offer("EAC1714051");
bq.offer("WAC1714554");
bq.offer("WAC1713554");
bq.offer("WAC1714054");
bq.offer("WAC1713954");
bq.offer("WAC1714654");
bq.offer("WAC1714251");
bq.offer("EAC1713954");
bq.offer("EAC1714155");

    }
}
