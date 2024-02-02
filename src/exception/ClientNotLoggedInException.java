package exception;

import beans.ClientType;
// exception for handling failed usage of facade when not logged in
public class ClientNotLoggedInException extends Exception{
    public ClientNotLoggedInException(ClientType client) {
        super(client + " is not logged in");
    }
}
