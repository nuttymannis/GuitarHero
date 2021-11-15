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
	
	private int capacity, s, e;
	
    //must use and array   []
	private double[] queue;

    // creates an empty ring buffer with the specified capacity
    public RingBuffer(int capacity) {
    	this.capacity = capacity;
        queue = new double[capacity];
        
        s = 0;
        e = 0;
    }

    // return the capacity of this ring buffer
    public int capacity() {
        return capacity;
    }

    // return number of items currently in this ring buffer
    public int size() {
    	if(e - s != 0)
    		if(e - s > 0)
    			return e - s;
    		if(e - s < 0)
    			return (capacity - s) + e;
    	else
    		return 0;
    }

    // is this ring buffer empty (cap equals zero)?
    public boolean isEmpty() {
        return size() == 0;
    }

    // is this ring buffer full (cap equals capacity)?
    public boolean isFull() {
        return size() == capacity - 1;
    }

    // adds item x to the end of this ring buffer
    public void enqueue(double x) {
    	if(!isFull()) {
    		if(e >= queue.length)
    			e = 0;
    		
    		queue[e] = x;
    		e++;
    	}
    }

    // deletes and returns the item at the read of this ring buffer
    public double dequeue() {
    	if(!isEmpty()) {
    		if(s >= queue.length && e != 0)
    			s = 0;
    		
    		double val = queue[s];
    		s++;
    		return val;
    	}
    	return 0;
    }

    // returns the item at the read of this ring buffer
    public double peek() {
        return queue[s];
    }
    
    public String toString() {
    	double[] arr = new double[size()];
    	int x = 0;
    	
    	for(int i = s; i != e; i++) {
    		if(i > queue.length - 1)
    			i = 0;
    		
    		arr[x] = queue[i];
    		x++;
    	}
    	
    	return Arrays.toString(arr);
    }
    
    // tests and calls every instance method in this class
    public static void main(String[] args) {
    	RingBuffer ring = new RingBuffer(1000);
    	
        for(int i = 1; i < 1001; i++) {
        	ring.enqueue(i);
        }
        
        for(int i = 1; i < 50; i++)
        	ring.dequeue();
        
        System.out.println(ring);
    }

}
