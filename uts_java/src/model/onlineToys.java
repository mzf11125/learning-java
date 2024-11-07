package model;

public class onlineToys extends toys{
	private int toysFileSize;
	private String downloadLink;
	
	public onlineToys(String code, String title, int toysFileSize, String downloadLink) {
		super(code, title);
		this.toysFileSize = toysFileSize;
		this.downloadLink = downloadLink;
	}
	public int getToysFileSize() {
		return toysFileSize;
	}
	public void setToysFileSize(int toysFileSize) {
		this.toysFileSize = toysFileSize;
	}
	public String getDownloadLink() {
		return downloadLink;
	}
	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}
}
