package cn.model;

public class User {
         private int id;
         private String userName;
         private String password;
         private double money;
         private int isLeader;
		public int getIsLeader() {
			return isLeader;
		}
		public void setIsLeader(int isLeader) {
			this.isLeader = isLeader;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public double getMoney() {
			return money;
		}
		public void setMoney(double money) {
			this.money = money;
		}
	
}
