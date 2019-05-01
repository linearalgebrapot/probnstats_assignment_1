package ErlangkDist;
import java.util.Random;

public class ExponentialDist {
	
	private double lambda;
	private int trials;
	private int howManyIntervals;
	private int intervalsGetP;
	
	private double[] probArr;
		
	/**
	 * 
	 * @param _p
	 * @param _trials
	 */
	public ExponentialDist(double _lamda, int _trials) {
		lambda = _lamda;
		trials = _trials;
		
		howManyIntervals = 100;
		intervalsGetP = 1000;
	}
	
	public double[] run() {
		
		int[] waitingTimeArr = new int[howManyIntervals]; //because... no use of idx 60.
		
		for (int i = 0; i < trials; ++i) {
			
			int successIdx = -1, successNextIdx = 0; //for no success case.
			for (int j = 0; j < howManyIntervals; ++j) {
				
				int rnd = new Random().nextInt(intervalsGetP);
				if (rnd < lambda * intervalsGetP) {
					successIdx = j;
					if (successNextIdx != 0) {
						//++waitingTimeArr[successIdx - successNextIdx];
						successNextIdx = successIdx;
						break;
					}
				}
			}
//			if (successIdx == -1) //한번도 성공 못해서 대기 시간이 뭐 없음 그냥 확률이 0
//			if (successNextIdx == 0) //한번만 성공해서 대기 시간이 그냥 ... 이것도 없네?
		}
		
		probArr = new double[waitingTimeArr.length]; //idx 0 ~ 59
		
		for (int i = 1; i < howManyIntervals; ++i)
			probArr[i] = waitingTimeArr[i] / (double)trials;
		return probArr;
	}
	
	public double mean() {
		
		double m = 0.0;
		
		for (int i = 1; i < probArr.length; ++i)
			m += i * probArr[i];
		return m;
	}
	
	public double variance() {
		
		return mean() * mean();
	}
	
	
	public static void main(String[] args) {
		
		double lambda = 0.3;
		int trials = 1000000;
		
		ExponentialDist exponential = new ExponentialDist(lambda, trials);
		double[] res = exponential.run();
		
		for (int i = 1; i < res.length; ++i)
			System.out.printf("%-3d " + res[i] + "\n", i);
		System.out.println("\nMean : " + exponential.mean()
						  +"\nVariance : " + exponential.variance());
	}

}
