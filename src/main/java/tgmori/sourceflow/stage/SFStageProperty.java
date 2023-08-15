package tgmori.sourceflow.stage;

import javafx.stage.Stage;
import tgmori.sourceflow.SourceFlow;

public class SFStageProperty {
	public static final String TITLE = SourceFlow.NAME;
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;

	public static void applyTo(Stage sfStage) {
		sfStage.setTitle(SFStageProperty.TITLE);

		sfStage.setResizable(false);
		sfStage.setWidth(SFStageProperty.WIDTH);
		sfStage.setHeight(SFStageProperty.HEIGHT);
	}
}
