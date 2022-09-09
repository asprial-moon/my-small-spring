package cn.yong.springframework;

/**
 * @author Line
 * @desc 定义属性
 * @date 2022/9/10
 */
public class PropertyValue {

    private final String name;

    private final Object value;


    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
