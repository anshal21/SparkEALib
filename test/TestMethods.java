
import SparkEA.Accessories;
import SparkEA.SparkGA.PermutationRepresentation.PermutationChromosome;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anshal
 */
public class TestMethods {
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] arr2 = {9,3,7,8,2,5,6,1,4};
        Accessories ac = new Accessories();
        PermutationChromosome p1 = new PermutationChromosome(ac,arr);
        PermutationChromosome p2 = new PermutationChromosome(ac,arr2);
        ArrayList<PermutationChromosome> p = p1.PMX(p2);
        p.get(0).print();
        p.get(1).print();
    }
}
