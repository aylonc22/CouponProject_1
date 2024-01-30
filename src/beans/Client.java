package beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
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


}
