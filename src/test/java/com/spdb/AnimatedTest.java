package com.spdb;


import com.spdb.core.utils.AnimatedUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * 通过AnimatedGifEncoder对gif进行压缩编码
 * 在大小和帧率，颜色和原来gif一样时，过小的gif压缩后可能会比原来的gif要大
 */
public class AnimatedTest {


    /**
     * 用java原生的图像处理
     * BufferedImage类
     * @throws IOException
     */
    @Test
    public void AnimatedSizeTest() throws IOException {
        final String resourcePath = "src/main/resources";
        String imgPath = resourcePath + "/original/5.gif";
        String newFilePath = resourcePath + "/result/result";
        try {
            AnimatedUtils.zoomGifBySize(imgPath, "gif", 360, 640, newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用Thumbnails进行图像处理
     * 目前来看效果好像不是很好，处理出来的gif会特别大，比上面那个方法要大
     * @throws IOException
     */
    @Test
    public void AnimatedQualityTest() throws IOException {
        final String resourcePath = "src/main/resources";
        String imgPath = resourcePath + "/original/5.gif";
        String newFilePath = resourcePath + "/result/result";
        try {
            AnimatedUtils.zoomGifByQuality(imgPath,"gif",1.0F,newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
