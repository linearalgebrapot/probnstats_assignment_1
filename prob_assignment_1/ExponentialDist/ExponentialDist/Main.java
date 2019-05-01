package ExponentialDist;

public class Main {

	public static void main(String[] args) {

		PseudoExponentialDist ped = new PseudoExponentialDist(100000, 10);
		
		ped.simulatePseudoExponentialDist();
		ped.showData();
	}

}
