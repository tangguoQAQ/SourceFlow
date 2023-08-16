package tgmori.sourceflow.scene;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import tgmori.sourceflow.graphics.MatrixStack;
import tgmori.sourceflow.resource.Resources;
import tgmori.sourceflow.stage.SFStageProperty;

public abstract class SFScene {
	private final Pane root = new Pane();
	private final Scene scene = new Scene(root);
	private final Canvas topCanvas = new Canvas(SFStageProperty.WIDTH, SFStageProperty.HEIGHT);
	private final Canvas bottomCanvas = new Canvas(SFStageProperty.WIDTH, SFStageProperty.HEIGHT);
	private final MatrixStack matrixStack = new MatrixStack(topCanvas.getGraphicsContext2D());
	private final MatrixStack bottomMatrixStack = new MatrixStack(bottomCanvas.getGraphicsContext2D());

	/**
	 * @return 场景的唯一名，请使用小写字母加下划线
	 */
	public abstract String getIdentifier();

	/**
	 * 子类覆写请不要忘记 {@code super.init()}，否则画板组件将不会生效。
	 */
	public void init() {
		matrixStack.target.setFont(Resources.DEFAULT_FONT);
		matrixStack.target.setImageSmoothing(false);
		bottomMatrixStack.target.setFont(Resources.DEFAULT_FONT);
		bottomMatrixStack.target.setImageSmoothing(false);
		this.addChildren(bottomCanvas, topCanvas);
		this.repaint();
	}

	protected void addChild(Node child) {
		root.getChildren().add(child);
	}

	protected void addChildren(Node... children) {
		root.getChildren().addAll(children);
	}

	public Scene getScene() {
		return scene;
	}

	public void repaint(boolean bottom, boolean top) {
		if(bottom) onRepaintBottom(bottomMatrixStack);
		if(top) onRepaint(matrixStack);
	}

	/**
	 * 重新绘制场景的所有内容，此方法会在场景初始化后自动调用一次。
	 */
	public void repaint() {
		repaint(true, true);
	}

	/**
	 * 当此场景将要被显示时（切换中），此事件将被触发。
	 */
	public void onShowing() {
	}

	/**
	 * 当此场景被显示后（已切换），此事件将被触发。
	 */
	public void onShown() {
	}

	/**
	 * 当此场景将要被隐藏时（切换中），此事件将被触发。
	 */
	public void onHiding() {
	}

	/**
	 * 当此场景被隐藏后（已切换），此事件将被触发。
	 */
	public void onHidden() {
	}

	protected void onRepaintBottom(MatrixStack ms) {
	}

	protected void onRepaint(MatrixStack ms) {
	}
}
