package presentation.Stockui;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;

import businesslogic.Clientbl.ClientUtilityImpl;
import businesslogic.Stockbl.StockUtilityImpl;
import po.ClientPO;
import po.ClientType;
import po.ProductsReceipt;
import po.StockReceiptPO;
import presentation.Saleui.GoodsPaneType;
import presentation.Saleui.GoodsPanel;
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
public class StockUI extends JPanel {
	 // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel custom_label;
    private JButton jButton1;
    private JButton jButton2;
    private JComboBox boxType;
    private JLabel jLabel13;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    public static JLabel labelTotal;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTable GoodsTable;
    private JComboBox boxClient;
//    private JTextField textSalesman;
    private JTextField textRepository;
    private JTextPane textComment;
//    private JLabel operator_label;
    private JPanel sale;
    List<ClientPO> clientList;
    public static double total;
    private StockUtilityImpl stockController;
    private PublicTableModel tableModel=new PublicTableModel(ModelType.PRODUCTS);
    private StockReceiptPO stockReceipt;
    private Vector<ProductsReceipt> list=new Vector<ProductsReceipt>();
    private GoodsPanel goodsPane;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form Stock1
     */
    public StockUI() {
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
//        operator_label = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5=new JLabel();
        labelTotal=new JLabel();
 //       textSalesman = new JTextField();
        textRepository = new JTextField();
        jScrollPane1 = new JScrollPane();
        GoodsTable = new JTable();
        jPanel1 = new JPanel();
        jLabel13 = new JLabel();
        jScrollPane2 = new JScrollPane();
        textComment = new JTextPane();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
       //FIXME,涉及服务器，暂时无法测试
        ClientUtilityImpl client;
		try {
	        stockController= new StockUtilityImpl();
	        HashMap<String,Object> map=new HashMap<String,Object>();
	        map.put("type",ClientType.STOCKER);
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
        //boxClient=new JComboBox(new String[]{"张三","李四"});
        boxType = new JComboBox(new String[]{"进货","进货退货"});
        
        jScrollPane3.setPreferredSize(new java.awt.Dimension(750, 500));

        sale.setPreferredSize(new java.awt.Dimension(850, 650));

        custom_label.setText("供应商");

//        operator_label.setText("业务员");

        jLabel3.setText("仓库");

        jLabel4.setText("单据类型");


//        textSalesman.setText("请输入业务员");

        textRepository.setText("请输入仓库");
        
        

        GoodsTable.setModel(tableModel);
        jScrollPane1.setViewportView(GoodsTable);

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
        jLabel5.setText("总额：");

        labelTotal.setText("");	
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
//                .addComponent(jLabel7)
//                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                .addComponent(jLabel8)
//                .addGap(83, 83, 83)
//                .addComponent(jLabel9)
//                .addGap(18, 18, 18)
//                .addComponent(jLabel10)
//                .addGap(58, 58, 58)
//                .addComponent(jLabel11)
//                .addGap(18, 18, 18)
//                .addComponent(jLabel12)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelTotal)
//                    .addComponent(jLabel7)
//                    .addComponent(jLabel8)
//                    .addComponent(jLabel9)
//                    .addComponent(jLabel10)
//                    .addComponent(jLabel11)
//                    .addComponent(jLabel12)
                    )
                .addContainerGap())
        );

        jButton1.setText("添加商品");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });



        jButton2.setText("制定单据");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton1)
//                .addGap(145, 145, 145)
//                .addComponent(jButton2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(74, 74, 74))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
//                    .addComponent(jButton3))
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
         //       .addComponent(operator_label)
            //    .addGap(18, 18, 18)
           //     .addComponent(textSalesman, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            //    .addGap(34, 34, 34)
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
                   // .addComponent(textSalesman, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textRepository, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(saleLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(saleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(custom_label)
                            //.addComponent(operator_label)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	goodsPane=new GoodsPanel(list,tableModel,GoodsPaneType.STOCK);
    	goodsPane.showAddPane();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	int id=clientList.get(boxClient.getSelectedIndex()).getId();
    	//FIXME,操作员get
    	stockReceipt=new StockReceiptPO(id,textRepository.getText(),
    			"操作员",textComment.getText(),new BigDecimal(total));
    	try {
			stockController.makeReceipt(stockReceipt);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	
    }//GEN-LAST:event_jButton1ActionPerformed


}
