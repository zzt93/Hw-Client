package presentation.SetAccountui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import businesslogic.SetAccountbl.AccountController;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;
import vo.BankVO;
import vo.GoodsModelVO;

public class GoodsPanel {
	private JPanel panel;
	private JTable table;
	private PublicTableModel tableModel;
	public ArrayList<GoodsModelVO> goodsList;
	private AccountController controller;
	public GoodsPanel(AccountController controller){
		this.controller=controller;
		initialize();
	}
	public JPanel getPanel(){
		return panel;
	}
	public void initialize(){
		panel = new JPanel();
		panel.setBounds(0, 0, 800, 500);
		panel.setLayout(null);
		
		JLabel label = new JLabel("商品信息");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(338, 24, 100, 15);
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 48, 639, 303);
		panel.add(scrollPane);
		
		tableModel = new PublicTableModel(ModelType.ACCOUNTGOODS);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("添加");
		btnAdd.setBounds(464, 387, 80, 30);
		panel.add(btnAdd);
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AddGoodsPanel add=new AddGoodsPanel();
			}
			
		});
		
		JButton btnDel = new JButton("删除");
		btnDel.setBounds(581, 387, 80, 30);
		panel.add(btnDel);
		btnDel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//TODO
			}
			
		});
	}
	public class AddGoodsPanel{
		private JFrame frame;
		private JTextField textName;
		private JTextField textModel;
		private JTextField textInprice;
		private JTextField textOutprice;
		private JComboBox comboBox;
		
		public AddGoodsPanel(){
			initialize();
			frame.setVisible(true);
		}
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 300, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel label = new JLabel("商品名称:");
			label.setBounds(30, 40, 54, 15);
			panel.add(label);
			
			JLabel label_1 = new JLabel("商品分类:");
			label_1.setBounds(30, 80, 54, 15);
			panel.add(label_1);
			
			JLabel label_2 = new JLabel("商品型号:");
			label_2.setBounds(30, 120, 54, 15);
			panel.add(label_2);
			
			JLabel label_3 = new JLabel("默认进价:");
			label_3.setBounds(30, 160, 54, 15);
			panel.add(label_3);
			
			JLabel label_4 = new JLabel("默认售价:");
			label_4.setBounds(30, 200, 54, 15);
			panel.add(label_4);
			
			textName = new JTextField();
			textName.setBounds(94, 37, 100, 21);
			panel.add(textName);
			textName.setColumns(10);
			
			textModel = new JTextField();
			textModel.setColumns(10);
			textModel.setBounds(94, 117, 100, 21);
			panel.add(textModel);
			
			textInprice = new JTextField();
			textInprice.setColumns(10);
			textInprice.setBounds(94, 157, 100, 21);
			panel.add(textInprice);
			
			textOutprice = new JTextField();
			textOutprice.setColumns(10);
			textOutprice.setBounds(94, 197, 100, 21);
			panel.add(textOutprice);
			
		
			
			try {
				comboBox = new JComboBox(controller.getGoodsType());
			} catch (RemoteException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
				e1.printStackTrace();
			}
			comboBox.setBounds(94, 77, 120, 21);
			panel.add(comboBox);
			
			JButton button = new JButton("确定");
			button.setBounds(49, 268, 60, 23);
			panel.add(button);
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//TODO
					String type=(String)comboBox.getSelectedItem();
					String model=textModel.getText();
					String name=textName.getText();
					String id=type+"-"+model;
					GoodsModelVO goods=new GoodsModelVO(type,id,name,model);
					goods.setDefault_in(Double.valueOf(textInprice.getText()));
					goods.setDefault_out(Double.valueOf(textOutprice.getText()));
					
					tableModel.addRow(goods);
					goodsList.add(goods);
				}
				
			});
			JButton button_1 = new JButton("取消");
			button_1.setBounds(154, 268, 60, 23);
			panel.add(button_1);
			button_1.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
				
			});
		}
	}
}
