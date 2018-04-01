/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA.BinaryRepresentation;

import SparkEA.Chromosome;
import SparkEA.Selection.SelectionMethods;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anshal
 */
public class ParentSlection {
    public static ArrayList<BinaryChromosome> RouletteWheelSelection(ArrayList<BinaryChromosome> population){
        ArrayList<Chromosome> tmp = new ArrayList<>();
        for(int i=0; i<population.size(); i++)
            tmp.add(population.get(i));
        tmp = SelectionMethods.RouletteWheel(tmp,tmp.size());
        population.removeAll(population);
        for(int i=0; i<population.size(); i++)
            population.add((BinaryChromosome)tmp.get(i));
        return population;
    }
    
    public static ArrayList<BinaryChromosome> RouletteWheelSelection(ArrayList<BinaryChromosome> population, int selectionSize){
        ArrayList<Chromosome> tmp = new ArrayList<>();
        for(int i=0; i<population.size(); i++)
            tmp.add(population.get(i));
        
        tmp = SelectionMethods.RouletteWheel(tmp,selectionSize);
        //System.out.println("Inside parent roulettwheel: " + tmp.size());
        population.removeAll(population);
        for(int i=0; i<tmp.size(); i++)
            population.add((BinaryChromosome)tmp.get(i));
        return population;
    }
    
    
}
