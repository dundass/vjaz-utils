package modulators;

public interface Modulator {

	public float get();
	public void setOffset(float o);
	public void setAmplitude(float a);
	public void update(float t);
	
}
