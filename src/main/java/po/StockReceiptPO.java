package po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/20.
 */
public class StockReceiptPO extends ReceiptPO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String supplier;
    private String repository;
    private String operator;
    private Vector<ProductsReceipt> productList;
    private String comment;
    private BigDecimal totalValue;

    public StockReceiptPO(String id, String supplier, String repository, String operator,
                          String comment) {
        this.number = id;
        this.supplier = supplier;
        this.repository = repository;
        this.operator = operator;
        this.comment = comment;
    }

    public String getId() {
        return number;
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
