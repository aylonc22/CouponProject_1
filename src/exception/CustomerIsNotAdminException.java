package exception;

public class CustomerIsNotAdminException extends  Exception{
   // exception for handling false admin login attempt
    public CustomerIsNotAdminException(String message) {
        super(message);
    }
}
