package concurrent_assignment1.B;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Create class Numbers which instantiates 5 T_PrintID objects (with ID 1 to 5) and runs them.
 * Can you detect some problem? Can you explain the reason?
 * 
 * @author yournamehere
 *
 */

public class Numbers {
    public static void main(String args[]) throws InterruptedException{
            
              
            T_PrintID t1 = new T_PrintID(1);
            T_PrintID t2 = new T_PrintID(2);
            T_PrintID t3 = new T_PrintID(3);
            T_PrintID t4 = new T_PrintID(4);
            T_PrintID t5 = new T_PrintID(5);
            
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
              
    }
}
