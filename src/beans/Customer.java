package beans;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Customer extends Client {
    //region Setters && Getters
    //region Field Declarations
    private String firstName;
    private String lastName;
    //endregion

    //region Constructors
    public Customer(Integer id, String firstName, String lastName, String email,String password, List<Coupon> coupons) {
        super(id, email, password, coupons);
        setFirstName(firstName);
        setLastName(lastName);

    }

    //for adding new customer to the database
    public Customer(String firstName, String lastName, String email, String password) {
        this(-1,firstName,lastName,email,password,new ArrayList<>());
    }
    //endregion

    //region Overrides
    @Override
    public String toString() {
        return "Customer{" +
                (getId() != -1?("id=" + getId()+", "):"") +
                 "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + getEmail() + '\'' +
                ", coupons=" + getCoupons() +
                "}\n";
    }
    //endregion
}
