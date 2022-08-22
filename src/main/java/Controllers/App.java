package Controllers;

import Models.DB;
import com.formdev.flatlaf.intellijthemes.FlatVuesionIJTheme;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;

public class App {

	public static void main(String[] args) {

		try {
			FlatVuesionIJTheme.setup();
			DB db = DB.GetInstance();
			db.CreateTable("Images", new HashMap<>() {{
				put("ImageID", "INTEGER PRIMARY KEY");
				put("ImageName", "VARCHAR");
				put("ImagePath", "VARCHAR");
				put("ImageText", "VARCHAR");
				put("ImageSize", "VARCHAR");
				put("GotText", "INTEGER");
			}});
			MainController view = new MainController();
			JFrame frame = new JFrame();

			frame.setContentPane(view.getView());
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
			view.loadFromDB();
		} catch (Exception ex) {
			System.err.println(ex.getMessage() + Arrays.toString(ex.getStackTrace()));
		}


	}
}
