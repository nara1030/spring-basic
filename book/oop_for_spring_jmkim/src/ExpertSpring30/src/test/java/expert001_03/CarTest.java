package expert001_03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CarTest {
	@Test
	public void �ڵ���_�ڸ���Ÿ�̾�_����_Ÿ�̾�귣��_�׽�Ʈ() {
		Tire aTire1 = new KoreaTire();
		Car aCar1 = new Car();
		aCar1.setTire(aTire1);
		
		assertEquals("������ Ÿ�̾�: �ڸ��� Ÿ�̾�", aCar1.getTireBrand());
	}
	
	@Test
	public void �ڵ���_�̱�Ÿ�̾�_����_Ÿ�̾�귣��_�׽�Ʈ() {
		Tire aTire2 = new AmericaTire();
		Car aCar2 = new Car();
		aCar2.setTire(aTire2);
		
		assertEquals("������ Ÿ�̾�: �̱� Ÿ�̾�", aCar2.getTireBrand());
	}
}