package com.spdb;

import com.madgag.gif.fmsware.AnimatedGifEncoder;
import com.madgag.gif.fmsware.GifDecoder;
import com.spdb.core.GifSequenceWriter.GifSequenceWriter;
import org.junit.Test;

import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 这个目前不知道用的什么方法，但也可以压缩,但是处理完后貌似不能一直循环播放
 * 用的GifSequenceWriter这个类
 */


public class SequenceTest {

    @Test
    public void SequenceTest() throws IOException {
        final String resourcePath = "src/main/resources";
        String imgPath = resourcePath + "/original/1.gif";
        String newFilePath = resourcePath + "/result/result.gif";

        // create a new BufferedOutputStream with the last argument
        ImageOutputStream output =
                new FileImageOutputStream(new File(newFilePath));

        // write out the first image to our sequence...
        GifDecoder decoder = new GifDecoder();
        int status = decoder.read(imgPath);
        if (status != GifDecoder.STATUS_OK) {
            throw new IOException("read image " + imgPath + " error!");
        }

        // grab the output image type from the first image in the sequence
        BufferedImage firstImage = decoder.getFrame(0);
        // create a gif sequence with the type of the first image, 1 second
        // between frames, which loops continuously
        //一般正常的话每2帧的间隔都是相同的
        GifSequenceWriter writer =
                new GifSequenceWriter(output, firstImage.getType(), decoder.getDelay(0)/100, false);
        writer.writeToSequence(firstImage);

        //从第二帧开始
        for (int i = 1; i < decoder.getFrameCount(); i++) {
            BufferedImage bufferedImage = decoder.getFrame(i);// 获取每帧BufferedImage流
            writer.writeToSequence(bufferedImage);
        }

        writer.close();
        output.close();
    }

}
