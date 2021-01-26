package com.tuhin47.graphql.example3final.graphql;

import com.tuhin47.graphql.example3final.customers.datafetcher.CustomerByIdFetcher;
import com.tuhin47.graphql.example3final.orders.datafetcher.OrderByIdFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class GraphQLManagerService {
    @Value("classpath:schema.graphqls")
    Resource resource;
    private GraphQL graphQL;

    @Autowired
    private CustomerByIdFetcher customerByIdFetcher;

    @Autowired
    private OrderByIdFetcher orderByIdFetcher;
    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("customerById", customerByIdFetcher)
                        .dataFetcher("orderById", orderByIdFetcher))
                .build();
    }


    public GraphQL getGraphQL() {
        return graphQL;
    }

    @PostConstruct
    private void loadSchema() throws IOException {

        //Load Books into the Book Repository
//        loadDataIntoHSQL();

        // get the schema
        File schemaFile = resource.getFile();
        // parse schema
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

}
