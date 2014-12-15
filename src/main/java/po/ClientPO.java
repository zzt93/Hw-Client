package po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Nifury on 2014/10/20.
 */
public class ClientPO implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private ClientType type;
    private ClientLevel level;
    private String name;
    private String phone;
    private String address;
    private String zip;
    private String email;
    private BigDecimal upperBound;
    private BigDecimal toReceive;
    private BigDecimal toPay;
    private String defaultSalesMan;
    
    public ClientPO(ClientType type, ClientLevel level,
                    String name, String phone, String address,
                    String zip, String email, String defaultSalesMan) {
        this.type = type;
        this.level = level;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.zip = zip;
        this.email = email;
        this.upperBound = BigDecimal.ZERO;
        this.toReceive = BigDecimal.ZERO;
        this.toPay = BigDecimal.ZERO;
        this.defaultSalesMan = defaultSalesMan;
    }
    public ClientPO(){
    	
    }
    public ClientPO(String test){
    	type=ClientType.SELLER;
    	level=ClientLevel.LEVEL1;
    	name="茶农";
    	phone="122221020201";
    	address="南京大学仙林大道";
    	zip="384021";
    	email="chanong@gmail.com";
        this.upperBound = BigDecimal.ZERO;
        this.toReceive = BigDecimal.ZERO;
        this.toPay = BigDecimal.ZERO;
        defaultSalesMan="王尼玛";
    }
    public int getId() {
        return id;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public ClientLevel getLevel() {
        return level;
    }

    public void setLevel(ClientLevel level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(BigDecimal upperBound) {
        //TODO 仅最高权限可修改，以及改Data层的MODIFY
        this.upperBound = upperBound;
    }

    public BigDecimal getToReceive() {
        return toReceive;
    }

    public BigDecimal getToPay() {
        return toPay;
    }

    public String getDefaultSalesMan() {
        return defaultSalesMan;
    }

    public void setDefaultSalesMan(String defaultSalesMan) {
        this.defaultSalesMan = defaultSalesMan;
    }

    @Override
    public String toString() {
        //TODO to be removed
        return "ClientPO{" +
                "id=" + id +
                ", type=" + type +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", zip='" + zip + '\'' +
                ", email='" + email + '\'' +
                ", upperBound=" + upperBound +
                ", toReceive=" + toReceive +
                ", toPay=" + toPay +
                ", defaultSalesMan='" + defaultSalesMan + '\'' +
                '}';
    }
}
