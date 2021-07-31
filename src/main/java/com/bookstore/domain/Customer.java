package com.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bookstore.core.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@PrimaryKeyJoinColumn(name = "user_id")
@Entity
@Table(name="customers")
public class Customer extends User{

	
	@Column(name = "first_name")
	@NotNull(message = "firstname cannot be null")
	@NotBlank
	@Size(min = 3, max = 30, message = "About Me must be between 3 and 30 characters")
	private String firstName;

	@Column(name = "last_name")
	@NotNull(message = "lastName cannot be null")
	@NotBlank
	@Size(min = 3, max = 30, message = "About Me must be between 3 and 30 characters")
	private String lastName;
	
	@Column(name= "phone_number")
	@NotNull(message="phoneNumber cannot be null")
	@NotBlank
	private String phoneNumber;
}
