package order.impl;


/**
 * This class represents the Order entity which is bound in JSP page using Spring form tag
 */

public class Order {
    private String customerName;
    private String productName;
    private int orderID;

    public Order() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(int productID) {
        this.orderID = productID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderID != order.orderID) return false;
        if (customerName != null ? !customerName.equals(order.customerName) : order.customerName != null) return false;
        if (productName != null ? !productName.equals(order.productName) : order.productName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerName != null ? customerName.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + orderID;
        return result;
    }
}
