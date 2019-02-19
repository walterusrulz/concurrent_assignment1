package concurrent_assignment1.C;

/**
 * Create class Numbers which instantiates 5 R_PrintID objects (with ID 1 to 5) and runs them.
 * 
 * 
 * @author yournamehere
 *
 */

public class Numbers {
    public static void main(String args[]){
            Thread t1 = new Thread(new R_PrintID(1));
            Thread t2 = new Thread(new R_PrintID(2));
            Thread t3 = new Thread(new R_PrintID(3));
            Thread t4 = new Thread(new R_PrintID(4));
            Thread t5 = new Thread(new R_PrintID(5));
            
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
    }
}
