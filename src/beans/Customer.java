package beans;

import java.util.List;

public class Customer {
    //region Field Declarations
    private final  Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Coupon> coupons;
    //endregion

    //region Constructors
    public Customer(Integer id, String firstName, String lastName, String email, List<Coupon> coupons) {
        this.id = id;
       setFirstName(firstName);
       setLastName(lastName);
       setEmail(email);
       setCoupons(coupons);
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
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", coupons=" + coupons +
                "}\n";
    }
    //endregion
}
