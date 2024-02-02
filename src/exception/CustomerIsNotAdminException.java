package exception;

// exception for handling false admin login attempt
public class CustomerIsNotAdminException extends  Exception{
    public CustomerIsNotAdminException(String message) {
        super(message);
    }
}
