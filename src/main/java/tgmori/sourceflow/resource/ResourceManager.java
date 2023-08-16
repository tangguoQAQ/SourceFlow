package tgmori.sourceflow.resource;

import javafx.scene.image.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class ResourceManager {
	public static final Logger LOGGER = LogManager.getLogger("ResourceManager");
	public static final Path RESOURCE_PATH = Paths.get("resource").toAbsolutePath();
	public static final Map<String, Image> images = new HashMap<>();

	public static void init() {
		if(!Files.exists(RESOURCE_PATH)) {
			LOGGER.fatal("无法加载资源，资源目录不存在。");
			throw new RuntimeException(new FileNotFoundException(RESOURCE_PATH.toString()));
		}
		load();
	}

	public static void load() {
		LOGGER.info("加载游戏所用资源。");
		try(Stream<Path> resDir = Files.list(RESOURCE_PATH).filter(Files::isDirectory)) {
			resDir.forEach(dir -> {
				try(Stream<Path> res = Files.list(dir).filter(Files::isRegularFile)) {
					final String resType = dir.getFileName().toString();
					LOGGER.info("加载资源：{}；", resType);
					switch(resType) {
						case "image" -> res.forEach(ResourceManager::addImage);

						default -> LOGGER.warn("未知的资源类型（{}），已跳过加载。", resType);
					}
				} catch(IOException e) {
					throwLoadingException(e);
				}
			});
		} catch(IOException e) {
			throwLoadingException(e);
		}
	}

	private static String genIdentifier(Path path) {
		return ResourceManager.RESOURCE_PATH.relativize(path).toString()
				.transform(pathStr -> pathStr.substring(0, pathStr.lastIndexOf('.')))
				.replace("\\", "/");
	}

	private static void addImage(Path path) {
		images.put(genIdentifier(path), new Image(path.toString()));
	}

	private static void throwLoadingException(Exception e) {
		LOGGER.fatal("无法加载资源。", e);
		throw new RuntimeException(e);
	}

	public static Image getImage(String identifier) {
		return Optional.ofNullable(images.get("image/" + identifier)).orElseGet(() -> {
			LOGGER.warn("图像唯一名（{}）无效。", identifier);
			return Resources.ERROR_IMAGE;
		});
	}
}
