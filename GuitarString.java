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
 * Description: 
 *  
 * This is a template file for GuitarString.java. It lists the constructors
 * and methods you need, along with descriptions of what they're supposed
 * to do.
 *  
 * Note: it won't compile until you fill in the constructors and methods
 *       (or at least commment out the ones whose return type is non-void).
 *
 ******************************************************************************/

public class GuitarString {
    // YOUR INSTANCE VARIABLES HERE
	private RingBuffer x;
	//private double f;
	private int s;
    // creates a guitar string of the specified frequency,
    // using sampling rate of 44,100
    public GuitarString(double frequency) {
        // YOUR CODE HERE
    	x = new RingBuffer((int)(44100/frequency));
    	s=0;
    	for(int i=0;i<(44100/frequency);i++) {
    		x.enqueue(0);
    	}
    	//System.out.println(a.toString());
    }

    // creates a guitar string whose size and initial values are given by
    // the specified array
    public GuitarString(double[] init) {
        // YOUR CODE HERE
    	x = new RingBuffer(init.length);
    	//System.out.println(Arrays.toString(init));
    	for(int i=0;i<init.length;i++) {
    		x.enqueue(init[i]);
    	}
    	s=0;
    }

    // returns the number of samples in the ring buffer
    public int length() {
        // YOUR CODE HERE
    	return x.size();
    }

    // plucks the guitar string (by replacing the buffer with white noise)
    public void pluck() {
        // YOUR CODE HERE
    	for(int y=0;y<x.size();y++) {
    		x.dequeue();
    		x.enqueue(Math.random()-.5);
    	}
    }

    // advances the Karplus-Strong simulation one time step
    public void tic() {
        // YOUR CODE HERE
    	double c = x.dequeue();
    	x.enqueue(.994 *(.5*(c+ x.peek())));
    	s++;
    }

    // returns the current sample
    public double sample() {
        // YOUR CODE HERE
    	return x.peek();
    }
    public int Time() {
    	return s;
    }
    public RingBuffer Ring() {
    	return x;
    }


    // tests and calls every constructor and instance method in this class
    public static void main(String[] args) {
        // YOUR CODE HERE
    	GuitarString c = new GuitarString(4410);
    	System.out.println(c.length());
    	c.pluck();
    	System.out.println(c.x.toString());
    
    	System.out.println(c.sample());
    	double[] a = {4,2,34,5};
    	c = new GuitarString(a);
    	System.out.println(c.sample());
    	c.pluck();
    	System.out.println(c.x.toString());
    	c.tic();
    	System.out.println(c.x.toString());
    }

}
