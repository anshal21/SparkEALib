/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA;

import java.util.List;
import java.util.Random;

/**
 *
 * @author anshal
 */
public class Utility {
    private static Random rand = new Random();
    
    public static int getRandomInt(){
        return rand.nextInt();
    }
    
    public static int getRandomInt(int low, int hi){
        return (rand.nextInt(hi-low+1) + low);
    }
    
    public static int getRandomInt(int hi){
        return rand.nextInt(hi+1);
    }
    
    public static double RandomProbability(){
        return Math.random();
    }
    
    public static Chromosome getFittest(List<Chromosome> population){
        if(population.size()==0)
            return null;
        Chromosome best = population.get(0);
        double maxFitness = population.get(0).getFitnessValue();
        for(int i=1; i<population.size(); i++){
            if(maxFitness < population.get(i).getFitnessValue()){
                maxFitness = population.get(i).getFitnessValue();
                best = population.get(i);
            }
        }
        return best;
    }
    
    public static boolean inRange(int value, int lo, int hi){
        if(value>=lo && value<=hi)
            return true;
        return false;
    }
    
    public static boolean inRange(double value, double lo, double hi){
        if(value>=lo && value<=hi)
            return true;
        return false;
    }
}
