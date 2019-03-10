package concurrent_assignment1.D;

import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Lazy must:
 * - Extend Thread
 * - Enter in a loop which iterates a random number of times between 2 to 8.
 * - Sleep 1 second
 * - At each iteration, it displays a random message among: “I am dressing up…”, “Just a sec, please…”, or “These clothes do not suit me…”.
 * - If Hurry interrupts Lazy before it is finished, Lazy claims: “That’s not cricket, please play the game!”.
 * - If Lazy finishes before being interrupted, it says “I am ready, the early bird catches the worm!”.
 * 
 * @author yournamehere
 *
 */

public class Lazy extends Thread {
    
    
    @Override
    public void run (){
        int i = (int) (Math.random() * 7) + 2;
        
        String msg [] = {
            "I'am dressing up...", // msg 0
            "Just a sec, please...", // msg 1
            "These clothes do not suit me...", // msg 2
            "That's not cricket, please play the game!", //msg 3
            "I am ready, the early bird catches the worm!" // msg 4
        };
        try {
            for (int j = 0; j < i; j++) {

                    int p = (int) (Math.random() * 2);

                    if (this.isInterrupted()){
                        System.out.println("Lazy said: " + msg[3]);
                        break;
                    } else {
                        System.out.println("Lazy said: " + msg[p]);
                    }
                        this.sleep(1200);
                                         }
            } catch (InterruptedException ex) {
                System.out.println("Lazy said: " + msg[3]);
                this.interrupt();
                }
        
        if(!this.isInterrupted()){
            System.out.println("Lazy said: " + msg[4]);
            
        }
        
    }
}
