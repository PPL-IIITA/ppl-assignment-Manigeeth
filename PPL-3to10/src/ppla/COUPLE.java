/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppla;

import java.util.ArrayList;

/**
 *A class that contains the attributes of a couple
 * methods to calculate happiness, gift allocation and compatibility
 * @author Manigeeth
 */
public class COUPLE {
    String name="";
    BOY boy;
    GIRL girl;
    int compatibility;
    int happiness;
    int gift_price;
    ArrayList <GIFT> gift_arr=new ArrayList<>();
    COUPLE(BOY boy, GIRL girl){
        name=boy.name+" and "+girl.name;
        this.boy=boy;
        this.girl=girl;
        compatibility=0;
        happiness=0;
        gift_price=0;
    }
    
    public void cal_happiness()
    {
        happiness=girl.cal_happiness(gift_price);
        happiness+=boy.cal_happiness(girl, gift_price);
    }
    
    public void cal_compatibility()
    {
        compatibility=boy.budget-girl.main_budget+Math.abs(boy.intel-girl.intel)+Math.abs(girl.atr-boy.atr);
    }
    
    
    
    public void gift_allot(ArrayList <GIFT> sgift_arr)
    {
        int j, k, max_cost, price;
        if (boy instanceof MISER){
            max_cost=girl.main_budget;
            price=0;
            k=0;
            while(price<max_cost){
                price+=sgift_arr.get(k).cost;
                gift_arr.add(sgift_arr.get(k));
                k++;
            }
            if (price>boy.budget){
                price-=gift_arr.get(k-1).cost;
                k--;
                gift_arr.remove(k);
            }
            gift_price=price;
        }else if(boy instanceof GENEROUS){
            max_cost=boy.budget;
            price=0;
            k=0;
            while(price<max_cost){
                price+=sgift_arr.get(k).cost;
                gift_arr.add(sgift_arr.get(k));
                k++;
            }
            if (price>boy.budget){
                price-=gift_arr.get(k-1).cost;
                k--;
                gift_arr.remove(k);
            }
            gift_price=price;
        }else{//For Geek
            max_cost=girl.main_budget;
            price=0;
            k=0;
            while(price<max_cost){
                price+=sgift_arr.get(k).cost;
                gift_arr.add(sgift_arr.get(k));
                k++;
            }
            if (price>boy.budget){
                price-=gift_arr.get(k-1).cost;
                k--;
                gift_arr.remove(k);
            }
            max_cost=boy.budget-price;
            for (j=0;j<sgift_arr.size();j++){
                if (sgift_arr.get(j) instanceof LUXURY && max_cost>=sgift_arr.get(j).cost){
                    gift_arr.add(sgift_arr.get(j));
                    price+=sgift_arr.get(j).cost;
                    break;
                }
            }
            gift_price=price;
        }
    }
}
