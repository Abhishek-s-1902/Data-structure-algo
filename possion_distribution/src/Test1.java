import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import java.util.List;

class SOfN<T> {
    private static final Random rand = new Random();
 
    private  List<T> sample;
    private int i = 0;
    private int n;
    public SOfN(int _n) {
	n = _n;
	sample = new ArrayList<T>(n);
    }
    public List<T> process(T item) {
	i++;
	if (i <= n) {
            sample.add(item);
	} else if (rand.nextInt(i) < n) {
	    sample.set(rand.nextInt(n), item);
	}
	return sample;
    }
}