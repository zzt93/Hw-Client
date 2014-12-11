package presentation.Saleui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import businesslogic.Adminbl.AdminController;
import businesslogic.Clientbl.ClientUtilityImpl;
import businesslogic.Salebl.SaleUtilityImpl;
import businesslogic.Stockbl.StockUtilityImpl;
import businesslogic.Strategybl.StrategyList;
import po.ClientPO;
import po.ClientType;
import po.ProductsReceipt;
import po.SaleReceiptPO;
import po.StockReceiptPO;
import po.StrategyPO;
import presentation.mainui.ModelType;
import presentation.mainui.PublicTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author zzt
 */
public class SaleUI extends JPanel {
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel custom_label;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JComboBox boxType;
    private JLabel labelCoupon;
    private JLabel jLabel11;
    private JLabel labelActualValue;
    private JLabel jLabel13;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    public static JLabel labelTotal;
    private JLabel jLabel7;
    private JLabel labelAllowance;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTable jTable1;
    private JComboBox boxClient;
    private JTextField textSalesman;
    private JTextField textRepository;
    private JTextPane textComment;
    private JLabel operator_label;
    private JPanel sale;
    
    List<StrategyPO> strategyList;
    private StrategyList strategyController;
    public static double total; 
    List<ClientPO> clientList;
    private SaleUtilityImpl saleController;
    private PublicTableModel tableModel=new PublicTableModel(ModelType.PRODUCTS);
    private SaleReceiptPO saleReceipt;
    private Vector<ProductsReceipt> prList=new Vector<ProductsReceipt>();
    private GoodsPanel goodsPane;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form sale1
     */
    public SaleUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new JScrollPane();
        sale = new JPanel();
        custom_label = new JLabel();
        operator_label = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        textSalesman = new JTextField();
        textRepository = new JTextField();
        boxType = new JComboBox();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jPanel1 = new JPanel();
        jLabel13 = new JLabel();
        jScrollPane2 = new JScrollPane();
        textComment = new JTextPane();
        jPanel2 = new JPanel();
        jLabel5 = new JLabel();
        labelTotal = new JLabel();
        jLabel7 = new JLabel();
        labelAllowance = new JLabel();
        jLabel9 = new JLabel();
        labelCoupon = new JLabel();
        jLabel11 = new JLabel();
        labelActualValue = new JLabel();
        jPanel3 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();

//      FIXME,涉及服务器，暂时无法测试
        ClientUtilityImpl client;
		try {
			saleController= new SaleUtilityImpl();
			HashMap<String,Object> map=new HashMap<String,Object>();
			map.put("type",ClientType.SELLER);
			client = new ClientUtilityImpl();
			try {
				clientList=client.queryClient(map);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "服务器出现问题");
			System.exit(ERROR);
		} catch (NotBoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "服务器出现问题");
			System.exit(ERROR);
		}
		String[] temp=new String[clientList.size()];
		for(int i=0;i<temp.length;i++){
			temp[i]=clientList.get(i).getName();
		}
		boxClient = new JComboBox(temp);
