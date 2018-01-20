package cn.model;

public class ShoppingCart {
       private int scId;
       private int UId;
      
       private double price;
       private int number;
       private String bookName;
       private Object addDate;
       private String publisher;
       private Object publishingDate;
       private Double sumMoney;
	public Double getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(Double sumMoney) {
		this.sumMoney = sumMoney;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Object getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(Object publishingDate) {
		this.publishingDate = publishingDate;
	}
	public int getScId() {
		return scId;
	}
	public void setScId(int scId) {
		this.scId = scId;
	}
	public int getUId() {
		return UId;
	}
	public void setUId(int uId) {
		UId = uId;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Object getAddDate() {
		return addDate;
	}
	public void setAddDate(Object addDate) {
		this.addDate = addDate;
	}
       
}
