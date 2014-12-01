package po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Nifury on 2014/10/20.
 */
public class ProductsReceipt implements Serializable {

    private static final long serialVersionUID = 1L;

    private int commodity_id;
    private int number;
    private String name;
    private BigDecimal price;
    private BigDecimal total_value;
    private String comment;
    private String type;
    public ProductsReceipt(int commodity_id, int number, BigDecimal price, String comment,String type,String name) {
        this.commodity_id = commodity_id;
        this.number = number;
        this.price = price;
        this.comment = comment;
        this.type=type;
        total_value=new BigDecimal(0);
        price=price.multiply(new BigDecimal(number));
        total_value=total_value.add(price);
    }
    public ProductsReceipt(){}
    public String getName(){
    	return name;
    }
    public void setName(String name){
    	this.name=name;
    }
    public String getType(){
    	return type;
    }
    public void setType(String type){
    	this.type=type;
    }

    public int getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public BigDecimal getTotal(){
    	return total_value;
    } 
}
