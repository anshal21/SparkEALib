/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParallelizationEngine;

import SparkEA.Work;
import SparkEA.Chromosome;
import SparkEA.Params;
import java.util.ArrayList;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 *
 * @author anshal
 */
public class AdvanceDistributor {
    private JavaSparkContext jsc;
    private SparkConf config;
    
    
    public AdvanceDistributor(String appName, String master){
        config = new SparkConf().setAppName(appName+" - AdvanceDistributor").setMaster(master);
        jsc = new JavaSparkContext(config);
        jsc.addJar("/home/anshal/NetBeansProjects/SparkEALib/dist/SparkEALib.jar");
    }
    
    public Chromosome distribute(Work worker, int parellizatioFactor, Params p){
        ArrayList<Params> pList = new ArrayList<>();
        pList.add(p);
        for(int i=1; i<parellizatioFactor; i++){
            pList.add(pList.get(i-1).upgrade());
        }
        ArrayList<Work> ds = (ArrayList<Work>) worker.fork(parellizatioFactor, pList);
        return parellelRun(ds);
    }
    
    public Chromosome distribute(Work worker, Params p){
        return distribute(worker, jsc.defaultParallelism(), p);
    }
    
    public Chromosome parellelRun(ArrayList<Work> ds){
       System.out.println("Debugging Duck ........");
       for(int i=0; i<ds.size(); i++){
           ds.get(i).getPopulation(0).getParams().print();
       }
       System.out.println("Debugging Duck Going ........");
       JavaRDD<Work> dataSet = jsc.parallelize(ds);
       JavaRDD<Chromosome> finalists = dataSet.map(Work::solver);
       System.out.println("I am here -------------XXXXXXXXXX");
       System.out.println(finalists.count());
       System.out.println("Slices: " + dataSet.count());
     //  Chromosome bestChromosome = finalists.reduce(Work::combine);
       Chromosome best = finalists.reduce(SparkEA.Utility::combine);
       return best;
    }
}
