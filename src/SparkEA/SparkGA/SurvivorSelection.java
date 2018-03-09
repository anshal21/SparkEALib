/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA;

import SparkEA.Chromosome;
import SparkEA.Selection.SelectionMethods;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anshal
 */
public class SurvivorSelection {
     private double[] cumulativeFitness;
    
     public static ArrayList<ChromosomeGA> RouletteWheelSelection(ArrayList<ChromosomeGA> population, ArrayList<ChromosomeGA> offSpring){
        int selectionSize = population.size();
        population.addAll(offSpring);
        ArrayList<Chromosome> tmp = new ArrayList<>();
        for(int i=0; i<population.size(); i++)
            tmp.add(population.get(i));
        tmp = (ArrayList<Chromosome>)SelectionMethods.RouletteWheel(tmp, selectionSize);
        population.removeAll(population);
        for(int i=0; i<tmp.size(); i++)
            population.add((ChromosomeGA)tmp.get(i));
        return population;
        
        
    }
}
