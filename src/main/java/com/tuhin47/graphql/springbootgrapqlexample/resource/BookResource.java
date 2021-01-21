package com.tuhin47.graphql.springbootgrapqlexample.resource;

import com.tuhin47.graphql.springbootgrapqlexample.dto.Query;
import com.tuhin47.graphql.springbootgrapqlexample.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest/books")
@RestController
public class BookResource {

    @Autowired
    GraphQLService graphQLService;

    @PostMapping
    public ResponseEntity<Object> getAllBooks(@RequestBody Query query) {
        ExecutionResult execute = graphQLService.getGraphQL().execute(query.getQuery());

        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
