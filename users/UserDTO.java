package users;

import java.io.Serializable;

public class UserDTO implements Serializable {
private String userid;
private String password;
private String gender;
private String city;
private String streetAddress;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getStreetAddress() {
	return streetAddress;
}
public void setStreetAddress(String streetAddress) {
	this.streetAddress = streetAddress;
}
}
