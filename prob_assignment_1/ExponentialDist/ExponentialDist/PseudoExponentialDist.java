package ExponentialDist;
import java.util.Random;

public class PseudoExponentialDist extends Dist{
	public static final int REAPEAT = 10000;
	public int lambda;
	public double prob;
	public int[] recordEachInterval;
	
	public PseudoExponentialDist(int domain, int lambda) {
		super(domain);
		this.lambda = lambda;
		this.prob = lambda / domain;
		recordEachInterval = new int[domain];
		
		//init. recordEachInterval array with 0
		for(int i = 0; i < recordEachInterval.length; i++) {
			this.recordEachInterval[i] = 0;
		}
	}
	
	public void simulatePseudoExponentialDist() {
		 
		int i = 0, j = 0;
		int firstSuccess;
		int secondSuccess;
		
		for(i=0;i<REAPEAT;i++) {
			//if a random number between 0 and domain - 1 is smaller than lambda -> success!
			Random rnd = new Random();
			firstSuccess = -1;
			secondSuccess = 0;
			
			for(j=0;j<domain;j++) {
				
				int isThisSuccess = rnd.nextInt(domain);
				
				if(isThisSuccess < lambda && firstSuccess == -1) {
					firstSuccess = j;
				}	
				else if (isThisSuccess < lambda && firstSuccess != -1) {
					secondSuccess = j;
					System.out.println(firstSuccess + "  " + secondSuccess);
					++recordEachInterval[secondSuccess - firstSuccess];
					break;
				}
			}	
		}
		
		double m=0;
		double p=0;
		for(i = 0; i < pointSet.length; ++i) {
			pointSet[i].x = i;
			pointSet[i].value = (double)i / domain;
			pointSet[i].y = (double)(recordEachInterval[i]) / REAPEAT;
			
			if(pointSet[i].y != 0) {
				m = m + (this.pointSet[i].value*this.pointSet[i].y);	
				p += pointSet[i].y;
			}
		}			
	}
}
