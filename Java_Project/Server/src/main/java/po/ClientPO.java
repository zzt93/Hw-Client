package po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public ClientPO(int id, ClientType type, ClientLevel level,
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

    public ClientPO(ResultSet set) throws SQLException {
        this.id = set.getInt(1);
        this.type = ClientType.values()[set.getInt(2)];
        this.level = ClientLevel.values()[set.getInt(3)];
        this.name = set.getString(4);
        this.phone = set.getString(5);
        this.address = set.getString(6);
        this.zip = set.getString(7);
        this.email = set.getString(8);
        this.upperBound = set.getBigDecimal(9);
        this.toReceive = set.getBigDecimal(10);
        this.toPay = set.getBigDecimal(11);
        this.defaultSalesMan = set.getString(12);
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
        this.upperBound = upperBound;
    }

    public BigDecimal getToReceive() {
        return toReceive;
    }

    public void setToReceive(BigDecimal toReceive) {
        this.toReceive = toReceive;
    }

    public BigDecimal getToPay() {
        return toPay;
    }

    public void setToPay(BigDecimal toPay) {
        this.toPay = toPay;
    }

    public String getDefaultSalesMan() {
        return defaultSalesMan;
    }

    public void setDefaultSalesMan(String defaultSalesMan) {
        this.defaultSalesMan = defaultSalesMan;
    }
}
