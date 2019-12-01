package user;



public class Owner extends User {

	private String role;

	public Owner(int id, String name, String email, String phone, String passwd, String role) {
		super(id, name, email, phone, passwd);
		this.role = role;
	}
	
	public Owner()
	{
		
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean check(Owner owner) {
		
		return false;
	}

	public void insertOwner(Owner owner) {
		
	}

	@Override
	public String toString() {
		
		return  String.format("%-10s\n", this.role);
	}
	
	
	

}
