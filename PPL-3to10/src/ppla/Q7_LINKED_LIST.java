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
 *Used to make a linked-list and contains a method to say whether a given set of boys have girl-friends or not
 * @author Manigeeth
 */
public class Q7_LINKED_LIST {
    int i;
    class node{
        BOY b;
        GIRL g;
        node next;
        node (){
            next=null;
        }
    }
    node first, last=null;
    Q7_LINKED_LIST(ArrayList <COUPLE> couple_arr){
        for (i=0;i<couple_arr.size();i++){
            node n=new node();
            n.b=couple_arr.get(i).boy;
            n.g=couple_arr.get(i).girl;
            if(last==null){
                first=n;
                last=n;
            }else{
                last.next=n;
                last=last.next;
            }
        }
    }
    public void find_girlfriend(String[] str, ArrayList <COUPLE> couple_arr, BufferedWriter bw) throws IOException{
        Timestamp t =new Timestamp(System.currentTimeMillis());
        for (String s : str){
            bw.write(t.toString());
            node n=first;
            while(n!=null && n.b.name != s){
                n=n.next;
            }
            if(n!=null){
                System.out.println("girlfriend of "+s+" is "+n.g.name);
                bw.write("girlfriend of "+s+" is "+n.g.name);
            }else{
                System.out.println(s+" -girlfriend not found");
                bw.write(s+" -girlfriend not found");
            }
            bw.newLine();
        }
    }
}
