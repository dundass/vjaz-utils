package max;

import com.cycling74.max.*;

//future - convert to generic 'UI' where you can add sliders, buttons etc separately + % col for lights + easing on/off per slider via side buttons

public class LaunchSliders extends MaxObject {
	private float[] sliders = new float[1];
	private char[] lights;
	private int numButtons = 0;
	private float ease;
	
	public LaunchSliders(Atom[] a) {	//1 arg = all sliders, 2 args = [0]x sliders, [1]x button/slider hybrid
		if(a.length == 1) {
			sliders = new float[a[0].toInt()];
		}
		else if(a.length == 2) {
			sliders = new float[a[0].toInt()];
			numButtons = a[1].toInt();
		}
		declareIO(1, sliders.length + (numButtons * 2) + 1);	//(midiin, [sliders, sub-button sliders, buttons, lightsmidi])
		ease = 1.f;
		lights = new char[72];
		for(int i = 0; i < lights.length; i++) lights[i] = 'o';
	}
	
	public void list(Atom[] a) {
		int note = a[0].toInt();
		int vel = a[1].toInt();
		int x = note % 16;
		int y = note / 16;
		if(x < sliders.length) {
			//is a slider
			sliders[x] = 1.f - ((float)y / 7.f);
			outlet(x, Atom.newAtom(sliders[x]));
			for(int i = 0; i < 8; i++) {
				lights[i * 9 + x] = 'o';
			}
			lights[y * 9 + x] = 'G';
		}
		else if(x == 8) {
			//is a side button
			//if(y == 8) ease = 1.f;
			//else ease = 0.001f + ((float)y / 7.f) / 10.f;
		}
		else {
			//is a button/slider combo col
			//if(y == 0) outlet(sliders.length + numButtons + (x - sliders.length), Atom.newAtom('b'));
			if(y == 0 && vel > 0) outletBang(sliders.length + numButtons + (x - sliders.length));
			else outlet(x, Atom.newAtom(1. - ((float)y / 6.)));
		}
		dumplights();
	}
	
	public void dumplights() {
		outlet(sliders.length + (numButtons * 2), lights);
	}
}
