/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java;

import java.util.concurrent.BlockingQueue;
import main.java.H1bCrawler.CaseNumberDataPool;
import main.java.H1bCrawler.CrawlerTask;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

import org.jsoup.nodes.Document;
import org.junit.Test;
/**
 *
 * @author xiej
 */
public class ParsingUrlTest {
    
    public ParsingUrlTest(){
        
    }
    @Test

    public void parse_test() {
           BlockingQueue<String> bq = CaseNumberDataPool.getInstance().getQueue();
        CrawlerTask task = new CrawlerTask(bq);
        task.GetContent("http://www.worktheme.com/api/data/vcases17/?a=history&casenum=EAC1713852335");
    }
    
}
