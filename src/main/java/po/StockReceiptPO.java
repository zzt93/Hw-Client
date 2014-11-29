package po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/20.
 */
public class StockReceiptPO extends ReceiptPO implements Serializable {

    private static final long serialVersionUID = 1L;
    private int clientId;
    private String repository;
    private String operator;
    private Vector<ProductsReceipt> productList;
    private String comment;
    private BigDecimal totalValue;

    public StockReceiptPO(int clientId, String repository, String operator,
                          String comment) {
        this.clientId = clientId;
        this.repository = repository;
        this.operator = operator;
        this.comment = comment;
    }

    public String getId() {
        return number;
    }

    public int getSupplier() {
        return clientId;
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
