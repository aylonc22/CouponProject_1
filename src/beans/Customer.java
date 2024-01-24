package beans;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    //region Field Declarations
    private final  Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Coupon> coupons;
    //endregion

    //region Constructors
    public Customer(Integer id, String firstName, String lastName, String email,String password, List<Coupon> coupons) {
        this.id = id;
       setFirstName(firstName);
       setLastName(lastName);
       setEmail(email);
       setPassword(password);
       setCoupons(coupons);
    }

    //for adding new customer to the database
    public Customer(String firstName, String lastName, String email, String password) {
        this(-1,firstName,lastName,email,password,new ArrayList<>());
    }
    //endregion

    //region Setters && Getters
    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }
    //endregion

    //region Overrides
    @Override
    public String toString() {
        return "Customer{" +
                (id != -1?("id=" + id+","):"") +
                 "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", coupons=" + coupons +
                "}\n";
    }
    //endregion
}
