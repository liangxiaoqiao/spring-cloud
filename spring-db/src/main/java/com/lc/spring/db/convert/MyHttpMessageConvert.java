package com.lc.spring.db.convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lc.spring.db.entity.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LC on 2017/10/28.
 */
public class MyHttpMessageConvert extends AbstractHttpMessageConverter {

    @Override
    protected boolean supports(Class clazz) {
        if(clazz == Author.class){
            return true;
        }
        return false;
    }

    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String result = StreamUtils.copyToString(inputMessage.getBody(), StandardCharsets.UTF_8);
        return result;
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }


    @Override
    public List<MediaType> getSupportedMediaTypes() {
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON);
        list.add(MediaType.ALL);
        return list;
    }
}
