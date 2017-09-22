package project.domain;

/** DB의 Member Table의 정보를 저장하기 위한 클래스 */
public class Member {

	/* 변수 */
	private String memberID;
	private String memberPwd;
	private String memberName;
	private String memberMail;
	private String memberAddr;
	private String memberPhone;
	private int memberLevel;
	
	/* 생성자 */
	public Member() {}
	public Member(String memberID, String memberPwd, String memberName, String memberMail, String memberAddr,
			String memberPhone, int memberLevel) {
		super();
		this.memberID = memberID;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberMail = memberMail;
		this.memberAddr = memberAddr;
		this.memberPhone = memberPhone;
		this.memberLevel = memberLevel;
	}
	
	/* 접근자, 수정자 */
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberMail() {
		return memberMail;
	}
	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public int getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}
	
	/* 함수 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [memberID=");
		builder.append(memberID);
		builder.append(", memberPwd=");
		builder.append(memberPwd);
		builder.append(", memberName=");
		builder.append(memberName);
		builder.append(", memberMail=");
		builder.append(memberMail);
		builder.append(", memberAddr=");
		builder.append(memberAddr);
		builder.append(", memberPhone=");
		builder.append(memberPhone);
		builder.append(", memberLevel=");
		builder.append(memberLevel);
		builder.append("]");
		return builder.toString();
	}
	
}//end of Member
