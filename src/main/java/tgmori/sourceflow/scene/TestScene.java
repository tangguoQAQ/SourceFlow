package tgmori.sourceflow.scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import tgmori.sourceflow.SourceFlow;

public class TestScene extends SFScene {
	private final Label label = new Label("label form test_scene");
	private final Button button = new Button("TestScene");

	{
		button.setOnMouseClicked(event -> {
			SourceFlow.LOGGER.info("[test_scene] button 按钮被单击。");
			SFSceneManager.switchTo(SFScenes.ABOUT_SCENE);
		});
	}

	@Override
	public String getIdentifier() {
		return "test_scene";
	}

	@Override
	public void init() {
		super.init();
		graphicsContext.setStroke(Color.GOLD);
		graphicsContext.strokeLine(10, 50, 100, 100);

		this.addAll(label, button);
	}

	@Override
	public void onShown() {
		SourceFlow.LOGGER.info("test_scene onShown()");

	}
}
