/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_q1;

/**
 *
 * @author Manigeeth
 */
public class BOY {
    String name;
    int atr;
    int budget;
    int intel;
    int atr_req;
    String type;
    boolean status;
    BOY (String name, int atr, int budget, int intel, int atr_req, String type){
        this.name=name;
        this.atr=atr;
        this.budget=budget;
        this.intel=intel;
        this.type=type;
        status=false;
        this.atr_req=atr_req;
    }
}
