package order.impl;

import order.api.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;


/**
 * This class represents the DAO layer. It holds reference on mocking data-storage object
 */
@Component
@Qualifier("OrderDAOImpl")
public class OrderDAOImpl implements OrderDAO {
    private HashMap<String, Orders> allOrders;


    public OrderDAOImpl() {
    }

    public HashMap<String, Orders> getOrders() {
        return allOrders;
    }

    @Autowired
    public void setOrders(HashMap<String, Orders> orders) {
        this.allOrders = orders;
    }

    @Override
    public boolean isCustomerExist(String customerName) {
        return allOrders.containsKey(customerName);
    }
    
    @Override
    public Orders putNewCustomer(String customerName) {
        allOrders.put(customerName, new Orders());
        return getCustomerOrders(customerName);
    }

    @Override
    public Orders getCustomerOrders(String customerName) {
        return allOrders.get(customerName);
    }

    @Override
    public void putNewOrder(String customerName, Order order) {
        Orders orders = allOrders.get(customerName);
        orders.addNewOrder(order);
    }
}
