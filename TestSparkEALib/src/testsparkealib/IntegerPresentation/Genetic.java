package testsparkealib.IntegerPresentation;


import SparkEA.SparkGA.IntegerRepresentation.IntegerChromosome;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADITYA
 */
public class Genetic extends SparkEA.SparkGA.IntegerRepresentation.Solver{
    int iteration;
    Genetic(int iteration){
        this.iteration = iteration;
    }
     
    @Override
    public IntegerChromosome solver(ArrayList<IntegerChromosome> population) {
        int popSize = population.size();
        IntegerChromosome best = population.get(0);
        for(int i=0; i<iteration; i++){
            IntegerChromosome tmp = SparkEA.SparkGA.IntegerRepresentation.Worker.getFittest(population);
            if(tmp.getFitnessValue() > best.getFitnessValue()){
                best = tmp;
            }
            for(int j=0; j<popSize; j++){
                population.get(j).RandomResetting();
            }
            //System.out.println("After mutation: "+population.size());
            ArrayList<IntegerChromosome> parents = SparkEA.SparkGA.IntegerRepresentation.ParentSelection.RouletteWheelSelection(population, popSize);
            //System.out.println("parents size: "+parents.size());
            ArrayList<IntegerChromosome> offSpring = new ArrayList<>();
            for(int j=0; j<parents.size()-1; j+=2){
                offSpring.addAll(parents.get(j).uniformCrossover(parents.get(j+1)));
            }
            
            population = SparkEA.SparkGA.IntegerRepresentation.SurvivorSelection.RouletteWheelSelection(population, offSpring);
            //System.out.println("population size: " + population.size());
            
        }
        IntegerChromosome tmp = SparkEA.SparkGA.IntegerRepresentation.Worker.getFittest(population);
        if(tmp.getFitnessValue() > best.getFitnessValue()){
            best = tmp;
        }
        best.print();
        return best;
    }
}
