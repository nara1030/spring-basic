package expert001_01;

public class Car {
	Tire aTire;

	public Car() {
		aTire = new KoreaTire();
		// aTire = new AmericaTire();
	}

	public String getTireBrand() {
		return "장착된 타이어: " + aTire.getBrand();
	}
}
