package tgmori.sourceflow.scene;

import javafx.scene.control.Button;
import tgmori.sourceflow.SourceFlow;

public class AboutScene extends SFScene {
	private final Button button = new Button("AboutScene");

	{
		button.setOnMouseClicked(event -> {
			SourceFlow.LOGGER.info("[about_scene] button 按钮被单击。");
			SFSceneManager.switchTo(SFScenes.TEST_SCENE);
		});
	}

	@Override
	public String getIdentifier() {
		return "about_scene";
	}

	@Override
	public void init() {
		super.init();

		this.add(button);
	}
}
