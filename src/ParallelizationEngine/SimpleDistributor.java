/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParallelizationEngine;

import SparkEA.Chromosome;
import SparkEA.SparkGA.BinaryRepresentation.BinaryChromosome;
import java.util.ArrayList;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 *
 * @author anshal
 */
public class SimpleDistributor {
    
    
    private JavaSparkContext jsc;
    private SparkConf config;
    
    
    public SimpleDistributor(String appName, String master){
        config = new SparkConf().setAppName(appName).setMaster(master);
        jsc = new JavaSparkContext(config);
        jsc.addJar("/home/anshal/NetBeansProjects/SparkEALib/dist/SparkEALib.jar");
    }
    public Chromosome parellelRun(ArrayList<Work> ds){
       JavaRDD<Work> dataSet = jsc.parallelize(ds);
       JavaRDD<Chromosome> finalists = dataSet.map(Work::solver);
       System.out.println(finalists.count());
       System.out.println("Slices: " + dataSet.count());
     //  Chromosome bestChromosome = finalists.reduce(Work::combine);
       Chromosome best = finalists.reduce(SparkEA.Utility::combine);
       return best;
    }
}
