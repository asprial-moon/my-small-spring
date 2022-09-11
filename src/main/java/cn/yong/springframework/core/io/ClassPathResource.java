package cn.yong.springframework.core.io;

import cn.hutool.core.lang.Assert;
import cn.yong.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Line
 * @desc 类路径资源的Resource实现。使用给定的ClassLoader或给定的Class来加载资源。
 * 如果类路径资源驻留在文件系统中，则支持解析为java.io.File ，但不支持 JAR 中的资源。始终支持解析为 URL。
 * @date 2022/9/11
 */
public class ClassPathResource implements Resource {
    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream inputStream = classLoader.getResourceAsStream(path);
        if (inputStream == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return inputStream;
    }
}
