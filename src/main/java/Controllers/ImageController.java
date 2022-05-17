package Controllers;

import Views.ImageView;
import lombok.NoArgsConstructor;

import javax.swing.*;

@NoArgsConstructor
public class ImageController extends JPanel {


	private Models.Image image;
	private ImageView _view;

	public ImageController(Models.Image file) throws Exception {
		this.image = file;
		this._view = new ImageView();
		this._view.ImageNameValue.setText(this.image.ImageName);
		this._view.ImageView.setIcon(this.image.getIcon());
		this._view.ImageSizeValue.setText(this.image.ImageSize);
		this._view.ImageTextValue.setText(this.image.ImageText);
		this._view.GetTextButton.addActionListener(e -> this.getText());
	}

	public void getText() {
		try {
			String text = this.image.getText();
			this._view.ImageTextValue.setText(text);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		this._view.validate();
		this._view.repaint();
	}

	public ImageView getView(){
		return this._view;
	}

}
