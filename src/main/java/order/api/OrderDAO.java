package order.api;

import order.impl.Order;
import order.impl.Orders;


/**
 * Created by W on 19.06.2014.
 */
public interface OrderDAO {

    boolean isCustomerExist(String customerName);

    Orders putNewCustomer(String customerName);

    Orders getCustomerOrders(String customerName);

    void putNewOrder(String customerName, Order order);
}
