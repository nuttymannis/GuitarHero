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
 * This is cap template file for RingBuffer.java. It lists the constructors and
 * methods you need, along with descriptions of what they're supposed to do.
 *  
 * Note: it won't compile until you fill in the constructors and methods
 *       (or at least commment out the ones whose return type is non-void).
 *
 ******************************************************************************/

public class RingBuffer {
    // YOUR INSTANCE VARIABLES HERE
    // You are creating cap circular queue.
    // Look up how to create cap cirucular queue using an array.

    //must use and array   []
	private double[] cap;
	public int Size;
	private int s;
	private int e;
    // creates an empty ring buffer with the specified capacity
    public RingBuffer(int capacity) {
        // YOUR CODE HERE
    	cap = new double[capacity];
    	Size = 0;
    	s =0;
    	e =0;
    }

    // return the capacity of this ring buffer
    public int capacity() {
        // YOUR CODE HERE
    	return cap.length - Size;
    }

    // return number of items currently in this ring buffer
    public int size() {
        // YOUR CODE HERE
    	return Size;
    }

    // is this ring buffer empty (size equals zero)?
    public boolean isEmpty() {
        // YOUR CODE HERE
    	if(Size==0) {
    		return true;
    	}
    	return false;
    }

    // is this ring buffer full (size equals capacity)?
    public boolean isFull() {
        // YOUR CODE HERE
    	if(Size==cap.length) {
    		return true;
    	}
    	return false;
    }

    // adds item x to the end of this ring buffer
    public void enqueue(double x) {
        // YOUR CODE HERE
    	Size++;
    	cap[e]=x;
    	if(e==cap.length-1) {
    		e=0;
    	}
    	else {
    	
    		e++;
    	}
   	
    	
    }

    // deletes and returns the item at the front of this ring buffer
    public double dequeue() {
        // YOUR CODE HERE
    	Size--;
    	double d = cap[s];
    	if(s==cap.length-1) {
    		s=0;
    	}
    	else {
    		s++;
    	}
    	return d;
    	
    }

    // returns the item at the front of this ring buffer
    public double peek() {
        // YOUR CODE HERE
    	return cap[s];
    }
    public String toString() {
    	if(Size==0) {
    		s=0;
    		e=0;
    		return "[]";
    	}
    	int cnt=s;
    	double [] i = new double[Size];	
    	for(int x=0;x<i.length;x++) {
    		if(cnt==cap.length) {
    			cnt = 0;
    			i[x]=cap[cnt];
    			cnt++;
    		}
    		else {
    			i[x]=cap[cnt];
    			cnt++;
    		}
    	}
    	return Arrays.toString(i);
    	
    }

    // tests and calls every instance method in this class
    public static void main(String[] args) {
        // YOUR CODE HERE
    }

}
