package com.web.controll;

import order.api.OrderManagement;
import order.impl.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by W on 19.06.2014.
 */
@Controller
public class OrderController {
    @Autowired
    @Qualifier("OrderManagementImpl")
    public OrderManagement management;

    @RequestMapping(value = "/order_page", method = RequestMethod.GET)
    public String openOrderPage(ModelMap model) {

        model.addAttribute("message", "Order page");

        //  Creating a Map of products. The key will be a variable name on JSP page, the value - a product name
        Map<String, String> products = new LinkedHashMap<String, String>();
        products.put("Good_product", "Good product");
        products.put("Wonderful_product", "Wonderful product");
        products.put("The_best_one", "The best one");
        products.put("Beautiful_product", "Beautiful product");

        // Adding the Map to a model for displaying variables on JSP
        model.addAllAttributes(products);

        return "order_page";
    }

    @RequestMapping(value = "/make_order", method = RequestMethod.POST)
    public String makeOrder(@ModelAttribute("order") Order order,
                            ModelMap model) {
        // Invoking Business logic method with reference to a bound Order object as argument
        Order customerOrder = management.makeOrder(order);
        if (customerOrder == null) {
            return "redirect:order_page";
        }
        //  Creating a map for representing order information on JSP page
        Map<String, String> orderInfo = new HashMap<String, String>();
        orderInfo.put("product_name", order.getProductName());
        orderInfo.put("order_id", String.valueOf(order.getOrderID()));
        orderInfo.put("customer_name", order.getCustomerName());

        model.addAllAttributes(orderInfo);
        model.addAttribute("message", "Order info");
        return "customer_order_info";
    }
}
