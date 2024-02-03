package exception;

public class OutOfStockException extends Exception{
    public OutOfStockException(int couponID) {
        super("Coupon id: " + couponID + " is out of stock and cannot be purchase!!");
    }
}
