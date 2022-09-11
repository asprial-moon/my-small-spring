package cn.yong.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Line
 * @desc 支持作为File和URL的解析。实现扩展的WritableResource接口。
 * @date 2022/9/11
 */
public class FileSystemResource implements Resource {
    private final File file;
    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public final String getPath() {
        return path;
    }
}
