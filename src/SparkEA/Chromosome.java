/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author anshal
 */
public abstract class Chromosome implements Comparable<Chromosome>, Serializable{
   public abstract void print();
   public abstract double getFitnessValue();
   public abstract Gene getRandomGene();
   public abstract Gene getGene(int index);
   public abstract int getLength();
   public Chromosome merge(Chromosome c1, Chromosome c2){
        return ((c1.getFitnessValue() > c2.getFitnessValue())?c1:c2);
   }
   public abstract Params getParams();
 
}
