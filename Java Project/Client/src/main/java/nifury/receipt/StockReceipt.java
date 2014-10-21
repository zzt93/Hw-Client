package nifury.receipt;

import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/20.
 */
public class StockReceipt implements ReceiptImpl {

    private String id;
    private String supplier;
    private String repository;
    private String operator;
    private Vector<ProductsReceipt> productList;
    private String comment;
    private BigDecimal totalValue;

    public StockReceipt(String id, String supplier, String repository, String operator,
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

}
