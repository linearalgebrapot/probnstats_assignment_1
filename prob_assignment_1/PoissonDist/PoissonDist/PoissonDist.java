package PoissonDist;


import java.util.Random;

public class PoissonDist {
	private double probability;
	private int probabilityIntervalNum;
	private int intervalNum;
	private int trialNum;
	
	private int[] successNumArray;
	private int successNum;
	
	private double[] probabilityArray;
	
	public PoissonDist(double probability, int probabilityIntervalNum, int intervalNum, int trialNum) {
		this.probability = probability;
		this.probabilityIntervalNum = probabilityIntervalNum;
		this.intervalNum = intervalNum;
		this.trialNum = trialNum;
		successNumArray = new int[intervalNum+1];
	}
	public double[] run() {
		for(int i=0; i<trialNum; i++) {
			successNum = 0;
			for(int j=0; j<intervalNum; j++) {
				int random = new Random().nextInt(probabilityIntervalNum);
				if(random < (probability * probabilityIntervalNum)) {
					successNum++;
				}
			}
			successNumArray[successNum]++;
		}
		probabilityArray = new double[successNumArray.length];
		for(int i=0; i<successNumArray.length; i++) {
			probabilityArray[i] = successNumArray[i] / (double)trialNum;
		}
		return probabilityArray;
	}
	public double lamda() {
		double result = 0;
		for(int i=0; i<probabilityArray.length; i++) {
			result += i*probabilityArray[i];
		}
		return result;
	}
}
