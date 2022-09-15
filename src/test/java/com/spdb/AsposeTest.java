package com.spdb;

import com.aspose.imaging.ColorPaletteHelper;
import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.imageoptions.GifOptions;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AsposeTest {

    /**
     * 这是一个收费的
     * 还没太搞明白怎么用，处理出来的效果不太好，颜色有问题
     * @throws IOException
     */
    @Test
    public void AsposeTest() throws IOException {
        final String resourcePath = "src/main/resources";
        String inputFile = resourcePath + "/original/5.gif";
        String outputFile = resourcePath + "/result/result.gif";

        try (Image image = Image.load(inputFile);ByteArrayOutputStream stream = new ByteArrayOutputStream())
        {
            GifOptions options = new GifOptions();
            options.setPaletteSorted(false);
            options.setDoPaletteCorrection(false);
            options.setMaxDiff(0);
            options.setColorResolution((byte) 7);
            options.setPalette(ColorPaletteHelper.getCloseImagePalette((RasterImage) image, 1 << 8));


            // Palette correction means that whenever image is exported to GIF the source image colors will be analyzed
            // in order to build the best matching palette (in case image Palette does not exist or not specified in the options)
            options.setDoPaletteCorrection(true);

            // Load a GIF image in a progressive way.
            // An interlaced GIF doesn't display its scanlines linearly from top to bottom, but instead reorders it
            // so the content of the GIF becomes clear even before it finishes loading.
            options.setInterlaced(true);
            image.save(outputFile, options);
//              image.save(outputFile);
        }

    }
}
