package expert001_01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CarTest {
	@Test
	public void �ڵ���_����_Ÿ�̾�귣��_�׽�Ʈ() {
		Car aCar = new Car();
		assertEquals("������ Ÿ�̾�: �ڸ��� Ÿ�̾�", aCar.getTireBrand());
	}
}
