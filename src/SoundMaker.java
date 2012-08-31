
import com.jsyn.*;
//import com.softsynth.jsyn.*;
import com.jsyn.unitgen.*;
public class SoundMaker extends Circuit {
	SineOscillator mainS= new SineOscillator();
	SineOscillator mod= new SineOscillator();
	Add freqAdder  = new Add();
	//public SineOscillator sine= new SineOscillator(200);
	LineOut lineOut= new LineOut();
	public SoundMaker() {
		super();
		//mainS.frequency.set(400);
		mainS.amplitude.set(0.9);
		mainS.output.connect(0,lineOut.input,0);
		mainS.output.connect(0,lineOut.input,1);
		add(mainS );
		add(lineOut);
		add(freqAdder);
		add(mod);
		
	}
	public void volMax(){
		mainS.amplitude.set(0.9);
	}
	public void volMin(){
		mainS.amplitude.set(0);
	}
	public void addWobble(){
		
		mod.frequency.set(4);
		mod.amplitude.set(20);
		

		mod.output.connect(freqAdder.inputA);
		freqAdder.inputB.set(120);
		freqAdder.output.connect(mainS.frequency);
		
	}
}
