package tgmori.sourceflow.stage;

import javafx.stage.Stage;
import tgmori.sourceflow.SourceFlow;
import tgmori.sourceflow.resource.ResourceManager;
import tgmori.sourceflow.scene.SFSceneManager;
import tgmori.sourceflow.scene.SFScenes;

public class SFStageManager {
	/**
	 * 请在 {@code SFStageManager.init()} 后使用此字段，否则为 {@code null}。
	 */
	private static Stage primaryStage;

	public static void init(Stage primaryStage) {
		SourceFlow.LOGGER.info("初始化游戏窗口。");
		SFStageManager.primaryStage = primaryStage;

		initStageProperty();
		initResource();
		initSceneManager();

	}

	private static void initStageProperty() {
		SFStageProperty.applyTo(primaryStage);
	}

	private static void initResource() {
		ResourceManager.init();
	}

	private static void initSceneManager() {
		SFSceneManager.bind(primaryStage, SFScenes.FIRST_SCENE);
		SFSceneManager.loadScenes();
	}

	public static void show() {
		SourceFlow.LOGGER.info("显示游戏窗口。");
		primaryStage.show();
	}

	public static Stage getStage() {
		return primaryStage;
	}

	public static void close() {
		SourceFlow.LOGGER.info("关闭游戏窗口。");
		SFSceneManager.close();
	}
}
