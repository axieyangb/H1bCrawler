
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.java.H1bCrawler.CaseNumberDataPool;
import main.java.H1bCrawler.CrawlerTask;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xiej
 */
public class Main {
    public static final int THREAD_NUM = 1;
     public static void main(String args[]){
        BlockingQueue<String> bq = CaseNumberDataPool.getInstance().getQueue();
        
      Thread[] threadPool = new Thread[THREAD_NUM];
		for (int i = 0; i < threadPool.length; i++) {	
			threadPool[i] = new Thread(new CrawlerTask(bq), "thread " + i);
			threadPool[i].start();
		}
		try {
			for (int i = 0; i < threadPool.length; i++) {
				threadPool[i].join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
        
    }
}
