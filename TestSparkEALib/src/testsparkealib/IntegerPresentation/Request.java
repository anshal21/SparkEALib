package testsparkealib.IntegerPresentation;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADITYA
 */
public class Request implements Comparable<Request> ,Serializable {
    int rid;
    int size;
    public Request(int i, int s){
        this.rid = i;
        this.size = s;
    }
    public int compareTo(Request c){
        double cq=c.size;
        
        if(cq==this.size)
                return 0;
        if(cq<this.size)
                return 1;
        else
               return -1;
    }
}
