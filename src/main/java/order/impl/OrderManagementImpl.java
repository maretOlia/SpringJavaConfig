package order.impl;

import order.api.OrderDAO;
import order.api.OrderManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * This class represents the Business layer. It stores the 'orderDAO' reference which holds the DAO object
 */
@Component
@Qualifier("OrderManagementImpl")
public class OrderManagementImpl implements OrderManagement {
    private OrderDAO orderDAO;

    public OrderManagementImpl() {
    }

    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public Order makeOrder(Order order) {
        // Validating the input
        if (Validator.isOrderCorrect(order) == true) {
            String customerName = order.getCustomerName();

            // Checking whether customer already exists in db
            boolean customerExist = orderDAO.isCustomerExist(customerName);

            if (!customerExist) {
                // Adding new customer
                orderDAO.putNewCustomer(customerName);
                // Saving id for customer order
                order.setOrderID(1);
            } else {
                // Retrieving customer's orders
                Orders customerOrders = orderDAO.getCustomerOrders(customerName);
                Order lastOrder = customerOrders.getListOfOrders().getLast();
                int lastId = lastOrder.getOrderID();
                // Defining and saving id for customer order
                order.setOrderID(++lastId);
            }
            // Putting new order in db
            orderDAO.putNewOrder(customerName, order);
            return order;
        }
        return null;
    }
}