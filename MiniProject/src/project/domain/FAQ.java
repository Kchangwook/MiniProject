package project.domain;

/** DB�� FAQ Table�� ������ �����ϱ� ���� Ŭ���� */
public class FAQ {

	/* ���� */
	private int faqNum;
	private String faqTitle;
	private String faqContent;
	
	/* ������ */
	public FAQ() {}
	public FAQ(int faqNum, String faqTitle, String faqContent) {
		super();
		this.faqNum = faqNum;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
	}
	
	/* ������, ������ */
	public int getFaqNum() {
		return faqNum;
	}
	public void setFaqNum(int faqNum) {
		this.faqNum = faqNum;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	
	/* �Լ� */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FAQ [faqNum=");
		builder.append(faqNum);
		builder.append(", faqTitle=");
		builder.append(faqTitle);
		builder.append(", faqContent=");
		builder.append(faqContent);
		builder.append("]");
		return builder.toString();
	}
	
}//end of FAQ
