package po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Nifury on 2014/10/20.
 */
public class SaleReceiptPO extends ReceiptPO implements Serializable {

    private static final long serialVersionUID = 1L;
    private int clientId;
    private String salesman;
    private String operator;
    private String repository;
    private List<ProductsReceipt> productList;
    private BigDecimal totalValue;      //折让前总额
    private BigDecimal allowance;       //折让
    private BigDecimal coupon;          //代金券金额
    private BigDecimal actualValue;     //折让后总额
    private String comment;

    public String getNumber() {
        return number;
    }

    public int getClientId() {
        return clientId;
    }

    public String getSalesman() {
        return salesman;
    }

    public String getOperator() {
        return operator;
    }

    public String getRepository() {
        return repository;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public BigDecimal getAllowance() {
        return allowance;
    }

    public BigDecimal getCoupon() {
        return coupon;
    }

    public BigDecimal getActualValue() {
        return actualValue;
    }

    public String getComment() {
        return comment;
    }

    public List<ProductsReceipt> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductsReceipt> productList) {
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
