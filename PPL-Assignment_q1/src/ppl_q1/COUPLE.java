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
public class COUPLE {
    String name;
    BOY boy;
    GIRL girl;
    COUPLE(BOY boy, GIRL girl){
        name=boy.name+" and "+girl.name;
        this.boy=boy;
        this.girl=girl;
    }
}
