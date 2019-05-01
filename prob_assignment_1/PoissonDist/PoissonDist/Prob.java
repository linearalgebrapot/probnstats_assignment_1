package PoissonDist;
public class Prob {

	public static void main(String[] args) {
		PoissonDist poissonDist = new PoissonDist(0.05, 1000, 100, 1000000);
		double[] poissonDistArray = poissonDist.run();
		for(int i=0; i<poissonDistArray.length; i++) {
			System.out.println(i + " " + poissonDistArray[i]);
		}
		System.out.println();
		System.out.println("lamda: " + poissonDist.lamda());
	}

}
