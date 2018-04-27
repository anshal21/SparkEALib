/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsparkealib.Binary;

import SparkEA.Chromosome;
import SparkEA.SparkGA.BinaryRepresentation.BinaryChromosome;
import java.util.Scanner;


/**
 *
 * @author anshal
 */
public class Accesories extends SparkEA.Accessories{

    public int w;
    public int[] wts;
    public int n;
    public void input(){
        Scanner sc=new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();
        wts = new int[n];
        for(int i=0; i<n; i++){
            wts[i] = sc.nextInt();
        }
    }
    @Override
    public double fitnessFunction(Chromosome c) {
       int ans=0;
        int mx=0;
        for(int i=0; i<c.getLength(); i++){
            int tmp=(int)c.getGene(i).getGeneValue();
            ans = ans+wts[i]*tmp;
            mx += wts[i];
        }
        return mx-Math.abs(w-ans);
    }
    
}
