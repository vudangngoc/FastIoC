
package org.fastioc.test;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.creative.fastioc.ConcurrentHashMapContainer;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * HashMapInfiniteLoopSimulator
 * @author Pierre-Hugues Charbonneau
 *
 */
public class HashMapInfiniteLoopSimulator {


       private static final int NB_THREADS = 3;
       private static final int NB_TEST_ITERATIONS = 50;
       static Injector injector = Guice.createInjector(new GuiceBinderModule());

       /**
        * Main program
        * @param args
        */
       public static void main(String[] args) {
            
             System.out.println("Infinite Looping HashMap Simulator");
             System.out.println("Author: Pierre-Hugues Charbonneau");
             System.out.println("http://javaeesupportpatterns.blogspot.com");
             ConcurrentHashMapContainer CHMcontainer = new ConcurrentHashMapContainer();
     		try {
     			CHMcontainer.regit(Father.class, Child3.class);
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
             
             for (int i=0; i<NB_TEST_ITERATIONS; i++) {                                     
                   
                    long timeBefore = System.currentTimeMillis();
                    long timeAfter = 0;
                    Float totalProcessingTime = null;
                   
                    ExecutorService executor = Executors.newFixedThreadPool(NB_THREADS);
                   
                    for (int j = 0; j < NB_THREADS; j++) {
                          
                           /** Assign the Map at your convenience **/
                           Runnable worker = new FastiocWorker(CHMcontainer);
                           //Runnable worker = new GuiceWorker(injector);
                           executor.execute(worker);              
                    }
                   
                    // This will make the executor accept no new threads
                    // and finish all existing threads in the queue
                    executor.shutdown();
                    // Wait until all threads are finish
                    while (!executor.isTerminated()) {}
                   
                    timeAfter = System.currentTimeMillis();
                    totalProcessingTime = new Float( (float) (timeAfter - timeBefore) / (float) 1000);
                   
                    System.out.print(totalProcessingTime+",");
             }
       }

}