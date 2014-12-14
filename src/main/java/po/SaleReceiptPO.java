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
    private String client;
    private String salesman;
    private String operator;
    private String repository;
    private List<ProductsReceipt> productList;
    private BigDecimal totalValue;      //折让前总额
    private BigDecimal allowance;       //折让
    private BigDecimal coupon;          //代金券金额
    private BigDecimal actualValue;     //折让后总额
    private String comment;
    public SaleReceiptPO(int clientId,String salesman,
    		String repository,String comment,BigDecimal totalValue){
    	this.clientId=clientId;
    	this.salesman=salesman;
    	this.repository=repository;
    	this.comment=comment;
    	this.totalValue=totalValue;
    }
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

    
    public void setClient(String name){
    	client=name;
    }
    public String getClient(){
    	return client;
    }
    
	public void setAllowance(BigDecimal allowance) {
		this.allowance = allowance;
	}

	public void setCoupon(BigDecimal coupon) {
		this.coupon = coupon;
	}

	public void setActualValue(BigDecimal actualValue) {
		this.actualValue = actualValue;
	}

	public void setComment(String string) {
		// TODO Auto-generated method stub
		
	}
}
