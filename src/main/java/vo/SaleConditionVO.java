package vo;

import java.io.Serializable;

public class SaleConditionVO extends TimeConditionVO implements Serializable {
    public String startTime, endTime, goods, client, storage, buisnessman;
    private static final long serialVersionUID = 1L;
}
