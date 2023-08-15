package tgmori.sourceflow;

import javafx.scene.image.Image;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ResourceManager {
    static String curPath = Paths.get(".").toUri().getRawPath();
    static List<Image> images = new ArrayList<Image>();

    public static String locate(String fileName) {
        if (!fileName.contains(":")) fileName = curPath + fileName;
        return fileName;
    }

    public static Image loadImage(String fileName) {
        Image _image = new Image(curPath + fileName);

        if (!_image.isError()) {
            images.add(_image);
        }

        return _image;
    }

    public static void _debug(){
        SourceFlow.LOGGER.info(curPath);
    }

}
