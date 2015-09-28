package session2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileEx {
    public static void main(String[] args) {
        Path file = Paths.get("test.txt");
        SeekableByteChannel channel = null;
        int readed = 0;
        try {
            channel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(10);
            while ((readed = channel.read(buffer)) != -1){
                System.out.print(new String(buffer.array(), 0, readed));
                buffer.clear();
            }
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            if (channel != null) try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
