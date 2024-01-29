package beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public abstract class Client {
    //region Field Declaration
    private final Integer id;
    private String email;
    private String password;
    private List<Coupon> coupons;
    //endregion
}
