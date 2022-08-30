package crud.model;

//import java.time.LocalDateTime;

public class crudModel {
	private String username;
	private int number;
	// LocalDateTime datetime;

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
//	public LocalDateTime getDatetime() {
//		return datetime;
//	}
//	public void setDatetime(LocalDateTime datetime) {
//		this.datetime = datetime;
//	}

	public crudModel() {
		super();
	}

	public crudModel(String username, int number) {
		super();
		this.username = username;
		this.number = number;
	}

}
