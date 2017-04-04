package numberplay;

//accepts 2 arrays; interleaves the 1st array with the 2nd 

public class ProbabilisticInterleaver {
	private boolean additive = true;	//if not, b replaces a when p > rand

	public int[] interleave(int[] a, int[] b, float p) {	//make static verson?
		if(a.length != b.length) return new int[1];
		for(int i = 0; i < a.length; i++) {
			if((float)Math.random() < p) {
				if(additive) {
					if(a[i] > 0) a[i] = (a[i] + b[i]) / 2;
					else a[i] = b[i];
				}
				else {
					a[i] = b[i];
				}
			}
		}
		return a;
	}
}
