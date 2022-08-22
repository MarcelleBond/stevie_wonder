package Controllers;

import Models.DB;
import Models.Image;
import Views.MainView;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainController {

	private final JFileChooser _fileChooser;
	private final MainView _view;
	private final DB _db;
	private List<ImageController> _imageList;

	public MainController() throws Exception {
		this._fileChooser = new JFileChooser();
		this._fileChooser.setAcceptAllFileFilterUsed(false);
		this._fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", ImageIO.getReaderFileSuffixes()));
		this._fileChooser.setMultiSelectionEnabled(true);
		this._view = new MainView();
		this._view.AddImagesButton.addActionListener(e -> addImages());
		this._view.GetAllTextButton.addActionListener(e -> getAllText());
		this._db = DB.GetInstance();
		this._imageList = new ArrayList<>();
	}

	public MainView getView() {
		return this._view;
	}

	protected void loadFromDB() {
		try {
			var imageList = this._db.Select("SELECT * FROM Images", Image.class);
			for (Image el : imageList) {
				ImageController image = new ImageController(el);
				_imageList.add(image);
				this._view.ListPane.add(image.getView());
			}
			this._view.validate();
			this._view.repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void addImages() {
		if (_fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File[] files = _fileChooser.getSelectedFiles();
			for (File file : files) {
				System.out.println(file.toPath());
				try {
					var image = new Image(file);
					ImageController imageController = new ImageController(image);
					_imageList.add(imageController);
					this._view.ListPane.add(imageController.getView());

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			this._view.validate();
			this._view.repaint();
		}
	}

	private void getAllText() {
		try {
			var imageList = this._imageList.stream().filter(i -> i.hasText() == false).collect(Collectors.toList());
			for (ImageController image : imageList) {
				image.getText();
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
