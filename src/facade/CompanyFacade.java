package facade;

//region Imports
import beans.*;
import exception.ClientNotLoggedInException;
import exception.CustomerIsNotAdminException;
import exception.ObjectNotFoundException;
import exception.SQLDuplicateUniqueKeyException;

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
        if(companiesDAO.isCompanyExists(email, password))
            return  companiesDAO.getClient(email,password);
        return null;
    }
    //endregion
    //region CRUD Methods
    public void addCoupon(Coupon coupon) throws ClientNotLoggedInException, SQLDuplicateUniqueKeyException {
        if(isLogged())
        {
            couponDAO.addCoupon(coupon);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Company);
    }
    public void updateCoupon(Coupon coupon) throws ClientNotLoggedInException, ObjectNotFoundException, SQLDuplicateUniqueKeyException {
        if(isLogged())
        {
            couponDAO.updateCoupon(coupon);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Company);
    }
    public void deleteCoupon(int couponID) throws ClientNotLoggedInException, ObjectNotFoundException {
        if(isLogged())
        {
            couponDAO.deleteCoupon(couponID, getClient().getId());
        }
        else
            throw new ClientNotLoggedInException(ClientType.Company);
    }
    public List<Coupon> getAllCoupons() throws ClientNotLoggedInException, SQLException {
        if(isLogged())
        {
            return couponDAO.getAllCouponsOfCompany(getClient().getId());
        }
        else
            throw new ClientNotLoggedInException(ClientType.Company);
    }
    public List<Coupon> getAllCouponsByCategory(Category category) throws ClientNotLoggedInException, SQLException {
        if(isLogged())
        {
            return couponDAO.getAllCouponsOfCompanyByCategory(getClient().getId(), category);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Company);
    }
    // return all the coupons of the company which price are below or equal to the criteria
    public List<Coupon> getAllCouponsByUpToPrice(double price) throws ClientNotLoggedInException, SQLException {
        if(isLogged())
        {
            return couponDAO.getAllCouponsOfCompanyUpToPrice(getClient().getId(), price);
        }
        else
            throw new ClientNotLoggedInException(ClientType.Company);
    }
    public String returnCompanyDetails() throws ClientNotLoggedInException, SQLException, ObjectNotFoundException {
        if(isLogged())
        {
            return companiesDAO.getOneCompany(getClient().getId()).toString();
        }
        else
            throw new ClientNotLoggedInException(ClientType.Company);

    }
    //endregion
}
