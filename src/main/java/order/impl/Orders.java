package order.impl;


import java.util.LinkedList;

/**
 * This class represents a mocking storage for customer's orders
 */

public class Orders {
    private LinkedList<Order> customerOrders = new LinkedList<Order>();

    public Orders() {
    }

    public LinkedList<Order> getListOfOrders() {
        return customerOrders;
    }

    public void addNewOrder(Order order) {
        customerOrders.add(order);
    }
}
