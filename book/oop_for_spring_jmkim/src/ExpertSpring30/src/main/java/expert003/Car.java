package expert003;

public class Car {
	Tire aTire;

	// �����ڰ� �������� tire �Ӽ��� ���� ������ �� ������ �޼��� ����
	public Tire getTire() {
		return aTire;
	}

	public void setTire(Tire aTire) {
		this.aTire = aTire;
	}

	public String getTireBrand() {
		return "������ Ÿ�̾�: " + aTire.getBrand();
	}
}
