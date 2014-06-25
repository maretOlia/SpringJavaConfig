package order.impl;

/**
 * This class validates the input on empty fields
 */
public class Validator {

    public static boolean isOrderCorrect(Order order) {
        if ((order.getCustomerName() == null) || (order.getCustomerName() == "") || (order.getProductName() == null) || (order.getProductName() == "")) {
            return false;
        }
        return true;
    }


}
