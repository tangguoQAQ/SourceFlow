package tgmori.sourceflow.stage;

import javafx.stage.Stage;
import tgmori.sourceflow.SourceFlow;
import tgmori.sourceflow.scene.SFSceneManager;
import tgmori.sourceflow.scene.SFScenes;

public class SFStageManager {
	/**
	 * 请在 {@code SFStageManager.init()} 后使用此字段，否则为 {@code null}。
	 */
	private static Stage primaryStage;

	public static void init(Stage primaryStage) {
		SourceFlow.LOGGER.info("初始化游戏窗口。");

		// 初始化窗口属性
		SFStageManager.primaryStage = primaryStage;
		SFStageManager.config();

		//初始化游戏场景
		SFSceneManager.bind(primaryStage, SFScenes.FIRST_SCENE);
		SFSceneManager.initSFScenes();
	}

	private static void config() {
		SFStageProperty.applyTo(primaryStage);
	}

	public static void show() {
		SourceFlow.LOGGER.info("显示游戏窗口。");
		SFStageManager.primaryStage.show();
	}

	public static Stage getStage() {
		return primaryStage;
	}
}
