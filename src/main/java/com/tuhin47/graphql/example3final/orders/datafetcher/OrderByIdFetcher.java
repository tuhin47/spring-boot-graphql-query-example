package com.tuhin47.graphql.example3final.orders.datafetcher;

import com.tuhin47.graphql.example3final.customers.data.Customer;
import com.tuhin47.graphql.example3final.orders.data.Order;
import com.tuhin47.graphql.example3final.orders.data.OrderRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderByIdFetcher implements DataFetcher<Order> {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        Long id = Long.parseLong(dataFetchingEnvironment.getArgument("id"));
        return orderRepository.findById(id).orElse(null);
    }


}
