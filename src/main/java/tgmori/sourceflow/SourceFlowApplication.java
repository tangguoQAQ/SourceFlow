package tgmori.sourceflow;

import javafx.application.Application;
import javafx.stage.Stage;

public class SourceFlowApplication extends Application {
	/**
	 * {@code start()} 前或 {@code stop()} 后此字段为 {@code null}。
	 */
	private static Stage primaryStage = null;

	@Override
	public void start(Stage primaryStage) {
		this.setPrimaryStage(primaryStage);

		this.initPrimaryStage();
		this.showPrimaryStage();
	}

	@Override
	public void stop() {

	}

	private void setPrimaryStage(Stage primaryStage) {
		SourceFlowApplication.primaryStage = primaryStage;
	}

	private void initPrimaryStage() {
		SourceFlow.LOGGER.info("初始化游戏窗口。");
		primaryStage.setTitle("SourceFlow");
	}

	private void showPrimaryStage() {
		SourceFlow.LOGGER.info("显示游戏窗口。");
		primaryStage.show();
	}
}
