package com.lingb.mystudy.javatools.image;

import com.luciad.imageio.webp.WebPReadParam;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.26 12:35
 */
public class DecodeDemo {

    public static void main(String args[]) throws IOException {
        String inputWebpPath = "G:/DevWorkSpace/IDEA/mystudy/java-tools/src/main/resources/test_pic/test.webp";
        String outputJpgPath = "G:/DevWorkSpace/IDEA/mystudy/java-tools/src/main/resources/test_pic/test_.jpg";
        String outputJpegPath = "G:/DevWorkSpace/IDEA/mystudy/java-tools/src/main/resources/test_pic/test_.jpeg";
        String outputPngPath = "G:/DevWorkSpace/IDEA/mystudy/java-tools/src/main/resources/test_pic/test_.png";

        ImageReader reader = ImageIO.getImageReadersByMIMEType("image/webp").next();
        WebPReadParam readParam = new WebPReadParam();
        readParam.setBypassFiltering(true);
        reader.setInput(new FileImageInputStream(new File(inputWebpPath)));
        BufferedImage image = reader.read(0, readParam);

        ImageIO.write(image, "png", new File(outputPngPath));
        ImageIO.write(image, "jpg", new File(outputJpgPath));
        ImageIO.write(image, "jpeg", new File(outputJpegPath));

    }
}
