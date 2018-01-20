package cn.model;

public  class BookCount {
           private int id;
           private int uid;
           private  String bookName;
           private   int sellNumber;
           private double sellPrice;
           private Object sellDate;
           public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public int getSellNumber() {
			return sellNumber;
		}
		public void setSellNumber(int sellNumber) {
			this.sellNumber = sellNumber;
		}
		public double getSellPrice() {
			return sellPrice;
		}
		public void setSellPrice(double sellPrice) {
			this.sellPrice = sellPrice;
		}
		public Object getSellDate() {
			return sellDate;
		}
		public void setSellDate(Object sellDate) {
			this.sellDate = sellDate;
		}
}
