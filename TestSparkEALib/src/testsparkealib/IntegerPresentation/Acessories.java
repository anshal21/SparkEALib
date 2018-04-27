/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsparkealib.IntegerPresentation;

import SparkEA.Chromosome;
import java.util.ArrayList;

/**
 *
 * @author anshal
 */
public class Acessories extends SparkEA.Accessories{
    
    ArrayList<VirtualMachine> virtualMachines ;
    ArrayList<Request> requests;
    int virtualMachinesSize, requestsSize;
    
    public void input(ArrayList<VirtualMachine> v, ArrayList<Request> r){
         this.virtualMachines = v;
         this.requests = r;
         this.virtualMachinesSize= v.size();
         this.requestsSize= r.size();
    }
    
    
    @Override
    public double fitnessFunction(Chromosome c) {
        return calculateFitnessByResponseTime(c);
    }

     
     public double calculateFitnessByResponseTime(Chromosome c){
         double r[]= new double[virtualMachinesSize];
         double x=0;
         for(int i=0;i<virtualMachinesSize;i++){
             r[i]=virtualMachines.get(i).finishTime;
             x+=r[i];
         }
         for(int i=0;i<requestsSize;i++){
             int vm=(int)(c.getGene(i).getGeneValue());
             r[vm]+= (requests.get(i).size/(virtualMachines.get(vm).mips * 1000000));
             x+=r[vm];
         }
         for(int i=0;i<virtualMachinesSize;i++)
               x-=r[i];
         return 20000-x;
     }
}
