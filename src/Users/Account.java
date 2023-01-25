package Users;

public  class Account {
	private String username;
	private String password;
	private String role;
	private static Account instance = null;
	
	private Account() {
		
	}
	public static Account getInstance() {
		if(instance == null) {
			instance = new Account();
		}
		return instance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public static void resetInstance() {
		instance = null;
	}

}
