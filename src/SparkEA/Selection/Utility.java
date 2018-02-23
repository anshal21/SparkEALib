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
public class Utility {
    
    public static int upperBound(double arr[], double val){
        int lo = 0, hi = arr.length-1;
        int ans=-1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(arr[mid] >= val){
                ans = mid;
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return ans;
    }
    
    public static List<Chromosome> RouletteWheel(List<Chromosome> population, int selectionSize){
        double[] cumulativeFitness;
        cumulativeFitness = new double[population.size()];
        cumulativeFitness[0] = population.get(0).getFitnessValue();
        for(int i=1; i<population.size(); i++){
            cumulativeFitness[i] = cumulativeFitness[i-1] + population.get(i).getFitnessValue();
        }
        List<Chromosome> selectedParents = new ArrayList<Chromosome>();
        for(int i=0; i<selectionSize; i++){
            double token = Math.random()*cumulativeFitness[cumulativeFitness.length - 1];
            int index = upperBound(cumulativeFitness, token);
            selectedParents.add(population.get(index));
        }
        return selectedParents;
    }
}
