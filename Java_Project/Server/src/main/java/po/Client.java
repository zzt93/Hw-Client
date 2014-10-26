package po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by Nifury on 2014/10/20.
 */
public class Client implements Serializable {

    private String id;
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

    public Client(String id, ClientType type, ClientLevel level,
                  String name, String phone, String address, String zip,
                  String email, BigDecimal upperBound, BigDecimal toReceive,
                  BigDecimal toPay, String defaultSalesMan) {
        this.id = id;
        this.type = type;
        this.level = level;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.zip = zip;
        this.email = email;
        this.upperBound = upperBound;
        this.toReceive = toReceive;
        this.toPay = toPay;
        this.defaultSalesMan = defaultSalesMan;
    }

    public String getId() {
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

}
