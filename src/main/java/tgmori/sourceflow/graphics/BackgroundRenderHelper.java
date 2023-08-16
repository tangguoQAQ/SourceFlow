package tgmori.sourceflow.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import tgmori.sourceflow.resource.ResourceManager;
import tgmori.sourceflow.stage.SFStageProperty;

public class BackgroundRenderHelper {
	public static void draw(MatrixStack ms, String imageIdentifier, int imageSize) {
		Image image = ResourceManager.getImage(imageIdentifier);

		ms.push();
		for(int y = 0; y < SFStageProperty.HEIGHT; y += imageSize) {
			ms.push();
			for(int x = 0; x < SFStageProperty.WIDTH; x += imageSize) {
				ms.target.drawImage(image, 0, 0, imageSize, imageSize);
				ms.translate(imageSize, 0);
			}
			ms.pop();
			ms.translate(0, imageSize);
		}
		ms.pop();
	}

	public static void draw(MatrixStack ms, String imageIdentifier) {
		draw(ms, imageIdentifier, 64);
	}

	public static void drawRandomly(MatrixStack ms, String imageIdentifier, int imageSize) {
		Image image = ResourceManager.getImage(imageIdentifier);
		double halfSize = imageSize / -2D;

		ms.push();
		ms.translate(-halfSize, -halfSize);
		for(int y = 0; y < SFStageProperty.HEIGHT; y += imageSize) {
			ms.push();
			for(int x = 0; x < SFStageProperty.WIDTH; x += imageSize) {
				int degrees = ((int) (Math.random() * 4)) * 90;
				ms.rotate(degrees);
				ms.target.drawImage(image, halfSize, halfSize, imageSize, imageSize);
				ms.rotate(-degrees);

				ms.translate(imageSize, 0);
			}
			ms.pop();
			ms.translate(0, imageSize);
		}
		ms.pop();
	}

	public static void drawRandomly(MatrixStack ms, String imageIdentifier) {
		drawRandomly(ms, imageIdentifier, 64);
	}

	public static void draw(MatrixStack ms, Paint color) {
		ms.target.setFill(color);
		ms.target.fillRect(0, 0, SFStageProperty.WIDTH, SFStageProperty.HEIGHT);
	}
}
