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
    private int clientId;
    private String salesman;
    private String operator;
    private String repository;
    private Vector<ProductsReceipt> productList;
    private BigDecimal totalValue;      //折让前总额
    private BigDecimal allowance;       //折让
    public void setAllowance(BigDecimal allowance) {
		this.allowance = allowance;
	}

	public void setCoupon(BigDecimal coupon) {
		this.coupon = coupon;
	}

	public void setActualValue(BigDecimal actualValue) {
		this.actualValue = actualValue;
	}

	private BigDecimal coupon;          //代金券金额
    private BigDecimal actualValue;     //折让后总额
    private String comment;

    public SaleReceiptPO(String id, int clientId, String salesman, String operator,
                         String repository, BigDecimal allowance,
                         BigDecimal coupon, String comment) {
        this.number = id;
        this.clientId = clientId;
        this.salesman = salesman;
        this.operator = operator;
        this.repository = repository;
        this.allowance = allowance;
        this.coupon = coupon;
        this.comment = comment;
    }
    public SaleReceiptPO(SaleReceiptPO po){
        this.number = po.number;
        this.clientId = po.clientId;
        this.salesman = po.salesman;
        this.operator = po.operator;
        this.repository = po.repository;
        this.allowance = po.allowance;
        this.coupon = po.coupon;
        this.comment = po.comment;
    }

    public String getId() {
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
}
