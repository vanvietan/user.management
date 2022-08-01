package s3.vietan.user.management.entity;



import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
	
	private UUID id;
	
	private String name;
	
	private String username;
	
	private String password;
	
	private String retypePassword;
	
	private int phoneNumber;
	
	private String address;
	
	private int age;
}
