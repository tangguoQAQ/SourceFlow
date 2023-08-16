package tgmori.sourceflow.scene;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import tgmori.sourceflow.SourceFlow;
import tgmori.sourceflow.graphics.BackgroundRenderHelper;
import tgmori.sourceflow.graphics.MatrixStack;

public class AboutScene extends SFScene {
	private final Button button = new Button("AboutScene");

	@Override
	public String getIdentifier() {
		return "about_scene";
	}

	@Override
	public void init() {
		super.init();

		button.setOnMouseClicked(event -> {
			SourceFlow.LOGGER.info("[about_scene] button 按钮被单击。");
			SFSceneManager.switchTo(SFScenes.TEST_SCENE);
		});
		addChild(button);
	}

	@Override
	protected void onRepaintBottom(MatrixStack ms) {
		BackgroundRenderHelper.draw(ms, "honey");
	}
}
