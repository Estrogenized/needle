package moe.queery.needle;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static java.nio.file.Files.*;

public final class Files {
    // @formatter:off
    Files() throws InstantiationException { throw new InstantiationException("it's an utility class!"); }
    // @formatter:on
    private static final String DEFAULT_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.102 Safari/537.36 OPR/90.0.4480.117";

    public static @NotNull File download(final String url, final File output) throws Throwable {
        return download(url, DEFAULT_AGENT, output);
    }

    public static @NotNull File download(final String url, final String agent, final File output) throws Throwable {
        final URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.setRequestProperty("User-Agent", agent);
        urlConnection.connect();
        try (final ReadableByteChannel channel = Channels.newChannel(urlConnection.getInputStream())) {
            try (final FileOutputStream fileOutputStream = new FileOutputStream(output)) {
                fileOutputStream.getChannel().transferFrom(channel, 0, Long.MAX_VALUE);
            }
        }
        return output;
    }

    public static final class Zip {
        public static void unzipFolder(final File source, final Path target) throws IOException {
            try (final ZipInputStream zis = new ZipInputStream(newInputStream(source.toPath()))) {
                ZipEntry zipEntry = zis.getNextEntry();
                while (zipEntry != null) {
                    final boolean isDirectory = zipEntry.getName().endsWith(File.separator);
                    final Path newPath = zipSlipProtect(zipEntry, target);
                    if (isDirectory) createDirectories(newPath);
                    else {
                        if (newPath.getParent() != null && notExists(newPath.getParent()))
                            createDirectories(newPath.getParent());
                        copy(zis, newPath, StandardCopyOption.REPLACE_EXISTING);
                    }
                    zipEntry = zis.getNextEntry();
                }
                zis.closeEntry();
            }
        }

        public static void unzip(final String zipFilePath, final String destDirectory) throws IOException {
            final File destDir = new File(destDirectory);
            if (!destDir.exists()) destDir.mkdir();
            final ZipInputStream zipIn = new ZipInputStream(newInputStream(Paths.get(zipFilePath)));
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                final String filePath = destDirectory + File.separator + entry.getName();
                if (!entry.isDirectory()) extractFile(zipIn, filePath);
                else new File(filePath).mkdirs();
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
            zipIn.close();
        }

        public static void extractFile(final ZipInputStream zipIn, final String filePath) throws IOException {
            final BufferedOutputStream bos = new BufferedOutputStream(newOutputStream(Paths.get(filePath)));
            final byte[] bytesIn = new byte[8192];
            int read;
            while ((read = zipIn.read(bytesIn)) != -1) bos.write(bytesIn, 0, read);
            bos.close();
        }

        public static Path zipSlipProtect(final ZipEntry zipEntry, final Path targetDir) throws IOException {
            final Path targetDirResolved = targetDir.resolve(zipEntry.getName());
            final Path normalizePath = targetDirResolved.normalize();
            if (!normalizePath.startsWith(targetDir))
                throw new IOException(String.format("Bad zip entry: %s", zipEntry.getName()));
            return normalizePath;
        }
    }
}
