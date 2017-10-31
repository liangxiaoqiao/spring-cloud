package com.lc.feign.consumer.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by liangchao on 17-10-28.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Language {
    private Integer id;
    private String name;
}
