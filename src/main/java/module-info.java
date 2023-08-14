module tgmori.sourceflow {
	requires javafx.controls;
	requires javafx.fxml;


	opens tgmori.sourceflow to javafx.fxml;
	exports tgmori.sourceflow;
}