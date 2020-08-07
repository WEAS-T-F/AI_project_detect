package aipd.vo;

public class DetectVO {

	String aipd_DTNUM;
	String aipd_DTDATE;
	String aipd_DTPLATENUM;
	String aipd_DTIMAGE;
	public String getAipd_DTNUM() {
		return aipd_DTNUM;
	}
	public void setAipd_DTNUM(String aipd_DTNUM) {
		this.aipd_DTNUM = aipd_DTNUM;
	}
	public String getAipd_DTDATE() {
		return aipd_DTDATE;
	}
	public void setAipd_DTDATE(String aipd_DTDATE) {
		this.aipd_DTDATE = aipd_DTDATE;
	}
	public String getAipd_DTPLATENUM() {
		return aipd_DTPLATENUM;
	}
	public void setAipd_DTPLATENUM(String aipd_DTPLATENUM) {
		this.aipd_DTPLATENUM = aipd_DTPLATENUM;
	}
	public String getAipd_DTIMAGE() {
		return aipd_DTIMAGE;
	}
	public void setAipd_DTIMAGE(String aipd_DTIMAGE) {
		this.aipd_DTIMAGE = aipd_DTIMAGE;
	}
	@Override
	public String toString() {
		return "DetectVO [aipd_DTNUM=" + aipd_DTNUM + ", aipd_DTDATE=" + aipd_DTDATE + ", aipd_DTPLATENUM="
				+ aipd_DTPLATENUM + ", aipd_DTIMAGE=" + aipd_DTIMAGE + "]";
	}
	public DetectVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetectVO(String aipd_DTNUM, String aipd_DTDATE, String aipd_DTPLATENUM, String aipd_DTIMAGE) {
		super();
		this.aipd_DTNUM = aipd_DTNUM;
		this.aipd_DTDATE = aipd_DTDATE;
		this.aipd_DTPLATENUM = aipd_DTPLATENUM;
		this.aipd_DTIMAGE = aipd_DTIMAGE;
	}
	
	

	
}
