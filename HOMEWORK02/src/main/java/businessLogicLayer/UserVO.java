package businessLogicLayer;

//import java.util.Map;

/*
 * 1. Client Data를 Object Modeling
 * 2. Value Object (Value Object Pattern) : Data를 갖는 객체
 * */
public class UserVO {
   private String id;
   private String password;
   private String name;
   private String gender;
   private String birth;
   private String job;
   private String cellPhone;
   private String address;
   private boolean active;
   
   
   
   public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getBirth() {
	return birth;
}

public void setBirth(String birth) {
	this.birth = birth;
}

public String getJob() {
	return job;
}

public void setJob(String job) {
	this.job = job;
}

public String getCellPhone() {
	return cellPhone;
}

public void setCellPhone(String cellPhone) {
	this.cellPhone = cellPhone;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}

@Override
public String toString() {
	return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender + ", birth=" + birth
			+ ", job=" + job + ", cellPhone=" + cellPhone + ", address=" + address + ", active=" + active + "]";
}


/*
public void setAll(Map<String,String> map) {
	
	this.name=map.get(name);
	this.gender=map.get("gender");
	this.birth=map.get("birth");
	this.job=map.get("job");
	this.cellPhone=map.get("cellphone");
	this.address=map.get("address");
}

public String getAll() {
	return cellPhone;
}

	  
@Override
public String toString() {
	return "UserVO [name=" + name + ", gender=" + gender + ", birth=" + birth + ", job=" + job + ", cellPhone="
			+ cellPhone + ", address=" + address + ", active=" + active + "]";
}
*/




}