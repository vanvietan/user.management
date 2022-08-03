package s3.vietan.user.management.datasource;

public class DbQuery {
	
	/* User */
	public static final String findAll ="SELECT * FROM myuser";		
	public static final String findById ="SELECT id, name, username, password, phone_number, address, age FROM myuser WHERE id =?";
	public static final String findByUsername ="SELECT id, name, username, password, phone_number, address, age FROM myuser WHERE username =?";
	public static final String save ="INSERT INTO myuser (name, username, password, phone_number, address, age) VALUES(?, ?, ?, ?, ?, ?)";
	public static final String update = "UPDATE myuser SET name =?  ,username = ?, password =?, phone_number =?, address =?, age =? WHERE id=?";
	public static final String delete ="DELETE FROM myuser WHERE id =?";
}
