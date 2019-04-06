package com.lingb.mystudy.javatools.image;

import com.luciad.imageio.webp.WebPWriteParam;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.26 12:16
 */
public class EncodeDemo {

    public static void main(String args[]) throws IOException {
        String inputPngPath = "G:/DevWorkSpace/IDEA/mystudy/java-tools/src/main/resources/test_pic/test.png";
        String inputJpgPath = "G:/DevWorkSpace/IDEA/mystudy/java-tools/src/main/resources/test_pic/test.jpg";
        String outputWebpPath = "G:/DevWorkSpace/IDEA/mystudy/java-tools/src/main/resources/test_pic/test_.webp";

        BufferedImage image = ImageIO.read(new File(inputJpgPath));
        ImageWriter writer = ImageIO.getImageWritersByMIMEType("image/webp").next();

        WebPWriteParam writeParam = new WebPWriteParam(writer.getLocale());
        writeParam.setCompressionMode(WebPWriteParam.MODE_DEFAULT);

        writer.setOutput(new FileImageOutputStream(new File(outputWebpPath)));
        writer.write(null, new IIOImage(image, null, null), writeParam);
    }
}
