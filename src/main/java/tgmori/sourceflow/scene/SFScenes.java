package tgmori.sourceflow.scene;

import tgmori.sourceflow.SourceFlow;

public class SFScenes {
	public static final SFScene ABOUT_SCENE = register(new AboutScene());
	public static final SFScene TEST_SCENE = register(new TestScene());

	public static final SFScene FIRST_SCENE = ABOUT_SCENE;

	private static SFScene register(SFScene scene) {
		SourceFlow.LOGGER.info("注册场景：{}", scene.getIdentifier());
		return SFSceneManager.register(scene);
	}
}
