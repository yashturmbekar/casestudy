package user;
public class User {
	private int id;
	private String name, email, phone, passwd;
	
	
	public User(int id, String name, String email, String phone, String passwd) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.passwd = passwd;
	}
	
   public User()
    {
    	
    }

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getPasswd() {
	return passwd;
}

public void setPasswd(String passwd) {
	this.passwd = passwd;
}

@Override
public String toString() {
	return String.format("%-5d%-20s%-21s%-22s\n", this.id, this.name, this.email, this.passwd);
}
   
   

}
