package exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

// exception for handling failed update or insert query by a duplicate unique  key
public class SQLDuplicateUniqueKeyException extends Exception{
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param table the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public SQLDuplicateUniqueKeyException(tables table) {
        super(table.getAction());
    }
   @AllArgsConstructor
   @Getter
    public enum tables{
        COUPON("Coupon has same title as another coupon of the same company"),
        CUSTOMER("Customer has same email as another customer"),
        COMPANY("Company has same name or email as another company");
        private final String action;
        }
}
