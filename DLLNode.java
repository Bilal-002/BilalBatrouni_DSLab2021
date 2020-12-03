
package circular.doubly.linkedlist;


public class DLLNode <T> {
    protected DLLNode<T> next;       
	protected DLLNode<T> previous;    
	protected T data;				  
	
	public DLLNode(T data) 
	
	{
		  this.data = data;
	      next = null;
	      previous = null;
	}

	public DLLNode<T> getNext()
	
	{
		return next;
	}

	public void setNext(DLLNode<T> next) 
	
	{
		this.next = next;
	}

	public T getData() 
	
	{
		return data;
	}

	public void setData(T data) 
	
	{
		this.data = data;
	}
	
	public DLLNode<T> getPrevious() 
	
	{
		return previous;
	}
	
	public void setPrevious(DLLNode<T> previous) 
	
	{
		this.previous = previous;	
	}

}
