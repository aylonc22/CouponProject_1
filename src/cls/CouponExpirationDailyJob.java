package cls;

import database.dbdao.CouponDBDAO;

public class CouponExpirationDailyJob implements  Runnable{
    //region Field Declaration
    private final CouponDBDAO couponDBDAO;
    private Boolean quit;
    // TIME = 24 HOURS || DAY
    private final  Integer TIME = 1000*60*60*24;
    //endregion

    public CouponExpirationDailyJob() {
        setQuit(false);
        couponDBDAO = new CouponDBDAO();
    }

    //region Getters && Setters
    public Boolean getQuit() {
        return quit;
    }

    public void setQuit(Boolean quit) {
        this.quit = quit;
    }
    //endregion

    //region Override
    @Override
    public void run() {
        while(!quit){
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
        setQuit(true);
    }
    //CHECK IF COUPON IS EXPIRED AND DELETE IT AND ALL ITS PURCHASES
    private void needToDeleteCoupons() {
        couponDBDAO.deleteExpiredCoupons();
    }
    //endregion
}
