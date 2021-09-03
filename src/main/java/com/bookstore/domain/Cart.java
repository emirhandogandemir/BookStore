package com.bookstore.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bookstore.core.entities.Role;
import com.bookstore.core.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne()
	@JoinColumn(name="user_id",nullable = false)
	private User user;
	
	
	 @ManyToMany(fetch =FetchType.EAGER)
	    @JoinTable(
	            name = "cart_books",
	            joinColumns = @JoinColumn(
	            name = "cart_id",referencedColumnName = "id"
	    ),
	            inverseJoinColumns = @JoinColumn(
	                    name = "book_id",referencedColumnName = "id"
	            )
	    )
	 
	    private Set<Book> books  = new HashSet<Book>();
}
