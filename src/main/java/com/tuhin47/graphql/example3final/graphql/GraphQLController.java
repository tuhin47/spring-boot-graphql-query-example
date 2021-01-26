package com.tuhin47.graphql.example3final.graphql;

import com.tuhin47.graphql.example3final.controllers.QueryModel;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest")
public class GraphQLController {

    @Autowired
    GraphQLManagerService graphQLManagerService;

    @PostMapping("/manager")
    public ResponseEntity<Object> getAllBooks(@RequestBody QueryModel query) {
        ExecutionResult execute = graphQLManagerService.getGraphQL().execute(query.getQuery());

        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
