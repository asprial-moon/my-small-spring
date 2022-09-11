package cn.yong.springframework.beans.factory;

/**
 * 由希望在 bean 工厂中了解其 bean 名称的 bean 实现的接口。请注意，通常不建议对象依赖于其 bean 名称，因为这表示对外部配置的潜在脆弱依赖，以及对 Spring API 的可能不必要的依赖。
 * @author Line
 * @date 2022/9/11
 */
public interface BeanNameAware extends Aware {
    /**
     * 在创建此 bean 的 bean 工厂中设置 bean 的名称。
     * @param name
     */
    void setBeanName(String name);
}
