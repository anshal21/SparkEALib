/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.BinaryRepresentation;

import ParallelizationEngine.SimpleDistributor;
import ParallelizationEngine.Work;
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
    SimpleDistributor sd;
    
    public Results(String appName, String master){
          sd = new SimpleDistributor(appName, master);
    }
    
    public void stop(){
        jsc.close();
    }
    
    public BinaryChromosome solve(Solver solve, Accessories access, int populationSize, int chromosomeLength){
       Worker worker = new Worker(solve, access, populationSize, chromosomeLength);
       ArrayList<Work> ds = (ArrayList<Work>) worker.fork(4);
       return (BinaryChromosome)sd.parellelRun(ds);
    }
}
