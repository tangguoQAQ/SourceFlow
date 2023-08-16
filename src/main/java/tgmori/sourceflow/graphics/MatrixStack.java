package tgmori.sourceflow.graphics;

import javafx.scene.canvas.GraphicsContext;

import java.util.Stack;

public class MatrixStack {
	public final GraphicsContext target;
	private final Stack<Transform> transforms = new Stack<>();

	public MatrixStack(GraphicsContext target) {
		this.target = target;
	}

	public void push() {
		transforms.push(new Transform());
	}

	public void pop() {
		Transform transform = transforms.pop();
		target.translate(-transform.x, -transform.y);
		target.rotate(-transform.rotation);
	}

	public void translate(double x, double y) {
		target.translate(x, y);
		transforms.peek().translate(x, y);
	}

	public void rotate(double degrees) {
		target.rotate(degrees);
		transforms.peek().rotate(degrees);
	}

	private static final class Transform {
		private double x;
		private double y;
		private double rotation;

		public void translate(double x, double y) {
			this.x += x;
			this.y += y;
		}

		public void rotate(double degrees) {
			this.rotation += degrees;
		}
	}
}
