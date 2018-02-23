/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.Selection;

import SparkEA.Chromosome;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anshal
 */
public class SurvivalSelection {
     private double[] cumulativeFitness;
    
     public List<Chromosome> RouletteWheelSelection(List<Chromosome> population, List<Chromosome> offSpring){
        int selectionSize = population.size();
        population.addAll(offSpring);
        return Utility.RouletteWheel(population, selectionSize);
    }
    
}
