package cn.model;

public class BookStock {
        private int id;
        private String bookName;
        private String bookContent;
        private String publisher;
        private Object publishingDate;
        private Object addDate;
        private double bookPrice;
        private int bookNumber;
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
		public String getBookContent() {
			return bookContent;
		}
		public void setBookContent(String bookContent) {
			this.bookContent = bookContent;
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
		public Object getAddDate() {
			return addDate;
		}
		public void setAddDate(Object addDate) {
			this.addDate = addDate;
		}
		public double getBookPrice() {
			return bookPrice;
		}
		public void setBookPrice(double bookPrice) {
			this.bookPrice = bookPrice;
		}
		public int getBookNumber() {
			return bookNumber;
		}
		public void setBookNumber(int bookNumber) {
			this.bookNumber = bookNumber;
		}
        
}
