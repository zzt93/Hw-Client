package po;

/**
 * Created by Nifury on 2014/10/20.
 */
public enum ReceiptType {
    STOCK_ACCEPT, STOCK_REJECTION, SALE_ACCEPT, SALE_REJECTION, RECEIVE, PAYMENT, CASH, 
    REPORECEIPT, GOODSRECEIPT, SIGNAL;
    public static String getName(ReceiptType type){
    	switch(type){
    	case STOCK_ACCEPT:
    		return "进货单";
    	case STOCK_REJECTION:
    		return "进货退货单";
    	case SALE_ACCEPT:
    		return "销售单";
    	case SALE_REJECTION:
    		return "销售退货单";
    	case RECEIVE:
    		return "收款单";
    	case PAYMENT:
    		return "付款单";
    	case CASH:
    		return "现金费用单";
    	case REPORECEIPT:
    		return "报溢报损单";
    	case GOODSRECEIPT:
    		return "库存赠送单";
    	case SIGNAL:
    		return "库存报警单";
    	}
    	return null;
    }
}
