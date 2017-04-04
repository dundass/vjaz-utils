package modulators;

public class Tan implements Modulator {
	float val = 0, amp = 1, offset = 0;

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
		val = (float)Math.tan(t);
	}

}
