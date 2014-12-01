package presentation.RepoUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Point;
import java.awt.Rectangle;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import po.TreeNodePO;
import vo.TreeNodeVO;
import businesslogic.GoodsTypebl.GT_controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zzt
 */
public class GoodsTypePanel extends javax.swing.JPanel {

	public static int NODE_W = 226;
	public static int NODE_H = 202;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creates new form GoodsTypePanel
	 */
	GT_controller gt_controller;
	HashMap<TreeNodePO, NodePanel> nodes = new HashMap<TreeNodePO, NodePanel>();
	ArrayList<TreeNodePO> treeNodePOs;

	public GoodsTypePanel() {
		try {
			gt_controller = new GT_controller();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(MainFrame.frame,
					"Fail to fetch data--GT_controller");
		}
		treeNodePOs = gt_controller.getTreeNodePOs();
		for (TreeNodePO treeNodePO : treeNodePOs) {
			nodes.put(treeNodePO, new NodePanel(treeNodePO));
		}

		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		GT_navigator = new javax.swing.JToolBar();
		repo_navi = new javax.swing.JButton();
		filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0),
				new java.awt.Dimension(20, 0),
				new java.awt.Dimension(20, 32767));
		rece_navi = new javax.swing.JButton();
		filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0),
				new java.awt.Dimension(20, 0),
				new java.awt.Dimension(20, 32767));
		log_out = new javax.swing.JButton();
		trees_scroll_panel = new javax.swing.JScrollPane();

		tree_panel = new TreePanel();

		setPreferredSize(new java.awt.Dimension(800, 600));

		GT_navigator.setFloatable(false);
		GT_navigator.setRollover(true);

		repo_navi.setText("库存管理");
		repo_navi.setFocusable(false);
		repo_navi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		repo_navi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		repo_navi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				repo_naviActionPerformed(evt);
			}
		});
		GT_navigator.add(repo_navi);
		GT_navigator.add(filler1);

		rece_navi.setText("单据管理");
		rece_navi.setFocusable(false);
		rece_navi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		rece_navi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		rece_navi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rece_naviActionPerformed(evt);
			}
		});
		GT_navigator.add(rece_navi);
		GT_navigator.add(filler2);

		log_out.setText("退出登录");
		log_out.setFocusable(false);
		log_out.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		log_out.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		log_out.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				log_outActionPerformed(evt);
			}
		});
		GT_navigator.add(log_out);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														trees_scroll_panel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														776, Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(11, 11,
																		11)
																.addComponent(
																		GT_navigator,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		372,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(0,
																		0,
																		Short.MAX_VALUE)))
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGap(18, 18, 18)
						.addComponent(GT_navigator,
								javax.swing.GroupLayout.PREFERRED_SIZE, 25,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(trees_scroll_panel,
								javax.swing.GroupLayout.DEFAULT_SIZE, 527,
								Short.MAX_VALUE).addContainerGap()));
	}// </editor-fold>//GEN-END:initComponents

	private void repo_naviActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_repo_naviActionPerformed

		CardLayout card = (CardLayout) MainFrame.frame.getContentPane()
				.getLayout();
		card.show(MainFrame.frame.getContentPane(), "main_card");
		MainFrame.tab_pane.setSelectedIndex(2);
	}// GEN-LAST:event_repo_naviActionPerformed

	private void rece_naviActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rece_naviActionPerformed

		CardLayout card = (CardLayout) MainFrame.frame.getContentPane()
				.getLayout();
		card.show(MainFrame.frame.getContentPane(), "main_card");
		MainFrame.tab_pane.setSelectedIndex(1);
	}// GEN-LAST:event_rece_naviActionPerformed

	private void log_outActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_log_outActionPerformed

		CardLayout card = (CardLayout) MainFrame.frame.getContentPane()
				.getLayout();
		card.show(MainFrame.frame.getContentPane(), "main_card");
		MainFrame.tab_pane.setSelectedIndex(3);
	}// GEN-LAST:event_log_outActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JToolBar GT_navigator;
	private javax.swing.Box.Filler filler1;
	private javax.swing.Box.Filler filler2;
	private javax.swing.JButton log_out;
	private javax.swing.JButton rece_navi;
	private javax.swing.JButton repo_navi;
	private javax.swing.JPanel tree_panel;
	private javax.swing.JScrollPane trees_scroll_panel;

	// End of variables declaration//GEN-END:variables

	public class TreePanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public TreePanel() {
			
			this.setPreferredSize(new java.awt.Dimension(2000 + NODE_W*gt_controller.getTreeNodePOs().size()/2,
					1000 + NODE_H*gt_controller.height()));
			this.setLayout(new java.awt.GridBagLayout());
	        trees_scroll_panel.setViewportView(this);
			
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // Do the original draw
			this.setPreferredSize(new java.awt.Dimension(2000 + NODE_W*gt_controller.getTreeNodePOs().size()/2,
					1000 + NODE_H*gt_controller.height()));
			Rectangle bounds = trees_scroll_panel.getViewport().getViewRect();
	        Dimension size = trees_scroll_panel.getViewport().getViewSize();
	        int x = (size.width - bounds.width) / 2;
	        int y = (size.height - bounds.height) / 2;
	        trees_scroll_panel.getViewport().setViewPosition(new Point(x, y));
	        
	        TreeNodePO fa = treeNodePOs.get(0);
	        
	        int initial = (treeNodePOs.size()/2>=4)?treeNodePOs.size()-1:3;
	        draw_node(fa, 0, initial);
	        
			setAntiAliasing(g, true);
			mydrawline(g, fa);
		}

		private void draw_node(TreeNodePO fa, int height, int row) {
			while (fa != null) {
				GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
				
		        gridBagConstraints.gridx = row;
		        gridBagConstraints.gridy = height;
		        tree_panel.add(nodes.get(treeNodePOs.get(0)), gridBagConstraints);
		        
		        int i = 0;
		        for (TreeNodePO treeNodePO : fa.getSons()) {
					fa = treeNodePO;
					draw_node(fa, height+1, row+i);
					++i;
				}
			}
	    }

		public void mydrawline(Graphics g, TreeNodePO fa) {
			NodePanel fa_panNodePanel = nodes.get(fa);
			while (fa != null) {
				int[] fa_loc = new int[] {
						fa_panNodePanel.getX() + fa_panNodePanel.getWidth() / 2,
						fa_panNodePanel.getY() + fa_panNodePanel.getHeight() };
				for (TreeNodePO son : fa.getSons()) {
					NodePanel sonNodePanel = nodes.get(son);

					int[] son_loc = new int[] {
							sonNodePanel.getX() + sonNodePanel.getWidth() / 2,
							sonNodePanel.getY() + sonNodePanel.getHeight() };
					g.drawLine(fa_loc[0], fa_loc[1], son_loc[0], son_loc[1]);

					fa = son;
					mydrawline(g, fa);
				}
			}
		}

		public final void setAntiAliasing(Graphics g, boolean yesno) {
			Object obj = yesno ? RenderingHints.VALUE_ANTIALIAS_ON
					: RenderingHints.VALUE_ANTIALIAS_OFF;

			Graphics2D g2d = (Graphics2D) g;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, obj);
	        g2d.setStroke(new BasicStroke(4,
	            BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		}
	}

	public class NodePanel extends javax.swing.JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * Creates new form NodePanel
		 */
		String type_info;
		String type_so_far;
		TreeNodePO treeNodePO_in_nodepanel;
		
		public NodePanel(TreeNodePO po) {
			type_info = po.getType();
			type_so_far = po.getType_so_far();
			treeNodePO_in_nodepanel = po;
			initComponents();
		}

		/**
		 * This method is called from within the constructor to initialize the
		 * form. WARNING: Do NOT modify this code. The content of this method is
		 * always regenerated by the Form Editor.
		 */
		@SuppressWarnings("unchecked")
		// <editor-fold default state="collapsed"
		// desc="Generated Code">//GEN-BEGIN:initComponents
		private void initComponents() {

			add = new javax.swing.JButton();
			add.setVisible(false);
			del = new javax.swing.JButton();
			del.setVisible(false);
			check = new javax.swing.JButton();
			check.setVisible(false);
			jPanel1 = new javax.swing.JPanel();
			type = new javax.swing.JLabel();

			setBackground(javax.swing.UIManager.getDefaults().getColor("white"));
			setOpaque(false);
			addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseExited(java.awt.event.MouseEvent evt) {
					formMouseExited(evt);
				}

				public void mouseEntered(java.awt.event.MouseEvent evt) {
					formMouseEntered(evt);
				}
			});

			add.setText("+");
			add.setToolTipText("在此类下添加新类型");
			add.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					addMouseEntered(evt);
				}
			});
			add.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					addActionPerformed(evt);
				}
			});

			del.setText("-");
			del.setToolTipText("删除此节点");
			del.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					delMouseEntered(evt);
				}
			});
			del.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					delActionPerformed(evt);
				}
			});

			check.setText("?");
			check.setToolTipText("详细信息");
			check.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					checkMouseEntered(evt);
				}
			});
			check.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					checkActionPerformed(evt);
				}
			});

			type.setText(type_info);

			javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
					jPanel1);
			jPanel1.setLayout(jPanel1Layout);
			jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING).addGroup(
					jPanel1Layout.createSequentialGroup().addContainerGap()
							.addComponent(type).addContainerGap()));
			jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING).addGroup(
					jPanel1Layout.createSequentialGroup().addContainerGap()
							.addComponent(type).addContainerGap()));

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
			this.setLayout(layout);
			layout.setHorizontalGroup(layout
					.createParallelGroup(
							javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(
							layout.createSequentialGroup()
									.addGap(72, 72, 72)
									.addComponent(
											jPanel1,
											javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addContainerGap(74, Short.MAX_VALUE))
					.addGroup(
							javax.swing.GroupLayout.Alignment.TRAILING,
							layout.createSequentialGroup()
									.addGap(37, 37, 37)
									.addComponent(del)
									.addPreferredGap(
											javax.swing.LayoutStyle.ComponentPlacement.RELATED,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE)
									.addGroup(
											layout.createParallelGroup(
													javax.swing.GroupLayout.Alignment.LEADING)
													.addComponent(check)
													.addComponent(add))
									.addGap(50, 50, 50)));
			layout.setVerticalGroup(layout
					.createParallelGroup(
							javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(
							layout.createSequentialGroup()
									.addGap(32, 32, 32)
									.addGroup(
											layout.createParallelGroup(
													javax.swing.GroupLayout.Alignment.BASELINE)
													.addComponent(del)
													.addComponent(add))
									.addGap(18, 18, 18)
									.addComponent(
											jPanel1,
											javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addGap(18, 18, 18).addComponent(check)
									.addContainerGap(35, Short.MAX_VALUE)));
		}// </editor-fold>//GEN-END:initComponents

		private void formMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMouseEntered
			add.setVisible(true);
			del.setVisible(true);
			check.setVisible(true);

		}// GEN-LAST:event_formMouseEntered

		private void formMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMouseExited
			add.setVisible(false);
			del.setVisible(false);
			check.setVisible(false);
		}// GEN-LAST:event_formMouseExited

		private void addActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addActionPerformed
			String type = JOptionPane.showInputDialog("New type name:");
			boolean add_result = false;
			try {
				add_result = gt_controller.add(new TreeNodeVO(treeNodePO_in_nodepanel), type);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (add_result) {
				JOptionPane.showMessageDialog(MainFrame.frame, "Successfully added");
				//TODO update node 
				tree_panel.repaint();
			} else {
				JOptionPane.showMessageDialog(MainFrame.frame, "Fail to add");
			}
			
		}// GEN-LAST:event_addActionPerformed

		private void delActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_delActionPerformed
			boolean del_result = false;
			try {
				del_result = gt_controller.delete(new TreeNodeVO(treeNodePO_in_nodepanel));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (del_result) {
				JOptionPane.showMessageDialog(MainFrame.frame, "Successfully added");
				//TODO update node 
				tree_panel.repaint();
			} else {
				JOptionPane.showMessageDialog(MainFrame.frame, "Fail to del");
			}
		}// GEN-LAST:event_delActionPerformed

		private void checkActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_checkActionPerformed
			JLabel label1 = new JLabel("Full type:");
			JLabel label2 = new JLabel("Children:");
			JLabel full_type = new JLabel(type_so_far + "\n");// type so far and
																// \n
			String full_info = treeNodePO_in_nodepanel.toString();
			JLabel childern = new JLabel(full_info);
			JOptionPane.showMessageDialog(MainFrame.frame, new Object[] {
					label1, full_type, label2, childern });
		}// GEN-LAST:event_checkActionPerformed

		private void addMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addMouseEntered
			formMouseEntered(evt);
		}// GEN-LAST:event_addMouseEntered

		private void checkMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_checkMouseEntered
			formMouseEntered(evt);
		}// GEN-LAST:event_checkMouseEntered

		private void delMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_delMouseEntered
			formMouseEntered(evt);
		}// GEN-LAST:event_delMouseEntered

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // Do the original draw
			int radius = getRadius();
			int xOffset = (getWidth() - radius) / 2;
			int yOffset = (getHeight() - radius) / 2;

			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(Color.GREEN);
			g2d.fillOval(xOffset, yOffset, radius, radius);
			g2d.setColor(Color.GREEN);
			g2d.drawOval(xOffset, yOffset, radius, radius);
			// This is test code to test the insets/usable area bounds...
			// Insets insets = getInsets();
			// g2d.drawRect(xOffset + insets.left,
			// yOffset + insets.top,
			// (xOffset + radius) - (insets.right + insets.left),
			// (yOffset + radius) - (insets.bottom + insets.top));
			g2d.dispose();
		}

		 @Override
		 public Dimension getPreferredSize() {
		 return new Dimension(NODE_W, NODE_H);
		 }

		protected int getRadius() {
			// Determines the radius based on the smaller of the width
			// or height, so we stay symmetrical
			return Math.min(getWidth(), getHeight());
		}

		// Variables declaration - do not modify//GEN-BEGIN:variables
		private javax.swing.JButton add;
		private javax.swing.JButton check;
		private javax.swing.JButton del;
		private javax.swing.JPanel jPanel1;
		private javax.swing.JLabel type;
		// End of variables declaration//GEN-END:variables
	}

}
