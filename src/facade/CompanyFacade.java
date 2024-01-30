package facade;

//region Imports
import beans.*;
import exception.ClientNotLoggedInException;
import exception.CustomerIsNotAdminException;

import java.sql.SQLException;
import java.util.List;
//endregion

public class CompanyFacade extends ClientFacade {
    public CompanyFacade(String email, String password) throws CustomerIsNotAdminException, SQLException {
        super(email, password);
    }
    //region Overrides
    @Override
    public Client login(String email, String password) throws  SQLException {
        if(companiesDBDAO.isCompanyExists(email, password))
            return  companiesDBDAO.getClient(email,password);
        return null;
    }
    //endregion
    //region CRUD Methods
    public void addCoupon(Coupon coupon) throws ClientNotLoggedInException {
        if(isLogged())
        {
            couponDBDAO.addCoupon(coupon);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Company);
    }
    public void updateCoupon(Coupon coupon) throws ClientNotLoggedInException {
        if(isLogged())
        {
            couponDBDAO.updateCoupon(coupon);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Company);
    }
    public void deleteCoupon(int couponID) throws ClientNotLoggedInException {
        if(isLogged())
        {
            couponDBDAO.deleteCoupon(couponID);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Company);
    }
    public List<Coupon> getALlCoupons() throws ClientNotLoggedInException, SQLException {
        if(isLogged())
        {
            return couponDBDAO.getAllCouponsOfCompany(getClient().getId());
        }
        else
            throw new ClientNotLoggedInException(ClientType.Company);
    }
    public List<Coupon> getALlCouponsByCategory(Category category) throws ClientNotLoggedInException, SQLException {
        if(isLogged())
        {
            return couponDBDAO.getAllCouponsOfCompanyByCategory(getClient().getId(), category);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Company);
    }
    // return all the coupons of the company which price are below or equal to the criteria
    public List<Coupon> getALlCouponsByUpToPrice(int price) throws ClientNotLoggedInException, SQLException {
        if(isLogged())
        {
            return couponDBDAO.getAllCouponsOfCompanyUpToPrice(getClient().getId(), price);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Company);
    }
    public String returnCompanyDetails() throws ClientNotLoggedInException {
        if(isLogged())
        {
            return getClient().toString();
        }
        else
            throw new ClientNotLoggedInException(ClientType.Company);

    }
    //endregion
}
