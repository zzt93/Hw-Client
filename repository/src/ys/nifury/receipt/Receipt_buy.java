package nifury.receipt;

import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/15.
 */
public class Receipt_buy {

    private String id;
    private String supplier;
    private String repository;
    private String operator;
    private Vector<Product_receipt> productList;
    private String comment;
    private BigDecimal totalValue;

    public Receipt_buy(String id, String supplier, String repository, String operator,
                       String comment) {
        this.id = id;
        this.supplier = supplier;
        this.repository = repository;
        this.operator = operator;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getRepository() {
        return repository;
    }

    public String getOperator() {
        return operator;
    }

    public String getComment() {
        return comment;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    private BigDecimal countPrice(Product_receipt receipt) {
        return new BigDecimal(receipt.getNumber()).multiply(receipt.getPrice());
    }

    public void addProduct(Product_receipt receipt) {
        productList.add(receipt);
        totalValue = totalValue.add(countPrice(receipt));
    }

    public void removeProduct(Product_receipt receipt) {
        productList.remove(receipt);
        totalValue = totalValue.subtract(countPrice(receipt));
    }

}
