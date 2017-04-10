/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppla;

import java.util.Comparator;

/**
 *Used as a comparator when sorting an array of boys using their attractiveness it sorts them in descending order
 * @author Manigeeth
 * 
 */
public class CMPB implements Comparator{
    @Override
    public int compare(Object o1,Object o2)
    {
        BOY b1, b2;
        b1=(BOY)o1;
        b2=(BOY)o2;
        if(b1.atr>b2.atr)
        {
            return -1;
        }
        else if(b2.atr>b1.atr)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
