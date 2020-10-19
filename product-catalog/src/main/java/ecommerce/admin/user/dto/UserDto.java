package ecommerce.admin.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String password;
	private String mobileNumber;
}
