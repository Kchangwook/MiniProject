package project.domain;

/** DB로부터 Free Table의 정보를 담을 클래스 */
public class Free {

	/* 변수 */
	private int freeNum;
	private String freeTitle;
	private String freeContent;
	private int freeNotice;
	private String memberMail;
	
	/* 생성자 */
	public Free() {}
	public Free(int freeNum, String freeTitle, String freeContent, int freeNotice, String memberMail) {
		super();
		this.freeNum = freeNum;
		this.freeTitle = freeTitle;
		this.freeContent = freeContent;
		this.freeNotice = freeNotice;
		this.memberMail = memberMail;
	}
	
	/* 접근자, 수정자 */
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
	public String getMemberMail() {
		return memberMail;
	}
	public void setMemberId(String memberMail) {
		this.memberMail = memberMail;
	}
	public int getFreeNotice() {
		return freeNotice;
	}
	public void setFreeNotice(int freeNotice) {
		this.freeNotice = freeNotice;
	}
	
	/* 함수 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Free [freeNum=");
		builder.append(freeNum);
		builder.append(", freeTitle=");
		builder.append(freeTitle);
		builder.append(", freeContent=");
		builder.append(freeContent);
		builder.append(", memberMail=");
		builder.append(memberMail);
		builder.append(", freeNotice=");
		builder.append(freeNotice);
		builder.append("]");
		return builder.toString();
	}
}//end of Free
