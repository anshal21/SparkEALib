/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA.SparkGA;

/**
 *
 * @author anshal
 */
public class GeneGA implements SparkEA.Gene {
    
    public int geneValue;
    
    @Override
    public void setRandom() {
        this.geneValue = ((int)(10*Math.random()))%2;
    }
    
    public void setRandom(double prob){
        double token = Math.random();
        if(token<=prob)
            this.geneValue = 1-this.geneValue;
    }
    
    public void setGeneValue(int value){
        this.geneValue = value;
    }
    @Override
    public double getGeneValue(){
        return geneValue;
    }
    
}
