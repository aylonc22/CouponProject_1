package beans;

import java.util.List;

public class Company {
    //region Field Declaration
    private final  Integer id;
    private final String name;
    private String email;
    private String password;
    private List<Coupon> coupons;
    //endregion

    //region Constructors
    public Company(Integer id, String name, String email, String password, List<Coupon> coupons) {
        this.id = id;
        this.name = name;
       setEmail(email);
       setPassword(password);
       setCoupons(coupons);
    }
    //endregion

    //region Setters && Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
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
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", coupons=" + coupons +
                "}\n";
    }
    //endregion
}
