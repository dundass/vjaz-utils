package modulators;

public class Sin implements Modulator {
	private float val = 0, amp = 0, offset = 1;

	@Override
	public float get() {
		return (offset + (val * amp));
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
		val = (float)Math.sin(t);
	}
	
}
