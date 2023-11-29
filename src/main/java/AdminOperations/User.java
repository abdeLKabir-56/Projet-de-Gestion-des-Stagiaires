package AdminOperations;

public class User {
	
	private String email;
	private String password;
	private String position;
	public User(String email, String password, String position) {
		super();
		this.email = email;
		this.password = password;
		this.position = position;
	}
	public User() {
		super();
	}
	protected String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	protected String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
	}
	protected String getPosition() {
		return position;
	}
	protected void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", position=" + position + "]";
	}
	
}
