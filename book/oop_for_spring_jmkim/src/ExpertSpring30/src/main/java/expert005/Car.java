package expert005;

import javax.annotation.Resource;

public class Car {
	@Resource
	Tire aTire;

	public String getTireBrand() {
		return "������ Ÿ�̾�: " + aTire.getBrand();
	}
}
