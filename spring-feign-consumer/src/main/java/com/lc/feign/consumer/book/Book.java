package com.lc.feign.consumer.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liangchao03
 *         2017/10/26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private Integer authorId;
    private String title;
    private Integer publishedIn;
    private Integer languageId;
    private Language language;
}
