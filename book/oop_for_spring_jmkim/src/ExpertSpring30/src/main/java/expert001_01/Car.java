package expert001_01;

public class Car {
	Tire aTire;

	public Car() {
		aTire = new KoreaTire();
		// aTire = new AmericaTire();
	}

	public String getTireBrand() {
		return "������ Ÿ�̾�: " + aTire.getBrand();
	}
}
