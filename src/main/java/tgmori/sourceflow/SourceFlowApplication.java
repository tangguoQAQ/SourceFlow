package tgmori.sourceflow;

import javafx.application.Application;
import javafx.stage.Stage;
import tgmori.sourceflow.stage.SFStageManager;

public class SourceFlowApplication extends Application {
	@Override
	public void start(Stage primaryStage) {
		SFStageManager.init(primaryStage);
		SFStageManager.show();
	}

	@Override
	public void stop() {
		SFStageManager.close();
	}
}
