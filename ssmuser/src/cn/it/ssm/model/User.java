package cn.it.ssm.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
    private Integer id;
    private String userName;
    private String password;
    private String path;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	//private Date birthday;
    private Object birthday;
    private String sex;
    public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	//private String birthday;
	/*public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}*/
	
	public Integer getId() {
		return id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Object getBirthday() {
		return birthday;
	}
	public void setBirthday(Object birthday) {
		this.birthday = birthday;
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
    
}
