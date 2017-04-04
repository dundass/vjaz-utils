package max;

import com.cycling74.max.Atom;
import com.cycling74.max.MaxObject;

public class NullTest extends MaxObject {

	public NullTest(Atom[] a) {
		declareIO(1, 1);
	}
	
	public void bang() {
		Integer i = null;
		Atom[] o = new Atom[2];
		o[0] = Atom.newAtom("stop");
		o[1] = Atom.newAtom(i);
		outlet(0, o);
	}
}
