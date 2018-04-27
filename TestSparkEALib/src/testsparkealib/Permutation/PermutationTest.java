/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsparkealib.Permutation;

import ParallelizationEngine.SimpleDistributor;
import SparkEA.SparkGA.PermutationRepresentation.PermutationChromosome;

import SparkEA.SparkGA.PermutationRepresentation.Worker;


/**
 *
 * @author anshal
 */
public class PermutationTest {
    public static void main(String args[]){
        Solver solve = new Solver();
        Accesories ac = new Accesories();
        ac.input();
        int[] iniPerm = new int[ac.n];
        for(int i=1;i<=ac.n;i++)
            iniPerm[i-1] = i-1;
        Worker work = new Worker(solve,ac,12,iniPerm);
        SimpleDistributor sd = new SimpleDistributor("Distributor", "spark://bluescorpion:7077");
        PermutationChromosome bestChromosome = (PermutationChromosome) sd.distribute(work,5);
        bestChromosome.print();
        System.out.println(bestChromosome.getFitnessValue());
        
    }
    
    
    
}
