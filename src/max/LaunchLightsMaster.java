package max;

import com.cycling74.max.Atom;
import com.cycling74.max.MaxObject;
import launchpad.LaunchLightsState;
import launchpad.Launchpad;

// accepts full state of other MaxObjects containing LaunchLightsHandler, and outputs the MIDI for the lights that have changed

public class LaunchLightsMaster extends MaxObject {
	private LaunchLightsState launch;

	public LaunchLightsMaster(Atom[] a) {
		launch = new LaunchLightsState();
		
		declareIO(1, 1);
	}
	
	public void list(int[] l) {	//l[] = the array of 72 midi notes corresponding to the new state of the lights
		Atom[] o = new Atom[2];
		for(int i = 0; i < launch.getStates1D().length; i++) {
			if(l[i] != launch.getStates1D()[i]) {
				o[0] = Atom.newAtom(Launchpad.notesLinear[i]);	//note
				o[1] = Atom.newAtom(l[i]);	//vel (from new state array l[])
				outlet(0, o);
				launch.setLight(i % Launchpad.xSize, i / Launchpad.xSize, l[i]);
			}
		}
	}
	
}
