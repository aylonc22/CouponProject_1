package beans;

import java.util.ArrayList;
import java.util.List;

public class Company extends Client{
    //region Field Declaration
        private final String name;
    //endregion

    //region Constructors
    public Company(Integer id, String name, String email, String password, List<Coupon> coupons) {
        super(id,email,password,coupons);
        this.name = name;

    }
    //for adding new company to the database
    public Company(String name, String email, String password) {
        this(-1,name,email,password,new ArrayList<>());
    }
    //endregion

    //region Setters && Getters
    public String getName() {
        return name;
    }

    //endregion

    //region Overrides
    @Override
    public String toString() {
        return "Company{" +
                (getId() != -1?("id=" + getId()+", "):"") +
                "name='" + name + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", coupons=" + getCoupons() +
                "}\n";
    }
    //endregion
}
