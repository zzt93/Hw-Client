package po;

enum UserRole{STOCK,IMPANDEXP,ACCOUNT,MANAGER}
public class UserPO {
	int id;
	String name;
	String password;
	UserRole role;
	
	public UserPO(int i ,String n,String p,UserRole r){
		id = i;
		name = n;
		password = p;
		role = r;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public UserRole getRole() {
		return role;
	}
}
