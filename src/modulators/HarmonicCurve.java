package modulators;

import chaoscore.OctaveTable;

public class HarmonicCurve extends OctaveTable implements Modulator {
	float amp = 1, offset = 0;
	
	public HarmonicCurve(int numHarmonics) {
		super(numHarmonics);
	}

	@Override
	public float get() {
		float s = super.getSum(0);
		return 0;
	}

	@Override
	public void setOffset(float o) {
		offset = o;
	}

	@Override
	public void setAmplitude(float a) {
		amp = a;
	}

	@Override
	public void update(float t) {
		//something like:
		//val = getSum((t * getResolution()) % getResolution()); ????
		//& make a separate freq parameter to control how fast it moves thru table??
	}
}