//      	boxClient=new JComboBox(new String[]{"张三","李四"});
        boxType=new JComboBox(new String[]{"销售","销售退货"});
        boxType.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(boxType.getSelectedIndex()==1){
					jButton2.setEnabled(false);
				}else{
					jButton2.setEnabled(true);
				}
			}
        	
        });
        
        jScrollPane3.setPreferredSize(new java.awt.Dimension(750, 500));

        sale.setPreferredSize(new java.awt.Dimension(850, 650));

        custom_label.setText("销售商");

        operator_label.setText("业务员");

        jLabel3.setText("仓库");

        jLabel4.setText("单据类型");
        
       
        textSalesman.setText("请输入业务员");
        textRepository.setText("请输入仓库");

        jTable1.setModel(tableModel);
        jScrollPane1.setViewportView(jTable1);

        jLabel13.setText("备注");

        jScrollPane2.setViewportView(textComment);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel13)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel13)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jLabel5.setText("折让前总额：");

        labelTotal.setText("");

        jLabel7.setText("折让：");

        labelAllowance.setText("");

        jLabel9.setText("代金券：");

        labelCoupon.setText("");

        jLabel11.setText("折让后总额：");

        labelActualValue.setText("");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(labelTotal)
                .addGap(65, 65, 65)
                .addComponent(jLabel7)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAllowance)
                .addGap(83, 83, 83)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(labelCoupon)
                .addGap(58, 58, 58)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(labelActualValue)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelTotal)
                    .addComponent(jLabel7)
                    .addComponent(labelAllowance)
                    .addComponent(jLabel9)
                    .addComponent(labelCoupon)
                    .addComponent(jLabel11)
                    .addComponent(labelActualValue))
                .addContainerGap())
        );

        jButton1.setText("添加商品");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("选择促销策略");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.setText("生成单据");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addGap(145, 145, 145)
                .addComponent(jButton2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(74, 74, 74))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        GroupLayout saleLayout = new GroupLayout(sale);
        sale.setLayout(saleLayout);
        saleLayout.setHorizontalGroup(
            saleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(saleLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(custom_label)
                .addGap(18, 18, 18)
                .addComponent(boxClient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(operator_label)
                .addGap(18, 18, 18)
                .addComponent(textSalesman, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(textRepository, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(boxType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(saleLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 709, GroupLayout.PREFERRED_SIZE))
            .addGroup(saleLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(saleLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(saleLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        saleLayout.setVerticalGroup(
            saleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(saleLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(saleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(boxClient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textSalesman, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textRepository, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(saleLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(saleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(custom_label)
                            .addComponent(operator_label)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane3.setViewportView(sale);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	goodsPane=new GoodsPanel(prList,tableModel,GoodsPaneType.SALE); 
    	goodsPane.showAddPane();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	//FIXME,注释掉
    	setSaleReceipt();
    	try {
			strategyList=strategyController.queryValidStrategy(saleReceipt);
			StrategyPane strategyPane=new StrategyPane();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
    	//StrategyPane strategyPane=new StrategyPane();
   }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	if(saleReceipt==null){
        	setSaleReceipt();
    	}
    	try {
			saleController.makeReceipt(saleReceipt);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
   }//GEN-LAST:event_jButton1ActionPerformed
    public void setSaleReceipt(){
    	//FIXME,测试注释掉
    	ClientPO client=clientList.get(boxClient.getSelectedIndex());
    	//FIXME,操作员get
    	//int id=123;
    	AdminController adminController;
    	String operator=null;
		try {
			adminController = new AdminController();
			operator=adminController.getUser();
		} catch (RemoteException | NotBoundException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2.getMessage());
			e2.printStackTrace();
		}
    	
    	saleReceipt=new SaleReceiptPO(
    			client.getId(),
    			textRepository.getText(),
    			operator,
    			textComment.getText(),
    			new BigDecimal(total));
    	saleReceipt.setProductList(prList);
    	saleReceipt.setClient(client.getName());
    }
    public class StrategyPane{
    	private JFrame frame;
    	private JTextField textDiscount;
    	private JTextField textCoupon;
    	JComboBox boxStrategy;
    	private JTable table;
    	private PublicTableModel giftModel;
    	public StrategyPane(){
    		initialize();
    	}
    	private void initialize() {
    		frame = new JFrame();
    		frame.setBounds(100, 100,600, 300);
    		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		
    		JPanel panel = new JPanel();
    		frame.getContentPane().add(panel, BorderLayout.CENTER);
    		panel.setLayout(null);
    		
    		JLabel label1 = new JLabel("策略选择：");
    		label1.setBounds(30, 30, 60, 15);
    		panel.add(label1);
    		String[] temp=new String[strategyList.size()];
    		for(int i=0;i<temp.length;i++){
    			temp[i]="策略"+String.valueOf(i+1);
    		}
    		boxStrategy = new JComboBox(temp);
    		boxStrategy.setBounds(84, 27, 80, 21);
    		boxStrategy.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent e) {
					refresh(strategyList.get(boxStrategy.getSelectedIndex()));
				}
    		});
    		panel.add(boxStrategy);
    		
    		JLabel label2 = new JLabel("折扣：");
    		label2.setBounds(30, 70, 54, 15);
    		panel.add(label2);
    		
    		textDiscount = new JTextField();
    		textDiscount.setBounds(84, 67, 80, 21);
    		panel.add(textDiscount);
    		textDiscount.setColumns(10);
    		textDiscount.setEditable(false);
    		
    		JLabel label3 = new JLabel("代金券：");
    		label3.setBounds(30, 111, 54, 15);
    		panel.add(label3);
    		
    		textCoupon = new JTextField();
    		textCoupon.setBounds(84, 108, 80, 21);
    		panel.add(textCoupon);
    		textCoupon.setColumns(10);
    		textCoupon.setEditable(false);
    		
    		JScrollPane scrollPane = new JScrollPane();
    		scrollPane.setBounds(203, 63, 357, 189);
    		panel.add(scrollPane);
    		
    		giftModel=new PublicTableModel(ModelType.GIFT);
    		table = new JTable(giftModel);
    		scrollPane.setViewportView(table);
    		
    		JLabel label4 = new JLabel("商品赠送:");
    		label4.setBounds(352, 30, 54, 15);
    		panel.add(label4);
    		
    		JButton btnRight = new JButton("确定");
    		btnRight.setBounds(30, 210, 60, 23);
    		btnRight.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					calculate();
				}
    			
    		});
    		panel.add(btnRight);
    		
    		JButton btnCancel = new JButton("取消");
    		btnCancel.setBounds(100, 210, 60, 23);
    		btnCancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
    			
    		});
    		panel.add(btnCancel);
    		
    		refresh(strategyList.get(0));
    		frame.setVisible(true);
    	}
    	 public void calculate(){
    	    	try {
					saleReceipt=strategyController.setTreatment(strategyList.get(boxStrategy.getSelectedIndex()), saleReceipt);
					labelAllowance.setText(saleReceipt.getAllowance().toString());
					labelCoupon.setText(saleReceipt.getCoupon().toString());
					labelActualValue.setText(saleReceipt.getActualValue().toString());
    	    	} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
    	    }
    	 public void refresh(StrategyPO po){
    		 textDiscount.setText(String.valueOf(po.getTreatment().getDiscount()));
    		 textCoupon.setText(String.valueOf(po.getTreatment().getCoupon()));
    		 giftModel.update(po.getTreatment().getGive());
    	 }
    }
 
    
}
