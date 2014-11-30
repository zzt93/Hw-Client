package presentation.Saleui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import po.ProductsReceipt;

public class GoodsPanel {
	static private JFrame frame;
	private JPanel panel;
	private JTextField textField;
	JList<String> list;
	private JTextField textName;
	private JTextField textId;
	private JTextField textType;
	private JTextField textNum;
	private JTextField textComment;
	private JTextField textPrice;
	ProductsReceipt pr;
	public GoodsPanel(ProductsReceipt pr){
		this.pr=pr;
	}
	public void initialize() {
		frame=new JFrame();
		frame.setBounds(0,0,300,400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label1 = new JLabel("商品名称:");
		label1.setBounds(30, 40, 54, 20);
		panel.add(label1);
		
		textName = new JTextField();
		textName.setBounds(85, 40, 100, 21);
		panel.add(textName);
		textName.setEditable(false);
		textName.setColumns(10);
		
		JButton button1 = new JButton("...");
		button1.setBounds(191, 40, 40, 20);
		panel.add(button1);
		
		JLabel label2 = new JLabel("商品编号:");
		label2.setBounds(30, 80, 200, 15);
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
		button2.setBounds(50, 270, 60, 23);
		panel.add(button2);
		
		JButton button3 = new JButton("取消");
		button3.setBounds(150, 270, 60, 23);
		panel.add(button3);
	}
	public void showGoodsList(){
		JFrame listFrame=new JFrame();
		listFrame.setBounds(0,0,200,400);
		listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//获得列表
		list=new JList<String>(new String[]{"test","test1","test2"});
		
		JScrollPane scroll=new JScrollPane();
		scroll.setViewportView(list);
		
		
	}
	public class MouseClick extends MouseAdapter{//选择商品用
		public void mouseClicked (MouseEvent e){
			if(e.getClickCount()>=2){
				String temp;
				temp=(String)list.getSelectedValue();
				//处理temp,获得商品信息，修改界面信息
				
			}
		}
	}
	public class Right implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			pr.setCommodity_id(Integer.valueOf(textId.getText()));
			pr.setComment(textName.getText());
			pr.setNumber(Integer.valueOf(textNum.getText()));
			pr.setPrice(new BigDecimal(textPrice.getText()));
		}
		
	}
	public class Cancel implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
		
	}
}
