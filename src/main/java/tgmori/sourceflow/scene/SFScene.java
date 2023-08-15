package tgmori.sourceflow.scene;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import tgmori.sourceflow.stage.SFStageProperty;

public abstract class SFScene implements Initializable {
	private final Group children = new Group();
	private final Scene scene = new Scene(children);
	private final Canvas canvas = new Canvas(SFStageProperty.WIDTH, SFStageProperty.HEIGHT);
	protected final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

	/**
	 * @return 场景的唯一名，请使用小写字母加下划线
	 */
	public abstract String getIdentifier();

	/**
	 * 子类覆写请不要忘记 {@code super.init()}，否则画板组件将不会生效。
	 */
	@Override
	public void init() {
		this.add(canvas);
	}

	protected void add(Node child) {
		this.children.getChildren().add(child);
	}

	protected void addAll(Node... children) {
		this.children.getChildren().addAll(children);
	}

	public Scene getScene() {
		return scene;
	}

	/**
	 * 当此场景将要被显示时（切换中），此事件将被触发。
	 */
	public void onShowing() {}

	/**
	 * 当此场景被显示后（已切换），此事件将被触发。
	 */
	public void onShown() {}

	/**
	 * 当此场景将要被隐藏时（切换中），此事件将被触发。
	 */
	public void onHiding() {}

	/**
	 * 当此场景被隐藏后（已切换），此事件将被触发。
	 */
	public void onHidden() {}
}
