package nifury.receipt;

import java.math.BigDecimal;

/**
 * Created by Nifury on 2014/10/15.
 */
public class ProductsReceipt implements ReceiptImpl {

    private String id;
    private int number;
    private BigDecimal price;
    private String comment;
    private int stock_After_Op;

    public ProductsReceipt(String id, int number, BigDecimal price, String comment, int stock_After_Op) {
        this.id = id;
        this.number = number;
        this.price = price;
        this.comment = comment;
        this.stock_After_Op = stock_After_Op;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getStock_After_Op() {
        return stock_After_Op;
    }

    public void setStock_After_Op(int stock_After_Op) {
        this.stock_After_Op = stock_After_Op;
    }

}
