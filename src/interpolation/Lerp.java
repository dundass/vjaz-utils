package interpolation;

public class Lerp {
	float inc;

	public Lerp() {
		this(1.0f);
	}
	
	public Lerp(float i) {
		inc = i;
	}
	
	public float lerp(float val, float tar) {
		float v = lerp(val, tar, inc);
		return v;
	}
	
	public static float lerp(float val, float tar, float inc) {
		float d = val - tar;
		if(Math.abs(d) >= inc) {
			if(d < 0) val += inc;
			else if(d > 0) val -= inc;
		}
		return val;
	}
}
