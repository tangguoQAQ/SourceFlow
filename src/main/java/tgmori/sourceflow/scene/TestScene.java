package tgmori.sourceflow.scene;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import tgmori.sourceflow.SourceFlow;
import tgmori.sourceflow.graphics.BackgroundRenderHelper;
import tgmori.sourceflow.graphics.MatrixStack;

public class TestScene extends SFScene {
	private final Button button = new Button("TestScene");
	private static final String TEST_BG = "ori";

	@Override
	public String getIdentifier() {
		return "test_scene";
	}

	@Override
	public void init() {
		super.init();
		button.setOnMouseClicked(event -> {
			SourceFlow.LOGGER.info("[test_scene] button 按钮被单击。");
			SFSceneManager.switchTo(SFScenes.ABOUT_SCENE);
		});


		addChildren(button);
	}

	@Override
	public void onShown() {
		SourceFlow.LOGGER.info("test_scene onShown()");
	}

	@Override
	protected void onRepaintBottom(MatrixStack ms) {
		BackgroundRenderHelper.draw(ms, TEST_BG);
	}

	@Override
	protected void onRepaint(MatrixStack ms) {
		ms.target.setStroke(Color.MAGENTA);
		ms.target.strokeLine(10, 50, 100, 100);
		ms.target.setFill(Color.GOLD);
		ms.target.fillText("abc 天地人", 100, 100);
	}
}
