package com.tuhin47.graphql.example3final.orders;


import com.tuhin47.graphql.example3final.orders.data.Order;
import com.tuhin47.graphql.example3final.orders.data.OrderRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private OrderRepository orderRepository;


    public Order createOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    /*private Order orderToGraphQL(Order orderModel) {
        Order order = new Order();
        order.setId(orderModel.getId());
        order.setStatus(orderModel.getStatus());
        order.setQuantity(orderModel.getQuantity());
        order.setCreated(orderModel.getCreated());

        Product product = new Product();
        product.setId(orderModel.getProductId());
        order.setProduct(product);

        Customer customer = new Customer();
        customer.setId(orderModel.getCustomerId());
        order.setCustomer(customer);

        return order;
    }*/

}