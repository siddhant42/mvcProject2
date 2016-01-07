package com.data;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
@PropertySource("classpath:/com/resources/ValidationMessages.properties")
public class Spitter {
	private Long id;
	@NotNull
	@Size(min=5, max=16, message="${username.size}")
	private String username;
	@NotNull
	@Size(min=5, max=25, message="${password.size}")
	private String password;
	@NotNull
	@Size(min=2, max=30 , message="${username.size}")
	private String firstName;
	@NotNull
	@Size(min=2, max=30, message="${lastName.size}")
	private String lastName;
	
	public Spitter() {
		super();
	}
	
	public Spitter(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Spitter(Long id, String username, String password, String firstName, String lastName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "username","password","firstName","lastName");
	}
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "username","password","firstName","lastName");
	}
/*public static void main(String[] args) {
	Spitter s = new Spitter("s","s","s","");
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    validator.validate(s);
	System.out.println(s.getFirstName()+" "+s.getLastName()+" "+s.getUsername());
}*/
}
