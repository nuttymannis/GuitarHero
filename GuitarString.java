import java.util.Arrays;

/******************************************************************************
 *  Name:Andrew Spears    
 *  NetID:   
 *  Precept: 
 *
 *  Partner Name:Bobby Hotary, Landon Miller     
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
	private RingBuffer a;
	private int b;
    // creates a guitar string of the specified frequency,
    // using sampling rate of 44,100
    public GuitarString(double frequency) {
    	a = new RingBuffer((int)(44100/frequency));
    	b=0;
    	for(int z=0;z<(44100/frequency);z++) {
    		a.enqueue(0);
    	}
    }

    // creates a guitar string whose size and initial values are given by
    // the specified array
    public GuitarString(double[] init) {
    	a = new RingBuffer(init.length);
    	
    	for(int x=0;x<init.length;x++) {
    		a.enqueue(init[x]);
    	}
    	b=0;
    }

    // returns the number of samples in the ring buffer
    public int length() {
    	return a.size();
    }

    // plucks the guitar string (by replacing the buffer with white noise)
    public void pluck() {
    	for(int y=0;y<a.size();y++) {
    		a.dequeue();
    		a.enqueue(Math.random()-.5);
    	}
    }

    // advances the Karplus-Strong simulation one time step
    public void tic() {
    	double c = a.dequeue();
    	a.enqueue(.994 *(.5*(c+ a.peek())));
    	b++;
    }

    // returns the current sample
    public double sample() {
    	return a.peek();
    }
    public int Time() {
    	return b;
    }
    public RingBuffer Ring() {
    	return a;
    }


    // tests and calls every constructor and instance method in this class
    public static void main(String[] args) {
    	GuitarString c = new GuitarString(4410);
    	System.out.println(c.length());
    	c.pluck();
    	System.out.println(c.a.toString());
    
    	System.out.println(c.sample());
    	double[] a = {4,2,34,5};
    	c = new GuitarString(a);
    	System.out.println(c.sample());
    	c.pluck();
    	System.out.println(c.a.toString());
    	c.tic();
    	System.out.println(c.a.toString());
    }

}
