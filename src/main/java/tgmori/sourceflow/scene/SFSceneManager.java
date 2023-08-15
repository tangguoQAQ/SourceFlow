package tgmori.sourceflow.scene;

import javafx.stage.Stage;
import tgmori.sourceflow.SourceFlow;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class SFSceneManager {
	private static final Set<SFScene> sfScenes = new HashSet<>();
	private static SFScene current = null;

	public static SFScene register(SFScene scene) {
		if(!sfScenes.add(scene)) {
			SourceFlow.LOGGER.error("无法注册场景：{}", scene.getIdentifier());
		}
		return scene;
	}

	private static Consumer<SFScene> sfSceneSwitcher;

	public static void bind(Stage stage, SFScene defaultScene) {
		defaultScene.onShowing();
		stage.setScene(defaultScene.getScene());
		defaultScene.onShown();
		current = defaultScene;

		sfSceneSwitcher = newScene -> stage.setScene(newScene.getScene());
	}

	public static void initSFScenes() {
		SourceFlow.LOGGER.info("初始化游戏场景，共 {} 个。", sfScenes.size());
		sfScenes.forEach(SFScene::init);
	}

	public static void switchTo(SFScene newScene) {
		current.onHiding();
		newScene.onShowing();
		sfSceneSwitcher.accept(newScene);
		current.onHidden();
		newScene.onShown();
		current = newScene;
	}

	public static SFScene getCurrent() {
		return current;
	}
}
