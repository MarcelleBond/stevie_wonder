package Controllers;

import Models.DB;
import Views.MainView;
import com.formdev.flatlaf.intellijthemes.FlatVuesionIJTheme;
import javax.swing.*;
import java.util.HashMap;

public class App {

	public static void main(String[] args) {

		try {
			DB db = DB.GetInstance();
			db.CreateTable("Images", new HashMap<>() {{
				put("ImageName", "NVARCHAR");
				put("ImagePath", "NVARCHAR");
				put("ImageText", "NVARCHAR");
			}});
			FlatVuesionIJTheme.setup();
		} catch( Exception ex ) {
			System.err.println( ex.getMessage() + ex.getStackTrace() );
		}
		JFrame frame = new JFrame();
		frame.setContentPane(new MainView());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
