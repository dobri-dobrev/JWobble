import com.jsyn.*;
import com.jsyn.unitgen.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame implements KeyListener{
	private static SoundMaker sound= new SoundMaker();
	private static Synthesizer synth = JSyn.createSynthesizer();
	public Main(String name){
		super(name);
	}
	public static void main(String[] args){
		synth.add(sound);
		synth.start();
		sound.addWobble();
		//sound.start();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
		
	}
	
	private static void createAndShowGUI(){
		 Main frame = new Main("JWobble");
		 Dimension minSize = new Dimension(100,100);
		 frame.setMinimumSize(minSize);
		 frame.setLocation(300,100);
		 //modified display panel
		 frame.addListener();
		
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setVisible(true);
	      frame.pack();
	}
	public void addListener(){
		JButton button = new JButton("Clear");
        button.addKeyListener(this);
        getContentPane().add(button);
	}
	public void keyPressed(KeyEvent e) {
        sound.start();
    }
	public void keyReleased(KeyEvent e){
		sound.stop();
	}
	public void keyTyped(KeyEvent e){
		
		long t0,t1;
        t0=System.currentTimeMillis();
        do{
            t1=System.currentTimeMillis();
        }
        while (t1-t0<50);
        
	}
}
