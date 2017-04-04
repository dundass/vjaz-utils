package interpolation;

public class Easing {
	float e;
	
	public Easing() {
		this(0.04f);
	}
	
	public Easing(float _e) {
		e = _e;
	}
	
	public float getE() {
		return e;
	}
	
	public void setE(float _e) {
		e = _e;
	}

	public float ease(float val, float tar) {
		float v = ease(val, tar, e);
		return v;
	}
	
	public static float ease(float val, float tar, float e) {
		float d = Math.abs(val - tar);
		if(d > 0.001) val += (d * e);
		return val;
	}
}
