/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppla;

/**
 *A sub-class of BOY contains a method to calculate happiness
 * @author Manigeeth
 */
public class MISER extends BOY{
    MISER (String name, int atr, int budget, int intel, int atr_req){
        super(name, atr, budget, intel, atr_req);
    }
    @Override
    public int cal_happiness(GIRL girl, int price)
    {
        happiness=budget-price;
        return happiness;
    }
}
