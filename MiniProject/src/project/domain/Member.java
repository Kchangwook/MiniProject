package project.domain;

/** DB�� Member Table�� ������ �����ϱ� ���� Ŭ���� */
public class Member {

	/* ���� */
	private String memberID;
	private String memberPwd;
	private String memberName;
	private String memberMail;
	private String memberAddr;
	private String memberPhone;
	private int memberLevel;
	
	/* ������ */
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
	
	/* ������, ������ */
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
	
	/* �Լ� */
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
