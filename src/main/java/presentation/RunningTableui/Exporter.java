package presentation.RunningTableui;

import java.io.*;   

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.*;   
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Exporter {
	private JTable table;
	public Exporter(JTable table){
		this.table=table;
		select();
	}
	public Exporter(){
		
	}
	public String select(){
		JFileChooser exporter = new JFileChooser();
		//设置选择框
		exporter.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
		exporter.setApproveButtonText("Export");
		exporter.setApproveButtonToolTipText("Export it to this path");
		exporter.setDialogTitle("Export excel to ...");
		exporter.setFileFilter(new FileFilter() {

			public boolean accept(File f) {
				return f.getName().contains(".xls");
			}

			public String getDescription() {
				return "Excel";
			}
		});
		//处理选择
		int result = exporter.showSaveDialog(exporter);
		if (result == JFileChooser.APPROVE_OPTION) {
			//TODO,获得路径开始写入
			File tempFile=exporter.getSelectedFile();
			File excel;
			if(!tempFile.getName().endsWith(".xls")){
				excel=new File(tempFile.getParent(),tempFile.getName()+".xls");
			}else{
				excel=tempFile;
			}
			if(excel.exists()){
				JOptionPane.showMessageDialog(null, "已存在同名文件");
				return null;
			}else{
				//TODO,调用creatExcel
				createExcel(excel);
				return excel.getPath();
			}
		} else if (result == JFileChooser.CANCEL_OPTION) {
			//取消
			return null;
		}
		return null;
	}
	private void createExcel(File file){
		try {
			WritableWorkbook book=Workbook.createWorkbook(file);
			WritableSheet sheet=book.createSheet("firse page",0);
			int rowNum=table.getRowCount();
			int columnNum=table.getColumnCount();
			try {
				for(int i=0;i<columnNum;i++){
					for(int j=0;i<rowNum;j++){
						Label label=new Label(i,j,(String)table.getValueAt(i, j));
						sheet.addCell(label);
					}
				}
			} catch (RowsExceededException e) {
				JOptionPane.showMessageDialog(null, "行数溢出");
				e.printStackTrace();
			} catch (WriteException e) {
				JOptionPane.showMessageDialog(null, "写文件时发生错误");
				e.printStackTrace();
			}
			book.write();
			try {
				book.close();
			} catch (WriteException e) {
				JOptionPane.showMessageDialog(null,"导出的文件无法关闭");
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "导出EXCEL的过程中遇到了问题");
			e.printStackTrace();
		}
		
	}
	

}
