/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.BinaryRepresentation;

import SparkEA.Accessories;
import SparkEA.Chromosome;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anshal
 */
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

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
    
    public BinaryChromosome solve(Solver solve, Accessories access, int populationSize, int chromosomeLength){
       
       Worker worker = new Worker(solve, access, populationSize, chromosomeLength);
       System.out.println("==========I am here================ -2.0");
       ArrayList<Worker> ds = (ArrayList<Worker>) worker.fork(4);
       JavaRDD<Worker> dataSet = jsc.parallelize(ds);
       JavaRDD<BinaryChromosome> finalists = dataSet.map(Worker::Solver);
       System.out.println(finalists.count());
       System.out.println("Slices: " + dataSet.count());
       BinaryChromosome bestChromosome = finalists.reduce(BinaryChromosome::combine);
       return bestChromosome;
    }
}
