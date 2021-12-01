import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.util.*;
import java.awt.event.*;

public class KeyTrapper extends Canvas implements KeyListener
{
	private String key;
	
	String keys = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ".toUpperCase();
	char[] tim = keys.toCharArray();
	int y = 0;
	int x = 0;
	int bob = (int)(Math.random()*keys.length());
	Map<String, GuitarString> notes;
		//this is the constructor
	public KeyTrapper( )
	{	
		key = "NO VALUE YET";
		addKeyListener( this );
		setFocusable( true );
		
		notes = new HashMap<String, GuitarString>();
		for(int x = 0; x<tim.length;x++)
			notes.put("" + tim[x],new GuitarString(440*Math.pow(1.05956, x-24)));
	}

	public void paint( Graphics window )
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,800,600);

		window.setColor(Color.BLACK);		
		window.drawString( key, 250, 250 );
			
	}
	
	public void keyTyped(KeyEvent e)
	{
		if( e.getKeyCode()  == KeyEvent.VK_SPACE )
		{
			key = "Key pressed " + e.getKeyCode();
			repaint();
		}
		if( e.getKeyCode()  == KeyEvent.VK_X )
		{
			key = "Key pressed " + e.getKeyCode();
			repaint();
		}				
	}
		
	public void keyPressed(KeyEvent e)
	{
		int l = e.getKeyCode();
		System.out.println((char)l);
		GuitarString k = notes.get("" + (char)l);
		
		System.out.println(k.Ring().toString());
		
		k.pluck();
		for(int x=0; x<1024*25;x++) {
			double sample = k.sample();
			
			StdAudio.play(sample);
			
			k.tic();
		}
	}
		
		
	public void keyReleased(KeyEvent e)
	{

		
	}
	

}