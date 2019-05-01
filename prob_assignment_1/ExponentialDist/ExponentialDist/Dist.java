package ExponentialDist;
//import java.util.Random;

public class Dist {
	public Point[] pointSet;
	public int domain;
	
	public Dist(int domain) {
		this.domain = domain;
		pointSet = new Point[domain];
		
		for(int i=0;i<pointSet.length;i++)
			pointSet[i] = new Point();
	}
	
	public double getMean() {
		double mean = 0;
		
		for(int i=0;i<pointSet.length;i++) {
			mean =  mean + (pointSet[i].value*pointSet[i].y);
		}
		
		return mean;
	}
	
	public double getFirstMoment() {
		double mean = 0;
		
		for(int i=0;i<pointSet.length;i++) {
			mean =  mean + pointSet[i].value*pointSet[i].y;
		}
		
		return mean;
	}
	
	public double getSecondMoment() {
		double average = 0;
		
		for(int i=0;i<pointSet.length;i++) {
			average = average + pointSet[i].value*pointSet[i].value*pointSet[i].y;
		}
		
		return average;
	}
	
	public double getVariance() {
		return getSecondMoment() - getFirstMoment() * getFirstMoment();
	}
	
	public void showData() {
		System.out.println("Show data : ");
		System.out.println("Domain : 0 <= x <= " + (domain-1));
		System.out.println("Mean : " + getMean());
		System.out.println("Variance : " + getVariance());	
	}
}
