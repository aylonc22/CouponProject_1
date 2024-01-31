package exception;

import beans.ClientType;
// exception for handling failed usage of facade when not logged in
public class ClientNotLoggedInException extends Exception{
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ClientNotLoggedInException(ClientType client) {
        super(client + " is not logged in");
    }
}
