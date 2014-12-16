package presentation.mainui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import po.BankPO;
import po.BkTransPO;
import po.CashPO;
import po.ClientPO;
import po.ClientType;
import po.DealState;
import po.GoodsModelPO;
import po.GoodsPO;
import po.GoodsReceiptPO;
import po.ItemPO;
import po.PayPO;
import po.ProductsReceipt;
import po.RecPO;
import po.ReceiptPO;
import po.ReceiptState;
import po.ReceiptType;
import po.RepoReceiptPO;
import po.SaleReceiptPO;
import po.StockReceiptPO;
import vo.BankVO;
import vo.GoodsModelVO;
import vo.GoodsRecordVO;
import vo.GoodsVO;
import vo.ProfitVO;

public class PublicTableModel extends DefaultTableModel {
	String[] name;
	Object[][] data;
	public ModelType type;
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
		case SALERECORD:
			name=new String[]{"时间","商品名","型号","数量","单价","总额"};
			break;
		case GOODSRECEIPT:
			name=new String[]{"商品编号","名称","类型","数量","进价","售价"};
			break;
		case PROFIT:
			name=new String[]{"项目","收入","支出","利润"};
			break;
		case ACCOUNTGOODS:
			name=new String[]{"名称","类别","型号","进价","售价","最近进价","最近售价"};
			break;
		case ACCOUNTCLIENT:
			name=new String[]{"客户名称","客户分类","联系方式","应收","应付"};
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
				data[i][4]=ReceiptState.getName(temp.statement);
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
//					data[i][2]=temp1
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
				
			}
			update(data);
			break;
		}
		case FINRECEIPT:{
			data=new Object[list.size()][5];
			ReceiptPO temp;
			for(int i=0;i<list.size();i++){
				temp=(ReceiptPO)list.get(i);
				if(temp!=null){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
				data[i][0]=temp.time;
				data[i][1]=ReceiptType.getName(temp.type);
				data[i][3]=ReceiptState.getName(temp.statement);
				switch(temp.type){
				case CASH:{
					CashPO temp1=(CashPO)temp;
					data[i][2]=temp1.total;
					break;
				}
				case RECEIVE:
				case PAYMENT:{
					RecPO temp1=(RecPO)temp;
					data[i][2]=temp1.total;
					data[i][4]=DealState.getName(temp1.dealState);
					break;
				}
				}
			}
			System.out.println("lala");
			update(data);
			break;
		}
		case GOODSRECEIPT:{
			data=new Object[list.size()][6];
			GoodsVO temp;
			for(int i=0;i<list.size();i++){
				temp=(GoodsVO)list.get(i);
				data[i][0]=temp.id;
				data[i][1]=temp.name;
				data[i][2]=temp.model;
				data[i][3]=temp.amount;
				data[i][4]=temp.inPrice;
				data[i][5]=temp.outPrice;
			}
			update(data);
			break;
		}
		case BANK:{
			data=new Object[list.size()][3];
			if(list.size()>0){
				Object obj=list.get(0);
				if(obj instanceof BankPO){
					BankPO temp;
					for(int i=0;i<list.size();i++){
						temp=(BankPO)list.get(i);
						data[i][0]=temp.getName();
						data[i][1]=temp.getBalance();
						data[i][2]=temp.getRemark();
					}
				}else{
					BkTransPO temp;
					for(int i=0;i<list.size();i++){
						temp=(BkTransPO)list.get(i);
						data[i][0]=temp.getName();
						data[i][1]=temp.getAmount();
						data[i][2]=temp.getRemark();
				}
				update(data);
				}
			}
			break;
		}
		case ACCOUNTCLIENT:{
			data=new Object[list.size()][5];
			ClientPO temp;
			for(int i=0;i<list.size();i++){
				temp=(ClientPO)list.get(i);
				data[i][0]=temp.getName();
				data[i][1]=ClientType.getName(temp.getType());
				data[i][2]=temp.getPhone();
				data[i][3]=temp.getToPay();
				data[i][4]=temp.getToReceive();
			}
			update(data);
			break;
		}
		case ACCOUNTGOODS:{
			data=new Object[list.size()][7];
			GoodsModelPO temp;
			for(int i=0;i<list.size();i++){
				temp=(GoodsModelPO)list.get(i);
				data[i][0]=temp.getName();
				data[i][1]=temp.getType();
				data[i][2]=temp.getModel();
				data[i][3]=temp.getDefault_in();
				data[i][4]=temp.getDefault_out();
				data[i][5]=temp.getLastInPrice();
				data[i][6]=temp.getLastOutPrice();
			}
			update(data);
			break;
		}
		case ITEM:{
			data=new Object[list.size()][3];
			ItemPO temp;
			for(int i=0;i<list.size();i++){
				temp=(ItemPO)list.get(i);
				data[i][0]=temp.getName();
				data[i][1]=temp.getAmount();
				data[i][2]=temp.getRemark();
			}
			update(data);
			break;
		}
		}
	}
	public void update(BankVO[] list){
		data=new Object[list.length][3];
		BankVO temp;
		for(int i=0;i<list.length;i++){
			temp=list[i];
			data[i][0]=temp.name;
			data[i][1]=temp.balance;
			data[i][2]=temp.remark;
		}
		update(data);
	}
	public void update(BkTransPO[] list){
		for(int i=0;i<list.length;i++){
			addRow(list[i]);
		}
	}
	public void update(ItemPO[] list){
		for(int i=0;i<list.length;i++){
			addRow(list[i]);
		}
	}
	public void update(ProfitVO vo){
		data=new Object[9][4];
		data[0][0]="销售";
		data[0][1]=vo.saleIncome;
		data[0][2]=vo.saleCost;
		data[1][0]="报溢报损";
		data[1][1]=vo.goodsOverflow;
		data[1][2]=vo.goodsLost;
		data[2][0]="成本调价";
		data[2][1]=vo.costAdjust;
		data[3][0]="进货退货差价";
		data[3][1]=vo.stockDiffer;
		data[4][0]="商品赠出";
		data[4][2]=vo.giftCost;
		data[5][0]="总计";
		data[5][1]=vo.income;
		data[5][2]=vo.expense;
		data[6][0]="折让";
		data[6][1]=vo.discount;
		data[7][0]="折让后总计";
		data[7][1]=vo.actualIncome;
		data[7][2]=vo.expense;
		data[7][3]=vo.profit;
		update(data);
	}
	public void update(GoodsRecordVO[] list){
		data=new Object[list.length][6];
		for(int i=0;i<list.length;i++){
			data[i][0]=list[i].time;
			data[i][1]=list[i].goods;
			data[i][2]=list[i].goodsType;
			data[i][3]=list[i].number;
			data[i][4]=list[i].price;
			data[i][5]=list[i].total;
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
	public void addRow(GoodsModelVO vo){
		Object[] data=new Object[7];
		data[0]=vo.getName();
		data[1]=vo.getType();
		data[2]=vo.getModel();
		data[3]=vo.getDefault_in();
		data[4]=vo.getDefault_out();
		addRow(data);
	}
	public void addRow(ClientPO po){
		Object[] data=new Object[3];
		data[0]=po.getName();
		data[1]=ClientType.getName(po.getType());
		data[2]=po.getPhone();
		data[3]=po.getToReceive();
		data[4]=po.getToPay();
		addRow(data);
	}
	public void addRow(BkTransPO po ){
		Object[] data=new Object[3];
		data[0]=po.getName();
		data[1]=po.getAmount();
		data[2]=po.getRemark();
		addRow(data);
	}
	public void addRow(BankVO vo){
		Object[] data=new Object[3];
		data[0]=vo.name;
		data[1]=vo.balance;
		data[2]=vo.remark;
		addRow(data);
	}
	public void addRow(ItemPO po){
		Object[] data=new Object[3];
		data[0]=po.getName();
		data[1]=po.getAmount();
		data[2]=po.getRemark();
		addRow(data);
	}
	public void insteadRow(int row,RecPO po){
		removeRow(row);
		Object[] data=new Object[5];
		data[0]=po.time;
		data[1]=ReceiptType.getName(po.type);
		data[2]=po.total;
		data[3]=ReceiptState.getName(po.statement);
		data[4]=DealState.getName(po.dealState);
		insertRow(row,data);
	}
	public void clear(){
		for(int i=0;i<this.getRowCount();i++){
			this.removeRow(0);
		}
	}
}
