/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.IntegerRepresentation;


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
    
    
    
    public IntegerChromosome solve(Solver solve, Accessories access, int populationSize, int chromosomeLength){
       Worker worker = new Worker(solve, access, populationSize, chromosomeLength);
       return solveInternal(worker);
    }
    
    public IntegerChromosome solve(Solver solve, Accessories access, int populationSize, int chromosomeLength, int geneLowerBound, int geneUpperBound){  
       Worker worker = new Worker(solve, access, populationSize, chromosomeLength, geneLowerBound, geneUpperBound);
       return solveInternal(worker);
    }
    
    private IntegerChromosome solveInternal(Worker worker){
       System.out.println("==========I am here================ -2.0");
       ArrayList<Worker> ds = (ArrayList<Worker>) worker.fork(4);
       JavaRDD<Worker> dataSet = jsc.parallelize(ds);
       JavaRDD<IntegerChromosome> finalists = dataSet.map(Worker::Solver);
       System.out.println(finalists.count());
       System.out.println("Slices: " + dataSet.count());
       IntegerChromosome bestChromosome = finalists.reduce(IntegerChromosome::combine);
       return bestChromosome;
    } 
}
