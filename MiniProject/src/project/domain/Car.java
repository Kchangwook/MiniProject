package project.domain;

/** DB�κ��� Car Table�� ������ ���� Ŭ���� */
public class Car {

	/* ���� */
	private int carNum;
	private String carName;
	private int carPrice;
	private String carSize;
	private int carMaxDistance;
	private String carEfficiency;
	private String carImgSrc;
	
	/* ������ */ 
	public Car() {}
	public Car(int carNum, String carName,int carPrice, String carSize, int carMaxDistance, String carEfficiency, String carImgSrc) {
		super();
		this.carNum = carNum;
		this.carName = carName;
		this.carPrice = carPrice;
		this.carSize = carSize;
		this.carMaxDistance = carMaxDistance;
		this.carEfficiency = carEfficiency;
		this.carImgSrc = carImgSrc;
	}
	
	/* ������, ������ */
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	public String getCarSize() {
		return carSize;
	}
	public void setCarSize(String carSize) {
		this.carSize = carSize;
	}
	public int getCarMaxDistance() {
		return carMaxDistance;
	}
	public void setCarMaxDistance(int carMaxDistance) {
		this.carMaxDistance = carMaxDistance;
	}
	public String getCarEfficiency() {
		return carEfficiency;
	}
	public void setCarEfficiency(String carEfficiency) {
		this.carEfficiency = carEfficiency;
	}
	public String getCarImgSrc() {
		return carImgSrc;
	}
	public void setCarImgSrc(String carImgSrc) {
		this.carImgSrc = carImgSrc;
	}
	public String getCarName() {
		return this.carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	/* �Լ� */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [carNum=");
		builder.append(carNum);
		builder.append(", carPrice=");
		builder.append(carPrice);
		builder.append(", carSize=");
		builder.append(carSize);
		builder.append(", carMaxDistance=");
		builder.append(carMaxDistance);
		builder.append(", carEfficiency=");
		builder.append(carEfficiency);
		builder.append(", carImgSrc=");
		builder.append(carImgSrc);
		builder.append(", carName=");
		builder.append(carName);
		builder.append("]");
		return builder.toString();
	}
	
}//end of Car
