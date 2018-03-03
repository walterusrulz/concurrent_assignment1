package concurrent_assignment1.A;

/**
 * Get the reference of the Main Thread */

public class Reference {
   public static void main(String args[]){
       int oddNum = -1;
       
       Thread muThread = Thread.currentThread();
       System.out.println("Original thread name: "+muThread.getName());
       String nameVanilla = muThread.getName();
       for(int i=0; i<50;i++){
            muThread.setName(nameVanilla+(i+1));
            oddNum += 2;
            System.out.println("Odd number "+(i+1)+" is: "+oddNum+" ->"+muThread.getName());
        }
    } 
   
}
