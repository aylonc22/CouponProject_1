package facade;

import beans.Category;
import beans.Client;
import beans.ClientType;
import beans.Coupon;
import exception.*;

import java.sql.SQLException;
import java.util.List;

public class CustomerFacade extends ClientFacade {
    //region Constructors
    public CustomerFacade(String email, String password) throws SQLException, CouponSystemException {
        super(email, password);
    }
    //endregion

    //region Overrides
    @Override
    public int login(String email, String password) throws  SQLException {
        if (customerDAO.isCustomerExists(email, password))
            return customerDAO.getClient(email, password).getId();
        else
            return 0;
    }
    //endregion
    //region CRUD Methods
    public void buyCoupon(int couponID) throws CouponSystemException, SQLException {
        if(isLogged())
        {
             couponDAO.addCouponPurchase(getId(), couponID);
        }
        else 
            throw  new CouponSystemException(ErrorMsg.CLIENT_NOT_LOGGED_IN);
    }
    public List<Coupon> getAllCoupons() throws CouponSystemException, SQLException {
        if(isLogged()){
            return couponDAO.getAllCouponsOfCustomer(getId());
        }
        else
            throw new CouponSystemException(ErrorMsg.CLIENT_NOT_LOGGED_IN);
    }
    public List<Coupon> getAllCouponsByCategory(Category category) throws CouponSystemException, SQLException {
        if(isLogged()){
            return couponDAO.getAllCouponsOfCustomerByCategory(getId()+1,category);
        }
        else
            throw new CouponSystemException(ErrorMsg.CLIENT_NOT_LOGGED_IN);
    }
    public List<Coupon> getAllCouponsByUpToPrice(double price) throws CouponSystemException, SQLException {
        if(isLogged()){
            return couponDAO.getAllCouponsOfCustomerUpToPrice(getId(),price);
        }
        else
            throw new CouponSystemException(ErrorMsg.CLIENT_NOT_LOGGED_IN);
    }
    //endregion
    public String getCustomerDetails() throws CouponSystemException, SQLException {
        if(isLogged()){
            return customerDAO.getOneCustomer(getId()).toString();
        }
        else
            throw new CouponSystemException(ErrorMsg.CLIENT_NOT_LOGGED_IN);

    }
}
