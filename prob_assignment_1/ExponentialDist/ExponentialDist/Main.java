package ExponentialDist;

public class Main {

	public static void main(String[] args) {

		PseudoErlangK2Dist ped = new PseudoErlangK2Dist(100000, 20);
		
		ped.simulatePseudoErlangK2Dist();
		ped.showData();
	}

}
