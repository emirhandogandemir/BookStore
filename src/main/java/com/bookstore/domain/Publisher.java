package com.bookstore.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="publisher")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","books"})
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="email",unique=true)
	@Email
	@NotNull
	private String email;
	
	@Column(name="website")
	private String webSite;
	
	@OneToMany(mappedBy="publisher",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Book> books;
	
}
