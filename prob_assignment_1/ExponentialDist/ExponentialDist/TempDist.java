package ExponentialDist;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Random;

public class TempDist extends Dist{	
	public TempDist(int domain) {
		super(domain);
	}
	
	public void simulateTempDist() {
		for(int i=0;i<pointSet.length;i++) {
			pointSet[i].value = i+1;
			pointSet[i].x = i+1;
			pointSet[i].y = (double)1/domain;
			
			//System.out.println("(" + pointSet[i].x + ", " + pointSet[i].y + ")");
		}
	}
	
	public void simulateTempDist2() {
		for(int i=0;i<pointSet.length;i++) {
			Random rnd = new Random();
			
			pointSet[i].value = rnd.nextInt(50);
			pointSet[i].x = i+1;
			pointSet[i].y = (double)1/domain;
			
			//System.out.println("(" + pointSet[i].x + ", " + pointSet[i].y + ")");
		}
	}
}
