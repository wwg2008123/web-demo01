/*
package com.wwg.webdemo01.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.wwg.webdemo01.model.ShareCouponVO;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.*;

*/
/**
 * <p></p>
 *
 * @author wangweiguang 2021/12/9 13:14
 *//*

public class ImgUtil {


    private byte[] createImage(BufferedImage image) throws IOException {


        ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
        ImageIO.write(image, "jpg", baos);//写入流中
        byte[] bytes = baos.toByteArray();//转换成字节
        return bytes;
    }

    private void createImage(String fileLocation, BufferedImage image) {
        try {
            FileOutputStream fos = new FileOutputStream(fileLocation);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);

            encoder.encode(image);
            bos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public BufferedImage graphicsGeneration(ShareCouponVO vo) throws IOException {

        //BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage image = ImageIO.read(new FileInputStream(vo.getImgPath()));
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();

        Graphics2D graphics = image.createGraphics();

        graphics.setFont(new Font("宋体", Font.CENTER_BASELINE, 40));
        int num = 362;
        graphics.drawString(vo.getCoupon_name(), 200, num);
        num += 50;
        graphics.drawString(vo.getShare_code(), 200, num);
        num += 50;
        graphics.drawString(vo.getCoupon_start_time() + "-" + vo.getCoupon_end_time(), 200, num);




        return image;
    }

    public String converBase64(byte[] bytes) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(bytes);
    }

    public static void main(String[] args) throws IOException {
        ShareCouponVO couponVO = new ShareCouponVO();
        couponVO.setCoupon_name("满100减1000");
        couponVO.setShare_code("AAAAAAAAAAAAA");
        couponVO.setCoupon_start_time("2021.12.09");
        couponVO.setCoupon_end_time("2022.02.09");
        couponVO.setImgPath("C:\\Users\\Administrator\\Desktop\\working\\coupon2.png");
        ImgUtil imgUtil = new ImgUtil();
         imgUtil.createImage("D://111.jpg",imgUtil.graphicsGeneration(couponVO)) ;
        //System.out.println(bytes);
        //String base64 = imgUtil.converBase64(bytes);
        //System.out.println(base64);
    }
}
*/
