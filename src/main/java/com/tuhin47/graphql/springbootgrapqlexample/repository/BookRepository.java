package com.tuhin47.graphql.springbootgrapqlexample.repository;

import com.tuhin47.graphql.springbootgrapqlexample.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
