package com.tuhin47.graphql.example3final.customers.datafetcher;

import com.tuhin47.graphql.example3final.customers.data.Customer;
import com.tuhin47.graphql.example3final.customers.data.CustomerRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerByIdFetcher implements DataFetcher<Customer> {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        Long id = Long.parseLong(dataFetchingEnvironment.getArgument("id"));
        return customerRepository
                .findById(id)
                .orElse(null);
    }
}
