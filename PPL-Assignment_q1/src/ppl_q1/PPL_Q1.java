/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_q1;
import java.io.*;
import java.util.*;
/**
 *
 * @author Manigeeth
 */
public class PPL_Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws FileNotFoundException {
        // TODO code application logic here
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader("data.txt");
            br=new BufferedReader(fr);
            ArrayList <BOY> boy_arr=new ArrayList<>();
            ArrayList <GIRL> girl_arr=new ArrayList<>();
            ArrayList <COUPLE> couple_arr=new ArrayList<>();
            int nob, nog;
            int intel, atr, atr_req, budget, main_budget;
            int i;
            String name;
            String type;
            String str;
            //Read Boys Info
            BOY boy;
            nob=Integer.parseInt(br.readLine());
            for (i=1;i<=nob;i++){
                str=br.readLine();
                StringTokenizer st=new StringTokenizer(str, ",");
                name=st.nextToken();
                atr=Integer.parseInt(st.nextToken());
                budget=Integer.parseInt(st.nextToken());
                intel=Integer.parseInt(st.nextToken());
                atr_req=Integer.parseInt(st.nextToken());
                type=st.nextToken();
                boy= new BOY(name, atr, budget, intel, atr_req, type);
                boy_arr.add(boy);
            }
            //Read Girls Info
            GIRL girl;
            nog=Integer.parseInt(br.readLine());
            for (i=1;i<=nog;i++){
                str=br.readLine();
                StringTokenizer st=new StringTokenizer(str, ",");
                name=st.nextToken();
                atr=Integer.parseInt(st.nextToken());
                main_budget=Integer.parseInt(st.nextToken());
                intel=Integer.parseInt(st.nextToken());
                type=st.nextToken();
                girl= new GIRL(name, atr, main_budget, intel, type);
                girl_arr.add(girl);
            }
            //Couple Matching
            COUPLE couple;
            int j, k;
            for (i=0, k=0;i<nob;i++){
                for (j=0;j<nog;j++){
                    if (girl_arr.get(j).status==false && boy_arr.get(i).atr_req<=girl_arr.get(j).atr && boy_arr.get(i).budget>=girl_arr.get(j).main_budget){
                        boy_arr.get(i).status=true;
                        girl_arr.get(j).status=true;
                        couple=new COUPLE(boy_arr.get(i), girl_arr.get(j));
                        couple_arr.add(couple);
                        k++;
                        break;
                    }
                }
            }
            //Print Output
            for (i=0;i<k;i++){
                System.out.println(couple_arr.get(i).name);
            }
        }catch(IOException | NumberFormatException e){
            
        }
    }
    
}
