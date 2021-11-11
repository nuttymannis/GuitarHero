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

    // creates a guitar string of the specified frequency,
    // using sampling rate of 44,100
	
	RingBuffer guitar;
	double decay;
	
    public GuitarString(double frequency) {
        guitar = new RingBuffer((int) Math.round(44100 / frequency));
        decay = .994;
        
        for(int i = 0; i < guitar.capacity(); i++) 
        	guitar.enqueue(0);
    }

    // creates a guitar string whose size and initial values are given by
    // the specified array
    public GuitarString(double[] init) {
        guitar = new RingBuffer(init.length);
        
        for(int i = 0; i < guitar.capacity(); i++) {
        	guitar.enqueue(init[i]);
        }
    }

    // returns the number of samples in the ring buffer
    public int length() {
        return guitar.size();
    }

    // plucks the guitar string (by replacing the buffer with white noise)
    public void pluck() {
    	for(int i = 0; i < guitar.capacity(); i++) {
        	guitar.dequeue();
        }
    	
        for(int i = 0; i < guitar.capacity(); i++) {
        	double val = (Math.random() * .5) * (Math.round(Math.random()) == 1 ? 1 : -1);
        	guitar.enqueue(val);
        }
    }

    // advances the Karplus-Strong simulation one time step
    public void tic() {
        double avg = (guitar.dequeue() + guitar.dequeue()) / 2;
        guitar.enqueue(avg * decay);
    }

    // returns the current sample
    public double sample() {
        return guitar.peek();
    }


    public String toString() {
    	return guitar.toString();
    }
    
    // tests and calls every constructor and instance method in this class
    public static void main(String[] args) {
        GuitarString gstring = new GuitarString(440);
        gstring.pluck();
        System.out.println(gstring);
        
        
        for(int i = 0; i < gstring.length(); i++) {
	        gstring.tic();
	        System.out.println(gstring.sample());
        }
    }

}
