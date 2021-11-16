import java.util.Arrays;

/******************************************************************************
 *  Name:    
 *  NetID:   
 *  Precept: 
 *
 *  Partner Name:    
 *  Partner NetID:   
 *  Partner Precept: 
 * 
 *  Description:  
 *
 * This is a template file for RingBuffer.java. It lists the constructors and
 * methods you need, along with descriptions of what they're supposed to do.
 *  
 * Note: it won't compile until you fill in the constructors and methods
 *       (or at least commment out the ones whose return type is non-void).
 *
 ******************************************************************************/

public class RingBuffer {
    // YOUR INSTANCE VARIABLES HERE
    // You are creating a circular queue.
    // Look up how to create a cirucular queue using an array.
	
	private int capacity, s, e, size;
	
    //must use and array   []
	private double[] queue;

    // creates an empty ring buffer with the specified capacity
    public RingBuffer(int capacity) {
    	this.capacity = capacity;
        queue = new double[capacity];
        
        size = 0;
        s = 0;
        e = 0;
    }

    // return the capacity of this ring buffer
    public int capacity() {
        return capacity;
    }

    // return number of items currently in this ring buffer
    public int size() {
    	return size;
    }

    // is this ring buffer empty (cap equals zero)?
    public boolean isEmpty() {
        return size() == 0;
    }

    // is this ring buffer full (cap equals capacity)?
    public boolean isFull() {
        return size() == capacity;
    }

    // adds item x to the end of this ring buffer
    public void enqueue(double x) {
    	if(!isFull()) {
    		if(e == queue.length)
    			e = 0;
    		
    		queue[e] = x;
    		e++;
    		size++;
    	}
    }

    // deletes and returns the item at the read of this ring buffer
    public double dequeue() {
    	if(!isEmpty()) {
    		if(s == queue.length)
    			s = 0;
    		
    		double val = queue[s];
    		s++;
    		size--;
    		return val;
    	}
    	return 0;
    }

    // returns the item at the read of this ring buffer
    public double peek() {
        return queue[s];
    }
    
    public String toString() {
    	String str = "[";
    	if(size()==0)
    	{
    		str += "]";
    	}
    	else
    	{
	    	for(int i=0;i<e-1;i++)
	    	{
	    		str += queue[i] + ", ";
	    	}
	    	str += queue[e-1] + "]";
    	}
    	return str;
    }
    
    // tests and calls every instance method in this class
    public static void main(String[] args) {
    	RingBuffer ring = new RingBuffer(1000);
    	
        for(int i = 1; i < 1000; i++) {
        	ring.enqueue(i);
        }
        
        System.out.println(ring.size());
        
        for(int i = 1; i < 950; i++)
        	ring.dequeue();
        
        System.out.println(ring.size());
        
        for(int i = 1; i < 500; i++) {
        	ring.enqueue(i);
        }
        
        System.out.println(ring.size());
    }

}
