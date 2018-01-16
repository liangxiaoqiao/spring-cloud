package com.lc.spring.db.loader;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class CustomPropertySourceLoader implements PropertySourceLoader,PriorityOrdered{
    @Override
    public String[] getFileExtensions() {
        return new String[] { "properties", "xml" };
    }

    @Override
    public PropertySource<?> load(String name, Resource resource, String profile) throws IOException {
        if (profile == null) {
            EncodedResource encodedResource = new EncodedResource(resource, StandardCharsets.UTF_8);
            Properties properties = PropertiesLoaderUtils.loadProperties(encodedResource);
            if (!properties.isEmpty()) {
                return new PropertiesPropertySource(name, properties);
            }
        }
        return null;
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
