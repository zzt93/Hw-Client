package po;


public class UserPO {
	int id;
	String name;
	String password;
	String role;
	
	public UserPO(int i ,String n,String p,String r){
		id = i;
		name = n;
		password = p;
		role = r;
	}

	
	public UserPO(int i){
		this(i,null,null,"STOCK");
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

	public String getRole() {
		return role;
	}
}
