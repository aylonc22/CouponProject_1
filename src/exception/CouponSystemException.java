package exception;

public class CouponSystemException extends Throwable {
    public CouponSystemException(ErrorMsg msg) {
        super(msg.getMsg());
    }
}
