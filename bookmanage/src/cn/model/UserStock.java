package cn.model;

public class UserStock {
     private int usId;
     private int UId;
 	private String bookName;
    private Object buyDate;
    private int buyNumber;
    private double bookPrice;
     public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getUsId() {
		return usId;
	}
	public void setUsId(int usId) {
		this.usId = usId;
	}
	
	public int getUId() {
		return UId;
	}
	public void setUId(int uId) {
		this.UId = uId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Object getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Object buyDate) {
		this.buyDate = buyDate;
	}
	public int getBuyNumber() {
		return buyNumber;
	}
	public void setBuyNumber(int buyNumber) {
		this.buyNumber = buyNumber;
	}

}
