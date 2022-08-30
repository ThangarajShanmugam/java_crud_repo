package crud.model;

public class crudModel  {
	private String username ;
	private int number ;
	private String userId;
	private String email;
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "crudModel [username=" + username + ", number=" + number + ", userId=" + userId + ", email=" + email
				+ "]";
	}


	public String getUsername() {
		return username;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public int getNumber() {
		return number;
	}
	
	
	public void setNumber(int number) {
		this.number = number;
	}

//	public crudModel() {
//		super();
//	}
//
//	public crudModel(String username, int number) {
//		super();
//		this.username = username;
//		this.number = number;
//	}

}
