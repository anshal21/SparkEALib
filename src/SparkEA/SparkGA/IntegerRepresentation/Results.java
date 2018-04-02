/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.IntegerRepresentation;


import ParallelizationEngine.SimpleDistributor;
import ParallelizationEngine.Work;
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
    SimpleDistributor sd;
    
    public Results(String appName, String master){
          sd = new SimpleDistributor(appName, master);
    }
    
    public void stop(){
        jsc.close();
    }
    
    private int geneLowerBound, geneUpperBound;
    
    
    
    public IntegerChromosome solve(Solver solve, Accessories access, int populationSize, int chromosomeLength){
       Worker worker = new Worker(solve, access, populationSize, chromosomeLength);
       return solveInternal(worker);
    }
    
    public IntegerChromosome solve(Solver solve, Accessories access, int populationSize, int chromosomeLength, int geneLowerBound, int geneUpperBound){  
       Worker worker = new Worker(solve, access, populationSize, chromosomeLength, geneLowerBound, geneUpperBound);
       return solveInternal(worker);
    }
    
    private IntegerChromosome solveInternal(Worker worker){
       ArrayList<Work> ds = (ArrayList<Work>) worker.fork(4);
       return (IntegerChromosome)sd.parellelRun(ds);
    } 
}
