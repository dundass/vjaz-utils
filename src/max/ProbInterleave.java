package max;

import com.cycling74.max.Atom;
import com.cycling74.max.MaxObject;
import numberplay.ProbabilisticInterleaver;

public class ProbInterleave extends MaxObject {
	private ProbabilisticInterleaver inter;
	private float[] a;//???
	private float p;

	public ProbInterleave(Atom[] a) {
		if(a.length > 0) p = a[0].toFloat();
		else p = 0.4f;
	}
	
	public void a(Atom[] a) {
		
	}
	
	public void interleave(Atom[] a) {
		
	}
	
}
