package expert001_02;

public class Car {
	Tire aTire;

	// new�� ������� �����ڿ� ���ڰ� �߰�
	public Car(Tire aTire) {
		this.aTire = aTire;
	}

	public String getTireBrand() {
		return "������ Ÿ�̾�: " + aTire.getBrand();
	}
}
