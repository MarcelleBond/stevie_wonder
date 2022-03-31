package Controllers;

import Views.MainView;
import com.formdev.flatlaf.intellijthemes.FlatVuesionIJTheme;
import javax.swing.*;

public class App {

	public static void main(String[] args) {



		try {
			FlatVuesionIJTheme.setup();
		} catch( Exception ex ) {
			System.err.println( "Failed to initialize LaF" );
		}
		JFrame frame = new JFrame();
		frame.setContentPane(new MainView());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
