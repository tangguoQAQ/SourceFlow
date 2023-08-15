package tgmori.sourceflow;

import javafx.application.Application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SourceFlow {
	public static final Logger LOGGER = LogManager.getLogger("SourceFlow");

	public static void main(String[] args) {
		SourceFlow.LOGGER.info("开始运行 Source Flow。");
		Application.launch(SourceFlowApplication.class, args);
		SourceFlow.LOGGER.info("结束运行 Source Flow。");
	}
}
