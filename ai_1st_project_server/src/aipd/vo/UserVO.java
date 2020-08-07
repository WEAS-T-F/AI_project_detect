package aipd.vo;

public class UserVO {

	String aipd_IDNUM;
	String aipd_ID;
	String aipd_PASSWD;
	String aipd_TYPE;

	
	public UserVO() {
		super();
	}


	public UserVO(String aipd_IDNUM, String aipd_ID, String aipd_PASSWD, String aipd_TYPE) {
		super();
		this.aipd_IDNUM = aipd_IDNUM;
		this.aipd_ID = aipd_ID;
		this.aipd_PASSWD = aipd_PASSWD;
		this.aipd_TYPE = aipd_TYPE;
	}


	public String getAipd_IDNUM() {
		return aipd_IDNUM;
	}


	public void setAipd_IDNUM(String aipd_IDNUM) {
		this.aipd_IDNUM = aipd_IDNUM;
	}


	public String getAipd_ID() {
		return aipd_ID;
	}


	public void setAipd_ID(String aipd_ID) {
		this.aipd_ID = aipd_ID;
	}


	public String getAipd_PASSWD() {
		return aipd_PASSWD;
	}


	public void setAipd_PASSWD(String aipd_PASSWD) {
		this.aipd_PASSWD = aipd_PASSWD;
	}


	public String getAipd_TYPE() {
		return aipd_TYPE;
	}


	public void setAipd_TYPE(String aipd_TYPE) {
		this.aipd_TYPE = aipd_TYPE;
	}


	@Override
	public String toString() {
		return "UserVO [aipd_IDNUM=" + aipd_IDNUM + ", aipd_ID=" + aipd_ID + ", aipd_PASSWD=" + aipd_PASSWD
				+ ", aipd_TYPE=" + aipd_TYPE + "]";
	}

	
	
	
}
