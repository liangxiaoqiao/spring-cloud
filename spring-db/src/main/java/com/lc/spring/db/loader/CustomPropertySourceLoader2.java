package com.lc.spring.db.loader;

import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 自定义SourceLoader覆盖原来的SourceLoader
 * 因为实现了ProorityOrdered。实现这个接口的对象在不实现这个接口的类之前，所以能够覆盖。
 * spring.factories需要配置
 *
 * 对应dev用自己的方法，其他的用 默认的。
 *
 */
public class CustomPropertySourceLoader2 extends PropertiesPropertySourceLoader implements PriorityOrdered{
    @Override
    public String[] getFileExtensions() {
        return new String[] { "properties", "xml" };
    }

    @Override
    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        if (profile == null) {
            if(name.equals("applicationConfig: [classpath:/application-dev.properties]")){
                EncodedResource encodedResource = new EncodedResource(resource, StandardCharsets.UTF_8);
                Properties properties = PropertiesLoaderUtils.loadProperties(encodedResource);
                if (!properties.isEmpty()) {
                    return new PropertiesPropertySource(name, properties);
                }
            }else{
                return super.load(name,resource,profile);
            }
        }
        return null;
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
