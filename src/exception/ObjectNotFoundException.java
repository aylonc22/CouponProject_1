package exception;
//Handling SQL Object not found
public class ObjectNotFoundException extends Exception{
    /**
     *
     * @param objectID
     * @param Object
     */
            public ObjectNotFoundException(int objectID,String Object) {
        super(Object + " with id: " + objectID + " is not exists!!");
    }

    /**
     *
     *  For Customers_vs_coupons table (where there are two tables connected)
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ObjectNotFoundException(String message) {
        super(message);
    }
}