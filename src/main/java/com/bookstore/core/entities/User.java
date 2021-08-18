package com.bookstore.core.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
@Entity
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email",unique = true)
	@Email
	@NotBlank
	@NotNull
	private String email;
	
	@NotBlank
	@Size(max = 20)
	@Column(name="username",unique = true)
	private String username;

	@Column(name = "password")
	@NotBlank
	@NotNull
	@Size(min = 6, max = 20, message = "About Me must be between 6 and 20 characters")
	private String password;
	
	@Column(name = "created_at")
	@JsonIgnore
	@LastModifiedDate
	private LocalDate createdAt=LocalDate.now() ;
	
	 @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	            name = "user_roles",
	            joinColumns = @JoinColumn(
	            name = "user_id",referencedColumnName = "id"
	    ),
	            inverseJoinColumns = @JoinColumn(
	                    name = "role_id",referencedColumnName = "id"
	            )
	    )
	 
	    private Set<Role> roles  = new HashSet<>();

	    @Override
	    public String toString() {
	        return "User{" +
	                "id='" + getId() + '\'' +
	                "username='" + username + '\'' +
	                ", email='" + email + '\'' +
	                ", password='" + password + '\'' +
	                '}';
	    }
	
}
