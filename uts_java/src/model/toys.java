package model;

public class toys {
	
	private String code;
	private String title;
	
	public toys(String code, String title) {
		super();
		this.code = code;
		this.title = title;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
