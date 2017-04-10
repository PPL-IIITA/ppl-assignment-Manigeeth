/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppla;

/**
 *A class that contains attributes of a girl and contains three sub-classes
 * has an abstract method to calculate happiness
 * @author Manigeeth
 */
public abstract class GIRL {
    String name;
    int atr;
    int main_budget;
    int intel;
    int happiness;
    boolean status;
    String ex;
    GIRL(String name, int atr, int main_budget, int intel){
        this.name=name;
        this.atr=atr;
        this.main_budget=main_budget;
        this.intel=intel;
        status=false;
        happiness=0;
        ex=null;
    }

    /**
     *
     * @param gift_price
     * @return
     */
    public abstract int cal_happiness(int gift_price);
}
