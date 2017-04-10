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
public class LUXURY extends GIFT{
    int rating;
    int difficult;
    LUXURY (String name, int cost, int value){
        super(name, cost, value);
        rating=0;
        difficult=0;
        type="LUXURY";
    }
}
