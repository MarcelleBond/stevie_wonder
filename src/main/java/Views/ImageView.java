/*
 * Created by JFormDesigner on Fri Mar 25 12:23:39 CAT 2022
 */

package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Tyler
 */
public class ImageView extends JPanel {

	private static final int IMAGE_HEIGHT = 188;
	private static final int IMAGE_WIDTH = 288;

	public ImageView(File image) {
		initComponents();
		try {
			this.ImageNameValue.setText(image.getName());
			this.ImageView.setIcon(ResizeImage(image));
			this.ImageSizeValue.setText(Long.toString(Files.size(image.toPath())  / 1024) + "KB");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void GetText(ActionEvent e) {
		// TODO add your code here
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
		setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
		EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax.swing
		.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12),
		java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener()
		{@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))
		throw new RuntimeException();}});

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
		GetTextButton.addActionListener(e -> GetText(e));

		//======== TextScrollPane ========
		{

			//---- ImageTextValue ----
			ImageTextValue.setLineWrap(true);
			ImageTextValue.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			ImageTextValue.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
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
	private JLabel ImageNameValue;
	private JLabel ImageSizeValue;
	private JLabel ImageView;
	private JButton GetTextButton;
	private JScrollPane TextScrollPane;
	private JTextArea ImageTextValue;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	// Custom Private Methods
	public ImageIcon ResizeImage(File image) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(image);
		Image newImage = bufferedImage.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT,Image.SCALE_SMOOTH);
		return new ImageIcon(newImage);
	}

}
