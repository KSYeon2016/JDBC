package kr.ac.sungkyul.bookmall.vo;

public class OrdersVo {
	private Long no;
	private Long memberNo;
	private String memberName;
	private String memberEmail;
	private Integer cost;
	private String address;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "OrdersVo [no=" + no + ", memberName=" + memberName + ", memberEmail=" + memberEmail + ", cost=" + cost
				+ ", address=" + address + "]";
	}
}
