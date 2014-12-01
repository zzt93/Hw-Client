package presentation.Saleui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import businesslogic.GoodsListbl.GL_controller;
import po.ProductsReceipt;
import vo.GoodsModelVO;
import vo.GoodsVO;

public class GoodsPanel {
	static private JFrame frame;
	static private JFrame listFrame;
	private JPanel panel;
	private JTextField textField;
	JList<String> goodsList;
	private JTextField textName;
	private JTextField textId;
	private JTextField textType;
	private JTextField textNum;
	private JTextField textComment;
	private JTextField textPrice;
	GL_controller controller;
	ProductsReceipt pr;
	private GoodsPaneType type;
	List<ProductsReceipt> list;
	PublicTableModel tableModel;
	GoodsVO goods;
	
	public GoodsPanel(List<ProductsReceipt> list,PublicTableModel tableModel,GoodsPaneType type){
		this.tableModel=tableModel;
		this.list=list;
		this.type=type;
	}
	public void showAddPane() {
		frame=new JFrame();
		frame.setBounds(0,0,300,400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label1 = new JLabel("商品名称:");
		label1.setBounds(30, 40, 60, 20);
		panel.add(label1);
		
		textName = new JTextField();
		textName.setBounds(85, 40, 100, 21);
		panel.add(textName);
		textName.setEditable(false);
		textName.setColumns(10);
		
		JButton button1 = new JButton("...");
		button1.setBounds(191, 40, 40, 20);
		panel.add(button1);
		button1.addActionListener(new ShowList());
		
		JLabel label2 = new JLabel("商品编号:");
		label2.setBounds(30, 80, 60, 15);
		panel.add(label2);
		
		JLabel label3 = new JLabel("型号:");
		label3.setBounds(30, 120, 30, 15);
		panel.add(label3);
		
		textId = new JTextField();
		textId.setBounds(85, 80, 100, 21);
		panel.add(textId);
		textId.setColumns(10);
		textId.setEditable(false);
		
		textType = new JTextField();
		textType.setBounds(70, 120, 100, 21);
		panel.add(textType);
		textType.setColumns(10);
		textType.setEditable(false);
		
		JLabel label4 = new JLabel("数量:");
		label4.setBounds(30, 160, 30, 15);
		panel.add(label4);
		
		textNum = new JTextField();
		textNum.setBounds(70, 160, 100, 21);
		panel.add(textNum);
		textNum.setColumns(10);
		
		JLabel label5=new JLabel("单价:");
		label5.setBounds(30,200,30,15);
		panel.add(label5);
		
		textPrice=new JTextField();
		textPrice.setBounds(70,200,100,21);
		textPrice.setColumns(10);
		panel.add(textPrice);
		
		JLabel label6 = new JLabel("备注:");
		label6.setBounds(30, 240, 30, 15);
		panel.add(label6);
		
		textComment = new JTextField();
		textComment.setBounds(70, 240, 200, 21);
		panel.add(textComment);
		textComment.setColumns(10);
		
		JButton button2 = new JButton("确定");
		button2.setBounds(60, 300, 60, 23);
		panel.add(button2);
		button2.addActionListener(new Right());
		
		JButton button3 = new JButton("取消");
		button3.setBounds(170, 300, 60, 23);
		panel.add(button3);
		button3.addActionListener(new Cancel());
		
		frame.setVisible(true);
	}
	public void showGoodsList(){
		listFrame=new JFrame();
		listFrame.setBounds(0,0,200,400);
		listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String[] temp;
		ArrayList tempList;
		//FIXME,测试暂时隐掉
//		if(type==GoodsPaneType.SALE){
//			tempList=controller.sell_type();
//		}else{
//			tempList=controller.stock_type();
//		}
//		temp=new String[tempList.size()];
//		for(int i=0;i<tempList.size();i++){//可能造成巨大的消耗
//			temp[i]=(String)tempList.get(i);
//		}
		temp=new String[]{"0001(商品1)"};
		
		goodsList=new JList<String>(temp);
		goodsList.addMouseListener(new MouseClick());
		JScrollPane scroll=new JScrollPane();
		scroll.setViewportView(goodsList);
		listFrame.add(scroll);
		listFrame.setVisible(true);
		
	}
	public class MouseClick extends MouseAdapter{//选择商品用
		public void mouseClicked (MouseEvent e){
			if(e.getClickCount()>=2){
				String temp;
				temp=(String)goodsList.getSelectedValue();
				//System.out.println(temp);
				//处理temp,获得商品信息，修改界面信息
//				FIXME,测试暂时注释掉
//				String temp2[]=temp.split("(");
//				goods=controller.eSearch_batch(temp2[0]).get(0);
				GoodsVO goods=new GoodsVO("0001",20);
				goods.name="商品1";
				goods.model="类型1";
				goods.inPrice=15;
				goods.outPrice=15;
				textName.setText(goods.name);
				textType.setText(goods.model);
				textId.setText(goods.id);
				if(type==GoodsPaneType.SALE){
					textPrice.setText(String.valueOf(goods.inPrice));
				}else{
					textPrice.setText(String.valueOf(goods.outPrice));
				}
				listFrame.dispose();		
			}
		}
	}
	public class Right implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			pr=new ProductsReceipt();
			pr.setCommodity_id(Integer.valueOf(textId.getText()));
			pr.setComment(textComment.getText());
			pr.setNumber(Integer.valueOf(textNum.getText()));
			pr.setPrice(new BigDecimal(textPrice.getText()));
			pr.setType(textType.getText());
			pr.setName(textName.getText());
			//添加到表格，添加到list
			tableModel.addRow(pr);
			list.add(pr);
			if(type==GoodsPaneType.SALE){
				Sale1.total+=(Double.valueOf(textPrice.getText())*Integer.valueOf(textNum.getText()));
				Sale1.labelTotal.setText(String.valueOf(Sale1.total));
				Sale1.labelTotal.repaint();
			}else{
				Stock1.total+=(Double.valueOf(textPrice.getText())*Integer.valueOf(textNum.getText()));
				Stock1.labelTotal.setText(String.valueOf(Stock1.total));
				Stock1.labelTotal.repaint();
			}
			frame.dispose();		
		}
		
	}
	public class Cancel implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
		
	}
	public class ShowList implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			showGoodsList();
		}
		
	}
	
}
