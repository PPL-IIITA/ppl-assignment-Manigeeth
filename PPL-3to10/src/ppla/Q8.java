/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppla;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *used to calculate the gifts with minimum cost of each type
 * @author Manigeeth
 */
public class Q8 {
    public void func(ArrayList <GIFT> sgift_arr, ArrayList <COUPLE> couple_arr, BufferedWriter bw) throws IOException{
        int min=9999, i, ind=-1, sum=0;
        bw.newLine();
        bw.write("The common gifts are");
        System.out.println("The common gifts are");
        System.out.println(sgift_arr.size());
        bw.newLine();
        for (i=0;i<sgift_arr.size();i++){//System.out.println(i);
            //if ("ESSENTIAL".equals(sgift_arr.get(i).type))System.out.println(i);
            System.out.println(sgift_arr.get(i).type);
            if(sgift_arr.get(i).type== "ESSENTIAL" && (sgift_arr.get(i).cost)<=min){
                min=sgift_arr.get(i).cost;
                ind=i;
                //System.out.println(i);
            }
        }
        bw.newLine();
        if (ind>=0){
        bw.write(sgift_arr.get(ind).name+"  Essential");
        System.out.println(sgift_arr.get(ind).name+"  Essential");
        }
        bw.newLine();
        for (i=0;i<couple_arr.size() && ind>=0;i++){
            couple_arr.get(i).gift_arr.add(sgift_arr.get(ind));
            couple_arr.get(i).boy.budget-=min;
        }
        sum+=min;
        min=9999;
        
        
        ind=-1;
        for (i=0;i<sgift_arr.size();i++){
            if(sgift_arr.get(i).type == "LUXURY" && sgift_arr.get(i).cost<=min){
                min=sgift_arr.get(i).cost;
                ind=i;
            }
        }
        bw.newLine();
        if (ind>=0){
        bw.write(sgift_arr.get(ind).name+"  Luxury");
        System.out.println(sgift_arr.get(ind).name+"  Luxury");
        }
        bw.newLine();
        for (i=0;i<couple_arr.size() && ind>=0;i++){
            couple_arr.get(i).gift_arr.add(sgift_arr.get(ind));
            couple_arr.get(i).boy.budget-=min;
        }
        sum+=min;
        min=9999;
        
        ind=-1;
        for (i=0;i<sgift_arr.size();i++){
            if(sgift_arr.get(i).type == "UTILITY" && sgift_arr.get(i).cost<=min){
                min=sgift_arr.get(i).cost;
                ind=i;
            }
        }
        bw.newLine();
        if (ind >=0){
        bw.write(sgift_arr.get(ind).name+"  Utility");
        System.out.println(sgift_arr.get(ind).name+"  Utility");
        }
        bw.newLine();
        for (i=0;i<couple_arr.size() && ind>=0;i++){
            couple_arr.get(i).gift_arr.add(sgift_arr.get(ind));
            couple_arr.get(i).boy.budget-=min;
        }
        sum+=min;
    }
}
