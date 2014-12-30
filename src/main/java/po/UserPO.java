package po;


import java.io.Serializable;

public class UserPO implements Serializable {
	int id;
	String name;
	String password;
	String role;
	private static final long serialVersionUID = 1L;
	
	public UserPO(int i ,String n,String p,String r){
		id = i;
		name = n;
		password = p;
		role = r;
	}
	public UserPO(UserPO po){
		id = po.getId();
		name = po.getName();
		password = po.password;
		role = po.role;
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
