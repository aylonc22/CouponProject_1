package exception;

public class ClientNotLoggedInException extends Exception{
    public ClientNotLoggedInException(String message) {
        super(message);
    }
}
