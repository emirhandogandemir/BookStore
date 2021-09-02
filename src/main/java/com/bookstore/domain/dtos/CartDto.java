package com.bookstore.domain.dtos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bookstore.core.entities.User;
import com.bookstore.core.entities.dtos.UserRegisterDto;
import com.bookstore.domain.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
private int id;
private User user;
private Set<Book> books  = new HashSet<>();

}
