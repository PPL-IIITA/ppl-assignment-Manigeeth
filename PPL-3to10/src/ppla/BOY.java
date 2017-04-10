/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppla;

/**
 *A parent class that describes about a boy and also has abstract methods
 * @author Manigeeth
 * 
 */
public abstract class BOY {
    String name;
    int atr;
    int budget;
    int intel;
    int atr_req;
    int happiness;
    boolean status;
    String ex;
    BOY (String name, int atr, int budget, int intel, int atr_req){
        this.name=name;
        this.atr=atr;
        this.budget=budget;
        this.intel=intel;
        status=false;
        this.atr_req=atr_req;
        happiness=0;
        ex=null;
    }
    
    public abstract int cal_happiness(GIRL girl, int price);
    
}
