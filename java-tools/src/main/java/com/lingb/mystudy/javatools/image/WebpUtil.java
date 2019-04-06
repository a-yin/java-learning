package com.lingb.mystudy.javatools.image;

import com.luciad.imageio.webp.WebPReadParam;
import com.luciad.imageio.webp.WebPWriteParam;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.26 12:23
 */
public class WebpUtil {

    public static String webp2png(String src, String dst) throws IOException {
        // Obtain a WebP ImageReader instance
        ImageReader reader = ImageIO.getImageReadersByMIMEType("image/webp").next();

        // Configure decoding parameters
        WebPReadParam readParam = new WebPReadParam();
        readParam.setBypassFiltering(true);

        // Configure the input on the ImageReader
        reader.setInput(new FileImageInputStream(new File(src)));

        // Decode the image
        BufferedImage image = reader.read(0, readParam);

        //the `png` can use `jpg`
        ImageIO.write(image, "png", new File(dst));
        return dst;
    }

    public static String png2webp(String src, String dst) throws IOException {
        // Obtain an image to encode from somewhere
        BufferedImage image = ImageIO.read(new File(src));

        // Obtain a WebP ImageWriter instance
        ImageWriter writer = ImageIO.getImageWritersByMIMEType("image/webp").next();

        // Configure encoding parameters
        WebPWriteParam writeParam = new WebPWriteParam(writer.getLocale());
        writeParam.setCompressionMode(WebPWriteParam.MODE_DEFAULT);

        // Configure the output on the ImageWriter
        writer.setOutput(new FileImageOutputStream(new File(dst)));

        // Encode
        writer.write(null, new IIOImage(image, null, null), writeParam);

        return dst;
    }

    public static void main(String[] args) throws IOException {
        String pngPath = "G:/DevWorkSpace/IDEA/mystudy/java-tools/com.lingb.mystudy.javatools.image.test_pic/test/test.png";
        String webpPath = "G:/DevWorkSpace/IDEA/mystudy/java-tools/com.lingb.mystudy.javatools.image.test_pic/test/test.webp";
        String s = png2webp(pngPath, webpPath);
        System.out.println(s);


        String pngPath1 = "G:/DevWorkSpace/IDEA/mystudy/java-tools/com.lingb.mystudy.javatools.image.test_pic/test1/test.png";
        String webpPath1 = "G:/DevWorkSpace/IDEA/mystudy/java-tools/com.lingb.mystudy.javatools.image.test_pic/test1/test.webp";
        String s1 = webp2png(webpPath1, pngPath1);
        System.out.println(s1);
    }
}
