
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PseudoExponentialDist ped = new PseudoExponentialDist(100000, 30);
		
		ped.simulatePseudoExponentialDist();
		ped.showData();
	}

}
