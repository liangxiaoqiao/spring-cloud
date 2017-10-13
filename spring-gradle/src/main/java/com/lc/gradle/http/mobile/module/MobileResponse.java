package com.lc.gradle.http.mobile.module;

import lombok.Data;

/**
 * @author liangchao03
 *         2017/10/13
 */
@Data
public class MobileResponse {
    private String mts;
    private String province;
    private String catName;
    private String telString;
    private String areaVid;
    private String ispVid;
    private String carrier;
}
