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

/**
 *A class that contains the methods and no variables what so ever
 * it contains methods to break-up last k couples, to match couples,
 * to match couples in a alternate manner
 * @author Manigeeth
 */
public class FUNCTION {
    
    public void Break_Up(ArrayList <COUPLE> couple_arr, int k, BufferedWriter bw) throws IOException
    {
        Timestamp t =new Timestamp(System.currentTimeMillis());
        int i=couple_arr.size()-1;
        System.out.println("Break last " + k +" couples");
        bw.write("      Timestamp     "+"couple_id");
        bw.newLine();
        for (;k>0;i--, k--){
            couple_arr.get(i).boy.status=false;
            couple_arr.get(i).girl.status=false;
            couple_arr.get(i).boy.ex=couple_arr.get(i).girl.name;
            couple_arr.get(i).girl.ex=couple_arr.get(i).boy.name;
            System.out.println(couple_arr.get(i).name);
            bw.write(t.toString()+"  "+couple_arr.get(i).name);
            bw.newLine();
            couple_arr.remove(couple_arr.get(i));
        }
        bw.newLine();
    }
    
    public void couple_match(ArrayList <BOY> boy_arr, ArrayList <GIRL> girl_arr, ArrayList <COUPLE> couple_arr)
    {
        int i, j, k, nob, nog;
        COUPLE couple;
        nob=boy_arr.size();
        nog=girl_arr.size();
        for (i=0, k=0;i<nob;i++){
            for (j=0;j<nog;j++){
                if (girl_arr.get(j).ex!=boy_arr.get(i).name && girl_arr.get(j).status==false && boy_arr.get(i).atr_req<=girl_arr.get(j).atr && boy_arr.get(i).budget>=girl_arr.get(j).main_budget){
                    boy_arr.get(i).status=true;
                    girl_arr.get(j).status=true;
                    couple=new COUPLE(boy_arr.get(i), girl_arr.get(j));
                    couple_arr.add(couple);
                    k++;
                    break;
                }  
            }
        }
    }
    
    public void alternate_match(ArrayList <BOY> boy_arr, ArrayList <GIRL> girl_arr, ArrayList <COUPLE> couple_arr, BufferedWriter bw) throws IOException
    {
        int i, j, k, flag=1;
        int nob, nog;
        nob=boy_arr.size();
        nog=girl_arr.size();
        COUPLE couple;
        //i-boy-0   j-girl-1
        Timestamp t =new Timestamp(System.currentTimeMillis());
        bw.write("Alternate Matching");
        bw.newLine();
        bw.write("        Time Stamp        "+"couple_id");
        bw.newLine();
        for(i=0, j=0;i<nob && j<nog;){
            if(flag==1 && girl_arr.get(j).status==false){
                for(k=0;k<nob;k++){
                    if(boy_arr.get(k).status==false && boy_arr.get(k).atr_req<=girl_arr.get(j).atr && boy_arr.get(k).budget>=girl_arr.get(j).main_budget){
                        boy_arr.get(k).status=true;
                        girl_arr.get(j).status=true;
                        couple=new COUPLE(boy_arr.get(k), girl_arr.get(j));
                        bw.write(t.toString()+" "+couple.name);
                        bw.newLine();
                        couple_arr.add(couple);
                        break;
                    }
                }
                j++;
                flag=0;
            }else if(flag==1){
                j++;
                flag=0;
            }else if (flag==0 && boy_arr.get(i).status==false){
                for(k=0;k<nog;k++){
                    if(girl_arr.get(k).status==false && boy_arr.get(i).atr_req<=girl_arr.get(k).atr && boy_arr.get(i).budget>=girl_arr.get(k).main_budget){
                        boy_arr.get(i).status=true;
                        girl_arr.get(k).status=true;
                        couple=new COUPLE(boy_arr.get(i), girl_arr.get(k));
                        bw.write(t.toString()+" "+couple.name);
                        bw.newLine();
                        couple_arr.add(couple);
                        break;
                    }
                }
                i++;
                flag=1;
            }else{
                i++;
                flag=1;
            }
        }
    }
    
}
