/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kevinlehmanassignment2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author kevin.lehman
 */
public class KevinLehmanAssignment2 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        Scanner in = null;
        try
        {
            in = new Scanner(new FileReader("tower_input.txt"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        int numCases = Integer.parseInt(in.nextLine());
        
        for(int i=0; i<numCases; i++)
        {
            int numTowers = Integer.parseInt(in.nextLine());
            int[] height = new int[numTowers];
            int[] span = new int[numTowers];
            span[0] = 1;
            String[] loc = in.nextLine().split(" ");
            
            for(int i1 =0; i1<numTowers; i1++)
            {
               height[i1] = Integer.parseInt(loc[i1]);
            }    
            
            Stack<Integer> s = new Stack<>();
            s.push(0);
            for(int i2 = 1; i2<numTowers; i2++)
            {
                while(!s.isEmpty() && height[s.peek()] <= height[i2])
                {
                   s.pop(); 
                }
                
                if(s.isEmpty())
                {
                    span[i2] = i2+1;
                }
                else
                {
                    span[i2] = i2-s.peek();
                }
                
                s.push(i2);
                
            }    
            
            System.out.println("Case #" + (i+1) + ":");
            
            for(int i3=0; i3 < span.length; i3++)
            {
                System.out.print(span[i3] + " ");
            }    
            
            System.out.println();
        }    
    }
    
}
