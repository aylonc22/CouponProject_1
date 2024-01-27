package exception;

import beans.ClientType;

public class ClientNotLoggedInException extends Exception{
    public ClientNotLoggedInException(ClientType client) {
        super(client + " is not logged in");
    }
}
