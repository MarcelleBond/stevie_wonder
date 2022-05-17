package Models;

import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Image {
	public Integer ImageID;
	public String ImageName;
	public String ImagePath;
	public String ImageText;
	public String ImageSize;
	public Integer GotText;
	private DB _db;
	private static final int IMAGE_HEIGHT = 188;
	private static final int IMAGE_WIDTH = 288;

	public Image(File file) throws Exception {
		this.ImageName = file.getName();
		this.ImagePath = file.getPath();
		this.ImageSize = Files.size(file.toPath()) / 1024 + "KB";
		this._db = DB.GetInstance();
		this.saveImage();
	}

	public String getText() throws Exception {
		List<AnnotateImageRequest> requests = new ArrayList<>();

		ByteString imgBytes = ByteString.readFrom(new FileInputStream(ImagePath));

		com.google.cloud.vision.v1.Image img =
				com.google.cloud.vision.v1.Image.newBuilder().setContent(imgBytes).build();

		Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();

		AnnotateImageRequest request =
				AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();

		requests.add(request);

		try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
			BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();

			for (AnnotateImageResponse res : responses) {
				if (res.hasError()) {
					System.out.format("Error: %s%n", res.getError().getMessage());
					throw new Exception(res.getError().getMessage());
				}
				this.ImageText =  res.getTextAnnotationsList().get(0).getDescription();
			}
		}
		this.saveText();
		return this.ImageText;
	}

	public ImageIcon getIcon() throws IOException {
		BufferedImage bufferedImage = ImageIO.read(new File(this.ImagePath));
		java.awt.Image newImage = bufferedImage.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(newImage);
	}

	private void saveImage() throws SQLException {
		this.ImageID = this._db.Insert("Images", new HashMap<>() {
			{
				put("ImageName", ImageName);
				put("ImagePath", ImagePath);
				put("ImageSize", ImageSize);
			}
		});
	}

	private void saveText(){
		try {
			this._db.Update("Images", new HashMap<>() {{
				put("ImageText", ImageText);
				put("GotText", "1");
			}}, "=", new HashMap<>() {{
				put("ImageID", ImageID.toString() );
			}});
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
