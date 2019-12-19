package expert001_02;

public class Driver {
	public static void main(String[] args) {
		Tire aTire = new KoreaTire();
		// Tire aTire = new AmericaTire();
		Car aCar = new Car(aTire);
		
		System.out.println(aCar.getTireBrand());
	}
}
