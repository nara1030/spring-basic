package expert003;

public class Car {
	Tire aTire;

	// 생성자가 없어지고 tire 속성에 대한 접근자 및 설정자 메서드 생성
	public Tire getTire() {
		return aTire;
	}

	public void setTire(Tire aTire) {
		this.aTire = aTire;
	}

	public String getTireBrand() {
		return "장착된 타이어: " + aTire.getBrand();
	}
}
