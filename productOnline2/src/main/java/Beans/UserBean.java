package Beans;
import java.io.*;
@SuppressWarnings("serial")
public class UserBean implements Serializable
{
//	 USERNAME                                  NOT NULL VARCHAR2(20)
//	 PASSWORD                                           VARCHAR2(20)
//	 FNAME                                              VARCHAR2(20)
//	 LNAME                                              VARCHAR2(20)
//	 GMAIL                                              VARCHAR2(45)
//	 PHNO                                               NUMBER(15)
private String userName;
private String passWord;
private String firstName;
private String lastName;
private String  email;
private Long mobile;
public UserBean() 
{
	
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassWord() {
	return passWord;
}
public void setPassWord(String passWord) {
	this.passWord = passWord;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getMobile() {
	return mobile;
}
public void setMobile(Long mobile) {
	this.mobile = mobile;
}


}
