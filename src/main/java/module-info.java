module tgmori.sourceflow {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.jetbrains.annotations;


	opens tgmori.sourceflow to javafx.fxml;
	exports tgmori.sourceflow;
}