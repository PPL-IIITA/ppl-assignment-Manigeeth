/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppla;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;
/**
 *This class is used to take in the input from the file
 * and it also takes input regarding which question to be solved
 * and call the required methods to solve the problems
 * @author Manigeeth
 * 
 */
public class PPLA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws FileNotFoundException {
        FileReader fr;
        BufferedReader br;
        BufferedWriter bw;
        FileWriter fw;
        File f;
        boolean bool;
        Timestamp t =new Timestamp(System.currentTimeMillis());
        try {
            f=new File ("log.txt");
            bool=f.createNewFile();
            fw=new FileWriter("log.txt");
            bw=new BufferedWriter(fw);
            fr=new FileReader("boy.txt");
            br=new BufferedReader(fr);
            String name;
            ArrayList <BOY> boy_arr=new ArrayList<>();
            ArrayList <GIRL> girl_arr=new ArrayList<>();
            ArrayList <COUPLE> couple_arr=new ArrayList<>();
            ArrayList <GIFT> gift_arr=new ArrayList<>();
            int nob;
            //Read Boys Info
            String str;
            int i, atr, budget, atr_req, intel, happiness;
            nob=Integer.parseInt(br.readLine());
            
            BOY boy;
            String type;
            for (i=1;i<=nob;i++){
                str=br.readLine();
                StringTokenizer st=new StringTokenizer(str, ",");
                name=st.nextToken();
                atr=Integer.parseInt(st.nextToken());
                budget=Integer.parseInt(st.nextToken());
                intel=Integer.parseInt(st.nextToken());
                atr_req=Integer.parseInt(st.nextToken());
                type=st.nextToken();
                //boy= new BOY(name, atr, budget, intel, atr_req, type);
                if (type=="MISER"){
                    boy= new MISER(name, atr, budget, intel, atr_req);
                    boy_arr.add(boy);
                }else if (type=="GENEROUS"){
                    boy= new GENEROUS(name, atr, budget, intel, atr_req);
                    boy_arr.add(boy);
                }else{
                    boy= new GEEK(name, atr, budget, intel, atr_req);
                    boy_arr.add(boy); 
                }
            }
            //Read Girl Info
            fr=new FileReader("girl.txt");
            br=new BufferedReader(fr);
            int nog, main_budget;
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
                if (type=="CHOOSY"){
                    girl= new CHOOSY(name, atr, main_budget, intel);//System.out.println("ch");
                    girl_arr.add(girl);
                }else if(type=="NORMAL"){
                    girl= new NORMAL(name, atr, main_budget, intel);
                    girl_arr.add(girl);
                }else{
                    girl= new DESPERATE(name, atr, main_budget, intel);
                    girl_arr.add(girl);
                }
                
            }
            
