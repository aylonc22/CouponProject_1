package beans;

import java.util.List;

public abstract class Client {
    //region Field Declaration
    private final Integer id;
    private String email;
    private String password;
    private List<Coupon> coupons;
    //endregion

    //region Constructions
    public Client(Integer id, String email, String password, List<Coupon> coupons) {
        this.id = id;
        setEmail(email);
        setPassword(password);
        setCoupons(coupons);
    }
    //endregion


    //region Getters && Setters
    public int getId() {
        return id;
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
}
