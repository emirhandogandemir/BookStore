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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties( value = {"hibernateLazyInitializer", "handler","images"})
@Table(name = "books")

public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	@Size(min = 1, max = 150, message = "About Me must be between 1 and 150 characters")
	private String name;

	@Column(name = "summary")
	@Size(min = 20, max = 1000)
	private String summary;

	@Column(name = "price")
	@Min(5)
	@Max(500)
	private double price;

	@Column(name = "edition_number")
	private String editionNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher_id", nullable = false)
	private Publisher publisher;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	 
	@OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Image> images;


}
