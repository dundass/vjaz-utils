package modulators;

import chaoscore.LogisticMap;

// proof-of-concept - could this scheme work as an input to render(Modulator[] m) function (for vij, rather than sending time)?
// is it portable to audio control structures as well?

public class Logistic extends LogisticMap implements Modulator {
	float offset = 0, amp = 1;
	int updatePeriod = 1, updateCount = 0;

	@Override
	public float get() {
		return (float)(offset + (getVal() * amp));
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
		if(updateCount % updatePeriod == 0) update();
		updateCount++;
	}

	public void setUpdatePeriod(int p) {
		updatePeriod = p;
	}
	
}
