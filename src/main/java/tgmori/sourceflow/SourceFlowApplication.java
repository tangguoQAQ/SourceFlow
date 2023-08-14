package tgmori.sourceflow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class SourceFlowApplication extends Application {
	/**
	 * {@code start()} 前或 {@code stop()} 后此字段为 {@code null}。
	 */
	private static Stage primaryStage = null;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.setPrimaryStage(primaryStage);

		this.initPrimaryStage();
		this.showPrimaryStage();
	}

	@Override
	public void stop() throws Exception {

	}

	private void setPrimaryStage(Stage primaryStage) {
		SourceFlowApplication.primaryStage = primaryStage;
	}

	private void initPrimaryStage() {
		primaryStage.setTitle("SourceFlow");
	}

	private void showPrimaryStage() {
		primaryStage.show();
	}
}
