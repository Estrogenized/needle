package moe.queery.needle.utils;

import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class Images {
    public static @Nullable InputStream imageToInputStream(final BufferedImage image) {
        InputStream inputStream;
        try {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", byteArrayOutputStream);
            inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (final Throwable throwable) {
            System.err.println("couldn't put awt-image to input-stream");
            throwable.printStackTrace();
            inputStream = null;
        }
        return inputStream;
    }

    public static @Nullable BufferedImage byteArrayToImage(final byte... data) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new ByteArrayInputStream(data));
        } catch (final Throwable throwable) {
            System.err.println("couldn't put byte[]-data to awt-image");
            throwable.printStackTrace();
        }
        return image;
    }

    public static BufferedImage color(final BufferedImage image, final Color color) { // TODO: improve ; should work like a hue-filter
        final int w = image.getWidth();
        final int h = image.getHeight();
        final BufferedImage imageDyed = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics = imageDyed.createGraphics();
        // graphics.drawImage(image, 0, 0, null);
        graphics.setXORMode(color);
        // graphics.setColor(color);
        graphics.drawImage(image, 0, 0, null);
        // graphics.fillRect(0, 0, w, h);
        graphics.dispose();
        return imageDyed;
    }

    public static BufferedImage color(final BufferedImage image, final int color) {
        return color(image, new Color(color));
    }

    public static BufferedImage resize(final BufferedImage img, final int newW, final int newH) {
        final Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        final BufferedImage image = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics = image.createGraphics();
        graphics.drawImage(tmp, 0, 0, null);
        graphics.dispose();
        return image;
    }
}
