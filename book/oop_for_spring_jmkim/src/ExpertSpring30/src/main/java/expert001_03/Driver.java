package expert001_03;

public class Driver {
	public static void main(String[] args) {
		Tire aTire = new KoreaTire();
		Car aCar = new Car();
		aCar.setTire(aTire);

		System.out.println(aCar.getTireBrand());
	}
}
