package Group1.Groupcsv;

public class Patients 
{
String pid;
String name;
String address;
String date;
public Patients(String pid,String name, String address, String date) {
	super();
	this.pid = pid;
    this.name=name;
	this.address = address;
	this.date = date;
}
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

}
