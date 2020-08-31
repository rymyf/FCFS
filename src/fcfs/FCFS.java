/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcfs;
import java.util.Scanner;
/**
 *
 * @author RAHAF
 */
public class FCFS {

    public static void main(String[] args){
    
     Scanner input = new Scanner(System.in);
     System.out.print("Enter number of processes: ");
     int num = input.nextInt();
    
     process[] p = new process[num];
        System.out.println("");
        
      
        for (int i=0; i<p.length; i++) 
        {
            System.out.print("Enter the name: ");
            String name = input.next();
            System.out.print("Enter the arrive: ");
            int ar = input.nextInt();
            System.out.print("Enter the burst: ");
            int bu = input.nextInt();
           p[i] = new process(name,bu,ar);
           System.out.println("");
        }
       
        
        fcfsAlgorithm(p);
        process.startTime(p);
        process.finishTime(p);
        System.out.println("Waiting Time = "+process.waitingTime(p));
        System.out.println("TurnaRound Time = "+process.turnaroundTime(p));
        
        for(process p1 : p){
         System.out.println(p1);
        }

        
}
    
      public static void fcfsAlgorithm(process[] p)
    {
       
        for (int i = 0; i < p.length; i++) 
        {
            for (int j = i+1; j < p.length; j++) 
            {
                if(p[i].getArrive() > p[j].getArrive())
                {
                   process temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
            
        }
        
    } 
      
      
}
