package presentation.RepositoryCheckui;

import javax.swing.SwingUtilities;

public class RepositoryCheckDriver {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				new Gui();
			}

		});
	}


}
