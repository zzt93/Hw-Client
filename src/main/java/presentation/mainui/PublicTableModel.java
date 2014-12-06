package presentation.mainui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import po.BkTransPO;
import po.CashPO;
import po.ClientPO;
import po.GoodsPO;
import po.GoodsReceiptPO;
import po.ItemPO;
import po.PayPO;
import po.ProductsReceipt;
import po.RecPO;
import po.ReceiptPO;
import po.RepoReceiptPO;
import po.SaleReceiptPO;
import po.StockReceiptPO;
import vo.BankVO;

public class PublicTableModel extends DefaultTableModel {
	String[] name;
	Object[][] data;
	ModelType type;
	public PublicTableModel(){
		super(0,3);
	} 
	private PublicTableModel(String[] name){
		super(name,0);
		this.name=name;
	}
	public PublicTableModel(ModelType type){
		this.type=type;
		switch(type){
		case BANK:	
			name=new String[]{"银行账户","余额","备注"};
			break;
		case CLIENT:
			name=new String[]{"姓名","编号","分类",
					"级别","应收","应付","业务员"};
			break;		
		case PRODUCTS:
			name=new String[]{"商品编号","商品名称","型号","数量","单价","金额","备注"};
			break;
		case GIFT:
			name=new String[]{"商品","型号","单价"};
			break;
		case FINRECEIPT:
			name=new String[]{"日期","类型","总额","审批状况","处理状况"};
			break;
		case ITEM:
			name=new String[]{"条目","金额","备注"};
			break;
		case RECEIPT:
			name=new String[]{"单据类型","日期","操作员","总额","审批情况"};
			break;
		default:
			return;
		}
		setDataVector(data,name);
	
	}
	public boolean isCellEditable(int row,int column){
		return false;
	}
	public void update(Object[][] data){
		setDataVector(data,name);
	}
	public void update(List list){
		switch(type){
		case CLIENT:{
			data=new Object[list.size()][7];
			ClientPO temp;
			for(int i=0;i<list.size();i++){
				temp=(ClientPO)list.get(i);
				data[i][0]=temp.getName();
				data[i][1]=temp.getId();
				data[i][2]=temp.getType();
				data[i][3]=temp.getLevel();
				data[i][4]=temp.getToPay();
				data[i][5]=temp.getToReceive();
				data[i][6]=temp.getDefaultSalesMan();
			}
			update(data);
			break;
		}
		case GIFT:{
			data=new Object[list.size()][4];
			GoodsPO temp;
			for(int i=0;i<list.size();i++){
				temp=(GoodsPO)list.get(i);
				data[i][0]=temp.getName();
				data[i][1]=temp.getModel();
				data[i][2]=temp.getOutPrice();
			}
			update(data);
			break;
		}
		case RECEIPT:{
			data=new Object[list.size()][5];
			ReceiptPO temp;
			for(int i=0;i<list.size();i++){
				temp=(ReceiptPO)list.get(0);
				data[i][1]=temp.time;
				switch(temp.type){
				case SALE_ACCEPT:{
					SaleReceiptPO temp1=(SaleReceiptPO)list.get(i);
					data[i][0]="销售单";
					data[i][2]=temp1.getOperator();	
					data[i][3]=temp1.getActualValue();
					break;
				}
				case SALE_REJECTION:{
					SaleReceiptPO temp1=(SaleReceiptPO)temp;
					data[i][0]="销售退货单";
					data[i][2]=temp1.getOperator();
					data[i][3]=temp1.getActualValue();
					break;
				}
				case STOCK_ACCEPT:{
					StockReceiptPO temp1=(StockReceiptPO)temp;
					data[i][0]="进货单";
					data[i][2]=temp1.getOperator();
					data[i][3]=temp1.getTotalValue();
					break;
				}
				case STOCK_REJECTION:{
					StockReceiptPO temp1=(StockReceiptPO)temp;
					data[i][0]="进货退货单";
					data[i][2]=temp1.getOperator();
					data[i][3]=temp1.getTotalValue();
					break;
				}
				case CASH:{
					CashPO temp1=(CashPO)temp;
					data[i][0]="现金费用单";
					data[i][2]=temp1.operator;
					data[i][3]=temp1.total;
					break;
				}
				case PAYMENT:{
					PayPO temp1=(PayPO)temp;
					data[i][0]="付款单";
					data[i][2]=temp1.operator;
					data[i][3]=temp1.total;
					break;
				}
				case RECEIVE:{
					RecPO temp1=(RecPO)temp;
					data[i][0]="收款单";
					data[i][2]=temp1.operator;
					data[i][3]=temp1.total;
					break;
				}
				case REPORECEIPT:{
					//FIXME
					RepoReceiptPO temp1=(RepoReceiptPO)temp;
					data[i][0]="报溢报损单";
//					data[i][2]=temp1.get
					break;
				}
				case GOODSRECEIPT:{
					//FIXME
					GoodsReceiptPO temp1=(GoodsReceiptPO)temp;
					data[i][0]="库存赠送单";
//					data[i][2]
					break;
				}
				}
				switch(temp.statement){
				case approve:
					data[i][4]="通过审批";
					break;
				case disapprove:
					data[i][4]="未通过审批";
					break;
				case wait:
					data[i][4]="待审批";
					break;
				}
			}
			update(data);
					
		}
		}
	}
	public void update(BankVO[] list){
		Object[][] data=new Object[list.length][3];
		BankVO temp;
		for(int i=0;i<list.length;i++){
			temp=list[i];
			data[i][0]=temp.name;
			data[i][1]=temp.balance;
			data[i][2]=temp.remark;
		}
		update(data);
	}
	public void addRow(ProductsReceipt pr){
		Object[] data=new Object[7];
		data[0]=pr.getCommodity_id();
		data[1]=pr.getName();
		data[2]=pr.getType();
		data[3]=pr.getNumber();
		data[4]=pr.getPrice();
		data[5]=pr.getTotal();
		data[6]=pr.getComment();
		addRow(data);
	}
	public void addRow(BkTransPO po ){
		Object[] data=new Object[3];
		data[0]=po.getName();
		data[1]=po.getAmount();
		data[2]=po.getRemark();
		addRow(data);
	}
	public void addRow(ItemPO po){
		Object[] data=new Object[3];
		data[0]=po.getName();
		data[1]=po.getAmount();
		data[2]=po.getRemark();
		addRow(data);
	}
	
}
