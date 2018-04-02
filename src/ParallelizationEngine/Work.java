/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParallelizationEngine;

import SparkEA.Chromosome;

/**
 *
 * @author anshal
 */
public interface Work {
    public Chromosome solver();
}
