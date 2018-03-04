/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.Selection;

import SparkEA.Chromosome;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author anshal
 */
public class ParentSelection {
    
    public static List<Chromosome> RouletteWheelSelection(List<Chromosome> population){
        return Utility.RouletteWheel(population,population.size());
    }
    
    public static List<Chromosome> RouletteWheelSelection(List<Chromosome> population, int selectionSize){
        return Utility.RouletteWheel(population, selectionSize);
    }
    
    
    
  
}
