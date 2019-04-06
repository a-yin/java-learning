package com.lingb.mystudy.javatools.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 请在此处输入描述信息。
 *
 * @author lingb
 * @date 2019.03.26 11:59
 */
public class ImageConverterWebp {

    public static final String WEBP = "webp";
    public static final String WEBP_SUFFIX = ".webp";

    private ImageConverterWebp() {
    }

    /**
     * 1. 传入图片文件路径，返回file对象
     * @param imgFilePath 图片文件路径(比如转换图片为F:/1.png 那么转换后的webp文件为：F:/1.png.webp)
     * @return
     */
    public static File toWebpFile(String imgFilePath) {
        File imgFile = new File(imgFilePath);
        File webpFile = new File(imgFilePath + WEBP_SUFFIX);
        try {
            BufferedImage bufferedImage = ImageIO.read(imgFile);
            ImageIO.write(bufferedImage, WEBP, webpFile);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return webpFile;
    }

    /**
     * 2. 传入图片url，返回file对象
     * @param imgUrlPath 图片路径url
     * @param webpFilePath 生成的webp文件路径
     * @return
     */
    public static File toWebpFile(String imgUrlPath, String webpFilePath) {
        File webpFile = new File(webpFilePath);
        try {
            BufferedImage bufferedImage = ImageIO.read(new URL(imgUrlPath));
            ImageIO.write(bufferedImage, WEBP, webpFile);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return webpFile;
    }

    /**
     * 3. 传入图片文件路径，返回InputStream
     * @param imgFilePath 图片文件路径(比如转换图片为F:/1.png 那么转换后的webp文件为：F:/1.png.webp)
     * @return
     */
    public static InputStream toWebpStream(String imgFilePath) {
        File imgFile = new File(imgFilePath);
        File webpFile = new File(imgFilePath + WEBP_SUFFIX);
        FileInputStream fis = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(imgFile);
            ImageIO.write(bufferedImage, WEBP, webpFile);
            fis = new FileInputStream(webpFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(fis != null){
                try {
                    fis.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fis;
    }

    /**
     * 4. 传入图片url，返回InputStream
     * @param imgUrlPath 图片路径url
     * @param webpFilePath 生成的webp文件路径
     * @return
     */
    public static InputStream toWebpStream(String imgUrlPath, String webpFilePath) {
        File webpFile = new File(webpFilePath);
        FileInputStream fis = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(new URL(imgUrlPath));
            ImageIO.write(bufferedImage, WEBP, webpFile);
            fis = new FileInputStream(webpFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(fis != null){
                try {
                    fis.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fis;
    }

    public static void main(String[] args) {
        String imgUrlPath = "com/lingb/mystudy/javatools/image/test_pic/test.png";
        File result = toWebpFile(imgUrlPath);
    }
}

