package order.api;

import order.impl.Order;

/**
 * Created by W on 19.06.2014.
 */
public interface OrderManagement {


    Order makeOrder(Order order);
}
