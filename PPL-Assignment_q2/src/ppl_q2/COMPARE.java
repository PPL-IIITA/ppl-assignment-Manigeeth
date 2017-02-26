/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_q2;

import java.util.Comparator;

/**
 *
 * @author Manigeeth
 */
public class COMPARE implements Comparator{
    @Override
    public int compare(Object o1,Object o2)
    {
        GIFT g1,g2;
        g1=(GIFT)o1;
        g2=(GIFT)o2;
        if(g1.cost>g2.cost)
        {
            return 1;
        }
        else if(g1.cost<g2.cost)
        {
            return -1;
        }
        else if(g1.value<g2.value)
        {
            return 1;
        }
        else if(g1.value>g2.value)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
