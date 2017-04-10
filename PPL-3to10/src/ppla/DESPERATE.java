/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppla;

/**
 *A sub-class of GIRL has a method which calculates happiness
 * @author Manigeeth
 */
public class DESPERATE extends GIRL{
    DESPERATE (String name, int atr, int main_budget, int intel){
        super(name, atr, main_budget, intel);
    }
    public int cal_happiness(int price)
    {
        int main_cost=main_budget;
        happiness=price-main_cost;
        return happiness;
    }
}
