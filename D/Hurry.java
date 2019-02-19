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
    public static void main(String args[]) throws InterruptedException{
        Lazy l = new Lazy();
        l.start();
        String msg[]= {
            "Aren't you ready yet?",
            "You are resting in your laurels... and I am leaving!",
            "At last, a turtle runs rings round you!"
        }; 
        
        for (int i = 0; i < 5; i++) {
            l.join(1000);
            if(l.isAlive()) {
                System.out.println("Hurry said: " + msg[0]);
            } else if(!l.isAlive()){
                System.out.println("Hurry said: " + msg[2]);
            }
        }
        
        if (l.isAlive()){
            System.out.println("Hurry said: " + msg[1]);
            l.interrupt();
        }
        
    }
}
