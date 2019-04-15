package ca.sheridancollege.bean;

import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.CreditCardNumber;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student implements Serializable {
	
	@Id
	@Min(value = 3, message = "id must be at least 3")
	@Max(value = 10, message = "id is at most 10")
	private int id;
	
	@NotNull(message = "Name cannot be NULL")
	@Size(min = 5, max = 20, message = "Name must be of size between 5 & 20")
	private String name;
	
	// @Email is use to validate any email 
	// if you need a literal . then put \\  
	@Pattern(regexp = ".*@sheridancollege\\.ca", message="Not a Sheridan College email")
	private String email;
	
	// "\\d" compiles into a string single backslash (\d) will give error
	@Pattern(regexp = "[A-Z]\\d[A-Z].?\\d[A-Z]\\d", message="Invalid Postal Code")
	private String postal;
	
//	@CreditCardNumber
//	private String creditCardNumber;

}
