package project.domain;

/** DB�� Station Table�� ������ �����ϱ� ���� Ŭ���� */
public class Station {

	/* ���� */
	private int stationNum;
	private String statingAddr;
	private String stationCsnm;
	private String stationCpnm;
	private int stationLat;
	private int stationLongi;
	
	/* ������ */
	public Station() {}
	public Station(int stationNum, String statingAddr, String stationCsnm, String stationCpnm, int stationLat,
			int stationLongi) {
		super();
		this.stationNum = stationNum;
		this.statingAddr = statingAddr;
		this.stationCsnm = stationCsnm;
		this.stationCpnm = stationCpnm;
		this.stationLat = stationLat;
		this.stationLongi = stationLongi;
	}
	
	/* ������ ������ */
	public int getStationNum() {
		return stationNum;
	}
	public void setStationNum(int stationNum) {
		this.stationNum = stationNum;
	}
	public String getStatingAddr() {
		return statingAddr;
	}
	public void setStatingAddr(String statingAddr) {
		this.statingAddr = statingAddr;
	}
	public String getStationCsnm() {
		return stationCsnm;
	}
	public void setStationCsnm(String stationCsnm) {
		this.stationCsnm = stationCsnm;
	}
	public String getStationCpnm() {
		return stationCpnm;
	}
	public void setStationCpnm(String stationCpnm) {
		this.stationCpnm = stationCpnm;
	}
	public int getStationLat() {
		return stationLat;
	}
	public void setStationLat(int stationLat) {
		this.stationLat = stationLat;
	}
	public int getStationLongi() {
		return stationLongi;
	}
	public void setStationLongi(int stationLongi) {
		this.stationLongi = stationLongi;
	}
	
	/* �Լ� */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Station [stationNum=");
		builder.append(stationNum);
		builder.append(", statingAddr=");
		builder.append(statingAddr);
		builder.append(", stationCsnm=");
		builder.append(stationCsnm);
		builder.append(", stationCpnm=");
		builder.append(stationCpnm);
		builder.append(", stationLat=");
		builder.append(stationLat);
		builder.append(", stationLongi=");
		builder.append(stationLongi);
		builder.append("]");
		return builder.toString();
	}
	
}//end of Station
