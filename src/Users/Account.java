package Users;

import properties.StorageAccessProperties;

public  class Account {
	private int id;
	private String username;
	private String password;
	private String role;
	private StorageAccessProperties storage;
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
	public StorageAccessProperties getStorage() {
		return storage;
	}
	public void setStorage(StorageAccessProperties storage) {
		this.storage = storage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
