
package circular.doubly.linkedlist;


public class CDoublyLinkedList <T> {
    protected DLLNode<T> head;		 
	protected DLLNode<T> tail;		
	protected DLLNode<T> location;	 
	protected int numElements;		 
	protected boolean found;       

	
 
    public CDoublyLinkedList() {
        
        
    }
	{
		head = null;
		tail = null;
		numElements = 0;
		location = null;
	}
	
	public boolean isEmpty()
	
	{
		return (head == null);
	}
	
	public int size()
	
	{
		return numElements;
	}
	
	protected void find(T target)
   
    {
      location = head;
      found = false;
      if(!isEmpty()){ 	  
    	  do 
          {
            if (location.getData().equals(target))  
            {
             found = true;
             return;
            }
            else
            {
                location = location.getNext();
            }
          }while(location != tail.getNext());
      }
      
    }

    public boolean contains (T element)
	
	{
		 find(element);
		 return found;
	}
    
	protected void findPosition(int position) 
	
	{
		int start = 0;
		location = head;
		found = false;
	
		if ((!isEmpty()) && (position >= 0) && (position <= size())) {
			do {
				
				location = location.getNext();
				start++;

			} while ((location != head) && start < position);
			found = true;
		}

	}
	
	public T get(T data)
	  
	  {
	    find(data);    
	    if (found)
	      return location.getData();
	    else
	      return null;
	  }
	
	public void reset()
	
	  {
	      location  = head;
	  }
	
	
	public void add(T data)
	
	{
		DLLNode<T> newNode = new DLLNode<T>(data);  
	   	
	   	 if (isEmpty())           
	   	 {
	   		 head = newNode;
	   	     tail = newNode;   	    
	   	     head.setPrevious(tail);
	   	     tail.setNext(head);	   	 
	   	 }
	   	 else                   
	   	 {
	   		 tail.setNext(newNode);
	   		 newNode.setPrevious(tail);
	   	     tail = newNode;
	   	     tail.setNext(head);
	   	 }
	   	 numElements++;
	}

    
    public void addFront(T data) 
    
    {
    	DLLNode<T> newNode = new DLLNode<T>(data);   
    	if (isEmpty())            
	   	 {
    		 head = newNode;
	   	     tail = newNode;   	    
	   	     head.setPrevious(tail);
	   	     tail.setNext(head);
	   	 }
	   	 else                       
	   	 {
	   		newNode.setNext(head);
	   		head.setPrevious(newNode);
	   	    head = newNode;
	   	    head.setPrevious(tail);
	   	    tail.setNext(head);
	   	 }
	   	 numElements++;
	   	
    }
    
    public void addBack(T data)
   
    {
    	DLLNode<T> newNode = new DLLNode<T>(data);  
	   	
	   	 if (isEmpty())           
	   	 {
	   		 head = newNode;
	   	     tail = newNode;   	    
	   	     head.setPrevious(tail);
	   	     tail.setNext(head);	   	 
	   	 }
	   	 else                      
	   	 {
	   		 tail.setNext(newNode);
	   		 newNode.setPrevious(tail);
	   	     tail = newNode;
	   	     tail.setNext(head);
	   	 }
	   	 numElements++;
	   	
    }
    
    public void addAtPosition(T data, int position)
    
    {
   	 DLLNode<T> newNode = new DLLNode<T>(data);

		if (isEmpty()) {
			
			 head = newNode;
	   	     tail = newNode;   	    
	   	     head.setPrevious(tail);
	   	     tail.setNext(head);
			
		} else if (position <= 0 ) {
			// insert at front of the list
			newNode.setNext(head);
	   		head.setPrevious(newNode);
	   	    head = newNode;
	   	    head.setPrevious(tail);
	   	    tail.setNext(head);
	   	  
		} else if (position >= size()) {
					
			 tail.setNext(newNode);
	   		 newNode.setPrevious(tail);
	   	     tail = newNode;
	   	     tail.setNext(head);	

		} else {
			
			findPosition(position);
			
			
			newNode.setPrevious(location.getPrevious());
       	newNode.setNext(location);
       	location.getPrevious().setNext(newNode);
       	location.setPrevious(newNode);
			
		}
		numElements++;
	}


	public boolean remove (T element)
   
    {
      find(element);
      if (found)
      { 
    	if(location == head && size() == 1) 
    	{
    		head = null;
    		tail = null;
    		
    	}else if (location == head)    
    	{   		
    		head = head.getNext(); 
            head.setPrevious(tail);
            tail.setNext(head); 
            
        }else if(location == tail)		
        {
        	
        	tail = tail.getPrevious();
            tail.setNext(head);
            head.setPrevious(tail); 
        }
        else{						 
        	location.getPrevious().setNext(location.getNext());  
        	location.getNext().setPrevious(location.getPrevious());  	
        }
        numElements--;
      }
      return found;
    }
	
	 public void removeFront()
	
	 {
		 
	        if(!isEmpty()){  
	        	
	        	if(head.getNext() == head){          		           
	        		head = null;
	        		tail = null;
	        	}else{			
	              head = head.getNext();
	              head.setPrevious(tail);
	              tail.setNext(head);              
	        	}
	        }
	        numElements--;
	 }
	 
	 public void removeBack()
	
	 {
		 
	     if(!isEmpty()){
	    	 
	    	 if(head.getNext() == head){ 
	                                	
	    		 head = null;
	    		 tail = null;
	         }else{				
	            tail = tail.getPrevious();
	            tail.setNext(head);
	            head.setPrevious(tail); 
	         }
	     }
	     numElements--;
	    }
	 
	 public void removeAtPosition(int position)
	 
	 {
		 if(position <= 0){		
			 head = head.getNext();	
			 head.setPrevious(tail);
             tail.setNext(head);   
		 }else if(position >= size() - 1){ 
			 
			 tail = tail.getPrevious(); 
	         tail.setNext(head);
	         head.setPrevious(tail); 
			 
		 }else{
			  
		findPosition(position);
                
	        location.getPrevious().setNext(location.getNext());
		location.getNext().setPrevious(location.getPrevious());
                
		 }
	         numElements--;
	 }
    
    public String toString() 
    
    {
    	String item = "List: [ ";
        
    		DLLNode<T> current = head;
 
    		if(!isEmpty()){
    			
    			do{
        			item += current.getData() + " ";
        			current = current.getNext();
        		}while(current != head);
    			
    		}
    		item += "]";
        return item;

    }
    
    
    public String printReverse() 
    
    {
    	
    	String item = "List: [ ";
        
    		DLLNode<T> current = tail;
 
    		if(!isEmpty()){
    			do{
        			item += current.getData() + " ";
        			current = current.getPrevious();
        		}while(current != tail);
    		}
    		item += "]";
        return item;

    }
    
}
