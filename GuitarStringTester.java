/*****************************************************************************
 *  Plays two guitar strings (concert A and concert C) when the user
 *  types the lowercase letters 'a' and 'c', respectively in the 
 *  standard drawing window.
 *
 ***************************************************************************/
import java.util.*;

public class GuitarStringTester {

    public static void main(String[] args) 
    {

        // Create two guitar strings, for concert A and C
        double CONCERT_A = 440.0;
        double CONCERT_C = CONCERT_A * Math.pow(2, 3.0/12.0);
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringC = new GuitarString(CONCERT_C);

        final double TEXT_POS_X = .2;
        final double TEXT_POS_Y = .5;
                
        Scanner kb = new Scanner( System.in );
 
        // the user types this character
        String key = kb.next();
      
        // pluck the corresponding string
        if (key.equals("a")) {
            stringA.pluck();
        	System.out.println(stringA.Ring().toString());
        }
        else if (key.equals("c")) 
            stringC.pluck();
        else if (key.equals("ac")) {
        	stringA.pluck();
        	stringC.pluck();
        }
        for(int x=0; x<Integer.MAX_VALUE;x++) {
        // compute the superposition of the samples
        double sample = stringA.sample() + stringC.sample();

        // send the result to standard audio
        StdAudio.play(sample);
    

        // advance the simulation of each guitar string by one step
        stringA.tic();
        stringC.tic();
        }
        
    }
}
