package numberplay;

public interface Patterns {
	
	public static int[] asInts(String s) {
		char[] c = s.toCharArray();
		int[] n = new int[c.length];
		for(int i = 0; i < c.length; i++) n[i] = (int)c[i];
		return n;
	}

	public static float regularity(int[] n) {	//need to also track min, to allow for -ve to +ve ranges in n[]
		int r = 0, max = 0;
		if(n[0] > max) max = n[0];
		for(int i = 1; i < n.length; i++) {
			r += (int)Math.abs(n[i] - n[i - 1]);
			if(n[i] > max) max = n[i];
		}
		return (float)r / (max * (n.length - 1));
	}
}
