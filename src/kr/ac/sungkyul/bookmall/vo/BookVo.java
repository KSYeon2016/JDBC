package kr.ac.sungkyul.bookmall.vo;

public class BookVo {
	private Long no;
	private String title;
	private Integer rate;
	private Long authorNo;
	private Integer status;
	// private AuthorVo author; 쓰지마러
	
	public Long getNo() {
		return no;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getRate() {
		return rate;
	}
	
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getAuthorNo() {
		return authorNo;
	}
	
	public void setAuthorNo(Long authorNo) {
		this.authorNo = authorNo;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", rate=" + rate + ", authorNo=" + authorNo + ", status="
				+ status + "]";
	}
}
