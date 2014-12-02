package presentation.mainui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import po.BkTransPO;
import po.ClientPO;
import po.GoodsPO;
import po.ProductsReceipt;
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
			setDataVector(data,name);
			break;
		case CLIENT:
			name=new String[]{"姓名","编号","分类",
					"级别","应收","应付","业务员"};
			setDataVector(data,name);
			break;		
		case PRODUCTS:
			name=new String[]{"商品编号","商品名称","型号","数量","单价","金额","备注"};
			setDataVector(data,name);
			break;
		case GIFT:
			name=new String[]{"商品","型号","单价"};
		}
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
	
}
