package vo;

import po.ReceiptType;

import java.io.Serializable;

public class ReceiptConditionVO extends TimeConditionVO implements Serializable {
    public String startTime, endTime, client, operator, storage;
    public ReceiptType type;

    public ReceiptConditionVO(String startTime, String endTime, ReceiptType type, String client
            , String operator, String storage) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.client = client;
        this.operator = operator;
        this.storage = storage;
    }

    public ReceiptConditionVO(ReceiptType type) {
        this(null, null, type, null, null, null);
    }

    public ReceiptConditionVO() {
    }
}
