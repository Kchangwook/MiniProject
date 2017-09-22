package project.domain;

/** DB�� Free Table�� ������ �����ϱ� ���� Ŭ���� */
public class Free {

	/* ���� */
	private int freeNum;
	private String freeTitle;
	private String freeContent;
	private String memberId;
	private int freeNotice;
	
	/* ������ */
	public Free() {}
	public Free(int freeNum, String freeTitle, String freeContent, String memberId, int freeNotice) {
		super();
		this.freeNum = freeNum;
		this.freeTitle = freeTitle;
		this.freeContent = freeContent;
		this.memberId = memberId;
		this.freeNotice = freeNotice;
	}
	
	/* ������ ������ */
	public int getFreeNum() {
		return freeNum;
	}
	public void setFreeNum(int freeNum) {
		this.freeNum = freeNum;
	}
	public String getFreeTitle() {
		return freeTitle;
	}
	public void setFreeTitle(String freeTitle) {
		this.freeTitle = freeTitle;
	}
	public String getFreeContent() {
		return freeContent;
	}
	public void setFreeContent(String freeContent) {
		this.freeContent = freeContent;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getFreeNotice() {
		return freeNotice;
	}
	public void setFreeNotice(int freeNotice) {
		this.freeNotice = freeNotice;
	}
	
	/* �Լ� */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Free [freeNum=");
		builder.append(freeNum);
		builder.append(", freeTitle=");
		builder.append(freeTitle);
		builder.append(", freeContent=");
		builder.append(freeContent);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", freeNotice=");
		builder.append(freeNotice);
		builder.append("]");
		return builder.toString();
	}
	
}//end of Free
