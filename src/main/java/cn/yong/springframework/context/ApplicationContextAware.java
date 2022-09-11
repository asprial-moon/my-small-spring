package cn.yong.springframework.context;

import cn.yong.springframework.beans.BeansException;
import cn.yong.springframework.beans.factory.Aware;

/**
 * <p>由希望被通知其运行的ApplicationContext的任何对象实现的接口。
 * <p>例如，当一个对象需要访问一组协作 bean 时，实现这个接口是有意义的。请注意，通过 bean 引用进行配置优于仅出于 bean 查找目的实现此接口。
 * <p>如果对象需要访问文件资源，即要调用getResource 、要发布应用程序事件或需要访问 MessageSource ，也可以实现此接口。但是，在这种特定场景中，最好实现更具体的ResourceLoaderAware 、 ApplicationEventPublisherAware或MessageSourceAware接口。
 * <p>请注意，文件资源依赖项也可以作为org.springframework.core.io.Resource类型的 bean 属性公开，通过字符串填充，并由 bean 工厂自动进行类型转换。这消除了仅仅为了访问特定文件资源而实现任何回调接口的需要。
 * org.springframework.context.support.ApplicationObjectSupport是应用程序对象的便利基类，实现了这个接口。
 * @author Line
 * @date 2022/9/11
 */
public interface ApplicationContextAware extends Aware {

    /**
     * 设置该对象运行的ApplicationContext。通常此调用将用于初始化该对象
     * @param applicationContext
     * @throws BeansException
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
