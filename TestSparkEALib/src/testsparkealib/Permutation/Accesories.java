/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsparkealib.Permutation;

import SparkEA.Chromosome;
import static java.lang.Math.ceil;
import java.util.Scanner;

/**
 *
 * @author anshal
 */
public class Accesories extends SparkEA.Accessories{

    public static int n;
    public void input(){
        Scanner sc=new Scanner(System.in);
        n = sc.nextInt();
    }
    @Override
    public double fitnessFunction(Chromosome c) {
       int totalCollison = 2*n*(n-1);
       System.out.print("++++++++" + totalCollison +"++++++++++++");
       for(int i=0;i<c.getLength();i++){
           for(int j=0;j<c.getLength();j++){
               if(i==j) continue;
               if(Math.abs(i-j)==(int)ceil(Math.abs(c.getGene(i).getGeneValue()-c.getGene(j).getGeneValue()))){
                   totalCollison--;
               }
           }
          
       }
        return totalCollison;
    }
    
}
