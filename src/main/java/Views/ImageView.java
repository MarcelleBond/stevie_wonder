/*
 * Created by JFormDesigner on Fri Mar 25 12:23:39 CAT 2022
 */

package Views;

import javax.swing.*;
import java.awt.*;

/**
 * @author Tyler
 */
public class ImageView extends JPanel {

	public ImageView() {
		initComponents();
	}


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Tyler
		NameLable = new JLabel();
		Sizelabel = new JLabel();
		ImageTextlabel = new JLabel();
		ImageNameValue = new JLabel();
		ImageSizeValue = new JLabel();
		ImageView = new JLabel();
		GetTextButton = new JButton();
		TextScrollPane = new JScrollPane();
		ImageTextValue = new JTextArea();

		//======== this ========
		setMaximumSize(new Dimension(300, 400));
		setMinimumSize(new Dimension(150, 200));
		setPreferredSize(new Dimension(300, 400));
		setAlignmentX(0.0F);
		setAlignmentY(0.0F);
		setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0
				, 0, 0, 0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM
				, new java.awt.Font("Dia\u006cog", java.awt.Font.BOLD, 12), java.awt.Color.red),
				getBorder()));
		addPropertyChangeListener(e -> {
			if ("\u0062ord\u0065r".equals(e.getPropertyName())) throw new RuntimeException();
		});

		//---- NameLable ----
		NameLable.setText("Image Name");
		NameLable.setMaximumSize(new Dimension(78, 16));
		NameLable.setPreferredSize(new Dimension(78, 16));
		NameLable.setVerifyInputWhenFocusTarget(false);

		//---- Sizelabel ----
		Sizelabel.setText("Image Size");
		Sizelabel.setMaximumSize(new Dimension(78, 16));
		Sizelabel.setPreferredSize(new Dimension(78, 16));

		//---- ImageTextlabel ----
		ImageTextlabel.setText("Image Text");
		ImageTextlabel.setMaximumSize(new Dimension(78, 16));
		ImageTextlabel.setMinimumSize(new Dimension(78, 16));
		ImageTextlabel.setPreferredSize(new Dimension(78, 16));

		//---- ImageNameValue ----
		ImageNameValue.setHorizontalAlignment(SwingConstants.TRAILING);
		ImageNameValue.setMaximumSize(new Dimension(204, 16));
		ImageNameValue.setPreferredSize(new Dimension(204, 16));

		//---- ImageSizeValue ----
		ImageSizeValue.setHorizontalAlignment(SwingConstants.TRAILING);
		ImageSizeValue.setMaximumSize(new Dimension(204, 16));
		ImageSizeValue.setPreferredSize(new Dimension(204, 16));

		//---- ImageView ----
		ImageView.setHorizontalAlignment(SwingConstants.CENTER);
		ImageView.setMaximumSize(new Dimension(288, 188));
		ImageView.setPreferredSize(new Dimension(288, 188));

		//---- GetTextButton ----
		GetTextButton.setText("Get Text");
		GetTextButton.setMaximumSize(new Dimension(78, 24));
		GetTextButton.setMinimumSize(new Dimension(78, 24));
		GetTextButton.setPreferredSize(new Dimension(78, 24));

		//======== TextScrollPane ========
		{

			//---- ImageTextValue ----
			ImageTextValue.setLineWrap(true);
			ImageTextValue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			TextScrollPane.setViewportView(ImageTextValue);
		}

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup()
										.addComponent(TextScrollPane)
										.addComponent(ImageView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup()
														.addComponent(Sizelabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
														.addComponent(ImageTextlabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
														.addComponent(NameLable, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup()
														.addComponent(ImageSizeValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(ImageNameValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGroup(layout.createSequentialGroup()
																.addGap(126, 126, 126)
																.addComponent(GetTextButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(ImageView, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup()
										.addComponent(NameLable, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addComponent(ImageNameValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(Sizelabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(ImageSizeValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup()
										.addComponent(ImageTextlabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(GetTextButton, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(TextScrollPane, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addContainerGap())
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Tyler
	private JLabel NameLable;
	private JLabel Sizelabel;
	private JLabel ImageTextlabel;
	public JLabel ImageNameValue;
	public JLabel ImageSizeValue;
	public JLabel ImageView;
	public JTextArea ImageTextValue;
	public JButton GetTextButton;
	private JScrollPane TextScrollPane;
	// JFormDesigner - End of variables declaration  //GEN-END:variables


}
