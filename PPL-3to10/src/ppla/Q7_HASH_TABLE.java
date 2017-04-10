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
import java.util.HashMap;
import java.util.Map;
/**
 *Used to make a hash-table and a method to say whether a given set of boys have girl-friends or not
 * @author Manigeeth
 */
public class Q7_HASH_TABLE {
    Map<String,String> hashtable = new HashMap<>();
     
     Q7_HASH_TABLE(ArrayList <COUPLE> couple_arr){
          int i;
          for(i=0;i<couple_arr.size();i++){
              hashtable.put(couple_arr.get(i).boy.name, couple_arr.get(i).girl.name);
          }
     }
     
      public void find_girlfriend(String [] str, ArrayList <COUPLE> couple_arr, BufferedWriter bw) throws IOException{
          Timestamp t =new Timestamp(System.currentTimeMillis());
          for(String s : str){
            bw.write(t.toString());
            if(hashtable.containsKey(s)){
                System.out.println("girlfriend of "+s+" is "+hashtable.get(s));
                bw.write("girlfriend of "+s+" is "+hashtable.get(s));
            }
            else{
                System.out.println(s+" -girlfriend not found");
                bw.write(s+" -girlfriend not found");
            }
            bw.newLine();
          }
      }
}
