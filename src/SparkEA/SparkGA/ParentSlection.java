/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA;

import SparkEA.Chromosome;
import SparkEA.Selection.Utility;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anshal
 */
public class ParentSlection {
    public static ArrayList<ChromosomeGA> RouletteWheelSelection(ArrayList<ChromosomeGA> population){
        ArrayList<Chromosome> tmp = new ArrayList<>();
        for(int i=0; i<population.size(); i++)
            tmp.add(population.get(i));
        tmp = (ArrayList<Chromosome>)Utility.RouletteWheel(tmp,tmp.size());
        population.removeAll(population);
        for(int i=0; i<population.size(); i++)
            population.add((ChromosomeGA)tmp.get(i));
        return population;
    }
    
    public static ArrayList<ChromosomeGA> RouletteWheelSelection(ArrayList<ChromosomeGA> population, int selectionSize){
        ArrayList<Chromosome> tmp = new ArrayList<>();
        for(int i=0; i<population.size(); i++)
            tmp.add(population.get(i));
        
        tmp = (ArrayList<Chromosome>)Utility.RouletteWheel(tmp,selectionSize);
        //System.out.println("Inside parent roulettwheel: " + tmp.size());
        population.removeAll(population);
        for(int i=0; i<tmp.size(); i++)
            population.add((ChromosomeGA)tmp.get(i));
        return population;
    }
    
    
}
