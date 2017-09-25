package project.domain;

/** DB�� Station Table�� ������ �����ϱ� ���� Ŭ���� */
public class Station {
	/* 변수 */
	private int stationNum;
	private String statingAddr;
	private String stationCsnm;
	private String stationCpnm;
	private double stationLat;
	private double stationLongi;
	private int stationCsid;
	private int stationCptp;
	private int stationCpstat;
	private String stationStatUpdate;
	
	/* 생성자 */
	public Station() {}
	public Station(int stationNum, String statingAddr, String stationCsnm, String stationCpnm, double stationLat,
			double stationLongi, int stationCsid, int stationCptp, int stationCpstat, String stationStatUpdate) {
		super();
		this.stationNum = stationNum;
		this.statingAddr = statingAddr;
		this.stationCsnm = stationCsnm;
		this.stationCpnm = stationCpnm;
		this.stationLat = stationLat;
		this.stationLongi = stationLongi;
		this.stationCsid = stationCsid;
		this.stationCptp = stationCptp;
		this.stationCpstat = stationCpstat;
		this.stationStatUpdate = stationStatUpdate;
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
	public double getStationLat() {
		return stationLat;
	}
	public void setStationLat(double stationLat) {
		this.stationLat = stationLat;
	}
	public double getStationLongi() {
		return stationLongi;
	}
	public void setStationLongi(double stationLongi) {
		this.stationLongi = stationLongi;
	}
	public int getStationCsid() {
		return stationCsid;
	}
	public void setStationCsid(int stationCsid) {
		this.stationCsid = stationCsid;
	}
	public int getStationCptp() {
		return stationCptp;
	}
	public void setStationCptp(int stationCptp) {
		this.stationCptp = stationCptp;
	}
	public int getStationCpstat() {
		return stationCpstat;
	}
	public void setStationCpstat(int stationCpstat) {
		this.stationCpstat = stationCpstat;
	}
	public String getStationStatUpdate() {
		return stationStatUpdate;
	}
	public void setStationStatUpdate(String stationStatUpdate) {
		this.stationStatUpdate = stationStatUpdate;
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
		builder.append(", stationCsid=");
		builder.append(stationCsid);
		builder.append(", stationCptp=");
		builder.append(stationCptp);
		builder.append(", stationCpstat=");
		builder.append(stationCpstat);
		builder.append(", stationStatUpdate=");
		builder.append(stationStatUpdate);
		builder.append("]");
		return builder.toString();
	}
}//end of Station
