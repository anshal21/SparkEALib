/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsparkealib.Binary;

import ParallelizationEngine.AdvanceDistributor;
import ParallelizationEngine.SimpleDistributor;
import SparkEA.Work;
import SparkEA.SparkGA.BinaryRepresentation.BinaryChromosome;

import SparkEA.SparkGA.BinaryRepresentation.Worker;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Scanner;
import SparkEA.Accessories;
import SparkEA.SparkGA.BinaryRepresentation.Parameters;
/**
 *
 * @author anshal
 */
public class TestSparkEALib {

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        

       SparkEA.SparkGA.BinaryRepresentation.Solver solver = new Solver();
       SparkEA.Accessories access = new Accesories();
       Accesories ac = (Accesories)access;
       ac.input();
       Worker work = new Worker(solver, access, 10, ac.n);
       Parameters params = new Parameters();
       params.setMutationChangeRate(0.1);
       params.setUniformCrossoverChangeRate(0.1);
       AdvanceDistributor ad = new AdvanceDistributor("Distributor","spark://bluescorpion:7077");
//       SimpleDistributor sd = new SimpleDistributor("Distributor", "spark://bluescorpion:7077");
//       System.out.println("==========I am here================ -2.2");
       BinaryChromosome bestChromosome = (BinaryChromosome) ad.distribute(work,6,params);
       bestChromosome.print();
       bestChromosome.params.print();
       System.out.println(bestChromosome.getFitnessValue());
       

    }
    
}
