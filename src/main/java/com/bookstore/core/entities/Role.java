package com.bookstore.core.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	  @Column(name = "name",unique = true,nullable = false)
	    private String name;
	  
	  @Override
	    public String toString() {
	        return "Role{" +
	                "id='" + getId() + '\'' +
	                "name='" + name + '\'' +
	                '}';
	    }
	    @ManyToMany(mappedBy = "roles")
	    private Set<User> users = new HashSet<>();

	
}
