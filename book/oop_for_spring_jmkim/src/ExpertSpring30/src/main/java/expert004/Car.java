package expert004;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
	@Autowired
	Tire aTire;

	public String getTireBrand() {
		return "장착된 타이어: " + aTire.getBrand();
	}
}
