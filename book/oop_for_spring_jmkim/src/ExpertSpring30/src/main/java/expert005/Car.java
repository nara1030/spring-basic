package expert005;

import javax.annotation.Resource;

public class Car {
	@Resource
	Tire aTire;

	public String getTireBrand() {
		return "장착된 타이어: " + aTire.getBrand();
	}
}
