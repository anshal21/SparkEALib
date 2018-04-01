/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA;

import java.io.Serializable;

/**
 *
 * @author anshal
 */
public interface Gene extends Serializable{
    public void setRandom();
    public double getGeneValue();
    public double getLowerBound();
    public double getUpperBound();
    public void setLowerBound(double value);
    public void setUpperBound(double value);
    public void setGeneValue(double value);
}
