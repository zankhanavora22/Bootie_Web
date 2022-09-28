package model;

public class Product {
	private int pid,sid;
	private String image,pname,pcategory;
	private double pprice;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcategory() {
		return pcategory;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", sid=" + sid + ", image=" + image + ", pname=" + pname + ", pcategory="
				+ pcategory + ", pprice=" + pprice + "]";
	}
	
}
