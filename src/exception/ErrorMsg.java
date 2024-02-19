package exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMsg {
    ADMIN_NOT_LOGGED_IN("Admin is not logged in!"),
    CLIENT_NOT_LOGGED_IN("Client is not logged in!"),
    CLIENT_NOT_ADMIN("Client is not registered as administrator!"),
    COMPANY_NOT_LOGGED_IN("Company is not logged in!"),
    COMPANY_NOT_FOUND("Company not found!"),
    Customer_NOT_FOUND("Customer not found!"),
    COUPON_NOT_FOUND("Coupon not found!"),
    OUT_OF_STOCK("Coupon is out of stock!"),
    SQL_DUPLICATE("Unique key exception!");
    private final String msg;
}
