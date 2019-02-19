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
        
        for (int i = 0; i < 5; i++) {
            try {
                l.join(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hurry.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(l.isAlive()) {
                System.out.println("Hurry said: " + msg[0]);
            } else if(!l.isAlive()){
                System.out.println("Hurry said: " + msg[2]);
                break;
            }
        }
        
        if (l.isAlive()){
            l.interrupt();
            System.out.println("Hurry said: " + msg[1]);    
        }
        
    }
}
