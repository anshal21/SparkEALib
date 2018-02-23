/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA;

import java.util.List;

/**
 *
 * @author anshal
 */
public interface Chromosome extends Comparable<Chromosome>{
   public void print();
   public double getFitnessValue();
   public Gene getRandomGene();
   public Gene getGene(int index);
 
}
