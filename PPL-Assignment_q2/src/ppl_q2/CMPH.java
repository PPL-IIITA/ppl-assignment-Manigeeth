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
public class CMPH implements Comparator{
    @Override
    public int compare(Object o1,Object o2)
    {
        COUPLE g1,g2;
        g1=(COUPLE)o1;
        g2=(COUPLE)o2;
        if(g1.happiness>g2.happiness)
        {
            return 1;
        }
        else if(g1.happiness<g2.happiness)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
