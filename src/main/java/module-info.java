module tgmori.sourceflow {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.jetbrains.annotations;
	requires org.apache.logging.log4j;

	opens tgmori.sourceflow to javafx.fxml;
	exports tgmori.sourceflow;
}