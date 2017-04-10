/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppla;

import java.util.Comparator;

/**
 *A comparator used in sorting girls in the decreasing order if their maintenance budget
 * @author Manigeeth
 * 
 */
public class CMPG implements Comparator{
    @Override
    public int compare(Object o1,Object o2)
    {
        GIRL g1,g2;
        g1=(GIRL)o1;
        g2=(GIRL)o2;
        if(g1.main_budget>g2.main_budget)
        {
            return -1;
        }
        else if(g1.main_budget<g2.main_budget)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
