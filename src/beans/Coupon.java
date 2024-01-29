package beans;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
public class Coupon {
    //region Field Declarations
    private final Integer id;
    private final  Integer companyId;
    private Category category;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private Integer amount;
    private Double price;
    private String image;
    //endregion

    //region Constructors
    public Coupon(Integer id, Integer companyId, Category category, String title, String description, Date startDate, Date endDate, Integer amount, Double price, String image) {
        this.id = id;
        this.companyId = companyId;
        setCategory(category);
        setTitle(title);
        setDescription(description);
        setStartDate(startDate);
        setEndDate(endDate);
        setAmount(amount);
        setPrice(price);
        setImage(image);
    }

    public Coupon(Integer companyId, Category category, String title, String description, Date startDate, Date endDate, Integer amount, Double price, String image) {
        this(-1,companyId,category,title,description,startDate,endDate,amount,price,image);
    }
    //endregion

    //region Overrides
    @Override
    public String toString() {
        return "Coupon{" +
                (id != -1?("id=" + id+", "):"") +
                "companyId=" + companyId +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", amount=" + amount +
                ", price=" + price +
                ", image='" + image + '\'' +
                "}\n";
    }
    //endregion
}
