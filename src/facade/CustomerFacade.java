package facade;

import beans.Category;
import beans.Client;
import beans.ClientType;
import beans.Coupon;
import exception.ClientNotLoggedInException;
import exception.CustomerIsNotAdminException;

import java.sql.SQLException;
import java.util.List;

public class CustomerFacade extends ClientFacade {
    //region Constructors
    public CustomerFacade(String email, String password) throws CustomerIsNotAdminException, SQLException {
        super(email, password);
    }
    //endregion

    //region Overrides
    @Override
    public Client login(String email, String password) throws  SQLException {
        return customerDBDAO.isCustomerExists(email,password);
    }
    //endregion
    //region CRUD Methods
    // TODO fix buy coupon by the conditions of the exercise
    public void buyCoupon(int couponID) throws ClientNotLoggedInException {
        if(isLogged())
        {
             couponDBDAO.addCouponPurchase(getClient().getId(), couponID);
        }
        else
            throw  new ClientNotLoggedInException(ClientType.Customer);
    }
    public List<Coupon> getAllCoupons() throws ClientNotLoggedInException, SQLException {
        if(isLogged()){
            return couponDBDAO.getAllCouponsOfCustomer(getClient().getId());
        }
        else
            throw new ClientNotLoggedInException(ClientType.Customer);
    }
    public List<Coupon> getAllCouponsByCategory(Category category) throws ClientNotLoggedInException, SQLException {
        if(isLogged()){
            return couponDBDAO.getAllCouponsOfCustomerByCategory(getClient().getId(),category);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Customer);
    }
    public List<Coupon> getAllCouponsByUpToPrice(double price) throws ClientNotLoggedInException, SQLException {
        if(isLogged()){
            return couponDBDAO.getAllCouponsOfCustomerUpToPrice(getClient().getId(),price);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Customer);
    }
    //endregion
    public String getCustomerDetails() throws ClientNotLoggedInException {
        if(isLogged()){
            return getClient().toString();
        }
        else
            throw new ClientNotLoggedInException(ClientType.Customer);

    }
}
