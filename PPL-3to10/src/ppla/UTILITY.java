/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppla;

/**
 *A sub-class of GIFT
 * @author Manigeeth
 */
public class UTILITY extends GIFT {
    int utilvalue;
    String utilclass;
    UTILITY (String name, int cost, int value){
        super(name, cost, value);
        utilvalue=0;
        utilclass="";
        type="UTILITY";
    }
}
