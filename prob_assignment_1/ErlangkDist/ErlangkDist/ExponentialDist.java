package ErlangkDist;
import java.util.Random;

public class ExponentialDist {
	
	private double probability;
	private int trials;
	private int howManyIntervals;
	private int intervalsGetP;
	
	int[] waitingTimeArr;
	private double[] probArr;
	
	private int trialsOfSuccess = 0;
		
	/**
	 * 
	 * @param _p
	 * @param _trials
	 */
	public ExponentialDist(double _probability, int _trials) {
		probability = _probability;
		trials = _trials;
		
		howManyIntervals = 100;
		intervalsGetP = 1000;
		
		waitingTimeArr = new int[howManyIntervals];
	}
	
	public double[] run() {
		
		int[] waitingTimeArr = new int[howManyIntervals];
		
		for (int i = 0; i < trials; ++i) {
			
			int successIdx = -1, successNextIdx = 0;
			for (int j = 0; j < howManyIntervals; ++j) {
				
				int rnd = new Random().nextInt(intervalsGetP);
				if (rnd < probability * intervalsGetP) {
					
					if (successIdx == -1) successIdx = j;
					else if (successIdx != -1) {
						successNextIdx = j;
						++waitingTimeArr[successNextIdx - successIdx];
						++trialsOfSuccess;
						break;
					}
				}
			}
		}
		
		probArr = new double[waitingTimeArr.length];
		
		for (int i = 1; i < howManyIntervals; ++i)
			probArr[i] = waitingTimeArr[i] / (double)trialsOfSuccess;
		return probArr;
	}
	
	public double mean() {
		
		double m = 0.0;
		
		for (int i = 1; i < probArr.length; ++i)
			m += i * probArr[i];
		return m;
	}
	
	public double meanOfSquare() {
		
		double ms = 0.0;
		
		for (int i = 1; i < probArr.length; ++i)
			ms += i * i * probArr[i];
		return ms;
	}
	
	public double variance() {
		
		return meanOfSquare() - mean() * mean();
	}
	
	
	public static void main(String[] args) {
		
		double probability = 0.05;
		int trials = 1000000;
		
		ExponentialDist exponential = new ExponentialDist(probability, trials);
		double[] res = exponential.run();
		
		for (int i = 1; i < res.length; ++i)
			System.out.printf("%-3d " + res[i] + "\n", i);
		System.out.println("\nMean : " + exponential.mean()
						  +"\nVariance : " + exponential.variance());
	}

}
