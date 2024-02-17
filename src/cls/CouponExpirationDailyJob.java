package cls;

import database.dbdao.CouponDBDAO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CouponExpirationDailyJob implements  Runnable{
    //region Field Declaration
    private final CouponDBDAO couponDBDAO;
    private Boolean quit;
    // TIME = 24 HOURS || DAY
    private final  Integer TIME = 1000*60*60*24;
    //endregion

    public CouponExpirationDailyJob() {
        this.quit = false;
        couponDBDAO = new CouponDBDAO();

    }

    //region Override
    @Override
    public void run() {
        while(!this.quit){
                needToDeleteCoupons();
            try {
                Thread.sleep(TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //endregion
    //region Core Methods
    public void stop(){
        this.quit=true;
    }
    //CHECK IF COUPON IS EXPIRED AND DELETE IT AND ALL ITS PURCHASES
    private void needToDeleteCoupons(){
        couponDBDAO.deleteExpiredCoupons();
    }
    //endregion
}
