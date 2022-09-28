package model;

public class wishlist {
	private int wid,cusid,pid;

	
	public int getWid() {
		return wid;
	}


	public void setWid(int wid) {
		this.wid = wid;
	}


	public int getCusid() {
		return cusid;
	}


	public void setCusid(int cusid) {
		this.cusid = cusid;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	@Override
	public String toString() {
		return "WishList [wid=" + wid + ", cusid=" + cusid + ", pid=" + pid + "]";
	}
	
	
}
