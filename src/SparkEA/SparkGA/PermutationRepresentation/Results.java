/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.PermutationRepresentation;

import SparkEA.Accessories;
import java.util.ArrayList;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 *
 * @author anshal
 */
public class Results {
    private JavaSparkContext jsc;
    private SparkConf config;
    
    public Results(String appName, String master){
        config = new SparkConf().setAppName(appName).setMaster(master);
        jsc = new JavaSparkContext(config);
        jsc.addJar("/home/anshal/NetBeansProjects/SparkEALib/dist/SparkEALib.jar");
    }
    
    public void stop(){
        jsc.close();
    }
    
    private int geneLowerBound, geneUpperBound;
    
    
    
    public PermutationChromosome solve(Solver solve, Accessories access, int populationSize, int[] iniPermutation){
       Worker worker = new Worker(solve, access, populationSize,iniPermutation);
       return solveInternal(worker);
    }
    
  
    private PermutationChromosome solveInternal(Worker worker){
       System.out.println("==========I am here================ -2.0");
       ArrayList<Worker> ds = (ArrayList<Worker>) worker.fork(4);
       JavaRDD<Worker> dataSet = jsc.parallelize(ds);
       JavaRDD<PermutationChromosome> finalists = dataSet.map(Worker::Solver);
       System.out.println(finalists.count());
       System.out.println("Slices: " + dataSet.count());
       PermutationChromosome bestChromosome = finalists.reduce(PermutationChromosome::combine);
       return bestChromosome;
    } 
}
