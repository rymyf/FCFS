/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcfs;

/**
 *
 * @author RAHAF
 */
public class process 
{
    
    private String name;
    private int burst;
    private int arrive;
    private int start;
    private int wait;
    private int finish;
    private int turnaRound;
    
    public process(String name, int burst, int arrive)
    {
        this.name = name;
        this.burst = burst;
        this.arrive = arrive;
    }

    public String getName() {
        return name;
    }

    public int getBurst() {
        return burst;
    }

    public int getArrive() {
        return arrive;
    }

  
    @Override
    public String toString() {
        return "process:-" + "\nname= " + name + " , burst= " + burst + " , arrive= " + arrive + "\n";
    }
    
   
    public static void startTime(process[] p)
    {
        p[0].start = p[0].arrive;
        p[1].start = p[0].arrive + p[1].burst;
       
        for (int i = 1; i < p.length; i++) 
        {
            p[i].start = p[i-1].start + p[i-1].burst;
        }
        
    }
    
    
    public static void finishTime(process[] p)
    {
        p[0].finish = p[0].arrive + p[0].burst;
       
        for (int i = 1; i < p.length; i++)
        {
            p[i].finish = p[i-1].arrive + p[i].burst;
        }
        
    }
    
    
    public static double waitingTime(process[] p)
    {
        double t=0;
       
        p[0].wait = p[0].arrive - p[0].arrive;
        for (int i = 1; i < p.length; i++) 
        {
            p[i].wait = p[i-1].finish - p[i].arrive;
            t += p[i].wait;
        }
        
      return t;  
    }
    
    public static double turnaroundTime(process[] p)
    {
        double t = 0;
//         turnAroundTime[i] = burstTimes[i] + waitingTimes[i];
//                        t2+=turnAroundTime[i];

        p[0].turnaRound = 0;
        for (int i = 0; i < p.length; i++) 
        {
            p[i].turnaRound = p[i].burst + p[i].wait;
            t += p[i].turnaRound;
        }
        return t;
    }
}
