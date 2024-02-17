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
    public CustomerFacade(String email, String password) throws SQLException, CustomerIsNotAdminException {
        super(email, password);
    }
    //endregion

    //region Overrides
    @Override
    public Client login(String email, String password) throws  SQLException {
        if (customerDAO.isCustomerExists(email, password))
            return customerDAO.getClient(email, password);
        else
            return null;
    }
    //endregion
    //region CRUD Methods
    public void buyCoupon(int couponID) throws ClientNotLoggedInException, ObjectNotFoundException, SQLDuplicateUniqueKeyException, OutOfStockException, SQLException {
        if(isLogged())
        {
             couponDAO.addCouponPurchase(getClient().getId(), couponID);
        }
        else
            throw  new ClientNotLoggedInException(ClientType.Customer);
    }
    public List<Coupon> getAllCoupons() throws ClientNotLoggedInException, SQLException {
        if(isLogged()){
            return couponDAO.getAllCouponsOfCustomer(getClient().getId());
        }
        else
            throw new ClientNotLoggedInException(ClientType.Customer);
    }
    public List<Coupon> getAllCouponsByCategory(Category category) throws ClientNotLoggedInException, SQLException {
        if(isLogged()){
            return couponDAO.getAllCouponsOfCustomerByCategory(getClient().getId()+1,category);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Customer);
    }
    public List<Coupon> getAllCouponsByUpToPrice(double price) throws ClientNotLoggedInException, SQLException {
        if(isLogged()){
            return couponDAO.getAllCouponsOfCustomerUpToPrice(getClient().getId(),price);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Customer);
    }
    //endregion
    public String getCustomerDetails() throws ClientNotLoggedInException, SQLException, ObjectNotFoundException {
        if(isLogged()){
            return customerDAO.getOneCustomer(getClient().getId()).toString();
        }
        else
            throw new ClientNotLoggedInException(ClientType.Customer);

    }
}
