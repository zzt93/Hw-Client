package po;
/**
 * Edited by dzh,add extension,11.12
 *
 */
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Vector;

/**
 * Created by Nifury on 2014/10/20.
 */
public class SaleReceiptPO extends ReceiptPO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private ClientPO clientPO;
    private String salesman;
    private String operator;
    private String repository;
    private Vector<ProductsReceipt> productList;
    private BigDecimal totalValue;      //折让前总额
    private BigDecimal allowance;       //折让
    private BigDecimal coupon;          //代金券金额
    private BigDecimal actualValue;     //折让后总额
    private String comment;

    public SaleReceiptPO(String id, ClientPO clientPO, String salesman, String operator,
                         String repository, BigDecimal allowance,
                         BigDecimal coupon, String comment) {
        this.id = id;
        this.clientPO = clientPO;
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

    public ClientPO getClientPO() {
        return clientPO;
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
}
