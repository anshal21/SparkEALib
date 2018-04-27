package testsparkealib.IntegerPresentation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADITYA
 */

import java.io.Serializable;
import java.util.ArrayList;

public class VirtualMachine implements Serializable {
    int vmid;
    double mips;
    double cost;
    int weight;
    boolean isActive;
    double startTime, endTime;
    double finishTime;
    ArrayList<Request> requests;
    public VirtualMachine(int id, double m, double c, double s, double e, int w){
        this.mips = m;
        this.cost = c;
        this.startTime=s;
        this.endTime=e;
        this.finishTime=0;
        this.isActive = false;
        this.weight=w;
        if(s==0)
            this.isActive=true;
        requests= new ArrayList<Request>();
    }
    public void calculateFinishTime(){
        finishTime = 0;
        for(int i=0;i<requests.size();i++){
            finishTime+= requests.get(i).size/(mips * 1000000);
        }
    }
}
