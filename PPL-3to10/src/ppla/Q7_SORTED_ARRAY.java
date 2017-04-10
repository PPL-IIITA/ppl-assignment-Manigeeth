/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppla;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
/**
 *Used to make a sorted-array and contains a method to say whether a given set of boys have girl-friends or not
 * @author Manigeeth
 */
public class Q7_SORTED_ARRAY {
    //ArrayList <COUPLE> couples = Pplq3.couples;
      
      Q7_SORTED_ARRAY(ArrayList <COUPLE> couple_arr){
        Collections.sort(couple_arr, (COUPLE b1, COUPLE b2) -> {
            //To change body of generated methods, choose Tools | Templates.
            if (b1.boy.name.compareTo(b2.boy.name)>0) {
                return 1;
            }
           
             else {
                return -1;
            }
        });
                  
                  
      }
        public void find_girlfriend(String [] str, ArrayList <COUPLE> couple_arr, BufferedWriter bw) throws IOException{
            Timestamp t =new Timestamp(System.currentTimeMillis());
            for(String s: str){
                int n = couple_arr.size();
                bw.write(t.toString());
                int low=0;
                int high = n-1;
                int mid;
                int flag = 0;
                while(high>=low){
                    mid = (low+high)/2;
                    
                    if(couple_arr.get(mid).boy.name.compareTo(s)==0){
                        System.out.println("girlfriend of "+s+" is "+couple_arr.get(mid).girl.name);
                        bw.write("girlfriend of "+s+" is "+couple_arr.get(mid).girl.name);
                        flag = 1;
                        break;
                    }
                    else if(couple_arr.get(mid).boy.name.compareTo(s)<0){
                        low = mid+1;
                        
                    }
                    else 
                        high = mid-1;
                    
                }
                if(flag == 0){
                     System.out.println(s+" -girlfriend not found");
                     bw.write(s+" -girlfriend not found");
                }
                bw.newLine();
            }
            
        } 
}
