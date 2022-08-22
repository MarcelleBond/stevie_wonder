package Controllers;

import Views.ImageView;
import lombok.NoArgsConstructor;

import javax.swing.*;

@NoArgsConstructor
public class ImageController extends JPanel {


	private Models.Image _image;
	private ImageView _view;

	public ImageController(Models.Image file) throws Exception {
		this._image = file;
		this._view = new ImageView();
		this._view.ImageNameValue.setText(this._image.ImageName);
		this._view.ImageView.setIcon(this._image.getIcon());
		this._view.ImageSizeValue.setText(this._image.ImageSize);
		this._view.ImageTextValue.setText(this._image.ImageText);
		this._view.GetTextButton.addActionListener(e -> getText());
	}

	public void getText() {
		try {
			if (this._image.GotText == 1)
				return;
			String text = this._image.getText();
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

	public boolean hasText(){
		return this._image.GotText != null && this._image.GotText != 0;
	}

}
