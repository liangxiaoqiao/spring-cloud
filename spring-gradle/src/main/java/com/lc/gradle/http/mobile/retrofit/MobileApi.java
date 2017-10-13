package com.lc.gradle.http.mobile.retrofit;

import com.lc.gradle.http.mobile.module.MobileResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author liangchao03
 *         2017/10/13
 */
public interface MobileApi {
    /**
     * http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=218.4.255.255
     * https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=手机号
     * @param tel
     * @return
     */

    @GET("/cc/json/mobile_tel_segment.htm")
    Call<MobileResponse> mobileInfo(String tel);

}
