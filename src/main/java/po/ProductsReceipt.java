package po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Nifury on 2014/10/20.
 */
public class ProductsReceipt implements Serializable {

    private static final long serialVersionUID = 1L;

    private int commodity_id;
    private int number;
    private BigDecimal price;
    private BigDecimal total_value;
    private String comment;

    public ProductsReceipt(int commodity_id, int number, BigDecimal price, String comment) {
        this.commodity_id = commodity_id;
        this.number = number;
        this.price = price;
        this.comment = comment;
    }

    public int getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
