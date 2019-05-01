package ExponentialDist;

public class Main {

	public static void main(String[] args) {

		PseudoExponentialDist ped = new PseudoExponentialDist(100000, 30);
		
		ped.simulatePseudoExponentialDist();
		ped.showData();
	}

}
