/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SparkEA;

import SparkEA.Chromosome;
import SparkEA.Params;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anshal
 */
public interface Work {
    public Chromosome solver();
    public List<Work> fork(int slices);
    public List<Work> fork(int slices, ArrayList<Params> params);
    public Chromosome getPopulation(int index);
}
