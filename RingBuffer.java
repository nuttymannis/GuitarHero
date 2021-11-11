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
	
	private int capacity, read, write;
	
    //must use and array   []
	private double[] queue;

    // creates an empty ring buffer with the specified capacity
    public RingBuffer(int capacity) {
    	this.capacity = capacity;
        queue = new double[capacity];
        
        read = 0;
        write = -1;
    }

    // return the capacity of this ring buffer
    public int capacity() {
        return capacity;
    }

    // return number of items currently in this ring buffer
    public int size() {
    	int cnt = 0;
    	
        for(double x : queue) {
        	if(x != 0)
        		cnt++;
        }
        
        return cnt;
    }

    // is this ring buffer empty (cap equals zero)?
    public boolean isEmpty() {
        return write < read;
    }

    // is this ring buffer full (cap equals capacity)?
    public boolean isFull() {
        return (write - read) + 1 == capacity;
    }

    // adds item x to the end of this ring buffer
    public void enqueue(double x) {
    	if(!isFull()) {
    		queue[(write + 1) % capacity] = x;
    		write++;
    	}
    }

    // deletes and returns the item at the read of this ring buffer
    public double dequeue() {
    	if(!isEmpty()) {
    		double r = queue[read % capacity];
    		read++;
    		return r;
    	}
    	return 0;
    }

    // returns the item at the read of this ring buffer
    public double peek() {
        return queue[read % capacity];
    }
    
    public String toString() {
    	return Arrays.toString(queue);
    }
    
    // tests and calls every instance method in this class
    public static void main(String[] args) {
    	RingBuffer ring = new RingBuffer(1000);
    	
        for(int i = 1; i < 1001; i++) {
        	ring.enqueue(i);
        }
        
        for(int i = 1; i < 1001; i++) {
        	System.out.println(ring.dequeue());
        }
        
        System.out.println(ring.peek());
        
        for(int i = 1; i < 1001; i++) {
        	ring.enqueue(i*5);
        }
        
        System.out.println(ring.peek());
        ring.dequeue();
        System.out.println(ring.peek());
        
    }

}
