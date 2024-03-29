/*
 * Created by JFormDesigner on Wed Mar 23 17:03:21 CAT 2022
 */

package Views;

import javax.swing.*;
import java.awt.*;

/**
 * @author Tyler
 */
public class MainView extends JPanel {



	public MainView() {
		initComponents();
		MainScrollPane.getViewport().add(ListPane);
	}


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Tyler
		AddImagesButton = new JButton();
		MainScrollPane = new JScrollPane();
		ListPane = new JPanel();
		GetAllTextButton = new JButton();

		//======== this ========
		setMaximumSize(new Dimension(1280, 800));
		setMinimumSize(new Dimension(785, 520));
		setPreferredSize(new Dimension(1280, 800));
		setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder ( 0
		, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM
		, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,
		 getBorder () ) );  addPropertyChangeListener(e -> { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;});

		//---- AddImagesButton ----
		AddImagesButton.setText("ADD IMAGES");

		//======== MainScrollPane ========
		{
			MainScrollPane.setBorder(null);
			MainScrollPane.setMaximumSize(new Dimension(1280, 32767));
			MainScrollPane.setInheritsPopupMenu(true);

			//======== ListPane ========
			{
				ListPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				ListPane.setLayout(new GridLayout(0, 4, 10, 10));
			}
			MainScrollPane.setViewportView(ListPane);
		}

		//---- GetAllTextButton ----
		GetAllTextButton.setText("GET ALL TEXT");

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addGap(0, 0, Short.MAX_VALUE)
							.addComponent(GetAllTextButton)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(AddImagesButton))
						.addComponent(MainScrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(MainScrollPane, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
					.addGap(12, 12, 12)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(AddImagesButton)
						.addComponent(GetAllTextButton)))
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Tyler
	public JButton AddImagesButton;
	public JScrollPane MainScrollPane;
	public JPanel ListPane;
	public JButton GetAllTextButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
