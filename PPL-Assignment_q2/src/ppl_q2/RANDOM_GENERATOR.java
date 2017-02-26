/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_q2;
import java.io.*;
import java.util.*;
/**
 *
 * @author Manigeeth
 */
public class RANDOM_GENERATOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        // TODO code application logic here
        File f;
        FileWriter fw=null;
        BufferedWriter bw=null;
        boolean bool;
        try{
            f=new File("data.txt");
            bool=f.createNewFile();
            fw=new FileWriter("data.txt");
            bw=new BufferedWriter(fw);
            int nob, nog;
            Random rand=new Random();
            nog=10+rand.nextInt(10);
            nob=nog+15+rand.nextInt(10);
            int atr, atr_req, intel, budget, t, main_budget;
            String name;
            String type;
            
            //Attributes or Info of boys
            bw.write(Integer.toString(nob));
            bw.newLine();
            for (int i=1;i<=nob;i++){
                name="boy"+i;
                bw.write(name);
                bw.write(",");
                
                atr=rand.nextInt(100);
                bw.write(Integer.toString(atr));
                bw.write(",");
                
                budget=rand.nextInt(100);
                bw.write(Integer.toString(budget));
                bw.write(",");
                
                intel=rand.nextInt(100);
                bw.write(Integer.toString(intel));
                bw.write(",");
                
                atr_req=rand.nextInt(100);
                bw.write(Integer.toString(atr_req));
                bw.write(",");
                
                t=rand.nextInt(3);
                if (t==0){
                    type="Miser";
                }else if(t==1){
                    type="Generous";
                }else{
                    type="Geek";
                }
                bw.write(type);
                bw.newLine();
            }
            //Attributes or Info of girls
            bw.write(Integer.toString(nog));
            bw.newLine();
            for (int i=1;i<=nog;i++){
                name="girl"+i;
                bw.write(name);
                bw.write(",");
                
                atr=rand.nextInt(100);
                bw.write(Integer.toString(atr));
                bw.write(",");
                
                main_budget=rand.nextInt(100);
                bw.write(Integer.toString(main_budget));
                bw.write(",");
                
                intel=rand.nextInt(100);
                bw.write(Integer.toString(intel));
                bw.write(",");
                
                t=rand.nextInt(3);
                if (t==0){
                    type="Choosy";
                }else if(t==1){
                    type="Normal";
                }else{
                    type="Desperate";
                }
                bw.write(type);
                bw.newLine();
            }
            //Info of Gifts
            int nogifts, cost, value;
            nogifts=15+rand.nextInt(100);
            bw.write(Integer.toString(nogifts));
            bw.newLine();
            for (int i=1;i<=nogifts;i++){
                name="gift"+i;
                bw.write(name);
                bw.write(",");
                
                cost=10+rand.nextInt(20);
                bw.write(Integer.toString(cost));
                bw.write(",");
                
                t=rand.nextInt(2);
                if(t==0){
                    value=cost-5;
                }else{
                    value=cost+5;
                }
                bw.write(Integer.toString(value));
                bw.write(",");
                
                t=rand.nextInt(3);
                if (t==0){
                    type="Essential";
                }else if(t==1){
                    type="Luxury";
                }else{
                    type="Utility";
                }
                bw.write(type);
                bw.newLine();
            }
            bw.close();
            fw.close();
        }catch(Exception e){
            
        }
        
    }
    
}
