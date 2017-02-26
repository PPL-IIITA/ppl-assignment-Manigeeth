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
public class PPL_Q2 {

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
            ArrayList <GIFT> gift_arr=new ArrayList<>();
            int nob, nog, nogifts;
            int intel, atr, atr_req, budget, main_budget, cost, value;
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
            //Read Info of Gifts
            nogifts=Integer.parseInt(br.readLine());
            GIFT gift;
            for(i=0;i<nogifts;i++){
                str=br.readLine();
                StringTokenizer st=new StringTokenizer(str, ",");
                name=st.nextToken();
                cost=Integer.parseInt(st.nextToken());
                value=Integer.parseInt(st.nextToken());
                type=st.nextToken();
                gift=new GIFT(name, cost, value, type);
                gift_arr.add(gift);
            }
            //Gift Allocations For Couples
            Collections.sort(gift_arr, new COMPARE());//sorting gifts according to their cost
            int max_cost, price;
            for (i=0;i<couple_arr.size();i++){
                if (couple_arr.get(i).boy.type=="Miser"){
                    max_cost=couple_arr.get(i).girl.main_budget;
                    price=0;
                    k=0;
                    while(price<max_cost){
                        price+=gift_arr.get(k).cost;
                        couple_arr.get(i).gift_arr.add(gift_arr.get(k));
                        k++;
                    }
                    if (price>couple_arr.get(i).boy.budget){
                        price-=gift_arr.get(k-1).cost;
                        k--;
                        couple_arr.get(i).gift_arr.remove(k);
                    }
                    couple_arr.get(i).price=price;
                }else if(couple_arr.get(i).boy.type=="Generous"){
                    max_cost=couple_arr.get(i).boy.budget;
                    price=0;
                    k=0;
                    while(price<max_cost){
                        price+=gift_arr.get(k).cost;
                        couple_arr.get(i).gift_arr.add(gift_arr.get(k));
                        k++;
                    }
                    if (price>couple_arr.get(i).boy.budget){
                        price-=gift_arr.get(k-1).cost;
                        k--;
                        couple_arr.get(i).gift_arr.remove(k);
                    }
                    couple_arr.get(i).price=price;
                }else{//For Geek
                    max_cost=couple_arr.get(i).girl.main_budget;
                    price=0;
                    k=0;
                    while(price<max_cost){
                        price+=gift_arr.get(k).cost;
                        couple_arr.get(i).gift_arr.add(gift_arr.get(k));
                        k++;
                    }
                    if (price>couple_arr.get(i).boy.budget){
                        price-=gift_arr.get(k-1).cost;
                        k--;
                        couple_arr.get(i).gift_arr.remove(k);
                    }
                    max_cost=couple_arr.get(i).boy.budget-price;
                    for (j=0;j<nogifts;j++){
                        if (gift_arr.get(j).type=="Luxury" && max_cost>=gift_arr.get(j).cost){
                            couple_arr.get(i).gift_arr.add(gift_arr.get(j));
                            price+=gift_arr.get(j).cost;
                            break;
                        }
                    }
                    couple_arr.get(i).price=price;
                }
            }
            //To Calculate Happiness And Compatibility
            int girl_h=0, boy_h=0, couple_h;
            int main_cost;
            for (i=0;i<couple_arr.size();i++){
                //Happiness For Girls
                price=couple_arr.get(i).price;
                main_cost=couple_arr.get(i).girl.main_budget;
                if(couple_arr.get(i).girl.type=="Choosy"){
                    girl_h=(int) Math.log10(price-main_cost);
                }else if(couple_arr.get(i).girl.type=="Normal"){
                    girl_h=(int) Math.exp(price-main_cost);
                }else{//For Despaerate
                    girl_h=price-main_cost;
                }
                //Happiness For Boys
                if(couple_arr.get(i).boy.type=="Miser"){
                    boy_h=couple_arr.get(i).boy.budget-price;
                }else if(couple_arr.get(i).boy.type=="Generous"){
                    boy_h=girl_h;
                }else{
                    boy_h=couple_arr.get(i).girl.intel;
                }
                couple_h=girl_h+boy_h;
                couple_arr.get(i).girl.happiness=girl_h;
                couple_arr.get(i).boy.happiness=boy_h;
                couple_arr.get(i).happiness=couple_h;
                couple_arr.get(i).compatibility=couple_arr.get(i).boy.budget-main_cost+Math.abs(couple_arr.get(i).boy.intel-couple_arr.get(i).girl.intel)+Math.abs(couple_arr.get(i).girl.atr-couple_arr.get(i).boy.atr);
            }
            System.out.println("Couples are");
            for (i=0;i<couple_arr.size();i++){
                System.out.println(couple_arr.get(i).name);
            }
            System.out.println();
            Collections.sort(couple_arr, new CMPH());
            System.out.println("Happiness");
            for (i=0;i<couple_arr.size();i++){
                System.out.println(couple_arr.get(i).name+" happiness is "+couple_arr.get(i).happiness);
            }
            System.out.println();
            Collections.sort(couple_arr, new CMPP());
            System.out.println("Compatibility");
            for (i=0;i<couple_arr.size();i++){
                System.out.println(couple_arr.get(i).name+" compatibility is "+couple_arr.get(i).compatibility);
            }
        }catch(IOException | NumberFormatException e){
            
        }
    }
    
}
