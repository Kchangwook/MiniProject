package project.domain;

/** DB로부터 Member Table의 정보를 담을 클래스*/
public class Member {

	/* 변수 */
	private String memberMail;
	private String memberPwd;
	private String memberName;
	private String memberAddr;
	private String memberPhone;
	private int memberLevel;
	
	/* 생성자 */
	public Member() {}
	public Member(String memberMail, String memberName, String memberAddr, String memberPhone, int memberLevel) {
		super();
		this.memberMail = memberMail;
		this.memberName = memberName;
		this.memberAddr = memberAddr;
		this.memberPhone = memberPhone;
		this.memberLevel = memberLevel;
	}
	public Member(String memberMail, String memberPwd, String memberName, String memberAddr,
			String memberPhone, int memberLevel) {
		super();
		this.memberMail = memberMail;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberAddr = memberAddr;
		this.memberPhone = memberPhone;
		this.memberLevel = memberLevel;
	}
	
	/* 접근자, 수정자 */
	public String getMemberMail() {
		return memberMail;
	}
	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
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
		builder.append("Member [memberMail=");
		builder.append(memberMail);
		builder.append(", memberPwd=");
		builder.append(memberPwd);
		builder.append(", memberName=");
		builder.append(memberName);
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