            //Read Info of Gifts
            fr=new FileReader("gift.txt");
            br=new BufferedReader(fr);
            int nogifts, cost, value;
            nogifts=Integer.parseInt(br.readLine());
            GIFT gift;
            for(i=0;i<nogifts;i++){
                str=br.readLine();
                StringTokenizer st=new StringTokenizer(str, ",");
                name=st.nextToken();
                cost=Integer.parseInt(st.nextToken());
                value=Integer.parseInt(st.nextToken());
                type=st.nextToken();
                if (type == "ESSENTIAL"){
                    gift=new ESSENTIAL(name, cost, value);
                    gift_arr.add(gift);
                }else if(type == "LUXURY"){
                    gift=new LUXURY(name, cost, value);
                    gift_arr.add(gift);
                }else{
                    gift=new UTILITY(name, cost, value);
                    gift_arr.add(gift);
                }
                //System.out.println(gift_arr.get(i));
            }
            int q_no=0, k, t6, j;
            /*boy =new BOY("temp", 0, 0, 0, 0);
            girl =new GIRL ("temp", 0, 0, 0);*/
            FUNCTION couple=new FUNCTION();
            FUNCTION fun = new FUNCTION();
            Random rand=new Random();
            System.out.println("Enter numbers from 3 to 8 to solve the respective questions");
            Scanner s=new Scanner(System.in);
            q_no=s.nextInt();
            switch (q_no){
                case 3:
                    bw.write("Couple Matching");
                    bw.newLine();
                    couple.couple_match(boy_arr, girl_arr, couple_arr);
                    bw.write("  Time Stamp  "+"couple_id");
                    System.out.println("Couples are");
                    bw.newLine();
                    for(i=0;i<couple_arr.size();i++){
                        bw.write(t.toString()+" "+couple_arr.get(i).name);
                        System.out.println(couple_arr.get(i).name);
                        bw.newLine();
                    }
                    //bw.write("Sorting Gifts");
                    Collections.sort(gift_arr, new COMPARE());
                    //Gift Allocation
                    bw.newLine();
                    bw.write("Gift Allocation");
                    System.out.println("couple_id     no of gifts");
                    bw.newLine();
                    int a;
                    bw.write("     Time Stamp    "+"couple_id"+"   gifts");
                    bw.newLine();
                    for (i=0;i<couple_arr.size();i++){
                        couple_arr.get(i).gift_allot(gift_arr);
                        a=couple_arr.get(i).gift_arr.size();
                        bw.write(t.toString()+" "+couple_arr.get(i).name+ a);
                        System.out.println(couple_arr.get(i).name+"   "+ a);
                        bw.newLine();
                    }
                    //Calculate Happiness And Compatibility
                    bw.newLine();
                    bw.write("Calculate Happiness And Compatibility");
                    System.out.println("Happiness And Compatibility for each couple");
                    bw.newLine();
                    bw.write("        Time Stamp          "+"couple id"+"Happiness"+"Compatibility");
                    bw.newLine();
                    for (i=0;i<couple_arr.size();i++){
                        bw.write(t.toString()+" ");
                        couple_arr.get(i).cal_happiness();
                        couple_arr.get(i).cal_compatibility();
                        bw.write(couple_arr.get(i).name+" "+couple_arr.get(i).happiness+"      "+couple_arr.get(i).compatibility);
                        System.out.println(couple_arr.get(i).name+" "+couple_arr.get(i).happiness+"      "+couple_arr.get(i).compatibility);
                        bw.newLine();
                    }
                    Collections.sort(couple_arr, new CMPH());
                case 4:
                    bw.write("Couple Matching");
                    System.out.println("Couples are");
                    bw.newLine();
                    couple.couple_match(boy_arr, girl_arr, couple_arr);
                    bw.write("  Time Stamp  "+"couple_id");
                    bw.newLine();
                    for(i=0;i<couple_arr.size();i++){
                        bw.write(t.toString()+" "+couple_arr.get(i).name);
                        System.out.println(couple_arr.get(i).name);
                        bw.newLine();
                    }
                    Collections.sort(gift_arr, new COMPARE());
                    bw.newLine();
                    bw.write("Gift Allocation");
                    System.out.println("couple_id      no of gifts");
                    bw.newLine();
                    bw.write("     Time Stamp    "+"couple_id"+"   gifts");
                    bw.newLine();
                    for (i=0;i<couple_arr.size();i++){
                        couple_arr.get(i).gift_allot(gift_arr);
                        a=couple_arr.get(i).gift_arr.size();
                        bw.write(t.toString()+" "+couple_arr.get(i).name+ a);
                        System.out.println(couple_arr.get(i).name+"    "+ a);
                        bw.newLine();
                    }
                    //Calculate Happiness And Compatibility
                    bw.newLine();
                    bw.write("Calculate Happiness And Compatibility");
                    System.out.println("Happiness And Compatibility for each couple");
                    bw.newLine();
                    bw.write("        Time Stamp          "+"couple id"+"Happiness"+"Compatibility");
                    bw.newLine();
                    for (i=0;i<couple_arr.size();i++){
                        bw.write(t.toString()+" ");
                        couple_arr.get(i).cal_happiness();
                        couple_arr.get(i).cal_compatibility();
                        bw.write(couple_arr.get(i).name+" "+couple_arr.get(i).happiness+"      "+couple_arr.get(i).compatibility);
                        System.out.println(couple_arr.get(i).name+" "+couple_arr.get(i).happiness+"      "+couple_arr.get(i).compatibility);
                        bw.newLine();
                    }
                    Collections.sort(couple_arr, new CMPH());
                    //Valentines Break-Up
                    k=rand.nextInt(couple_arr.size());
                    bw.newLine();
                    bw.write(t.toString()+"Break couples");
                    fun.Break_Up(couple_arr, k, bw);
                    bw.newLine();
                    bw.newLine();
                    bw.write("Couple Matching");
                    System.out.println("Couples matching");
                    bw.newLine();
                    couple.couple_match(boy_arr, girl_arr, couple_arr);
                    bw.write("  Time Stamp  "+"couple_id");
                    bw.newLine();
                    for(i=0;i<couple_arr.size();i++){
                        bw.write(t.toString()+" "+couple_arr.get(i).name);
                        System.out.println(couple_arr.get(i).name);
                        bw.newLine();
                    }
                    break;
                case 5:
                    Collections.sort(boy_arr, new CMPB());
                    Collections.sort(girl_arr, new CMPG());
                    fun.alternate_match(boy_arr, girl_arr, couple_arr, bw);
                    System.out.println("Couples Formed by alternate matching");
                    for(i=0;i<couple_arr.size();i++){
                        System.out.println(couple_arr.get(i).name);
                    }
                    break;
                case 6:
                    t6=rand.nextInt(30);
                    bw.write("value of time interval "+t6);
                    bw.newLine();
                    bw.write("Couple Matching");
                    System.out.println("Couples are");
                    bw.newLine();
                    couple.couple_match(boy_arr, girl_arr, couple_arr);
                    bw.write("  Time Stamp  "+"couple_id");
                    bw.newLine();
                    for(i=0;i<couple_arr.size();i++){
                        bw.write(t.toString()+" "+couple_arr.get(i).name);
                        System.out.println(couple_arr.get(i).name);
                        bw.newLine();
                    }
                    for(i=0;i<t6;i++){
                        Collections.sort(couple_arr, new CMPH());
                        k=rand.nextInt(couple_arr.size());
                        bw.newLine();
                        bw.write(t.toString()+"  Break couples ");
                        fun.Break_Up(couple_arr, k, bw);
                        bw.newLine();
                        bw.newLine();
                        bw.write("Couple Matching");
                        System.out.println("couple matching");
                        bw.newLine();
                        couple.couple_match(boy_arr, girl_arr, couple_arr);
                        bw.write("  Time Stamp  "+"couple_id");
                        bw.newLine();
                        for(j=0;j<couple_arr.size();j++){
                            bw.write(t.toString()+" "+couple_arr.get(j).name);
                            bw.newLine();
                        }
                    }
                    System.out.println("Final Couples are");
                    for(i=0;i<couple_arr.size();i++){
                        System.out.println(couple_arr.get(i).name);
                    }
                    break;
                case 7:
                    String[] string;
                    string = new String[boy_arr.size()];
                    for (i=0;i<boy_arr.size();i++){
                        string[i]=boy_arr.get(i).name;
                    }
                    couple.couple_match(boy_arr, girl_arr, couple_arr);
                    System.out.println("Couples matching");
                    for(i=0;i<couple_arr.size();i++){
                        System.out.println(couple_arr.get(i).name);
                    }
                    Q7_LINKED_LIST obj1 = new Q7_LINKED_LIST(couple_arr);
                    Q7_HASH_TABLE obj2 = new Q7_HASH_TABLE(couple_arr);
                    Q7_SORTED_ARRAY obj3 = new Q7_SORTED_ARRAY(couple_arr);
                    System.out.println();
                    System.out.println("Linked List Implementation");
                    bw.write("Linked List Implementation");
                    bw.newLine();
                    obj1.find_girlfriend(string, couple_arr, bw);
                    System.out.println();
                    
                    System.out.println("Hash Table");
                    bw.newLine();
                    bw.write("Hash Table");
                    bw.newLine();
                    bw.newLine();
                    obj2.find_girlfriend(string, couple_arr, bw);
                    
                    System.out.println();
                    System.out.println("Sorted Table");
                    bw.newLine();
                    bw.write("Sorted Table");
                    bw.newLine();
                    bw.newLine();
                    obj3.find_girlfriend(string, couple_arr, bw);
                    break;
                case 8:
                    bw.write("Couple Matching");
                    bw.newLine();
                    couple.couple_match(boy_arr, girl_arr, couple_arr);
                    bw.write("  Time Stamp  "+"couple_id");
                    bw.newLine();
                    for(i=0;i<couple_arr.size();i++){
                        bw.write(t.toString()+" "+couple_arr.get(i).name);
                        bw.newLine();
                    }
                    Q8 obj = new Q8();
                    obj.func(gift_arr, couple_arr, bw);
                    bw.newLine();
                    bw.write("     Time Stamp    "+"couple_id"+"   gifts");
                    System.out.println("couple_id     no of gifts");
                    bw.newLine();
                    for (i=0;i<couple_arr.size();i++){
                        couple_arr.get(i).gift_allot(gift_arr);
                        a=couple_arr.get(i).gift_arr.size();
                        bw.write(t.toString()+" "+couple_arr.get(i).name+ a);
                        System.out.println(couple_arr.get(i).name+"    "+ a);
                        bw.newLine();
                    }
                    break;
                case 9:
                    break;
                case 10:
                    break;
            }
            bw.close();
            fw.close();
            br.close();
            fr.close();
        }catch(IOException | NumberFormatException e){
            
        }
    }
    
}
