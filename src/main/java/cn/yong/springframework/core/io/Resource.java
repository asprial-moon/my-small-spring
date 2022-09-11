package cn.yong.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Line
 * @desc 作为InputStream源的对象的简单接口
 * @date 2022/9/11
 */
public interface Resource {

    /**
     * 返回底层资源内容的InputStream 。
     * 预计每次调用都会创建一个新的流
     * @return 底层资源的输入流
     * @throws IOException IO异常
     */
    InputStream getInputStream() throws IOException;

}
