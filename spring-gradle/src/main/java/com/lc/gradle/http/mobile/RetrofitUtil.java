package com.lc.gradle.http.mobile;

import retrofit2.Retrofit;

/**
 * @author liangchao03
 *         2017/10/13
 */
public class RetrofitUtil {
    public static <T> T createClient(Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com")
                .build();
        return retrofit.create(clazz);
    }
}
