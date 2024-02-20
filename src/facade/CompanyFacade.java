package facade;

//region Imports
import beans.*;
import exception.CouponSystemException;
import exception.ErrorMsg;

import java.sql.SQLException;
import java.util.List;
//endregion

public class CompanyFacade extends ClientFacade {
    public CompanyFacade(String email, String password) throws CouponSystemException, SQLException {
        super(email, password);
    }
    //region Overrides
    @Override
    public int login(String email, String password) throws SQLException, CouponSystemException {
        if(companiesDAO.isCompanyExists(email, password))
            return  companiesDAO.getClientID(email,password);
        return 0;
    }
    //endregion
    //region CRUD Methods
    public void addCoupon(Coupon coupon) throws CouponSystemException {
        if(isLogged())
        {
            couponDAO.addCoupon(coupon);
        }
        else
            throw new CouponSystemException(ErrorMsg.COMPANY_NOT_LOGGED_IN);
    }
    public void updateCoupon(Coupon coupon) throws CouponSystemException {
        if(isLogged())
        {
            couponDAO.updateCoupon(coupon);
        }
        else
            throw new CouponSystemException(ErrorMsg.COMPANY_NOT_LOGGED_IN);
    }
    public void deleteCoupon(int couponID) throws CouponSystemException {
        if(isLogged())
        {
            couponDAO.deleteCoupon(couponID, getId());
        }
        else
            throw new CouponSystemException(ErrorMsg.COMPANY_NOT_LOGGED_IN);
    }
    public List<Coupon> getAllCoupons() throws CouponSystemException, SQLException {
        if(isLogged())
        {
            return couponDAO.getAllCouponsOfCompany(getId());
        }
        else
            throw new CouponSystemException(ErrorMsg.COMPANY_NOT_LOGGED_IN);
    }
    public List<Coupon> getAllCouponsByCategory(Category category) throws CouponSystemException, SQLException {
        if(isLogged())
        {
            return couponDAO.getAllCouponsOfCompanyByCategory(getId(), category);
        }
        else
            throw new CouponSystemException(ErrorMsg.COMPANY_NOT_LOGGED_IN);
    }
    // return all the coupons of the company which price are below or equal to the criteria
    public List<Coupon> getAllCouponsByUpToPrice(double price) throws CouponSystemException, SQLException {
        if(isLogged())
        {
            return couponDAO.getAllCouponsOfCompanyUpToPrice(getId(), price);
        }
        else 
            throw new CouponSystemException(ErrorMsg.COMPANY_NOT_LOGGED_IN);
    }
    public String returnCompanyDetails() throws CouponSystemException, SQLException {
        if(isLogged())
        {
            return companiesDAO.getOneCompany(getId()).toString();
        }
        else
            throw new CouponSystemException(ErrorMsg.COMPANY_NOT_LOGGED_IN);

    }
    //endregion
}
