package presentation.LoginUI;


import presentation.RepoUI.MainFrame;

import javax.swing.*;


public class Beginer {
	
	public static void main(String[] args) {
		MainFrame.look_and_feel();

		SwingUtilities.invokeLater(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				new Gui();
			}
			
		});
	}
	
	
}
