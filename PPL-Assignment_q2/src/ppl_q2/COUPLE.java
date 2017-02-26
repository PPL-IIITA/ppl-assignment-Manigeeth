/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_q2;
import java.util.*;
/**
 *
 * @author Manigeeth
 */
public class COUPLE {
    String name;
    BOY boy;
    GIRL girl;
    int compatibility;
    int happiness;
    int price;
    ArrayList <GIFT> gift_arr=new ArrayList<>();
    COUPLE(BOY boy, GIRL girl){
        name=boy.name+" and "+girl.name;
        this.boy=boy;
        this.girl=girl;
        compatibility=0;
        happiness=0;
        price=0;
    }
}
