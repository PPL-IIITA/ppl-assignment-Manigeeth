/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppla;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *used to generate input and writes into a file
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
            f=new File("boy.txt");
            bool=f.createNewFile();
            fw=new FileWriter("boy.txt");
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
                    type="MISER";
                }else if(t==1){
                    type="GENEROUS";
                }else{
                    type="GEEK";
                }
                bw.write(type);
                bw.newLine();
            }
            bw.close();
            fw.close();
            //Attributes or Info of girls
            f=new File("girl.txt");
            bool=f.createNewFile();
            fw=new FileWriter("girl.txt");
            bw=new BufferedWriter(fw);
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
                    type="CHOOSY";
                }else if(t==1){
                    type="NORMAL";
                }else{
                    type="DESPERATE";
                }
                bw.write(type);
                bw.newLine();
            }
            bw.close();
            fw.close();
            //Info of Gifts
            f=new File("gift.txt");
            bool=f.createNewFile();
            fw=new FileWriter("gift.txt");
            bw=new BufferedWriter(fw);
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
                    type="ESSENTIAL";
                }else if(t==1){
                    type="LUXURY";
                }else{
                    type="UTILITY";
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
