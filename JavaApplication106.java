
package circular.doubly.linkedlist;
import circular.doubly.linkedlist.CDoublyLinkedList;

public class JavaApplication106 {

    
    public static void main(String[] args) {
         CDoublyLinkedList<Integer> cdll = new CDoublyLinkedList<Integer>(); 
		   
		   cdll.add(1);       
		   cdll.add(2);
		   cdll.add(3);
		   cdll.add(4);
		   
		   System.out.println("\nOriginal list: ");
		   System.out.println(cdll.toString());  
		   											
		   
		   System.out.println("\naddFront(9)");
		   cdll.addFront(9);                       
		   System.out.println(cdll.toString());   
		   
		   System.out.println("\naddBack(8)");
		   cdll.addBack(8);							
		   System.out.println(cdll.toString());		
		   
		   System.out.println("\naddAtPosition(6,2)");
		   cdll.addAtPosition(6, 2);					
		   System.out.println(cdll.toString());		
		   
		   System.out.println("\nremove(4)");
		   cdll.remove(4);							
		   System.out.println(cdll.toString());		
		   
		   System.out.println("\nremoveFront()");
		   cdll.removeFront();						
		   System.out.println(cdll.toString());		
		   
		   System.out.println("\nremoveBack()");
		   cdll.removeBack();						
		   System.out.println(cdll.toString());		
		   
		   System.out.println("\nremoveAtPosition(1)");
		   cdll.removeAtPosition(1);					
		   System.out.println(cdll.toString());		
		   
		   System.out.println("\nprintReverse()");
		   System.out.println(cdll.printReverse());  
		   										      
		   
	}
    }

