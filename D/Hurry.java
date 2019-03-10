package concurrent_assignment1.D;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hurry must:
 * - Be the main thread
 * - Create the Lazy thread.
 * - Wait for Lazy to finish. Each second it must print the message: “Aren’t you ready yet?” and checks if Lazy is finished.
 * - If Lazy isn’t finished after 5 seconds, Hurry will claim “You are resting in your laurels… and I am leaving!” and interrupts Lazy. Then it waits for Lazy to finish.
 * - However, if Lazy finishes before the 5 seconds deadline, Hurry says “At last, a turtle runs rings round you!”.
 * 
 * @author yournamehere
 *
 */


public class Hurry {
    public static void main(String args[]){
        Lazy l = new Lazy();
        
        String msg[]= {
            "Aren't you ready yet?", // msg 0
            "You are resting in your laurels... and I am leaving!", // msg 1
            "At last, a turtle runs rings round you!" // msg 2
        }; 
        
        l.start();
        boolean flag= false;
        try {
                for (int i = 0; i < 5; i++) {
                        if(l.isAlive()) {
                            System.out.println("Hurry said: " + msg[0]);
                        } else if(!l.isAlive()&&!flag){
                            System.out.println("Hurry said: " + msg[2]);
                            flag = true;
                        }
                        Thread.sleep(1000);
                        //Sometimes Lazy finishes just outside the 5 sec deadline,
                        //but is already dead when it reaches the outside loop. To
                        //counteract this behaviour we once again check if Lazy is
                        //finished. The flag is to make sure we do not enter twice
                        //the [2] message.
                }    
                if (l.isAlive()){
                    l.interrupt();
                    System.out.println("Hurry said: " + msg[1]);    
                }else if(!flag){
                    System.out.println("Hurry said: " + msg[2]);
                }
        } catch (InterruptedException ex) {
            System.out.println("Something weird happened...");
            }
    }
}
