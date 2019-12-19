package expert001_02;

public class Car {
	Tire aTire;

	// new가 사라지고 생성자에 인자가 추가
	public Car(Tire aTire) {
		this.aTire = aTire;
	}

	public String getTireBrand() {
		return "장착된 타이어: " + aTire.getBrand();
	}
}
