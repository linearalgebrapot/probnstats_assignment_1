import java.util.Random;

public class PoissonDist {

	/**
	 * 
	 */
	private double p;
	private int trials;
	private int howManyIntervals;
	private int intervalsGetP;
	
	private double[] probArr;
	
	/**
	 * 
	 * @param _p
	 * @param _trials
	 */
	public PoissonDist(double _p, int _trials) {
		p = _p;
		trials = _trials;
		
		howManyIntervals = 300;
		intervalsGetP = 1000;
	}
	
	public double[] run() {
		
		int[] successNumArr = new int[howManyIntervals + 1]; //+1 for 0 to "All successes".
		
		for (int i = 0; i < trials; ++i) {
			int successNum = 0;
			for (int j = 0; j < howManyIntervals; ++j) {
				
				int rnd = new Random().nextInt(intervalsGetP);
				if (rnd < p * intervalsGetP) ++successNum;
			}
			++successNumArr[successNum];
		}
		
		probArr = new double[successNumArr.length];
		
		for (int i = 0; i < howManyIntervals; ++i)
			probArr[i] = successNumArr[i] / (double)trials;
		return probArr;
	}
	
	public double lamda() {
		
		double l = 0.0;
		
		for (int i = 0; i < probArr.length; ++i)
			l += i * probArr[i];
		return l;
	}
	
	
	public static void main(String[] args) {
		//* to simulate lamda and poisson dist.
		//unit time 1 hour -> divide 300, p is 0.07, 1,000,000 trials, ...
		double p = 0.07;
		int trials = 1000000;
		
		PoissonDist poisson = new PoissonDist(p, trials);
		double[] res = poisson.run();
		
		for (int i = 0; i < res.length; ++i)
			System.out.printf("%-3d " + res[i] + "\n", i);
		System.out.println("\nLamda : " + poisson.lamda());
	}

}
