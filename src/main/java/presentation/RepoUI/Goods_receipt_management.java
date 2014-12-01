package presentation.RepoUI;

import vo.GoodsReceiptVO;
import vo.GoodsVO;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zzt
 */
public class Goods_receipt_management extends javax.swing.JPanel {

    /**
     * Creates new form Goods_receipt
     */
    public Goods_receipt_management() {
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

        Repo_navigator = new javax.swing.JToolBar();
        goods_navi = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        repo_navi = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        log_out = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        show_rece = new javax.swing.JButton();
        change = new javax.swing.JPanel();
        make = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gift_table = new javax.swing.JTable();
        buttons = new javax.swing.JPanel();
        produce = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        goods_id = new javax.swing.JComboBox();
        del = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        show = new javax.swing.JPanel();
        show_buttons = new javax.swing.JPanel();
        back = new javax.swing.JPanel()
        ;
        goods_rece2 = new Goods_rece();
        rece_buttons = new javax.swing.JPanel();
        layerList = new javax.swing.JComboBox(layerStrings);
        back_make = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        Repo_navigator.setFloatable(false);
        Repo_navigator.setRollover(true);

        goods_navi.setText("商品管理");
        goods_navi.setFocusable(false);
        goods_navi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        goods_navi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        goods_navi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goods_naviActionPerformed(evt);
            }
        });
        Repo_navigator.add(goods_navi);
        Repo_navigator.add(filler1);

        repo_navi.setText("库存管理");
        repo_navi.setFocusable(false);
        repo_navi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        repo_navi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        repo_navi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repo_naviActionPerformed(evt);
            }
        });
        Repo_navigator.add(repo_navi);
        Repo_navigator.add(filler2);

        log_out.setText("退出登录");
        log_out.setFocusable(false);
        log_out.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        log_out.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        log_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_outActionPerformed(evt);
            }
        });
        Repo_navigator.add(log_out);
        Repo_navigator.add(filler3);

        show_rece.setText("查看单据");
        show_rece.setFocusable(false);
        show_rece.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        show_rece.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        show_rece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_receActionPerformed(evt);
            }
        });
        Repo_navigator.add(show_rece);

        change.setLayout(new java.awt.CardLayout());

        gift_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "商品名", "商品id", "数量"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gift_table.setColumnSelectionAllowed(true);
        gift_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(gift_table);
        gift_table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (gift_table.getColumnModel().getColumnCount() > 0) {
            gift_table.getColumnModel().getColumn(0).setResizable(false);
            gift_table.getColumnModel().getColumn(1).setResizable(false);
            gift_table.getColumnModel().getColumn(2).setResizable(false);
        }

        produce.setText("确定提交");
        produce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produceActionPerformed(evt);
            }
        });

        jLabel2.setText("商品id：");

        goods_id.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        

        del.setText("删除");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });

        add.setText("添加");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel1.setText("数量：");

        amount.setText("jTextField1");

        javax.swing.GroupLayout buttonsLayout = new javax.swing.GroupLayout(buttons);
        buttons.setLayout(buttonsLayout);
        buttonsLayout.setHorizontalGroup(
            buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buttonsLayout.createSequentialGroup()
                        .addGap(0, 127, Short.MAX_VALUE)
                        .addComponent(add)
                        .addGap(16, 16, 16))
                    .addGroup(buttonsLayout.createSequentialGroup()
                        .addGroup(buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(del)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(goods_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(produce)
                .addGap(61, 61, 61))
        );
        buttonsLayout.setVerticalGroup(
            buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goods_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(del))
                .addGap(18, 18, 18)
                .addComponent(produce)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout makeLayout = new javax.swing.GroupLayout(make);
        make.setLayout(makeLayout);
        makeLayout.setHorizontalGroup(
            makeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(makeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        makeLayout.setVerticalGroup(
            makeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(makeLayout.createSequentialGroup()
                .addGroup(makeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(makeLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(makeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        change.add(make, "make");

        javax.swing.GroupLayout show_buttonsLayout = new javax.swing.GroupLayout(show_buttons);
        show_buttons.setLayout(show_buttonsLayout);
        show_buttonsLayout.setHorizontalGroup(
            show_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );
        show_buttonsLayout.setVerticalGroup(
            show_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backLayout = new javax.swing.GroupLayout(back);
        back.setLayout(backLayout);
        backLayout.setHorizontalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(goods_rece2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        backLayout.setVerticalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backLayout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addComponent(goods_rece2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layerList.setSelectedIndex(2);    //cyan layer
        layerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layerListActionPerformed(evt);
            }
        });

        back_make.setText("返回");
        back_make.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_makeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rece_buttonsLayout = new javax.swing.GroupLayout(rece_buttons);
        rece_buttons.setLayout(rece_buttonsLayout);
        rece_buttonsLayout.setHorizontalGroup(
            rece_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rece_buttonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rece_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(layerList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back_make))
                .addContainerGap())
        );
        rece_buttonsLayout.setVerticalGroup(
            rece_buttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rece_buttonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back_make)
                .addGap(18, 18, 18)
                .addComponent(layerList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout showLayout = new javax.swing.GroupLayout(show);
        show.setLayout(showLayout);
        showLayout.setHorizontalGroup(
            showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(show_buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(showLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rece_buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        showLayout.setVerticalGroup(
            showLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rece_buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(show_buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
            .addGroup(showLayout.createSequentialGroup()
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 76, Short.MAX_VALUE))
        );

        change.add(show, "show");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Repo_navigator, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(Repo_navigator, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(change, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void show_receActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_receActionPerformed
        
        CardLayout cardlayout = (CardLayout) change.getLayout();
        cardlayout.show(change, "show");
    }//GEN-LAST:event_show_receActionPerformed

    private void back_makeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_makeActionPerformed
        
        CardLayout cardlayout = (CardLayout) change.getLayout();
        cardlayout.show(change, "make");
    }//GEN-LAST:event_back_makeActionPerformed

    private void goods_naviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goods_naviActionPerformed
        
        CardLayout card = (CardLayout) MainFrame.frame.getContentPane().getLayout();
        card.show(MainFrame.frame.getContentPane(), "main_card");
        MainFrame.tab_pane.setSelectedIndex(0);
    }//GEN-LAST:event_goods_naviActionPerformed

    private void repo_naviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repo_naviActionPerformed
        
        CardLayout card = (CardLayout) MainFrame.frame.getContentPane().getLayout();
        card.show(MainFrame.frame.getContentPane(), "main_card");
        MainFrame.tab_pane.setSelectedIndex(2);
    }//GEN-LAST:event_repo_naviActionPerformed

    private void log_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_outActionPerformed
        
        CardLayout card = (CardLayout) MainFrame.frame.getContentPane().getLayout();
        card.show(MainFrame.frame.getContentPane(), "log_card");
    }//GEN-LAST:event_log_outActionPerformed

    private void layerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layerListActionPerformed
        String cmd = evt.getActionCommand();
       
    }//GEN-LAST:event_layerListActionPerformed

    
    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void produceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produceActionPerformed
        // TODO get goods and user
    	ArrayList<GoodsVO> goodsVOs = new ArrayList<GoodsVO>();
    	
    	String date = new Date().toString();
    	new GoodsReceiptVO(goodsVOs, date, "user");
    	
    }//GEN-LAST:event_produceActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar Repo_navigator;
    private javax.swing.JButton add;
    private javax.swing.JTextField amount;
    private javax.swing.JPanel back;
    private javax.swing.JButton back_make;
    private javax.swing.JPanel buttons;
    private javax.swing.JPanel change;
    private javax.swing.JButton del;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JTable gift_table;
    private javax.swing.JComboBox goods_id;
    private javax.swing.JButton goods_navi;
    private Goods_rece goods_rece2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox layerList;
    private javax.swing.JButton log_out;
    private javax.swing.JPanel make;
    private javax.swing.JButton produce;
    private javax.swing.JPanel rece_buttons;
    private javax.swing.JButton repo_navi;
    private javax.swing.JPanel show;
    private javax.swing.JPanel show_buttons;
    private javax.swing.JButton show_rece;
    // End of variables declaration//GEN-END:variables
    private String[] layerStrings = {"Yellow (0)", "Magenta (1)",
        "Cyan (2)", "Red (3)",
        "Green (4)"};
    private Color[] layerColors = {Color.yellow, Color.magenta,
        Color.cyan, Color.red,
        Color.green};

    
}