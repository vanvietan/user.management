package s3.vietan.user.management.entity;

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
public class UpdatedUserDTO {
	

	private String name;
	
	private String password;
	
	private int phoneNumber;
	
	private String address;
	
}
