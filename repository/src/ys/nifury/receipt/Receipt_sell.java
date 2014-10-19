package nifury.receipt;

import nifury.client.Client;

import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/15.
 */
public class Receipt_sell {

    private String id;
    private Client client;
    private String salesman;
    private String operator;
    private String repository;
    private Vector<Product_receipt> productList;
    private BigDecimal totalValue;      //折让前总额
    private BigDecimal allowance;       //折让
    private BigDecimal coupon;          //代金券金额
    private BigDecimal actualValue;     //折让后总额
    private String comment;

    public Receipt_sell(String id, Client client, String salesman, String operator,
                        String repository, BigDecimal allowance,
                        BigDecimal coupon, String comment) {
        this.id = id;
        this.client = client;
        this.salesman = salesman;
        this.operator = operator;
        this.repository = repository;
        this.allowance = allowance;
        this.coupon = coupon;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public Client getClient() {
        return client;
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

    private BigDecimal countPrice(Product_receipt receipt) {
        return new BigDecimal(receipt.getNumber()).multiply(receipt.getPrice());
    }

    private BigDecimal countActualValue() {
        BigDecimal tmp = totalValue.subtract(allowance).subtract(coupon);
        if (tmp.compareTo(BigDecimal.ZERO) == -1)
            return BigDecimal.ZERO;
        else
            return tmp;
    }

    public void addProduct(Product_receipt receipt) {
        productList.add(receipt);
        totalValue = totalValue.add(countPrice(receipt));
        actualValue = countActualValue();
    }

    public void removeProduct(Product_receipt receipt) {
        productList.remove(receipt);
        totalValue = totalValue.subtract(countPrice(receipt));
        actualValue = countActualValue();
    }
}
