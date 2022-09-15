# Gif 动画压缩
> 主要用到了2位大佬写的编码类 `AnimateGifEncoder`、`GifSequenceWriter`。
> 
> 还有Aspose这个也可以用来压缩，但是效果不是太好


## 测试样例

> 请参考test下的类，分别使用不同的方法进行处理
> 
> 原始gif在resource下的orginal文件夹下，执行完后的gif压缩文件在resource下的result文件夹下


## 使用演示

* **AnimateGifEncoder**

  > 简单演示，详细演示请参考具体代码：

  ```java
  final BufferedImage img1 = ImageIO.read(new ByteArrayInputStream(pngByte1));
  final BufferedImage img2 = ImageIO.read(new ByteArrayInputStream(pngByte2));
  final BufferedImage img3 = ImageIO.read(new ByteArrayInputStream(pngByte3));
  
  try (
  	final FileOutputStream outputStream = new FileOutputStream(new File("result_02.gif"))
  ) {
      final AnimatedGifEncoder encoder = new AnimatedGifEncoder();
      encoder.setRepeat(0);
      encoder.start(outputStream);
      encoder.addFrame(img1);
      encoder.setDelay(500);
      encoder.addFrame(img2);
      encoder.setDelay(500);
      encoder.addFrame(img3);
      encoder.finish();
      outputStream.flush();
  }
  ```

  

* **GifSequenceWriter**

  > 简单演示，详细演示请参考具体代码：
  
  ```java
  final BufferedImage img1 = ImageIO.read(new ByteArrayInputStream(pngByte1));
  final BufferedImage img2 = ImageIO.read(new ByteArrayInputStream(pngByte2));
  final BufferedImage img3 = ImageIO.read(new ByteArrayInputStream(pngByte3));
  
  try (
      final FileImageOutputStream outputStream = new FileImageOutputStream(new File("result_01.gif"));
      final GifSequenceWriter writer = new GifSequenceWriter(outputStream, img1.getType(), 500, false)
  ) {
      writer.writeToSequence(img1);
      writer.writeToSequence(img2);
      writer.writeToSequence(img3);
  }
  
  ```


