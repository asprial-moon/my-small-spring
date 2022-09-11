package cn.yong.springframework.core.io;

/**
 * @author Line
 * @desc 用于加载资源（例如，类路径或文件系统资源）的策略接口
 * @date 2022/9/11
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 返回指定资源位置的Resource句柄
     * @param location 位置
     * @return
     */
    Resource getResource(String location);
}
