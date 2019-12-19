package expert001_03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CarTest {
	@Test
	public void 자동차_코리아타이어_장착_타이어브랜드_테스트() {
		Tire aTire1 = new KoreaTire();
		Car aCar1 = new Car();
		aCar1.setTire(aTire1);
		
		assertEquals("장착된 타이어: 코리아 타이어", aCar1.getTireBrand());
	}
	
	@Test
	public void 자동차_미국타이어_장착_타이어브랜드_테스트() {
		Tire aTire2 = new AmericaTire();
		Car aCar2 = new Car();
		aCar2.setTire(aTire2);
		
		assertEquals("장착된 타이어: 미국 타이어", aCar2.getTireBrand());
	}
}
