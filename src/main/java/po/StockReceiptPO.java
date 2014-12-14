package po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Nifury on 2014/10/20.
 */
public class StockReceiptPO extends ReceiptPO implements Serializable {

    private static final long serialVersionUID = 1L;
    private int clientId;
    private String client;
    private String repository;
    private String operator;
    private List<ProductsReceipt> productList;
    private String comment;
    private BigDecimal totalValue;

    public StockReceiptPO(int clientId, String repository, String operator,
                          String comment,BigDecimal totalValue) {
        this.clientId = clientId;
        this.repository = repository;
        this.operator = operator;
        this.comment = comment;
        this.totalValue=totalValue;
    }

    public String getNumber() {
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

    public List<ProductsReceipt> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductsReceipt> productList) {
        this.productList = productList;
    }

    
    public void setClient(String name ){
    	client=name;
    }
    public void setTotalValue(BigDecimal temp){
    	totalValue=temp;
    }
    public String getClient(){
    	return client;
    }


}